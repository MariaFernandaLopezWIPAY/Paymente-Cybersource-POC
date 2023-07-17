package com.wipay.payment.services;

import com.wipay.payment.cybersource.PaymentRequest;
import com.wipay.payment.cybersource.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    // TODO: Create object response bussinnes acording
    private PaymentRequest paymentRequest = new PaymentRequest();
    public String createPaymentRequest(Payment payment){
        var objResponse = paymentRequest.callService(payment);
        return String.format("Id :%s", objResponse.getId().toString());
    }

}
