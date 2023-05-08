package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.dto.PdfGenerator;
import com.crm.entities.Billing;
import com.crm.entities.Contact;
import com.crm.services.BillingService;
import com.crm.services.ContactService;

@Controller
public class BillingController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private BillingService billingService;
	@Autowired
	private PdfGenerator pdfGenerator;
	@RequestMapping("/generateBill")
	public String viewBillingPage(@RequestParam("id") long id,Model model) {
		Contact contact=contactService.getContactById(id);
		model.addAttribute("contact", contact);
        return"generate_bill";
}
	//Save the bill in database & show invoice
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("billing") Billing billing, ModelMap model) {
	billingService.saveBill(billing);
	PdfGenerator pdf =new PdfGenerator();
	String filePath = "D:\\STSV4.17\\zohocrm_1\\ticket" + billing.getId() + ".pdf";
	 pdfGenerator.generatePdf(billing, filePath);

	model.addAttribute("billing", billing);
	return "bill_info";
}
}
