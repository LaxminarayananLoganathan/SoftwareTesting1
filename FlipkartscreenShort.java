package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class FlipkartscreenShort {
    public static void main(String[]args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        By Screen= By.xpath("//input[@name='q']");
        WebElement ele= driver.findElement(Screen);
        ele.sendKeys("Flipkart", Keys.ENTER);

        WebElement ScreenShortMainPage= driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
        ScreenShortMainPage.click();

        String pathe =System.getProperty("user.dir")+"/Screenshorts/";
        File srco;
        File desti;

        TakesScreenshot Ts=(TakesScreenshot) driver;
        srco=Ts.getScreenshotAs(OutputType.FILE);
        desti=new File(pathe+String.valueOf(System.currentTimeMillis())+".png");
        FileUtils.copyFile(srco,desti);







    }
}
