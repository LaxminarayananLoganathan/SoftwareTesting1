package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownAmazon {
    public static void main(String []args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.in/");
        driver.navigate().refresh();
        By dropdownlock=By.tagName("select");
        WebElement ele= driver.findElement(dropdownlock);
        Select s=new Select(ele);

// List<WebElement> li=driver.findElements(By.xpath("option"));
        // for(WebElement elee:li)
        //{
        // System.out.println(elee.getAttribute("value"));
        // System.out.println(ele.getText());
        //}

        s.selectByValue("search-alias=aps");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=alexa-skills");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=amazon-devices");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=fashion");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=nowstore");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=amazon-pharmacy");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=appliances");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=mobile-apps");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=baby");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=beauty");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=stripbooks");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=automotive");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=apparel");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=collectibles");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=computers");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=todays-deals");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=electronics");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=furniture");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=lawngarden");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=gift-cards");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=grocery");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=hpc");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=kitchen");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=industrial");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=jewelry");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=digital-text");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=luggage");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=luxury-beauty");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=dvd");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=popular");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=mi");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=office-products");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=pets");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=instant-video");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=shoes");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=software");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=sporting");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=specialty-aps-sns");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=home-improvement");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=toys");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=under-ten-dollars");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=videogames");
        System.out.println(s.getFirstSelectedOption().getText());

        s.selectByValue("search-alias=watches");
        System.out.println(s.getFirstSelectedOption().getText());

        Thread.sleep(2000);




        driver.quit();
    }

}
