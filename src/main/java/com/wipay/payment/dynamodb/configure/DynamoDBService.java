package com.wipay.payment.dynamodb.configure;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.wipay.payment.dynamodb.model.AuditPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamoDBService {
    @Autowired
    private DynamoDbConfiguration dynamoDBConfiguration;

    @Autowired
    private DynamoDBMapper mapper;

    public boolean createTable(String tableName, String pKey){
        AmazonDynamoDB dbClient = dynamoDBConfiguration.amazonDynamoDB();
        CreateTableRequest tableRequest = mapper.generateCreateTableRequest(AuditPayment.class);

        try {

            dbClient.createTable(tableRequest);
            return true;
        } catch (final ResourceInUseException exception){
            System.err.println(exception.getMessage());
            return false;
        }
    }

    public boolean tableExists(String tableName){
        AmazonDynamoDB dbClient = dynamoDBConfiguration.amazonDynamoDB();
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
