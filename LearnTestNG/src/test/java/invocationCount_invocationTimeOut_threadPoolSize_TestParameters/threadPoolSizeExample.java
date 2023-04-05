package invocationCount_invocationTimeOut_threadPoolSize_TestParameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class threadPoolSizeExample {
    @Test(invocationCount = 4,threadPoolSize = 2)
    public void readUserNameAndEmail() throws InterruptedException {
         /* invocationCount will help us to execute the
         test method repeatedly which we have given in invocationCount parameter
         threadPoolSize is same like a thread here I am giving threadPoolSize as 2.
         So, the test will be run parallel 2 times */

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);


        driver.manage().window().maximize();

        driver.get("https://randomuser.me/");

        driver.findElement(By.xpath("//li[@data-label='name']")).click();
        Thread.sleep(2000);
        String username = driver.findElement(By.id("user_value")).getText();
        System.out.println("Username : "+username);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//li[@data-label='email']")).click();
        String email = driver.findElement(By.id("user_value")).getText();
        System.out.println("Email : "+email);

        driver.quit();

    }
}
