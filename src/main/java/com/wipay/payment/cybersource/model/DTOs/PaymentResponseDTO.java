package com.wipay.payment.cybersource.model.DTOs;

public class PaymentResponseDTO {
    
    private String id;
    private String submitTimeUtc;
    private String status;
    private String reconciliationId;
    
    private ErrorInformation errorInformation;
    
    private ClientReferenceInformation clientReferenceInformation;
    
    private ProcessorInformation processorInformation;
    
    private PaymentInformation paymentInformation;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getSubmitTimeUtc() {
        return submitTimeUtc;
    }
    
    public void setSubmitTimeUtc(String submitTimeUtc) {
        this.submitTimeUtc = submitTimeUtc;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getReconciliationId() {
        return reconciliationId;
    }
    
    public void setReconciliationId(String reconciliationId) {
        this.reconciliationId = reconciliationId;
    }
    
    public ErrorInformation getErrorInformation() {
        return errorInformation;
    }
    
    public void setErrorInformation(ErrorInformation errorInformation) {
        this.errorInformation = errorInformation;
    }
    
    public ClientReferenceInformation getClientReferenceInformation() {
        return clientReferenceInformation;
    }
    
    public void setClientReferenceInformation(ClientReferenceInformation clientReferenceInformation) {
        this.clientReferenceInformation = clientReferenceInformation;
    }
    
    public ProcessorInformation getProcessorInformation() {
        return processorInformation;
    }
    
    public void setProcessorInformation(ProcessorInformation processorInformation) {
        this.processorInformation = processorInformation;
    }
    
    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }
    
    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }
}
