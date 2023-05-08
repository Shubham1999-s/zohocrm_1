package com.crm.dto;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.crm.entities.Billing;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Component

public class PdfGenerator {
	public void generatePdf(Billing billing, String filePath) {
	    Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	    Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	    try {
	        // Create a new PDF document
	        Document document = new Document();

	        // Create a PDF writer that writes to the specified file path
	        PdfWriter.getInstance(document, new FileOutputStream(filePath));

	        // Open the document
	        document.open();

	        // Add content to the document
	        Paragraph title = new Paragraph("Billing Details", catFont);
	        title.setAlignment(Element.ALIGN_CENTER);

	        // Create a table with 2 columns
	        PdfPTable table = new PdfPTable(2);

	        // Add the billing details as cells to the table
	        table.addCell(new PdfPCell(new Phrase("First Name:", smallBold)));
	        table.addCell(new PdfPCell(new Phrase(billing.getFirstName())));

	        table.addCell(new PdfPCell(new Phrase("Last Name:", smallBold)));
	        table.addCell(new PdfPCell(new Phrase(billing.getLastName())));

	        table.addCell(new PdfPCell(new Phrase("Email:", smallBold)));
	        table.addCell(new PdfPCell(new Phrase(billing.getEmail())));

	        table.addCell(new PdfPCell(new Phrase("Mobile:", smallBold)));
	        table.addCell(new PdfPCell(new Phrase(billing.getMobile())));

	        table.addCell(new PdfPCell(new Phrase("Product Name:", smallBold)));
	        table.addCell(new PdfPCell(new Phrase(billing.getProduct())));

	        table.addCell(new PdfPCell(new Phrase("Price:", smallBold)));
	        table.addCell(new PdfPCell(new Phrase(String.valueOf(billing.getPrice()))));

	        // Add the title and table to a new paragraph
	        Paragraph titleAndTable = new Paragraph();
	        titleAndTable.add(title);
	        titleAndTable.add(new Paragraph(" "));
	        titleAndTable.add(table);

	        // Add the new paragraph to the document
	        document.add(titleAndTable);

	        // Close the document
	        document.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
