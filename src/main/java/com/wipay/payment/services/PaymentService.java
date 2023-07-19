package com.wipay.payment.services;

import com.wipay.payment.cybersource.PaymentRequest;
import com.wipay.payment.cybersource.model.DTOs.*;
import com.wipay.payment.cybersource.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    // TODO: Create object response bussinnes acording
    private PaymentRequest paymentRequest = new PaymentRequest();
    
    public PaymentResponseDTO createPaymentRequest(Payment payment) {
        var paymentResponse = new PaymentResponseDTO();
        var objResponse = paymentRequest.callService(payment);
        paymentResponse.setId(objResponse.getId());
        paymentResponse.setSubmitTimeUtc(objResponse.getSubmitTimeUtc());
        paymentResponse.setStatus(objResponse.getStatus());
        paymentResponse.setReconciliationId(objResponse.getReconciliationId());
        
        var errorInformation = new ErrorInformation();
        errorInformation.setReason(objResponse.getErrorInformation().getReason());
        errorInformation.setMessage(objResponse.getErrorInformation().getMessage());
        paymentResponse.setErrorInformation(errorInformation);
        
        var clientReferenceInformation = new ClientReferenceInformation();
        clientReferenceInformation.setCode(objResponse.getClientReferenceInformation().getCode());
        clientReferenceInformation.setSubmitLocalDateTime(objResponse.getClientReferenceInformation().getSubmitLocalDateTime());
        clientReferenceInformation.setOwnerMerchantId(objResponse.getClientReferenceInformation().getOwnerMerchantId());
        paymentResponse.setClientReferenceInformation(clientReferenceInformation);
        
        var processorInformation = new ProcessorInformation();
        processorInformation.setAuthIndicator(objResponse.getProcessorInformation().getAuthIndicator());
        processorInformation.setApprovalCode(objResponse.getProcessorInformation().getApprovalCode());
        processorInformation.setCardReferenceData(objResponse.getProcessorInformation().getCardReferenceData());
        processorInformation.setTransactionId(objResponse.getProcessorInformation().getTransactionId());
        processorInformation.setNetworkTransactionId(objResponse.getProcessorInformation().getNetworkTransactionId());
        paymentResponse.setProcessorInformation(processorInformation);
        
        var paymentInformation = new PaymentInformation();
        paymentInformation.setBin(objResponse.getPaymentInformation().getBin());
        paymentInformation.setAccountType(objResponse.getPaymentInformation().getAccountType());
        paymentInformation.setIssuer(objResponse.getPaymentInformation().getIssuer());
        paymentInformation.setBinCountry(objResponse.getPaymentInformation().getBinCountry());
        paymentResponse.setPaymentInformation(paymentInformation);
        
        return paymentResponse;
    }
    
}
