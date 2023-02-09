package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class MouseMoments {
    public static void main(String []args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.ebay.com/");

        JavascriptExecutor js=(JavascriptExecutor)driver;

        WebElement ele=driver.findElement(By.xpath("//a[@_sp='p2481888.m4776.l9803']"));
        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",ele);

        Actions a=new Actions(driver);
        a.moveToElement(ele).perform();

        String path =System.getProperty("user.dir")+ "/Screenshorts/";
        File src;
        File dest;
        TakesScreenshot ts=(TakesScreenshot) driver;
        WebElement section= driver.findElement(By.xpath("//a[@_sp='p2481888.m4776.l9803']"));
        src=section.getScreenshotAs(OutputType.FILE);
        dest=new File(path + String.valueOf(System.currentTimeMillis())+".png");
        FileUtils.copyFile(src,dest);

        ele.click();
//-------------------------------------------------------------------------------------------------------------------
        WebElement elem= driver.findElement(By.xpath("(//span[@itemprop='name'])[1]"));
        js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red;')",elem);
        Actions action=new Actions(driver);
        action.moveToElement(elem).perform();

        String pathe=System.getProperty("user.dir")+"/Screenshorts/";
        File srct;
        File des;

       TakesScreenshot Ts=(TakesScreenshot) driver;
        WebElement eleme= driver.findElement(By.xpath("(//span[@itemprop='name'])[1]"));
        srct=eleme.getScreenshotAs(OutputType.FILE);
        des=new File(pathe+String.valueOf(System.currentTimeMillis())+".png");
        FileUtils.copyFile(srct,des);

        elem.click();
//----------------------------------------------------------------------------------------------------------------------
        Thread.sleep(5000);
        driver.quit();


    }
}
