package com.wipay.payment.cybersource.model.DTOs;

public class ProcessorInformation {
    private String authIndicator;
    private String approvalCode;
    private String cardReferenceData;
    private String transactionId;
    private String networkTransactionId;
    
    public String getAuthIndicator() {
        return authIndicator;
    }
    
    public void setAuthIndicator(String authIndicator) {
        this.authIndicator = authIndicator;
    }
    
    public String getApprovalCode() {
        return approvalCode;
    }
    
    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
    
    public String getCardReferenceData() {
        return cardReferenceData;
    }
    
    public void setCardReferenceData(String cardReferenceData) {
        this.cardReferenceData = cardReferenceData;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    public String getNetworkTransactionId() {
        return networkTransactionId;
    }
    
    public void setNetworkTransactionId(String networkTransactionId) {
        this.networkTransactionId = networkTransactionId;
    }
}
