package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alert_popup {
    public static void main(String[]args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://nxtgenaiacademy.com/alertandpopup/");
        JavascriptExecutor js;

        js=(JavascriptExecutor)driver;
        By alertbtn=By.name("Alert Box");


        WebElement alertbox= driver.findElement(alertbtn);
        js.executeScript("arguments[0].click;",alertbox);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.quit();
    }
}
