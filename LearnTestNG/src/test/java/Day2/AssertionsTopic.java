package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsTopic {
    @Test
    public void assertionsExample(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        WebElement google = driver.findElement(By.name("q"));
        google.sendKeys("Chennai");
        google.sendKeys(Keys.ENTER);

        String expectedTitle = "Chennai - Google Search";
        String actualTitle = driver.getTitle();
        System.out.println("Expected: "+expectedTitle);
        System.out.println("Actual: "+actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle,"Title is mismatched");

        driver.quit();
    }
}
