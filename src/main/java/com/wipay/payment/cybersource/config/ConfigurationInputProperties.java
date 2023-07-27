package com.wipay.payment.cybersource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties (prefix = "cybersource")
public class ConfigurationInputProperties {
    
    private String authenticationType;
    private String merchantID;
    private String runEnvironment;
    private String requestJsonPath;
    private String portfolioID;
    private String useMetaKey;
    private String keyAlias;
    private String keyPass;
    private String keyFileName;
    private String keysDirectory;
    private String merchantKeyId;
    private String merchantsecretKey;
    private String enableLog;
    private String logDirectory;
    private String logFilename;
    private String logMaximumSize;
    private String enableClientCert;
    private String clientCertDirectory;
    private String clientCertFile;
    private String clientCertPassword;
    private String clientId;
    private String clientSecret;
    
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
    
    public String getRequestJsonPath() {
        return requestJsonPath;
    }
    
    public void setRequestJsonPath(String requestJsonPath) {
        this.requestJsonPath = requestJsonPath;
    }
    
    public String getPortfolioID() {
        return portfolioID;
    }
    
    public void setPortfolioID(String portfolioID) {
        this.portfolioID = portfolioID;
    }
    
    public String getUseMetaKey() {
        return useMetaKey;
    }
    
    public void setUseMetaKey(String useMetaKey) {
        this.useMetaKey = useMetaKey;
    }
    
    public String getKeyAlias() {
        return keyAlias;
    }
    
    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }
    
    public String getKeyPass() {
        return keyPass;
    }
    
    public void setKeyPass(String keyPass) {
        this.keyPass = keyPass;
    }
    
    public String getKeyFileName() {
        return keyFileName;
    }
    
    public void setKeyFileName(String keyFileName) {
        this.keyFileName = keyFileName;
    }
    
    public String getKeysDirectory() {
        return keysDirectory;
    }
    
    public void setKeysDirectory(String keysDirectory) {
        this.keysDirectory = keysDirectory;
    }
    
    public String getMerchantKeyId() {
        return merchantKeyId;
    }
    
    public void setMerchantKeyId(String merchantKeyId) {
        this.merchantKeyId = merchantKeyId;
    }
    
    public String getMerchantsecretKey() {
        return merchantsecretKey;
    }
    
    public void setMerchantsecretKey(String merchantsecretKey) {
        this.merchantsecretKey = merchantsecretKey;
    }
    
    public String getEnableLog() {
        return enableLog;
    }
    
    public void setEnableLog(String enableLog) {
        this.enableLog = enableLog;
    }
    
    public String getLogDirectory() {
        return logDirectory;
    }
    
    public void setLogDirectory(String logDirectory) {
        this.logDirectory = logDirectory;
    }
    
    public String getLogFilename() {
        return logFilename;
    }
    
    public void setLogFilename(String logFilename) {
        this.logFilename = logFilename;
    }
    
    public String getLogMaximumSize() {
        return logMaximumSize;
    }
    
    public void setLogMaximumSize(String logMaximumSize) {
        this.logMaximumSize = logMaximumSize;
    }
    
    public String getEnableClientCert() {
        return enableClientCert;
    }
    
    public void setEnableClientCert(String enableClientCert) {
        this.enableClientCert = enableClientCert;
    }
    
    public String getClientCertDirectory() {
        return clientCertDirectory;
    }
    
    public void setClientCertDirectory(String clientCertDirectory) {
        this.clientCertDirectory = clientCertDirectory;
    }
    
    public String getClientCertFile() {
        return clientCertFile;
    }
    
    public void setClientCertFile(String clientCertFile) {
        this.clientCertFile = clientCertFile;
    }
    
    public String getClientCertPassword() {
        return clientCertPassword;
    }
    
    public void setClientCertPassword(String clientCertPassword) {
        this.clientCertPassword = clientCertPassword;
    }
    
    public String getClientId() {
        return clientId;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    public String getClientSecret() {
        return clientSecret;
    }
    
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
