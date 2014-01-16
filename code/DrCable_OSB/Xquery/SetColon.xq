xquery version "1.0" encoding "Cp1252";

declare namespace functx = "http://www.functx.com"; 
declare namespace xf = "http://tempuri.org/DrCableTrans/xquery/SetColon/";

declare function functx:insert-string 
  ( $originalString as xs:string? ,
    $stringToInsert as xs:string? ,
    $pos as xs:integer )  as xs:string {
       
   concat(substring($originalString,1,$pos - 1),
             $stringToInsert,
             substring($originalString,$pos))
};

declare function xf:SetColon($macAddress as xs:string)
    as xs:string {
	functx:insert-string(functx:insert-string(functx:insert-string(functx:insert-string(functx:insert-string($macAddress, ':', 3), ':', 6), ':', 9), ':', 12), ':', 15)
};

declare variable $macAddress as xs:string external;

xf:SetColon($macAddress)
