package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin", Keys.ENTER);
        Thread.sleep(20000);
        WebElement username = driver.findElement(By.name("username"));
        //username.click();
        username.sendKeys("admin", Keys.ENTER);
        Thread.sleep(2000);
    }
}
