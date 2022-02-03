package com.orange.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddEmployeeExcel {
	public AddEmployeeExcel() {
		// TODO Auto-generated constructor stub
	}
	
	public static  ArrayList<Object[]> getExcelData() throws InvalidFormatException, IOException {
		
		ArrayList<Object[]> employeeData = new ArrayList<Object[]>();
		FileInputStream file = null;
		try {
				file= new FileInputStream("D:\\eclipse-workspace\\WebSite\\src\\main\\java\\com\\orange\\excelsheets\\HrmOrange.xlsx");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		Sheet sheet=	WorkbookFactory.create(file).getSheet("ADDEMPLOYEE");
		int row= sheet.getLastRowNum();
		int col= sheet.getRow(1).getLastCellNum();
		System.out.println(col);
	
		for (int i = 1; i <=row; i++)
		{
			//	for (int j = 3; j < col;j++) {
					int j=0;
					while(j<col-1) {
				String firstName = sheet.getRow(i).getCell(j).getStringCellValue();
				String middleName= sheet.getRow(i).getCell(++j).getStringCellValue();
				String lastName = sheet.getRow(i).getCell(++j).getStringCellValue();
				String emplyeeId1= sheet.getRow(i).getCell(++j).getStringCellValue();
					
				Object obj[]= {firstName,middleName,lastName,emplyeeId1};
				employeeData.add(obj);
					}
		//	}
			
		}
		return employeeData;
		
}
}
