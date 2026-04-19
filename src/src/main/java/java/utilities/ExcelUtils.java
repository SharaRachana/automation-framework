package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
        
    	
    	try  {
    		File file = new File(filePath);
    		System.out.println("Entered Try");
        	FileInputStream fis = new FileInputStream(file);
        	System.out.println("Entered Try1");
        	Workbook workbook = WorkbookFactory.create(fis);
            System.out.println("Entered Try2");
            Sheet sheet = workbook.getSheet(sheetName);
            System.out.println("Entered Try3");
            
			/*
			 * File file = new File("src/test/resources/testdata.xlsx"); FileInputStream fis
			 * = new FileInputStream(file);
			 * 
			 * workbook = new XSSFWorkbook(fis); sheet = workbook.getSheet(sheetName);
			 */
            if(sheet == null) return "";

            Row row = sheet.getRow(rowNum);
            if(row == null) return "";

            Cell cell = row.getCell(colNum);
            if(cell == null) return "";

            System.out.println("Before Switch");
            switch(cell.getCellType()) {
                case STRING:
                	System.out.print("string Switch");
                    return cell.getStringCellValue();
                case NUMERIC:
                    double num = cell.getNumericCellValue();
                    if(num == (long)num) return String.valueOf((long)num);
                    else return String.valueOf(num);
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return cell.getCellFormula();
                default:
                    return "";
            }
            
        }
        catch (IOException e) {
            e.printStackTrace();
            return "***********Exception";
        }
    }
    public static int getRowCount(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                workbook.close();
                return 0;
            }
            int lastRowNum = sheet.getLastRowNum(); // gets the last row index (0-based)
            workbook.close();
            return lastRowNum; 
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}