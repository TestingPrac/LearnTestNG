package DataProviderUsingExcelData;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class OrangeHRMLogInGettingTestDataFromExcel {
    @Test(dataProvider = "loginTestData", dataProviderClass = ExcelDataSupplier.class)
    public void LoginOrangeHRM(String Username, String Password) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        WebDriver driver;
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);


        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(4000);

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(Username);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(Password, Keys.ENTER);

        Thread.sleep(2000);
    }
}
