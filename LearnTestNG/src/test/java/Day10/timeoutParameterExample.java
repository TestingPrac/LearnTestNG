package Day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class timeoutParameterExample {
    @Test(timeOut = 20000)
    public void timeOutTestMethod(){
        /*In this method I am checking whether I can open the below website before 20 sec,
          if it takes more than 20sec then test will fail*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);


        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/");
        driver.quit();
    }
}
