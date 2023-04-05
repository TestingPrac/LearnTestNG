package Day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class expectedExceptionsParameterExample {
    @Test(expectedExceptions = NoSuchElementException.class)
    public void ExpectedExceptionsTestMethod(){
        /*In this method I am intentionally giving wrong locator and trying to click that locator
          for getting NoSuchElementException
          but in expectedExceptions parameter I have given NoSuchElementException.
          So, it will match and test will be passed */

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);


        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/");
        driver.findElement(By.xpath("(//a[text()='Tutorials qwdqwdw'])[1]")).click();
        driver.quit();
    }
}
