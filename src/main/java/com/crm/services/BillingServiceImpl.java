package com.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entities.Billing;
import com.crm.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {
	@Autowired
	private BillingRepository billingRepo;

	@Override
	public void saveBill(Billing billing) {
		billingRepo.save(billing);
	}

}
