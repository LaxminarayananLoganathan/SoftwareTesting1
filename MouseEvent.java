package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.lang.model.element.Element;
import java.time.Duration;

public class MouseEvent {
    public static void main(String []args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");

        JavascriptExecutor js=(JavascriptExecutor)driver;

       //By mouse=By.xpath("//input[@name='q']");
       //WebElement elem=driver.findElement(mouse);
      // elem.sendKeys("facebook",Keys.ENTER);

        Actions a=new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("(//div[@style='font-family: inherit;'])[2]"))).build().perform();
        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",a);
        driver.findElement(By.linkText("Student Discount")).click();



        /*WebElement facebooklogin= driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
        facebooklogin.click();

        By Mailid=By.xpath("//input[@id='email']");
        WebElement eleme= driver.findElement(Mailid);
        eleme.sendKeys("laxminarayananmech@gmail.com");

        By password=By.xpath("//input[@id='pass']");
        WebElement elemen= driver.findElement(password);
        elemen.sendKeys("lakshminarayanan");


        WebElement signin= driver.findElement(By.xpath("//button[@name='login']"));
        signin.click();*/






        Thread.sleep(5000);
        driver.quit();


    }

}
