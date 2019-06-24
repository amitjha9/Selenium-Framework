package com.inetBanking.utilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilities 
{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell column;

	public static int getRowCount(String xlsFilePath) throws IOException
	{
		fis=new FileInputStream(xlsFilePath);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheetAt(0);
		int rowCount=worksheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}

	public static int getCellCount(String excelFilePath, int rownum) throws IOException
	{
		fis=new FileInputStream(excelFilePath);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheetAt(0);
		row=worksheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}

	public static String getCellData(String excelFilePath, int rowNum, int cellNum) throws IOException
	{
		String data;
		fis=new FileInputStream(excelFilePath);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheetAt(0);
		row=worksheet.getRow(rowNum);
		column=row.getCell(cellNum);
		try {
			DataFormatter dataFormatter=new DataFormatter();
			String cellValue=dataFormatter.formatCellValue(column);
			return cellValue;

		} catch (Exception e) {
			data=" ";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String excelFilePath, int rowNum, int cellNum, String data) throws IOException
	{
		fis=new FileInputStream(excelFilePath);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheetAt(0);
		row=worksheet.getRow(rowNum);
		column=row.createCell(cellNum);
		column.setCellValue(data);
		fos=new FileOutputStream(excelFilePath);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
}
