package com.wipay.payment.controllers;

import com.wipay.payment.dynamodb.model.AuditPayment;
import com.wipay.payment.repositories.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class AuditController {
    
    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;
    
    @GetMapping("/test/save")
    public ResponseEntity saveAudit() {
        var data = new AuditPayment();
        data.setIdTransaction("hello");
        var result = paymentDetailsRepository.save(data);
      
        return ResponseEntity.created(URI.create("/" + result.getId())).build();
    }
    
    
}
