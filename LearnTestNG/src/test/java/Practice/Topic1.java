package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        driver.findElement(By.linkText("Sign In")).click();

        driver.findElement(By.linkText("Register Now!")).click();

        String username = "Modan8";

        //String password = "Modan123";

        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("password")).sendKeys("Modan123");

        driver.findElement(By.name("repeatedPassword")).sendKeys("Modan123");

        driver.findElement(By.name("account.firstName")).sendKeys("Modan");

        driver.findElement(By.name("account.lastName")).sendKeys("Kumar");

        driver.findElement(By.name("account.email")).sendKeys("modan@gmail.com");

        driver.findElement(By.name("account.phone")).sendKeys("0861234544");

        driver.findElement(By.name("account.address1")).sendKeys("Sipcot");

        driver.findElement(By.name("account.address2")).sendKeys("Navalur");

        driver.findElement(By.name("account.city")).sendKeys("Chennai");

        driver.findElement(By.name("account.state")).sendKeys("Tamil Nadu");

        driver.findElement(By.name("account.zip")).sendKeys("603103");

        driver.findElement(By.name("account.country")).sendKeys("India");

        driver.findElement(By.name("account.listOption")).click();

        driver.findElement(By.name("account.bannerOption")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("newAccount")).click();

        System.out.println("Created A New User/Account in JPetStore Successfully");

        driver.findElement(By.linkText("Sign In")).click();

        driver.findElement(By.name("username")).sendKeys(username);

        Thread.sleep(5000);

        driver.findElement(By.name("password")).clear();

        driver.findElement(By.name("password")).sendKeys("Modan123");

        driver.findElement(By.name("signon")).click();

        Thread.sleep(3000);

        driver.quit();


    }

}
