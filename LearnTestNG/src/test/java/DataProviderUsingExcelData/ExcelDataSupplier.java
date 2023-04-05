package DataProviderUsingExcelData;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataSupplier {
    @DataProvider(name = "loginTestData")
    public Object[][] ExcelTestData() throws IOException {
        File excelFile = new File("C:\\Users\\a853684\\IdeaProjects\\LearnTestNG\\src\\test\\resources\\ExcelFiles\\Test1.xlsx");

        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int numberOfRows = sheet.getPhysicalNumberOfRows();

        int numberOfColumns = sheet.getRow(0).getLastCellNum();

        String data[][] = new String[numberOfRows-1][numberOfColumns];
        for(int i=0;i<numberOfRows-1;i++)
        {
            for(int j=0;j<numberOfColumns;j++)
            {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}
