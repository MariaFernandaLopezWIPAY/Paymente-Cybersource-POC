package com.wipay.payment.cybersource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;
@Component
public class ConfigurationCybersource {
    
    private static ConfigurationInputProperties config;
    
    @Autowired
    public ConfigurationCybersource(ConfigurationInputProperties config) {
        this.config = config;
    }
    
    
    public static Properties getMerchantDetails() {
        Properties props = new Properties();
        
        // HTTP_Signature = http_signature and JWT = jwt
        props.setProperty("authenticationType",config.getAuthenticationType());
        props.setProperty("merchantID", config.getMerchantID());
        props.setProperty("runEnvironment",config.getRunEnvironment());
        props.setProperty("requestJsonPath", config.getRequestJsonPath());
        
        // MetaKey Parameters
        props.setProperty("portfolioID",config.getPortfolioID());
        props.setProperty("useMetaKey", config.getUseMetaKey());
        
        // JWT Parameters
        props.setProperty("keyAlias", config.getKeyAlias());
        props.setProperty("keyPass", config.getKeyPass());
        props.setProperty("keyFileName", config.getKeyFileName());
        
        // P12 key path. Enter the folder path where the .p12 file is located.
        
        props.setProperty("keysDirectory", config.getKeysDirectory());
        // HTTP Parameters
        props.setProperty("merchantKeyId", config.getMerchantKeyId());
        props.setProperty("merchantsecretKey", config.getMerchantsecretKey());
        // Logging to be enabled or not.
        props.setProperty("enableLog", config.getEnableLog());
        // Log directory Path
        props.setProperty("logDirectory", config.getLogDirectory());
        props.setProperty("logFilename", config.getLogFilename());
        
        // Log file size in KB
        props.setProperty("logMaximumSize", config.getLogMaximumSize());
        
        // OAuth related properties.
        props.setProperty("enableClientCert", config.getEnableClientCert());
        props.setProperty("clientCertDirectory", config.getClientCertDirectory());
        props.setProperty("clientCertFile", config.getClientId());
        props.setProperty("clientCertPassword", config.getClientCertPassword());
        props.setProperty("clientId", config.getClientId());
        props.setProperty("clientSecret", config.getClientSecret());
        
        return props;
        
    }
    /**
    public static Properties getAlternativeMerchantDetails() {
        Properties props = new Properties();
        
        // HTTP_Signature = http_signature and JWT = jwt
        props.setProperty("authenticationType", "http_signature");
        props.setProperty("merchantID", "testrest_cpctv");
        props.setProperty("runEnvironment", "apitest.cybersource.com");
        props.setProperty("requestJsonPath", "src/main/resources/request.json");
        
        // JWT Parameters
        props.setProperty("keyAlias", "testrest_cpctv");
        props.setProperty("keyPass", "testrest_cpctv");
        props.setProperty("keyFileName", "testrest_cpctv");
        
        // P12 key path. Enter the folder path where the .p12 file is located.
        
        props.setProperty("keysDirectory", "src/main/resources");
        // HTTP Parameters
        props.setProperty("merchantKeyId", "964f2ecc-96f0-4432-a742-db0b44e6a73a");
        props.setProperty("merchantsecretKey", "zXKpCqMQPmOR/JRldSlkQUtvvIzOewUVqsUP0sBHpxQ=");
        // Logging to be enabled or not.
        props.setProperty("enableLog", "true");
        // Log directory Path
        props.setProperty("logDirectory", "log");
        props.setProperty("logFilename", "cybs");
        
        // Log file size in KB
        props.setProperty("logMaximumSize", "5M");
        
        return props;
        
    }*/
    
}

