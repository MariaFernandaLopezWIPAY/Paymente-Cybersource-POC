package com.wipay.payment.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable (tableName = "tbl_audit_payment")
public class AuditPayment {


    private String PK;
    private String id;
    private String idTransaction;
    private String reconciliationId;
    private String clientReferenceInformationCode;
    private String dateTransaction;

    @DynamoDBAttribute(attributeName = "PK")
    @DynamoDBHashKey
    public String getPK() {
        return PK;
    }
    public void setPK(String PK) {
        this.PK = PK;
    }
    @DynamoDBAttribute (attributeName = "id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute (attributeName = "idTransaction")
    public String getIdTransaction() {
        return idTransaction;
    }
    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    @DynamoDBAttribute (attributeName = "reconciliationId")
    public String getReconciliationId() {
        return reconciliationId;
    }
    public void setReconciliationId(String reconciliationId) {
        this.reconciliationId = reconciliationId;
    }

    @DynamoDBAttribute (attributeName = "clientReferenceInformationCode")
    public String getClientReferenceInformationCode() {
        return clientReferenceInformationCode;
    }
    public void setClientReferenceInformationCode(String clientReferenceInformationCode) {
        this.clientReferenceInformationCode = clientReferenceInformationCode;
    }

    @DynamoDBAttribute (attributeName = "dateTransaction")
    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }


    public AuditPayment() {
        this.id = id;
        this.idTransaction = idTransaction;
        this.reconciliationId = reconciliationId;
        this.clientReferenceInformationCode = clientReferenceInformationCode;
        this.dateTransaction = dateTransaction;
    }

    public AuditPayment(String PK){

        this.PK = String.format("%s#%s", KeyPrefixes.AuditPayment.getValue(), PK);
        this.id = PK;
    }
    public String getPKDummy() {
        this.PK = String.format("%s#%s", KeyPrefixes.AuditPayment.getValue(), id);
        return PK;
    }
    public AuditPayment(AuditPayment auditPayment){
        this.PK= auditPayment.getPKDummy();
        this.id = auditPayment.getId();
    }
    @DynamoDBIgnore
    public AuditPayment getAuditPayment(){
        return new AuditPayment(
                this.id
        );
    }


}
