package com.crm.services;

import java.util.List;

import com.crm.entities.Lead;

public interface LeadService {

	void saveOneLead(Lead lead);

	Lead findLeadById(long id);

	void deleteLeadById(long id);

	public List<Lead> getAllLeads();

}
