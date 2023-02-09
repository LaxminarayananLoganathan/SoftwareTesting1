package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class tnpsc {
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        JavascriptExecutor js;

        js=(JavascriptExecutor)driver;

        By tnpsc=By.xpath("//input[@name='q']");
        WebElement ele= driver.findElement(tnpsc);
        ele.sendKeys("tnpsc", Keys.ENTER);

      WebElement tnpsclc= driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
      tnpsclc.click();

      By NewBrowser=By.xpath("//h3[@class='home-title reg-user']");
      WebElement NewBrowserln= driver.findElement(NewBrowser);
      js.executeScript("arguments[0].click();",NewBrowserln);
      driver.switchTo().alert().accept();

      Thread.sleep(500);

        String ParentWindowname= driver.getWindowHandle();

        for(String i: driver.getWindowHandles())
        {
            if(!i.equals(ParentWindowname))
            {
                driver.switchTo().window(i);
                driver.manage().window().maximize();
                WebElement NewBrowserlog= driver.findElement(By.xpath("(//div[@class='frontcircle '])[2]"));
                NewBrowserlog.click();

                WebElement UserName= driver.findElement(By.xpath("(//div[@class='frontcircle '])[2]"));
                UserName.sendKeys("laxminarayanan1993");

                WebElement Password=driver.findElement(By.xpath("//input[@id='PASSWORD']"));
                Password.sendKeys("Narayanan@123");




            }
        }









        Thread.sleep(10000);
        driver.quit();
    }
}
