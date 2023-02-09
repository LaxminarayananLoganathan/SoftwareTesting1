package mypack;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JavascriptExecuter {
    public static void main(String args[]) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.redbus.in/");

        JavascriptExecutor js=(JavascriptExecutor)driver;


        By Searchtext=By.xpath("//input[@tabindex='1']");
        WebElement ele= driver.findElement(Searchtext);
        ele.sendKeys("Bus Stand, Hosur",Keys.ENTER);
        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",ele);


        By Webtext=By.xpath("//input[@tabindex='2']");
        WebElement el= driver.findElement(Webtext);
        el.sendKeys("Salem",Keys.ENTER);
        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",el);

        By datetext=By.xpath("//input[@tabindex='3']");
        WebElement dateen=driver.findElement(datetext);
        dateen.click();

        WebElement   date=driver.findElement(By.xpath("//div[@class='rb-calendar']//table//tbody//tr[5]//td[2]"));
        date.click();


        WebElement searchButtonLoc= driver.findElement(By.xpath("//button[@id='search_btn']"));
        js.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')",searchButtonLoc);
        searchButtonLoc.click();

        Thread.sleep(5000);

        driver.close();
    }

    public void executeScript(String s, WebElement alertbox) {
    }
}
