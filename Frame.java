package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

    public static  void main(String a[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        driver.get("https://demoqa.com/frames");

        WebElement ele=driver.findElement(By.id("frame1"));
        driver.switchTo().frame(ele);
        WebElement h1tag=driver.findElement(By.xpath("//h1[text()='This is a sample page']"));

        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",h1tag);
        System.out.println(h1tag.getText());

        //switch to main page

        driver.switchTo().defaultContent();
        WebElement mainpageLoc=driver.findElement(By.xpath("//div[text()='Frames']"));
        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",mainpageLoc);


        // switch to second window

        WebElement elem=driver.findElement(By.id("frame2"));
        driver.switchTo().frame(elem);
        WebElement h2tag=driver.findElement(By.xpath("//h1[text()='This is a sample page']"));

        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",h2tag);
        System.out.println(h2tag.getText());


        Thread.sleep(5000);
        driver.quit();

    }
}
