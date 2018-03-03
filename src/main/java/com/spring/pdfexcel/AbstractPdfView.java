package com.spring.pdfexcel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.das.bo.UserBo1;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
public  class AbstractPdfView extends org.springframework.web.servlet.view.document.AbstractPdfView{
	
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfDocument, PdfWriter pdfWriter, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<UserBo1> users=(List<UserBo1>) model.get("userspdf") ;
		
		Table t=new Table(3);
		for(int i=0;i<users.size();i++) {
			UserBo1 userBo = users.get(i);
			t.addCell(userBo.getUsername());
			t.addCell(userBo.getPassword());
			t.addCell(userBo.getRole());
		 
		}
 
		pdfDocument.add(t);
	}}