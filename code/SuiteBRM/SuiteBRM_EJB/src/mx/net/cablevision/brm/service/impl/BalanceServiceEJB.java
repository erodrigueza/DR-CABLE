package mx.net.cablevision.brm.service.impl;


import com.portal.custom.CustomOp;
import com.portal.custom.CvFldAmountNotOverdue;
import com.portal.custom.CvFldCreatedDate;
import com.portal.custom.CvFldCreditLimit;
import com.portal.custom.CvFldCurrencyStr;
import com.portal.custom.CvFldDueDate;
import com.portal.custom.CvFldEndDate;
import com.portal.custom.CvFldInvoiceNoStr;
import com.portal.custom.CvFldLastPaymentAmt;
import com.portal.custom.CvFldLastPaymentT;
import com.portal.custom.CvFldSourceStr;
import com.portal.custom.CvFldStartDate;
import com.portal.custom.CvFldStatusStr;
import com.portal.custom.CvFldTotalCharges;
import com.portal.custom.CvFldTypeCodeStr;
import com.portal.pcm.EBufException;
import com.portal.pcm.FList;
import com.portal.pcm.Poid;
import com.portal.pcm.SparseArray;
import com.portal.pcm.fields.FldAccountNo;
import com.portal.pcm.fields.FldAuditFlag;
import com.portal.pcm.fields.FldBillNo;
import com.portal.pcm.fields.FldBills;
import com.portal.pcm.fields.FldBuckets;
import com.portal.pcm.fields.FldCurrentBal;
import com.portal.pcm.fields.FldCurrentTotal;
import com.portal.pcm.fields.FldDays;
import com.portal.pcm.fields.FldDue;
import com.portal.pcm.fields.FldGuid;
import com.portal.pcm.fields.FldLastBillT;
import com.portal.pcm.fields.FldPoid;
import com.portal.pcm.fields.FldPreviousTotal;
import com.portal.pcm.fields.FldTotalDebits;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.Stateless;

import mx.net.cablevision.brm.service.BalanceService;
import mx.net.cablevision.common.SuiteBRMException;
import mx.net.cablevision.util.Messages;
import mx.net.cablevision.vo.Balance;
import mx.net.cablevision.vo.Bill;
import mx.net.cablevision.vo.Billinfo;
import mx.net.cablevision.vo.Bucket;

import org.apache.log4j.Logger;


@Stateless
public class BalanceServiceEJB extends GenericService implements BalanceService{

    private static Logger LOG = Logger.getLogger(BalanceServiceEJB.class);
    
    public Balance getBalance(String account) throws SuiteBRMException{

        FList inFlist, outFlist;
        FList flist = new FList();
        flist.set(FldPoid.getInst(), new Poid(1, -1, "/account"));
            flist.set(FldAccountNo.getInst(), account);
        inFlist = flist;
        outFlist = executeOpcode(CustomOp.CRM_POL_GET_BALANCE_INFO, inFlist);

        return getBalanceFromFlist(outFlist);    
    }
    
    public Billinfo getBillinfo(String account) throws SuiteBRMException{

        FList inFlist, outFlist;
        FList flist = new FList();
        flist.set(FldPoid.getInst(), new Poid(1, -1, "/account"));
            flist.set(FldAccountNo.getInst(), account);
        inFlist = flist;
        outFlist = executeOpcode(CustomOp.CRM_POL_GET_BILL_INFO, inFlist);

        return getBillinfoFromFlist(outFlist);    
    }
    
    private Balance getBalanceFromFlist(FList outFlist) throws SuiteBRMException {
        Balance balance = new Balance();
        if(outFlist != null){
            try {
                balance.setAccountNo(outFlist.get(FldAccountNo.getInst()));
                balance.setAmountNotOverdue(outFlist.get(CvFldAmountNotOverdue.getInst()));
                balance.setAuditFlag(outFlist.get(FldAuditFlag.getInst()));
                balance.setCreditLimit(outFlist.get(CvFldCreditLimit.getInst()));
                balance.setCurrentBal(outFlist.get(FldCurrentBal.getInst()));
                balance.setLastBill(outFlist.get(FldLastBillT.getInst()).toString());
                balance.setLastPayment(outFlist.get(CvFldLastPaymentT.getInst()).toString());
                balance.setLastPaymentAmt(outFlist.get(CvFldLastPaymentAmt.getInst()));
                balance.setTotalCharges(outFlist.get(CvFldTotalCharges.getInst()));
                balance.setTotalDebits(outFlist.get(FldTotalDebits.getInst()));
                balance.setBuckets(getBuckets(outFlist));
                    
            } catch (EBufException e) {
                LOG.error(Messages.getStackTrace(e));
                throw new SuiteBRMException(e);
            }
        }
        return balance;
    }
    
    private List<Bucket> getBuckets(FList outFlist) throws EBufException {
        List<Bucket> list = new ArrayList<Bucket>();
        SparseArray buckets = outFlist.get(FldBuckets.getInst());
        Enumeration valueEnum = buckets.getValueEnumerator();
        while(valueEnum.hasMoreElements()) {
            Bucket bucket = new Bucket();
            FList flist = (FList)valueEnum.nextElement();
            bucket.setDays(flist.get(FldDays.getInst()));
            bucket.setDue(flist.get(FldDue.getInst()));
            list.add(bucket);
        }
        return list;
    }
    
    private Billinfo getBillinfoFromFlist(FList outFlist) throws SuiteBRMException {
        Billinfo billinfo = new Billinfo();
        if(outFlist != null){
            try {
                billinfo.setAccountNo(outFlist.get(FldAccountNo.getInst()));
                billinfo.setCurrency(outFlist.get(CvFldCurrencyStr.getInst()));
                billinfo.setSource(outFlist.get(CvFldSourceStr.getInst()));
                billinfo.setStatus(outFlist.get(CvFldStatusStr.getInst()));
                billinfo.setTypeCode(outFlist.get(CvFldTypeCodeStr.getInst()));
                billinfo.setBills(getBills(outFlist));                
                addCurrentTotal(billinfo);
            } catch (EBufException e) {
                LOG.error(Messages.getStackTrace(e));
                throw new SuiteBRMException(e);
            }
        }
        return billinfo;
    }

    private List<Bill> getBills(FList outFlist) throws EBufException {
        List<Bill> list = new ArrayList<Bill>();
        SparseArray bills = outFlist.get(FldBills.getInst());
        Enumeration valueEnum = bills.getValueEnumerator();
        while(valueEnum.hasMoreElements()) {
            Bill bill = new Bill();
            FList flist = (FList)valueEnum.nextElement();
            bill.setBillNo(flist.get(FldBillNo.getInst()));
            bill.setCreatedDate(flist.get(CvFldCreatedDate.getInst()));
            bill.setCurrentTotal(flist.get(FldCurrentTotal.getInst()));
            bill.setDueDate(flist.get(CvFldDueDate.getInst()));
            bill.setEndDate(flist.get(CvFldEndDate.getInst()));
            bill.setGuid(flist.get(FldGuid.getInst()));
            bill.setInvoiceNo(flist.get(CvFldInvoiceNoStr.getInst()));
            bill.setPreviousTotal(flist.get(FldPreviousTotal.getInst()));
            bill.setStartDate(flist.get(CvFldStartDate.getInst()));
                
            list.add(bill);
        }
        return list;
    }
    
    private void addCurrentTotal(Billinfo billinfo){
        List<Bill> bills = billinfo.getBills();
        BigDecimal total = BigDecimal.ZERO;
        for(Bill bill : bills){
            total = total.add(bill.getCurrentTotal());
        }
        billinfo.setCurrentTotal(total);
    }
    
}

