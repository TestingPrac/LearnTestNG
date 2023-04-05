package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        String product = "Fish";

        driver.findElement(By.name("keyword")).sendKeys(product);

        System.out.println("Searching A Product: "+product);

        Thread.sleep(3000);

        driver.findElement(By.name("searchProducts")).click();

        System.out.println("Clicking On Search Button");

        Thread.sleep(3000);

        driver.findElement(By.linkText("Salt Water fish from Australia")).click();

        System.out.println("selected last product in search result page successfully");

        Thread.sleep(3000);

        driver.findElement(By.xpath("(//a[text()='Add to Cart'])[2]")).click();

        System.out.println("Item is Added Successfully after clicking on Add to Cart Button");

        Thread.sleep(3000);

        driver.findElement(By.linkText("Remove")).click();

        Thread.sleep(3000);

        System.out.println("Cart is empty after clicking remove button");

        String cartEmptyMessage = driver.findElement(By.xpath("//td[@colspan='8']")).getText();

        System.out.println(cartEmptyMessage);

        driver.quit();

    }
}
