package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeDayTwo1 {

    public WebDriver driver;

    @Test
    public void launchingBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openGoogleAndSearchingOrangeHRMInGoogle() {
        driver.get("https://www.google.com/");
        WebElement google = driver.findElement(By.name("q"));
        google.sendKeys("Practice.OrangeHRM");
        google.sendKeys(Keys.ENTER);
    }

}
