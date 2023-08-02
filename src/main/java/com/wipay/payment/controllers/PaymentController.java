package com.wipay.payment.controllers;

import com.wipay.payment.cybersource.model.DTOs.PaymentResponseDTO;
import com.wipay.payment.cybersource.model.Payment;
import com.wipay.payment.dynamodb.model.AuditPayment;
import com.wipay.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping ("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    

    @PostMapping (value = "", consumes = "application/json")
    @Operation (summary = "Guarda una transaccion",
            description = "Este metedo guarda una transaccion realiza",
            tags = {"Audit"})
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "OK",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema (implementation = AuditPayment.class))}),
            @ApiResponse (responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse (responseCode = "404", description = " Page Not Found", content = @Content),
            @ApiResponse (responseCode = "500", description = " Internal server error - view logs server", content = @Content)})
    public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody Payment payment) {
        try {
            var response = paymentService.createPaymentRequest(payment);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
            
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception", e);
        }
    }
    
    
}
