package Day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderBasics {


    @Test(dataProvider = "loginTestData")
    public void loginOrangeHRM(String Username, String Password) throws InterruptedException {


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

    @DataProvider(name = "loginTestData")
    public Object[][] loginData(){
        Object[][] data = new Object[2][2];

        data[0][0] = "Admin";
        data[0][1] = "admin123";

        data[1][0] = "Admin";
        data[1][1] = "admin";

        return data;
    }
}
