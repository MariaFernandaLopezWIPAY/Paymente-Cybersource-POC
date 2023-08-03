package com.wipay.payment.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.wipay.payment.cybersource.PaymentRequest;
import com.wipay.payment.cybersource.model.DTOs.*;
import com.wipay.payment.cybersource.model.Payment;
import com.wipay.payment.dynamodb.DynamoDBService;
import com.wipay.payment.dynamodb.configure.DynamoDbConfiguration;
import com.wipay.payment.dynamodb.model.AuditPayment;
import com.wipay.payment.repositories.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    // TODO: Create object response bussinnes acording

    @Autowired
    private DynamoDBMapper mapper;
    private PaymentRequest paymentRequest = new PaymentRequest();
    
    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    private DynamoDBService dynamoDBService;
    
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
        
        buildPaymentAuditData(paymentResponse);
        System.out.println(paymentResponse);
        
        return paymentResponse;
    }
    
    private void buildPaymentAuditData(PaymentResponseDTO paymentResponse) {
        var data = new AuditPayment();
        data.setPK(paymentResponse.getId()); //parametros nuevos porque los estaba poniendo nulls
        data.setId(paymentResponse.getId()); // "       "       "        "    "       "      "
        data.setIdTransaction(paymentResponse.getId());
        data.setReconciliationId(paymentResponse.getReconciliationId());
        data.setClientReferenceInformationCode(paymentResponse.getClientReferenceInformation().getCode());
        data.setDateTransaction(paymentResponse.getSubmitTimeUtc());
        dynamoDBService.createTable("tbl_audit_payment", data.getId());
        var result = paymentDetailsRepository.save(data);
    }

    @Autowired
    private DynamoDbConfiguration dynamoDBConfiguration;

    public AuditPayment readAudit(String id) {
        AmazonDynamoDB dbClient = dynamoDBConfiguration.amazonDynamoDB();
        DynamoDBMapper mapper = new DynamoDBMapper(dbClient);
        AuditPayment payment = mapper.load(AuditPayment.class, id);
        System.out.println(payment);
        return payment;
    }
    public AuditPayment getTransaction(String id) {
        return readAudit(id);
    }



//    private AuditPayment ReadItemBy(String PK){
//        try {
//
//            System.out.println(PK);
//
//            return mapper.load(AuditPayment.class, PK);
//        }
//        catch (Exception exception){
//            System.err.println(exception.getMessage());
//            return null;
//        }
//    }

    
}
