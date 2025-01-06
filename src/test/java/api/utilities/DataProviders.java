package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    private static final String EXCEL_FILE_PATH = "testData/Userdata.xlsx";
    private static final String SHEET_NAME = "Sheet1";

    @DataProvider(name = "getAllData")
    public Object[][] getAllData() throws Exception {
        XLUtility xlUtility = new XLUtility(EXCEL_FILE_PATH, SHEET_NAME);

        int rowCount = xlUtility.getRowCount();
        int colCount = xlUtility.getColumnCount();

        Object[][] data = new Object[rowCount][colCount];

        // Read all data from Excel sheet
        for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip headers
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = xlUtility.getCellData(i, j);
            }
        }

        xlUtility.close();
        return data;
    }

    @DataProvider(name = "getUserNames")
    public Object[][] getUserNames() throws Exception {
        XLUtility xlUtility = new XLUtility(EXCEL_FILE_PATH, SHEET_NAME);

        int rowCount = xlUtility.getRowCount();

        Object[][] data = new Object[rowCount][1];

        // Read only the "Username" column (assuming it's the first column)
        for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip headers
            data[i - 1][0] = xlUtility.getCellData(i, 1);
        }

        xlUtility.close();
        return data;
    }
}
