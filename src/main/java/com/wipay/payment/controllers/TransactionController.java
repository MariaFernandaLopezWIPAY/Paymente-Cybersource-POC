package com.wipay.payment.controllers;

import com.wipay.payment.cybersource.model.Transaction;
import com.wipay.payment.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/transactions")
public class TransactionController {
    
    private TransactionService transactionService;
    
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }
}
