package com.wipay.payment.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.wipay.payment.dynamodb.configure.DynamoDbConfiguration;
import com.wipay.payment.dynamodb.model.AuditPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamoDBService {
    @Autowired
    private DynamoDbConfiguration dynamoDBConfiguration;

    @Autowired
    private DynamoDBMapper mapper;

    public boolean createTable(String tbl_audit_payment, String PK){

        try {
            String tableName = "tbl_audit_payment";
            AmazonDynamoDB dbClient = dynamoDBConfiguration.amazonDynamoDB();
            CreateTableRequest tableRequest = mapper.generateCreateTableRequest(AuditPayment.class);
            System.out.println(tableExists(tableName));

            dbClient.createTable(tableRequest);
            return true;
        } catch (final ResourceInUseException exception){
            System.err.println(exception.getMessage());
            return false;
        }
    }

    public boolean tableExists(String tableName){
        AmazonDynamoDB dbClient = dynamoDBConfiguration.amazonDynamoDB();
        DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName(tableName);
        DescribeTableResult describeTableResult = dbClient.describeTable(describeTableRequest);
        TableStatus tableStatus = TableStatus.valueOf(describeTableResult.getTable().getTableStatus());
        System.out.println("Table Status: " + tableStatus);

        ListTablesRequest listTablesRequest = new ListTablesRequest()
                .withExclusiveStartTableName(tableName);
        ListTablesResult listTablesResult = dbClient.listTables(listTablesRequest);
        return listTablesResult.getTableNames().contains(tableName);
    }

    public int save(AuditPayment auditPayment){
        AuditPayment dynamoTablePayment = new AuditPayment(auditPayment);
        return saveItem(dynamoTablePayment);

    }


    private int saveItem(AuditPayment auditPayment){
        try{
            mapper.save(auditPayment);
            return 1;
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
            return -1;
        }
    }
    private AuditPayment ReadItemByPk(String PK){
        try {
            return mapper.load(AuditPayment.class, PK);
        }
        catch (Exception exception){
            System.err.println(exception.getMessage());
            return null;
        }
    }

}
