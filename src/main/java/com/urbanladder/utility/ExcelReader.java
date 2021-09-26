package com.urbanladder.utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static void main(String[] args) throws IOException {
		
//		ArrayList<String> data = getExcelData("TestData","Search");
//		System.out.println(data);
		
	}
	
	public static ArrayList<String> getExcelData(String sheetname,String parameter) throws IOException {
		FileInputStream fis = new FileInputStream(PropertyFileUtil.loadFile().getProperty("excelpath"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int noOfSheets = workbook.getNumberOfSheets();
		XSSFSheet sheet = null;
		for(int i=0;i<noOfSheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetname)) 
			{
			 sheet=workbook.getSheetAt(i);
			}
		}
		Iterator<Row> rows = sheet.iterator();
		ArrayList<String> data = new ArrayList<String>();
		Row firstrow = rows.next();
		Iterator<Cell> ce = firstrow.cellIterator();
		int k = 0;
		int column = 0;
		while (ce.hasNext()) {
			Cell value = ce.next();
			if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
				column = k;
			}
			k++;
		}
		//System.out.println("Col is "+column);
		while (rows.hasNext()) {
			Row r = rows.next();
			Cell name = r.getCell(column);
			if ( name.getStringCellValue().equals(parameter)) {
				Iterator<Cell> c = r.cellIterator();
				Cell value = c.next();
				while(c.hasNext())
				{
					value = c.next();
					//System.out.println(value.getStringCellValue());
					data.add(value.getStringCellValue());
				}
			}
			
		}
		workbook.close();
		return data;
	}
}
