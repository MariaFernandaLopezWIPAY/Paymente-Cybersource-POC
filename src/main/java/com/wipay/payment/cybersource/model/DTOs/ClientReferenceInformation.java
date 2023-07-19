package com.wipay.payment.cybersource.model.DTOs;

public class ClientReferenceInformation {
    private String code;
    private String submitLocalDateTime;
    private String ownerMerchantId;
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getSubmitLocalDateTime() {
        return submitLocalDateTime;
    }
    
    public void setSubmitLocalDateTime(String submitLocalDateTime) {
        this.submitLocalDateTime = submitLocalDateTime;
    }
    
    public String getOwnerMerchantId() {
        return ownerMerchantId;
    }
    
    public void setOwnerMerchantId(String ownerMerchantId) {
        this.ownerMerchantId = ownerMerchantId;
    }
}
