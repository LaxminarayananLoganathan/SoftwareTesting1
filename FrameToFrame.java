package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class FrameToFrame {

    public static void main(String[]args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/nestedframes");

        JavascriptExecutor js=(JavascriptExecutor)driver;


        int noofframesinpage=driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total no of frames in the page:"+noofframesinpage);

        WebElement elem= driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(elem);

        int Noofframesinsideparent=driver.findElements(By.tagName("iframe")).size();
        System.out.println("No of frames in parent frame:"+Noofframesinsideparent);

        //Child frame

        driver.switchTo().frame(0);
        int noofframechiled=driver.findElements(By.tagName("iframe")).size();
        System.out.println("Child frame in side "+noofframechiled);
        WebElement frame1element= driver.findElement(By.tagName("body"));
        System.out.println("Child frame element name:"+frame1element.getText());

        //parent frame switch step--------1

      /*  driver.switchTo().defaultContent();
        WebElement elem1= driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(elem1);
        WebElement farmeparent= driver.findElement(By.tagName("body"));
        System.out.println("Parent frame name:"+farmeparent.getText());*/

        //parent frame switch step-----------2

        driver.switchTo().parentFrame();
        WebElement farmeparent= driver.findElement(By.tagName("body"));
        System.out.println("Parent window text:"+farmeparent.getText());

        // Main page of the window
        driver.switchTo().defaultContent();
        WebElement mainpage= driver.findElement(By.xpath("(//span[@class='text'])[14]"));

        System.out.println("Index page is viewing:"+mainpage);


        driver.quit();

    }
}
