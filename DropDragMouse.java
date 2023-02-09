package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DropDragMouse {
    public static void main(String[]args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        JavascriptExecutor js=(JavascriptExecutor)driver;


        Actions a=new Actions(driver);

        WebElement Frombank= driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        js.executeScript("arguments[0].setAttribute('Style','backround:blue;border: 2px solid green;')",Frombank);
        WebElement Fromsales= driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
        js.executeScript("arguments[0].setAttribute('Style','backround:green;border: 2px solid yellow;')",Fromsales);

        WebElement FromDepAcc= driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        js.executeScript("arguments[0].setAttribute('Style','backround:red;border: 2px solid blue;')",FromDepAcc);
        WebElement FromDepAmou= driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
        js.executeScript("arguments[0].setAttribute('Style','backround:pink;border: 2px solid brown')",FromDepAmou);


        WebElement FromCriAcc= driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
        js.executeScript("arguments[0].setAttribute('style','backround:green;border: 2px solid black')",FromCriAcc);
        WebElement FromCriAmou= driver.findElement(By.xpath("(//li[@class='placeholder'])[4]"));
        js.executeScript("arguments[0].setAttribute('Style','backround:blue;border: 2px solid red')",FromCriAmou);

        WebElement FiveZero= driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        js.executeScript("arguments[0].setAttribute('style','backround:blue;border: 2px solid pink')",FiveZero);

        String pathe=System.getProperty("user.dir")+"/Screenshorts/";
        File srce;
        File deste;
        TakesScreenshot TS=(TakesScreenshot)driver;
        srce=TS.getScreenshotAs(OutputType.FILE);
        deste=new File(pathe+String.valueOf(System.currentTimeMillis())+".png");
        FileUtils.copyFile(srce,deste);

        a.dragAndDrop(Frombank,FromDepAcc).build().perform();

        Thread.sleep(5000);

        a.dragAndDrop(FiveZero,FromDepAmou).build().perform();

        Thread.sleep(5000);

        a.dragAndDrop(Fromsales,FromCriAcc).build().perform();

        Thread.sleep(5000);

        a.dragAndDrop(FiveZero,FromCriAmou).build().perform();


        String path=System.getProperty("user.dir")+"/Screenshorts/";
        File src;
        File dest;
        TakesScreenshot Ts=(TakesScreenshot)driver;
        src=Ts.getScreenshotAs(OutputType.FILE);
        dest=new File(path+String.valueOf(System.currentTimeMillis())+".png");
        FileUtils.copyFile(src,dest);

        Thread.sleep(5000);
        driver.quit();

    }
}
