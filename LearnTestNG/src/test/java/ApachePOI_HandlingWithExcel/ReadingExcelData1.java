package ApachePOI_HandlingWithExcel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingExcelData1 {

    public static void main(String[] args) throws IOException {
        // Workbook -> Sheet -> Row -> Cell ( Column )

        File excelFile = new File("C:\\Users\\a853684\\IdeaProjects\\LearnTestNG\\src\\test\\resources\\ExcelFiles\\Test1.xlsx");
        System.out.println(excelFile.exists());

        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int numberOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println(numberOfRows);


        int numberOfColumns = sheet.getRow(0).getLastCellNum();
        System.out.println(numberOfColumns);

        int numberOfColumns1 = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println(numberOfColumns1);

        int numberOfRowsWithoutHeader = sheet.getLastRowNum();
        System.out.println(numberOfRowsWithoutHeader);

        for(int i=1;i<numberOfRows;i++)
        {
          for(int j=0;j<numberOfColumns;j++)
          {
              DataFormatter df = new DataFormatter();
              System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
              //System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
          }
            System.out.println();
        }

        workbook.close();
        fis.close();

    }
}


