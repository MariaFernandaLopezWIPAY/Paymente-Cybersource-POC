package com.wipay.payment.cybersource.model;

public class Payment {
    private ClientReferenceInformation clientReferenceInformation;
    private PaymentInformation paymentInformation;
    private OrderInformation orderInformation;
    private OrderInformationBillTo orderInformationBillTo;
    
    
    public ClientReferenceInformation getClientReferenceInformation() {
        return clientReferenceInformation;
    }
    
    public void setClientReferenceInformation(ClientReferenceInformation clientReferenceInformation) {
        this.clientReferenceInformation = clientReferenceInformation;
    }
    
    
    public OrderInformation getOrderInformation() {
        return orderInformation;
    }
    
    public void setOrderInformation(OrderInformation orderInformation) {
        this.orderInformation = orderInformation;
    }
    
    public OrderInformationBillTo getOrderInformationBillTo() {
        return orderInformationBillTo;
    }
    
    public void setOrderInformationBillTo(OrderInformationBillTo orderInformationBillTo) {
        this.orderInformationBillTo = orderInformationBillTo;
    }
    
    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }
    
    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }
}
