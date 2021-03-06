package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//creating a file Object and provide the file path.
		File src = new File("C://Users//Mohit//eclipse-workspace//ExcelData//TestData.xlsx");
		
		//Create a "FileInputStream" class to read/ write operations in the file and assign file object.
		FileInputStream fis = new FileInputStream(src);
		
		//Creating a "Workbook" class to find excel sheet and assigning the " FileInputStream" class Object.
		//Here we are using ".xlsx" file that's why we are using "XSSFWorkbook" class.
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//If we use ".Xls" file the we need to use "HSSFWorkbook" class.
		//HSSFWorkbook wb = new HSSFWorkbook(fis);
		
		
		//Reading Sheet using the index number. 
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Data from Excel" + data0);
		String data1 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Data from Excel" + data1);
		
		wb.close();
		
	}

}
