package com.wipay.payment.repositories;

import com.wipay.payment.dynamodb.model.AuditPayment;
import org.springframework.data.repository.CrudRepository;

@org.socialsignin.spring.data.dynamodb.repository.EnableScan
public interface PaymentDetailsRepository extends CrudRepository<AuditPayment, String> {
}

