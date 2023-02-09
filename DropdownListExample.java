package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownListExample {
    public static void main(String a[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        driver.navigate().refresh();
        By DropdownLoc=By.tagName("select");// or By DropdownLoc=By.xpath("//select");

        WebElement ele=driver.findElement(DropdownLoc);
        Select s=new Select(ele);

        s.selectByIndex(5);
        Thread.sleep(5000);
        System.out.println(s.getFirstSelectedOption().getText());
        s.selectByValue("DZA");
        Thread.sleep(5000);
        //System.out.println(s.getFirstSelectedOption().getText());
        //Thread.sleep(5000);
       // s.selectByVisibleText("Australia");
        //System.out.println(s.getFirstSelectedOption().getText());
        List<WebElement> li= s.getOptions();

        for(WebElement e:li)
        {
            if(e.getText().equals(s.getFirstSelectedOption().getText()))
            {
                System.out.println("You selected "+s.getFirstSelectedOption().getText());
            }
        }
driver.quit();
    }
}
