package com.wipay.payment.cybersource.model.DTOs;

public class ErrorInformation {
    private String reason;
    private String message;
    
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}
