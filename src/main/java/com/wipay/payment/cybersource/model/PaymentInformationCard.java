package com.wipay.payment.cybersource.model;

public class PaymentInformationCard {
    private String number;
    private String expirationMonth;
    private String expirationYear;
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getExpirationMonth() {
        return expirationMonth;
    }
    
    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }
    
    public String getExpirationYear() {
        return expirationYear;
    }
    
    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }
}
