package com.wipay.payment.cybersource.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "TransactionTable")
public class Transaction {
    @DynamoDBHashKey(attributeName = "transactionId")
    private String transactionId;
}
