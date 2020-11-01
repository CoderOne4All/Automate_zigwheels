package com.automation.datadriven.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.automaton.base.BaseUI;
import com.automaton.base.BikeInfo;
import com.automaton.base.PopularCarInfo;


public class WriteToExcel {
	
	public static void writeInExcel_BikeInfo(List<BikeInfo> details) throws IOException
	{
		FileOutputStream writeFile = new FileOutputStream(BaseUI.prop.getProperty("excelFileName_Bikes"));
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet =  workBook.createSheet(BaseUI.prop.getProperty("excelSheetName"));
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue(BaseUI.prop.getProperty("firstColumnName_Bike"));
		row.createCell(1).setCellValue(BaseUI.prop.getProperty("secondColumnName_Bike"));
		row.createCell(2).setCellValue(BaseUI.prop.getProperty("thirdColumnName_Bike"));
		for(int index=0; index<details.size(); index++)
		{
			row = sheet.createRow(index+1);
			row.createCell(0).setCellValue(details.get(index).bikeName);
			row.createCell(1).setCellValue(details.get(index).bikePrice);
			row.createCell(2).setCellValue(details.get(index).expectedLaunchDate);
		}
		workBook.write(writeFile);
		 writeFile.close();
		 workBook.close();
	}
	
	public static void writeInExcel_CarInfo(List<PopularCarInfo> details) throws IOException
	{
		FileOutputStream writeFile = new FileOutputStream(BaseUI.prop.getProperty("excelFileName_Cars"));
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet =  workBook.createSheet(BaseUI.prop.getProperty("excelSheetName"));
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue(BaseUI.prop.getProperty("firstColumnName_Car"));
		row.createCell(1).setCellValue(BaseUI.prop.getProperty("secondColumnName_Car"));
		for(int index=0; index<details.size(); index++)
		{
			row = sheet.createRow(index+1);
			row.createCell(0).setCellValue(details.get(index).carName);
			row.createCell(1).setCellValue(details.get(index).carCost);
		}
		workBook.write(writeFile);
		 writeFile.close();
		 workBook.close();
		
	}
			

}

