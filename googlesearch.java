package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.channels.SelectableChannel;
import java.time.Duration;

public class googlesearch {
    public static void main(String args[])
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://www.google.com/");



        By searchtext=By.xpath("//input[@name='q']");
        WebElement ele= driver.findElement(searchtext);
        ele.sendKeys("demo site for test box", Keys.ENTER);

        driver.close();

    }

}
