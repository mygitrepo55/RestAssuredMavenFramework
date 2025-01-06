package api.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLUtility {

    private Workbook workbook;
    private Sheet sheet;

    // Constructor to initialize the workbook and sheet
    public XLUtility(String excelFilePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
    }

    // Get the total number of rows in the sheet
    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    // Get the total number of columns in the sheet
    public int getColumnCount() {
        Row row = sheet.getRow(0); // Assuming the first row has headers
        return row.getLastCellNum();
    }

    // Get the cell data as a String
    public String getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
    }

    // Close the workbook
    public void close() throws IOException {
        workbook.close();
    }
}

