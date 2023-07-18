package com.wipay.payment.controllers;

import com.wipay.payment.cybersource.model.Payment;
import com.wipay.payment.Dto.PaymentDTO;
import com.wipay.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping ("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    
    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody Payment payment){
        try {
            var response = paymentService.createPaymentRequest(payment);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
            
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception", e);
        }
    }
    @GetMapping("/processPayment/{id}")
    public ResponseEntity<String> processPayment(@PathVariable String id){
        try {
            var response = paymentService.processPayment();
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception", e);
        }
    }



}
