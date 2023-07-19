package com.wipay.payment.cybersource.model.DTOs;

public class PaymentInformation {
    private String bin;
    private String accountType;
    private String issuer;
    private String binCountry;
    
    public String getBin() {
        return bin;
    }
    
    public void setBin(String bin) {
        this.bin = bin;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public String getIssuer() {
        return issuer;
    }
    
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    
    public String getBinCountry() {
        return binCountry;
    }
    
    public void setBinCountry(String binCountry) {
        this.binCountry = binCountry;
    }
}
