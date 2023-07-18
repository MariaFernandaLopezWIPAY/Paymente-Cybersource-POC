package com.wipay.payment.Dto;

import Model.PtsV2PaymentsPost201ResponseClientReferenceInformation;
import Model.PtsV2PaymentsPost201ResponseOrderInformation;
import Model.PtsV2PaymentsPost201ResponseOrderInformationBillTo;
import Model.PtsV2PaymentsPost201ResponsePaymentInformation;
import com.wipay.payment.cybersource.model.ClientReferenceInformation;
import com.wipay.payment.cybersource.model.OrderInformation;
import com.wipay.payment.cybersource.model.OrderInformationBillTo;
import com.wipay.payment.cybersource.model.PaymentInformation;

public class PaymentDTO {
    private ClientReferenceInformation clientReferenceInformation;
    private PaymentInformation paymentInformation;
    private OrderInformation orderInformation;
    private OrderInformationBillTo orderInformationBillTo;

    public PaymentDTO() {
        this.clientReferenceInformation = clientReferenceInformation;
        this.paymentInformation = paymentInformation;
        this.orderInformation = orderInformation;
        this.orderInformationBillTo = orderInformationBillTo;
    }

    public ClientReferenceInformation getClientReferenceInformation() {
        return clientReferenceInformation;
    }

    public void setClientReferenceInformation(ClientReferenceInformation clientReferenceInformation) {
        this.clientReferenceInformation = clientReferenceInformation;
    }

    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
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


    public void setClientReferenceInformation(PtsV2PaymentsPost201ResponseClientReferenceInformation ptsV2PaymentsPost201ResponseClientReferenceInformation) {
        setClientReferenceInformation(clientReferenceInformation);
    }

    public void setPaymentInformation(PtsV2PaymentsPost201ResponsePaymentInformation ptsV2PaymentsPost201ResponsePaymentInformation) {
        setPaymentInformation(paymentInformation);
    }

    public void setOrderInformation(PtsV2PaymentsPost201ResponseOrderInformation ptsV2PaymentsPost201ResponseOrderInformation) {
        setOrderInformation(orderInformation);
    }

    public void setOrderInformationBillTo(PtsV2PaymentsPost201ResponseOrderInformationBillTo ptsV2PaymentsPost201ResponseOrderInformationBillTo) {
        setOrderInformationBillTo(orderInformationBillTo);
    }
}
