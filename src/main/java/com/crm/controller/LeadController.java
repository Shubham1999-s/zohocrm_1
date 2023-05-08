package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entities.Contact;
import com.crm.entities.Lead;
import com.crm.services.ContactService;
import com.crm.services.LeadService;

 

 

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/viewLead")
	public String viewCreateLead() {
		return"create_lead";
	}
	 @RequestMapping("/saveLead")
	    public String saveLead(@ModelAttribute("lead") Lead lead , ModelMap modelMap) {
	    	leadService.saveOneLead(lead);
	    	modelMap.addAttribute("lead", lead);
	    	 
	        return "lead_info";
	 }
	 @PostMapping("/convertLead")
	    public String convertLead(@RequestParam("id") long id, Model model) {
	    	Lead lead = leadService.findLeadById(id);
	    	Contact contact=new Contact();
	    	contact.setFirstName(lead.getFirstName());
	    	contact.setLastName(lead.getLastName());
	    	contact.setEmail(lead.getEmail());
	    	contact.setMobile(lead.getMobile());
	    	contact.setSource(lead.getSource());
	    	contactService.saveContact(contact);
	    	
	    	leadService.deleteLeadById(id);
	    	List<Contact> contacts = contactService.getAllContacts();
	    	model.addAttribute("contacts", contacts);
	    	 
	    	return "list_contacts";

}
	 @RequestMapping("/listall")
	 public String listAllLeads(Model model) {
		 List<Lead> leads = leadService.getAllLeads();
		 model.addAttribute("leads",leads);
		 return "lead_lists";
		 
	 }
	 @RequestMapping("/leadInfo")
	 public String leadInfo(@RequestParam("id") long id, ModelMap modelMap) {
		 Lead lead = leadService.findLeadById(id);
		 modelMap.addAttribute("lead", lead);
		 return "lead_info";
		 
	 }
}
