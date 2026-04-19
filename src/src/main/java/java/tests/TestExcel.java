package tests;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestExcel {
    public static void main(String[] args) {
        try {
            String path = "C:\\Users\\Prashanth\\eclipse-workspace\\basicproject\\src\\test\\resources\\testdata.xlsx";
            File file = new File(path);

            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("LoginData");
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(0);

            System.out.println("Cell value: " + cell.getStringCellValue());

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}