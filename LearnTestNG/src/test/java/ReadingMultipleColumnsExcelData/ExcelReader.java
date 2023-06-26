package ReadingMultipleColumnsExcelData;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    Object[][] data = null;


    @Test(dataProvider = "logindata")
    public void f(String Uname, String Pword, String type) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
        Username.sendKeys(Uname);
        WebElement Passwrd = driver.findElement(By.xpath("//input[@name='password']"));
        Passwrd.sendKeys(Pword);
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
        System.out.println(type);
    }


    @DataProvider(name = "logindata")
    public Object[][] loginDataprovider() throws IOException {
        data = getExceldata();
        return data;
    }


    public Object[][] getExceldata() throws IOException {
        FileInputStream excel = new FileInputStream("C:\\Users\\a853684\\IdeaProjects\\LearnTestNG\\src\\test\\resources\\ExcelFiles\\Test2.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(excel);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int getRow = sheet.getPhysicalNumberOfRows();
        int getColumn = sheet.getRow(1).getPhysicalNumberOfCells();
        System.out.println("Total rows : " + getRow);
        System.out.println("Total Column : " + getColumn);

        Object[][] testdata = new Object[getRow - 1][getColumn];

        for (int i = 1; i < getRow; i++) {
            for (int j = 0; j < getColumn; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                DataFormatter format = new DataFormatter();
                testdata[i - 1][j] = format.formatCellValue(cell);

            }
        }
        return testdata;
    }
}
