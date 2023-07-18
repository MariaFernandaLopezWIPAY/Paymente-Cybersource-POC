package com.wipay.payment.Dto;

import Model.PtsV2PaymentsPost201Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentMapper {
    /*public PaymentMapper() throws JsonProcessingException {
    }*/

    public static PaymentDTO mapCybersourceResponseToDTO(PaymentDTO paymentDTO) {
        PtsV2PaymentsPost201Response ptsV2PaymentsPost201Response = new PtsV2PaymentsPost201Response();
        paymentDTO.setClientReferenceInformation(ptsV2PaymentsPost201Response.getClientReferenceInformation());
        paymentDTO.setPaymentInformation(ptsV2PaymentsPost201Response.getPaymentInformation());
        paymentDTO.setOrderInformation(ptsV2PaymentsPost201Response.getOrderInformation());
        paymentDTO.setOrderInformationBillTo(ptsV2PaymentsPost201Response.getOrderInformation().getBillTo());

        return paymentDTO;

    }

   /* PaymentDTO paymentDTO = new PaymentDTO();
    ObjectMapper objectMapper = new ObjectMapper();
    String paymentJson = objectMapper.writeValueAsString(paymentDTO);
    // Serializa el DTO a una cadena JSON
    PaymentDTO deserializedPayment = objectMapper.readValue(paymentJson, PaymentDTO.class);*/

}

