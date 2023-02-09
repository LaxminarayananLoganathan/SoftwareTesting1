package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Windows_Handling {
    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://nxtgenaiacademy.com/multiplewindows/");

        WebDriverWait wait=new WebDriverWait(driver,10);
        By newBrowser=By.xpath("//button[@name='newbrowserwindow123']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(newBrowser));



        driver.findElement(newBrowser).isEnabled();
       System.out.println(driver.findElement(newBrowser).getText());


        Thread.sleep(4000);

        String ParentWindowName=driver.getWindowHandle();
        System.out.println("Parent Window:"+ParentWindowName);

        for(String i:driver.getWindowHandles())
        {
            System.out.println("Window="+i);

            if(!i.equals(ParentWindowName))
            {
               driver.switchTo().window(i);
               driver.manage().window().maximize();

            By newbrowser1=By.xpath("(//a)[1]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(newbrowser1));


               Thread.sleep(5000);

               driver.close();

              break;

            }
        }

        driver.switchTo().window(ParentWindowName);
        driver.quit();
    }
}
