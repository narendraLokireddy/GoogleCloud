package com.spring.pdfexcel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.das.bo.UserBo1;


public class ExcelBuilder extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook  workbook, HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		List<UserBo1> users1=(List<UserBo1>) model.get("usersexcel");
		   HSSFSheet sheet = workbook.createSheet("usersexcel");
		 
		/* 
		 for(int i=0;i<users1.size();i++) {
			 
			 UserBo1 userBo1 = users1.get(i);
			 HSSFRow row = sheet.createRow(i);
			 HSSFCell createCell = row.createCell(1);
			 createCell.setCellValue(userBo1.getUsername());
			HSSFCell createCell2 = row.createCell(2);
			createCell2.setCellValue(userBo1.getPassword());
			HSSFCell createCell3 = row.createCell(3);
			createCell3.setCellValue(userBo1.getRole());
			 
		 }
		 
		 */
		 
		
		sheet.setDefaultColumnWidth(30);
		
		CellStyle style = workbook.createCellStyle();
	    Font font = workbook.createFont();
	             font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("USER NAME");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("PASSWORD");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("ROLES");
		header.getCell(2).setCellStyle(style);
		int rowCount = 1;
		
		for (UserBo1 bo : users1) {
		Row aRow = sheet.createRow(rowCount++);
		aRow.createCell(0).setCellValue(bo.getUsername());
		aRow.createCell(1).setCellValue(bo.getPassword());
		aRow.createCell(2).setCellValue(bo.getRole()) ;	 
	}
		
		
		
		
	}}


