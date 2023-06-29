package ApachePOI_HandlingWithExcel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;

public class CreatingAndWritingAnExcel {

    public static void main(String[] args) throws IOException {
        File file = new File("src/test/resources/ExcelFiles/Excel3.xlsx");
        //FileOutputStream fos = new FileOutputStream(file);
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Test");
//
//
//
//        Row r = sheet.createRow(0);
//        Cell c1 = r.createCell(0);
//        c1.setCellValue("Hello");
//
//
//         FileOutputStream fos = new FileOutputStream(file);
//        workbook.write(fos);
//        workbook.close();

    }
//public static void main(String[] args) throws Exception {
//    System.out.println("i am working");
//    File file = new File("C:\\Users\\a853684\\IdeaProjects\\LearnTestNG\\src\\test\\resources\\ExcelFiles\\Test1.xlsx");
//    FileInputStream stream = new FileInputStream(file);
//    Workbook workbook = new XSSFWorkbook(stream);
//    Sheet sheet = workbook.getSheet("a");
//    for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//        Row row = sheet.getRow(i);
//        for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
//            Cell cell = row.getCell(j);
//            System.out.println(cell);
//        }
//// Cell cell = row.getCell(1);
//// System.out.println(cell);
//    }
//}
//public static void main(String[] args) throws IOException {
//    File file = new File("C:\\Users\\a853684\\IdeaProjects\\LearnTestNG\\src\\test\\resources\\ExcelFiles\\Test1.xlsx");
//    FileInputStream stream = new FileInputStream(file);
//    Workbook workbook = new XSSFWorkbook(stream);
//    Sheet sheet = workbook.getSheet("Sheet1");
//    Row row = sheet.getRow(1);
//    System.out.println("fg");
//    Cell cell = row.getCell(1);
//    System.out.println(cell);
//}

}
