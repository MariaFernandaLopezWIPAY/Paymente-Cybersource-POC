package com.wipay.payment.dynamodb.model;

public enum KeyPrefixes {
    AuditPayment("TRT");
    private String value;
    private KeyPrefixes(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
