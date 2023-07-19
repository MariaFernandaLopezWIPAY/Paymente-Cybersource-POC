package com.wipay.payment.cybersource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;
@Component
public class ConfigurationCybersource {
    @Autowired
    private static ConfigurationInputProperties config;
    public static Properties getMerchantDetails() {
        Properties props = new Properties();
        
        // HTTP_Signature = http_signature and JWT = jwt
        props.setProperty("authenticationType","http_signature"); //config.getAuthenticationType());
        props.setProperty("merchantID", "rosenstiehl_sandbox"); //config.getMerchantID());
        props.setProperty("runEnvironment","apitest.cybersource.com"); //config.getRunEnvironment());
        props.setProperty("requestJsonPath", "src/main/resources/request.json");
        
        // MetaKey Parameters
        props.setProperty("portfolioID", "");
        props.setProperty("useMetaKey", "false");
        
        // JWT Parameters
        props.setProperty("keyAlias", "testrest");
        props.setProperty("keyPass", "testrest");
        props.setProperty("keyFileName", "testrest");
        
        // P12 key path. Enter the folder path where the .p12 file is located.
        
        props.setProperty("keysDirectory", "src/main/resources");
        // HTTP Parameters
        props.setProperty("merchantKeyId", "5c646231-d25a-4c87-82a1-5e9f8c3e0ee8");
        props.setProperty("merchantsecretKey", "THteBfn245R2oenq9T9Glm6iEm+sx0ox54RjytoGJWk=");
        // Logging to be enabled or not.
        props.setProperty("enableLog", "true");
        // Log directory Path
        props.setProperty("logDirectory", "log");
        props.setProperty("logFilename", "cybs");
        
        // Log file size in KB
        props.setProperty("logMaximumSize", "5M");
        
        // OAuth related properties.
        props.setProperty("enableClientCert", "false");
        props.setProperty("clientCertDirectory", "src/main/resources");
        props.setProperty("clientCertFile", "");
        props.setProperty("clientCertPassword", "");
        props.setProperty("clientId", "");
        props.setProperty("clientSecret", "");
        
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

