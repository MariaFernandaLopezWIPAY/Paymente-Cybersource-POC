package com.wipay.payment.services;

import com.wipay.payment.Dto.PaymentDTO;
import com.wipay.payment.Dto.PaymentMapper;
import com.wipay.payment.cybersource.PaymentRequest;
import com.wipay.payment.cybersource.model.*;
import com.wipay.payment.dynamodb.model.AuditPayment;
import com.wipay.payment.repositories.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    // TODO: Create object response bussinnes acording
    private PaymentRequest paymentRequest = new PaymentRequest();
    
    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;
    
    
    
    public String createPaymentRequest(Payment payment) {
        var objResponse = paymentRequest.callService(payment);
        return String.format("Id :%s", objResponse.getId().toString());
    }
    
    public String processPayment() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO = PaymentMapper.mapCybersourceResponseToDTO(paymentDTO);
        // Realiza el procesamiento del pago utilizando los datos del DTO
        ClientReferenceInformation clientReferenceInformation = paymentDTO.getClientReferenceInformation();
        PaymentInformation paymentInformation = paymentDTO.getPaymentInformation();
        OrderInformation orderInformation = paymentDTO.getOrderInformation();
        OrderInformationBillTo orderInformationBillTo = paymentDTO.getOrderInformationBillTo();
        
        String code = clientReferenceInformation.getCode();
        String number = paymentInformation.getPaymentInformationCard().getNumber();
        String totalAmount = orderInformation.getOrderInformationAmountDetails().getTotalAmount();
        String firstName = orderInformationBillTo.getFirstName();
        
        paymentRequest.processPayment(paymentDTO);
        
        /*var data = new AuditPayment();
        data.setIdTransaction(paymentRequest.);
        var result = paymentDetailsRepository.save(data);*/
       
        return String.format("RESULT", code, number, totalAmount, firstName);
        
    }
    
}
