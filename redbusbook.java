package mypack;

import com.github.dockerjava.core.command.ListTasksCmdImpl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class redbusbook {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.redbus.in/");

        By Searchtext=By.xpath("//input[@tabindex='1']");
        WebElement ele= driver.findElement(Searchtext);
        ele.sendKeys("Bus Stand, Hosur",Keys.ENTER);

        By Webtext=By.xpath("//input[@tabindex='2']");
        WebElement el= driver.findElement(Webtext);
        el.sendKeys("Salem",Keys.ENTER);

        By datetext=By.xpath("//input[@tabindex='3']");
        WebElement dateen=driver.findElement(datetext);
        dateen.click();

        WebElement   date=driver.findElement(By.xpath("//div[@class='rb-calendar']//table//tbody//tr[5]//td[2]"));
        date.click();


        WebElement elea= driver.findElement(By.xpath("//button[@id='search_btn']"));
        elea.click();

       // Thread.sleep(5000);

        driver.close();
    }
}
