package com.wipay.payment.cybersource;

import Api.PaymentsApi;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.*;
import com.cybersource.authsdk.core.MerchantConfig;
import com.wipay.payment.cybersource.config.ConfigurationCybersource;
import com.wipay.payment.cybersource.model.Payment;

import java.util.Properties;

public class PaymentRequest {
    
    public static boolean userCapture = false;
    private static String responseCode = null;
    private static String status = null;
    private static Properties merchantProp;
    //TODO: Create
    
    public PtsV2PaymentsPost201Response callService(Payment payment) {
        CreatePaymentRequest requestObj = new CreatePaymentRequest();
        PtsV2PaymentsPost201Response result = null;
        try {
        Ptsv2paymentsClientReferenceInformation clientReferenceInformation = new Ptsv2paymentsClientReferenceInformation();
        clientReferenceInformation.code(payment.getClientReferenceInformation().getCode());
        requestObj.clientReferenceInformation(clientReferenceInformation);
        
        Ptsv2paymentsProcessingInformation processingInformation = new Ptsv2paymentsProcessingInformation();
        processingInformation.capture(false);
        if (userCapture) {
            processingInformation.capture(true);
        }
        
        requestObj.processingInformation(processingInformation);
        
        Ptsv2paymentsPaymentInformation paymentInformation = new Ptsv2paymentsPaymentInformation();
        Ptsv2paymentsPaymentInformationCard paymentInformationCard = new Ptsv2paymentsPaymentInformationCard();
        paymentInformationCard.number(payment.getPaymentInformation().getPaymentInformationCard().getNumber());
        paymentInformationCard.expirationMonth(payment.getPaymentInformation().getPaymentInformationCard().getExpirationMonth());
        paymentInformationCard.expirationYear(payment.getPaymentInformation().getPaymentInformationCard().getExpirationYear());
        paymentInformation.card(paymentInformationCard);
        
        requestObj.paymentInformation(paymentInformation);
        
        Ptsv2paymentsOrderInformation orderInformation = new Ptsv2paymentsOrderInformation();
        Ptsv2paymentsOrderInformationAmountDetails orderInformationAmountDetails = new Ptsv2paymentsOrderInformationAmountDetails();
        orderInformationAmountDetails.totalAmount(payment.getOrderInformation().getOrderInformationAmountDetails().getTotalAmount());
        orderInformationAmountDetails.currency(payment.getOrderInformation().getOrderInformationAmountDetails().getCurrency());
        orderInformation.amountDetails(orderInformationAmountDetails);
        
        Ptsv2paymentsOrderInformationBillTo orderInformationBillTo = new Ptsv2paymentsOrderInformationBillTo();
        orderInformationBillTo.firstName(payment.getOrderInformationBillTo().getFirstName());
        orderInformationBillTo.lastName(payment.getOrderInformationBillTo().getLastName());
        orderInformationBillTo.address1(payment.getOrderInformationBillTo().getAddress1());
        orderInformationBillTo.locality(payment.getOrderInformationBillTo().getLocality());
        orderInformationBillTo.administrativeArea(payment.getOrderInformationBillTo().getAdministrativeArea());
        orderInformationBillTo.postalCode(payment.getOrderInformationBillTo().getPostalCode());
        orderInformationBillTo.country(payment.getOrderInformationBillTo().getCountry());
        orderInformationBillTo.email(payment.getOrderInformationBillTo().getEmail());
        orderInformationBillTo.phoneNumber(payment.getOrderInformationBillTo().getPhoneNumber());
        orderInformation.billTo(orderInformationBillTo);
        
        requestObj.orderInformation(orderInformation);
        
        
   
            merchantProp = ConfigurationCybersource.getMerchantDetails();
            ApiClient apiClient = new ApiClient();
            MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
            apiClient.merchantConfig = merchantConfig;
            PaymentsApi apiInstance = new PaymentsApi(apiClient);
            result = apiInstance.createPayment(requestObj);
            
            responseCode = apiClient.responseCode;
            status = apiClient.status;
            System.out.println("ResponseCode :" + responseCode);
            System.out.println("ResponseMessage :" + status);
            System.out.println(result);
            //WriteLogAudit(Integer.parseInt(responseCode));
            
        } catch (ApiException e) {

            e.printStackTrace();
            //WriteLogAudit(e.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
