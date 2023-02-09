package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Highlighter_of_Searching_Box {
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");

        JavascriptExecutor js=(JavascriptExecutor)driver;

        By Searchtext=By.xpath("//input[@name='q']");
        WebElement ele= driver.findElement(Searchtext);
        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",ele);
        ele.sendKeys("software testing", Keys.ENTER);

        Thread.sleep(5000);
        driver.quit();

    }
}
