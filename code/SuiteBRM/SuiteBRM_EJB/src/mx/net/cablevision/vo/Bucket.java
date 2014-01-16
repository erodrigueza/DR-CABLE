package mx.net.cablevision.vo;

import java.io.Serializable;

import java.math.BigDecimal;

public class Bucket implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private BigDecimal due;
    private Integer days;

    public void setDue(BigDecimal due) {
        this.due = due;
    }

    public BigDecimal getDue() {
        return due;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getDays() {
        return days;
    }
}
