package com.wipay.payment.cybersource.model;

public class OrderInformation {
    private OrderInformationAmountDetails orderInformationAmountDetails;
    
    public OrderInformationAmountDetails getOrderInformationAmountDetails() {
        return orderInformationAmountDetails;
    }
    
    public void setOrderInformationAmountDetails(OrderInformationAmountDetails orderInformationAmountDetails) {
        this.orderInformationAmountDetails = orderInformationAmountDetails;
    }
}
