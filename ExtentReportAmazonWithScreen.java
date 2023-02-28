package extentpack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class ExtentReportAmazonWithScreen {
    ExtentReports report;
    ExtentTest test;
    ExtentSparkReporter html;
    WebDriver driver;
    WebDriverWait wait;
    By Searchtext = By.name("q");
    boolean flag = false;
    String searchElement = "Amazon";
    Logger log = Logger.getLogger(ExtentReportAmazonWithScreen.class);



    public String takess() throws IOException {

        String path=System.getProperty("user.dir")+"/Screenshots/";
        TakesScreenshot Ts=(TakesScreenshot)driver;
        File src=Ts.getScreenshotAs(OutputType.FILE);
        File dest=new File(path+System.currentTimeMillis()+".png");
        FileUtils.copyFile(src,dest);
        System.out.println("path="+dest.getAbsolutePath());
        return dest.getAbsolutePath();
    }


    @BeforeTest
    public void settingthebrowser() {
        PropertyConfigurator.configure("log4j.properties");
        System.out.println("Settingup the browser.......!");

        WebDriverManager.chromedriver().setup();
        log.info("Browser setup driver is done");

        driver = new ChromeDriver();
        log.info("Browser initialized");

        driver.get("https://www.google.com/");
        log.info("URL Loaded" + driver.getCurrentUrl());

        driver.manage().window().maximize();
        log.info("Browser Maximized");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        html = new ExtentSparkReporter(System.getProperty("user.dir") + "\\extent-reports\\extent-amazonreport.html");
        html.config().setReportName("AMAZON SERVER PAGE");
        report = new ExtentReports();
        report.attachReporter(html);
        report.setSystemInfo("Amazon Mother of nation:", " America");
        report.setSystemInfo("Amazon Founded Date:", "05/july/1994");
        report.setSystemInfo("Amazon Founder Name:", " Jeff Bezos");
    }

    @Test(priority = 1)
    public void googleSearch() throws IOException
    {
        test = report.createTest("Google Search");

        try
        {
            wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Searchtext));
            if (driver.findElement(Searchtext).isDisplayed()) {
                flag = true;
                test.pass("Search box displayed Successfully");
            } else {
                flag = false;
            }

        } catch (Exception e) {
            flag = false;
            test.fail("Element not found");
        }
        Assert.assertTrue(flag, "Search is not done Because Text Box Element Not displayed for searching");
        driver.findElement(Searchtext).sendKeys(searchElement, Keys.ENTER);
        test.pass("Amazon page Sucessfully Searched: " + flag);
        log.info("Google Search=Amazon");
      //  test.addScreenCaptureFromPath(takess());
    }

@Test(priority = 2)
public void amazon() throws IOException {
    test= report.createTest("Amazon Server page");
    By amazonserverpage= By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]");
   try {
       wait= new WebDriverWait(driver,Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOfElementLocated(amazonserverpage));
       if(driver.findElement(amazonserverpage).isDisplayed())
       {
           flag=true;
           test.pass("Amazon option click");
           log.info("URL Loaded : "+driver.getCurrentUrl());
       }
       else
       {
           flag=false;
       }
    }
   catch (Exception x)
   {
       flag=false;
       test.fail("Element is not found");

   }
   Assert.assertTrue(flag,"Find element is not done Bcz Element Not displayed");
   driver.findElement(amazonserverpage).click();
   test.pass("Successfully enabled button:"+flag);
   log.info("Amazon main page is displayed");
    //test.addScreenCaptureFromPath(takess());

}
@Test(priority = 3)
public void amazontext() throws IOException {
    test=report.createTest("Amazon Element Text Box ");
    By amazontextpage=By.id("twotabsearchtextbox");
    try
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amazontextpage));
        if (driver.findElement(amazontextpage).isDisplayed())
        {
            flag=true;
            test.pass("Amazon index text page will be show successfully");
            log.info("URL Loaded:"+driver.getCurrentUrl());
        }
        else
        {
            flag=false;
        }
    }
    catch (Exception c)
    {
       flag=false;
       test.fail("Element is not found");
    }
    Assert.assertTrue(flag,"Search is not done Bcz Text Box Element Not displayed for searching");
    driver.findElement(amazontextpage).sendKeys("Waterbottle",Keys.ENTER);
    test.pass("User Successfully find out amazon search box:"+flag);
    log.info("Amazon text page =mobile");
    //test.addScreenCaptureFromPath(takess());
}
@Test(priority = 4)
public void Choosingbottle() throws IOException {
    test=report.createTest("Bottle Selected ");
    By bottleorder=By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[28]/div/div/div/div/div/div/div[2]/div[1]/h2/a/span");
    try
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bottleorder));
        if(driver.findElement(bottleorder).isDisplayed())
        {
            flag=true;
            test.pass("Bottle Selected successfully");
            log.info(driver.getCurrentUrl());
        }
        else {
            flag=false;
        }
    }
    catch (Exception p)
    {
        flag=false;
        test.fail("Element is not found");
    }
    Assert.assertTrue(flag,"Select is not done because Not enabled Element Not displayed for searching");
    driver.findElement(bottleorder).click();
    test.pass("Total No of Waterbottle  is viewing:"+flag);
    log.info("Total water bottle is showing ");
    //test.addScreenCaptureFromPath(takess());
}
@Test(priority = 5)
public void confirmbook() throws IOException
{
    test = report.createTest("Confirm order mobile");
    By orderconfirm = By.id("buy-now-button");
    String parentwindowname = driver.getWindowHandle();

    for (String i : driver.getWindowHandles())
    {
        if (!i.equals(parentwindowname))
        {
            driver.switchTo().window(i);
            try
            {
                wait = new WebDriverWait(driver, Duration.ofSeconds(40));
                wait.until(ExpectedConditions.visibilityOfElementLocated(orderconfirm));
                if (driver.findElement(orderconfirm).isDisplayed())
                {
                    flag = true;
                    test.pass("User click BuyNow Button");
                }
                else
                {
                    flag = false;
                }
            }
            catch (Exception t)
            {
                flag = false;
                test.fail("Element is not found");
            }
            Assert.assertTrue(flag, "Select is not done Bcz Not enabled Element Not displayed for searching");
            driver.findElement(orderconfirm).click();
            test.pass("User successfully buynow button will be enabled " + flag);
            log.info("Water bottle order c");
            //test.addScreenCaptureFromPath(takess());
        }

    }
}
@Test(priority = 6)
public void emailid()
{
    test= report.createTest("Enter Valid Mail ID");
    By Emailid= By.id("ap_email");
    try
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Emailid));
        if(driver.findElement(Emailid).isDisplayed())
        {
            flag=true;
            test.pass("User to click email id text box");
        }
        else {
            flag=flag;

        }
    }catch (Exception i)
    {
        flag=false;
        test.fail("Element not found");
    }
    Assert.assertTrue(flag,"MailID Text box not available and text button is not enabled");
    driver.findElement(Emailid).sendKeys("narenloganathan9@gmail.com",Keys.ENTER);
    test.pass("User Entered valid email-ID and entered on continue button"+flag);
    log.info("user enter valid mailid");
}

@Test(priority = 7)
public void password()
{
    test=report.createTest("User Entered password");
    By password=By.id("ap_password");
    try
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        if(driver.findElement(password).isDisplayed())
        {
            flag=true;
            test.pass("User click on password text box");

        }
        else
        {
            flag=false;
        }
    }catch (Exception a)
    {
        flag=false;
        test.fail("Password button is not enabled");
    }
    Assert.assertTrue(flag,"Password text box is not available and text button is not enabled ");
    driver.findElement(password).sendKeys("Narayanan@123",Keys.ENTER);
    test.pass("User Entered valid Password login successfully"+flag);
    log.info("Entered valid password");
}
@Test(priority = 8)
public void cashondeleviery()
{
    test=report.createTest("Cash On Delivery");
    By cash=By.xpath("//input[@value='instrumentId=0h_PE_CUS_18b1c868-2e63-40e2-8b24-414fe05d88c8%2FCash&isExpired=false&paymentMethod=COD&tfxEligible=false']");
    WebElement radio= driver.findElement(By.xpath("//input[@value='instrumentId=0h_PE_CUS_18b1c868-2e63-40e2-8b24-414fe05d88c8%2FCash&isExpired=false&paymentMethod=COD&tfxEligible=false']"));
    if(radio.isSelected())
    {
        System.out.println("Selected"+"value="+radio.getAttribute("value"));
    }
    else {
        System.out.println("not selected");
    }
    try
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cash));
        if(driver.findElement(cash).isDisplayed())
        {
            flag=true;
            test.pass("User to choose the cash on delivery option");
        }
        else {
            flag=false;

        }
    }
    catch (Exception o)
    {
        flag=false;
        test.fail("Element not enabled");
    }
    Assert.assertTrue(flag,"Cash on delivery button is not enabled");
    driver.findElement(cash);
    radio.click();
    test.pass("User Successfully click Cash on delivery/Pay on delivery "+flag);
    log.info("User Choose Cash on delivery");
}
    @Test(priority = 9)
    public void payment()
    {
        test= report.createTest("Payment Method");
        By payment=By.xpath("(//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent'])[1]");
        try
        {
            wait=new WebDriverWait(driver,Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(payment));
            if(driver.findElement(payment).isDisplayed())
            {
                flag=true;
                test.pass("User click payment method Button");
            }
            else
            {
                flag=false;

            }
        }catch (Exception n)
        {
            flag=false;
            test.fail("This element is not enabled");
        }
        Assert.assertTrue(flag,"Payment button is not enabled");
        driver.findElement(payment).click();
        test.pass("User click this payment method"+flag);
        log.info("use this payment method");
    }
    @Test(priority = 10)
    public void placeorder()
    {
        test= report.createTest("Place and order confirmation");
        By place=By.id("bottomSubmitOrderButtonId");
        try
        {
            wait=new WebDriverWait(driver,Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(place));
            if(driver.findElement(place).isDisplayed())
            {
                flag=true;
                test.pass("User click on place your order");
            }
            else
            {
                flag=false;
            }
        }catch (Exception b)
        {
            flag=false;
            test.fail("Element not enabled");
        }
        Assert.assertTrue(flag,"Place order Button is not enabled");
        driver.findElement(place).click();
        test.pass("User ensure valid delivery address after click on place your order button successfully");
        log.info("user click place your order");
    }
    @Test(priority = 11)          //test case ====== 5
    public void cancelorder()
    {
        String parentwindowname = driver.getWindowHandle();
       driver.switchTo().window(parentwindowname);

        test=report.createTest("Order Cancellation");
        By cancel=By.xpath("//*[@id=\"nav-orders\"]");

        try
        {
         wait=new WebDriverWait(driver,Duration.ofSeconds(40));
         wait.until(ExpectedConditions.visibilityOfElementLocated(cancel));
         if(driver.findElement(cancel).isDisplayed())
         {
             flag=true;
             test.pass("User to click returns and orders ");
         }
         else {
             flag=false;
         }
        }catch (Exception d)
        {
            flag=false;
            test.fail("Element not found");
        }
        Assert.assertTrue(flag,"Returns & Orders button not enabled");
        driver.findElement(cancel).click();
        test.pass("User successfully Click returns and orders button");
        log.info("Successfully clicked returns and orders");
    }
    @Test(priority = 12)
    public void cancelconfirm()
    {
        test= report.createTest("cancel confirmation");
        By cancelcnfrm=By.xpath("//a[@id='Cancel-items_2']");
        try
        {
            wait=new WebDriverWait(driver,Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(cancelcnfrm));
            if(driver.findElement(cancelcnfrm).isDisplayed())
            {
                flag=true;
                test.pass("User find out cancel Items button");
            }
            else {
                flag=false;

            }
        }catch (Exception c)
        {
            flag=false;
            test.fail("Element not found");
        }
        Assert.assertTrue(flag,"Cancel button is not enabled");
        driver.findElement(cancelcnfrm).click();
        test.pass("User successfully clicked cancel items button");
        log.info("Cancel items");
    }
    @Test(priority = 13)
    public  void reason()
    {
        test= report.createTest("Reason for cancellation");
        By reason=By.xpath("//*[@id=\"a-page\"]/form/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/select/option[3]");
        try
        {
            wait=new WebDriverWait(driver,Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(reason));
            if(driver.findElement(reason).isDisplayed())
            {
                flag=true;
                test.pass("Cancelling reason is selected");
            }
            else
            {
                flag=false;
            }
        }catch (Exception c)
        {
            flag=false;
            test.fail("Element not found");
        }
        Assert.assertTrue(flag,"This element is not found");
        driver.findElement(reason).click();

        test.pass("user successfully selected reason of cancelling");
        log.info("order cancelled");
    }
    @Test(priority =14 )
    public void cancelitem()
    {
        test= report.createTest("Cancel selected items in this order");
        By orderselect=By.xpath("//input[@aria-labelledby='cancelButton-announce']");
        try
        {
            wait=new WebDriverWait(driver,Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(orderselect));
            if(driver.findElement(orderselect).isDisplayed())
            {
                flag=true;
                test.pass("User find out Cancel selected items in this order ");
            }
            else {
                flag=false;
            }
        }catch (Exception f)
        {
            flag=false;
            test.fail("Element not found");
        }
        Assert.assertTrue(flag,"Cancel selected items button not enabled");
        driver.findElement(orderselect).click();

        test.pass("Successfully clicked Cancel button");
        log.info("Successfully Cancel selected");
    }
    @Test(priority=15)
    public void account()
    {
        test=report.createTest("Your account");
        By youraccount=By.xpath("//*[@id=\"nav-link-accountList\"]");
        try
        {
            wait=new WebDriverWait(driver,Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(youraccount));
            if(driver.findElement(youraccount).isDisplayed())
            {
                flag=true;
                test.pass("User find out the profile");
            }
            else {
                flag=false;
            }
        }catch (Exception g)
        {
            flag=false;
            test.fail("ELement not found");
        }
        Assert.assertTrue(flag,"User account list not enabled");
        driver.findElement(youraccount);
        test.pass("user Get account successfully");
        log.info("User profile to be view");
    }
    @Test(priority = 16)
            public void signout()
    {
        test=report.createTest("User Click logout");
        By logout=By.xpath("//*[@id=\"nav-item-signout\"]/span");
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
            if (driver.findElement(logout).isDisplayed()) {
                flag = true;
                test.pass("User Find out logout button");
            } else {
                flag = false;
            }
        }catch (Exception g)
        {
            flag=false;
            test.fail("Element not  found");
        }
        Assert.assertTrue(flag,"Signout button not enabled");
        driver.findElement(logout).click();
        test.pass("User account successfully signout");
        log.info("User signout the account ");
    }

    @AfterMethod
    public void checkstatus(ITestResult result)
   {
       if(result.getStatus()==ITestResult.SUCCESS)
       {
           test.pass(result.getName()+":"+result.getStatus());
           log.info(result.getName()+"="+result.getStatus());
       }else
       {
           test.fail(result.getThrowable());
           log.info(result.getName()+":"+result.getThrowable());
       }
   }

   @AfterTest
    public void closebrowser() throws InterruptedException {
       Thread.sleep(5000);
       report.flush();
       driver.close();
       log.info("Driver close");
   }
}

