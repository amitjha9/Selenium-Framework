package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateAndReadExcelFile {

	public XSSFWorkbook workbook;
	public XSSFSheet worksheet;
	public XSSFRow row;
	public void createFile(String path)
	{
		//XSSFCell cell;
		try {
			File src=new File(path);
			FileInputStream fiStream= new FileInputStream(src);
			workbook=new XSSFWorkbook(fiStream);
			worksheet=workbook.createSheet("sheet2");

			//Create row header
			row=worksheet.createRow(0);
			row.createCell(0).setCellValue("No.");
			row.createCell(1).setCellValue("Name");
			row.createCell(2).setCellValue("Address");
			row.createCell(3).setCellValue("Email");
			//worksheet=workbook.getSheetAt(0);

			//Put the value here in file
			row=worksheet.createRow(1);
			row.createCell(0).setCellValue("1");
			row.createCell(1).setCellValue("Amit");
			row.createCell(2).setCellValue("Bangalore");
			row.createCell(3).setCellValue("amitjha4391@gmail.com");

			//Print the file.
			FileOutputStream fos = new FileOutputStream(src);
			workbook.write(fos);
			fos.close();
			workbook.close();
			System.out.println("File has been create and updated:");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readExcelData()
	{
		Iterator<Sheet> itr = workbook.sheetIterator();
		while (itr.hasNext()) 
		{
			Sheet sheet = itr.next();
			System.out.println("Sheet name is:"+sheet.getSheetName());

			sheet=workbook.getSheetAt(1);
			DataFormatter dataFormatter = new DataFormatter();
			System.out.println("Iterating over row and column using iterator:");
			Iterator<Row> itr1=sheet.rowIterator();
			while (itr1.hasNext()) 
			{
				Row row = itr1.next();

				Iterator<Cell> itr2 = row.cellIterator();
				while (itr2.hasNext()) 
				{
					Cell getcell=itr2.next();
					String cellValue=dataFormatter.formatCellValue(getcell);
					System.out.println(cellValue +"\t");
				}

				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		String path = "./Configuration/Book1.xlsx";
		CreateAndReadExcelFile test = new CreateAndReadExcelFile();
		test.createFile(path);
		test.readExcelData();
	}

}
