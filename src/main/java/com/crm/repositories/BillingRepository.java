package com.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing,Long> {

}
