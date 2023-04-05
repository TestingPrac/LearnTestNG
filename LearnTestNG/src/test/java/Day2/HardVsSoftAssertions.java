package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

    public WebDriver driver;

    @Test(priority = 1)
    public void launchOrangeHRM() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void loginWithoutEnteringPassword() throws InterruptedException {
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin", Keys.ENTER);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin",Keys.ENTER);
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void HardAssertionPositiveExample(){
        //Validating Title
        String expectedTitle = "Practice.OrangeHRM";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is mismatched");

        //Validating URL
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URL is mismatched");

        //Validating Text in Password Text Field
        String expectedText = "";
        String actualText = driver.findElement(By.name("password")).getAttribute("value");
        Assert.assertEquals(actualText,expectedText,"Text is mismatched");

        //Validating Border color of Password field
        String expectedBorder = "1px solid rgb(235, 9, 16)";
        String actualBorder = driver.findElement(By.name("password")).getCssValue("border");
        Assert.assertEquals(actualBorder,expectedBorder,"Border is mismatched");

        driver.quit();
    }

    @Test(priority = 4)
    public void HardAssertionNegativeExample(){
        //Validating Title By giving wrong expected title
        String expectedTitle = "Practice.OrangeHRM  s";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is mismatched");

        //Validating URL
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URL is mismatched");

        //Validating Text in Password Text Field
        String expectedText = "";
        String actualText = driver.findElement(By.name("password")).getAttribute("value");
        Assert.assertEquals(actualText,expectedText,"Text is mismatched");

        //Validating Border color of Password field
        String expectedBorder = "1px solid rgb(235, 9, 16)";
        String actualBorder = driver.findElement(By.name("password")).getCssValue("border");
        Assert.assertEquals(actualBorder,expectedBorder,"Border is mismatched");

        driver.quit();
    }


    @Test(priority = 5)
    public void SoftAssertionsExample(){
        SoftAssert softAssert = new SoftAssert();
        //Validating Title By giving wrong expected title
        String expectedTitle = "Practice.OrangeHRM  s";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title is mismatched");

        //Validating URL
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String actualURL = driver.getCurrentUrl();
        softAssert.assertEquals(actualURL,expectedURL,"URL is mismatched");

        //Validating Text in Password Text Field
        String expectedText = "";
        String actualText = driver.findElement(By.name("password")).getAttribute("value");
        softAssert.assertEquals(actualText,expectedText,"Text is mismatched");

        //Validating Border color of Password field
        String expectedBorder = "1px solid rgb(235, 9, 16)";
        String actualBorder = driver.findElement(By.name("password")).getCssValue("border");
        softAssert.assertEquals(actualBorder,expectedBorder,"Border is mismatched");

        driver.quit();
        softAssert.assertAll();
    }


}
