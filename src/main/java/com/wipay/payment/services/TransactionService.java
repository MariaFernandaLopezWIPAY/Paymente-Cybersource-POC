package com.wipay.payment.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.wipay.payment.cybersource.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    
    private DynamoDBMapper dynamoDBMapper;
    @Autowired
    public TransactionService(AmazonDynamoDB amazonDynamoDB){
        this.dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }
    public Transaction saveTransaction(Transaction transaction) {
        dynamoDBMapper.save(transaction);
        
        return  transaction;
    }
}
