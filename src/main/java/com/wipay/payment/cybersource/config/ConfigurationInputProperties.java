package com.wipay.payment.cybersource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties (prefix = "cybersource")
public class ConfigurationInputProperties {
   
   private String authenticationType;
   private String merchantID;
   private String runEnvironment;
    
    public String getAuthenticationType() {
        return authenticationType;
    }
    
    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }
    
    public String getMerchantID() {
        return merchantID;
    }
    
    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }
    
    public String getRunEnvironment() {
        return runEnvironment;
    }
    
    public void setRunEnvironment(String runEnvironment) {
        this.runEnvironment = runEnvironment;
    }
}
