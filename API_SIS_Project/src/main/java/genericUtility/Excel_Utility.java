package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;
	}
	
	public void writedataIntoExcel(String sheetName, int rowNum, int cellNum, String value) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		 cell.setCellValue(value);
		 FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		 workbook.write(fos);
	}
	
	public int getLastCellNumber(String sheetName, int rowNum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		int cellNum = row.getLastCellNum();
		return cellNum;
	}
	
	public int getLastRowNumber(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowNum = sheet.getLastRowNum();
		return rowNum;
	}
	
	public double readIntegerFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		double data = cell.getNumericCellValue();
		return data;
	}
}
