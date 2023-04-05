package Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParametersInTestNG {
    public WebDriver driver;

    @Parameters("browserName")
    @BeforeTest
    public void openBrowser(@Optional("Chrome") String browser){

        switch (browser.toLowerCase()){

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Opening Chrome as default browser");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    @Parameters("url")
    @Test
    public void OpenOrangeHRM(String url) throws InterruptedException {

        driver.get(url);
        Thread.sleep(10000);
    }

    @Parameters({"username","password"})
    @Test
    public void enterUserNameAndPassword(@Optional("Admin")String Username,@Optional("admin123")String Password) throws InterruptedException {
        Thread.sleep(3000);
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(Username);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(Password,Keys.ENTER);
        Thread.sleep(2000);
    }

    @Test
    public void loginValidation() throws InterruptedException {
        Thread.sleep(2000);
        String welcomeMessage = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
        System.out.println("UserName Displayed in top right corner of Homepage: " +welcomeMessage);
        //Assert.assertEquals(welcomeMessage,"Chintan Chintan Patel", "Welcome User text Mismatches ");
        boolean welcomeMessageDisplayedOrNot = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed();
        Assert.assertTrue(welcomeMessageDisplayedOrNot);
    }

    @Test
    public void loginFailureErrorMessageValidation() throws InterruptedException {
        Thread.sleep(2000);
        String loginCredentialsErrorMessage = driver.findElement(By.xpath(("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))).getText();
        System.out.println(loginCredentialsErrorMessage);
        boolean invalidCredentialsErrorMessage = driver.findElement(By.xpath(("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))).isDisplayed();
        Assert.assertTrue(invalidCredentialsErrorMessage);
    }

}
