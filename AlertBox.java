package mypack;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class AlertBox {
    public static void main(String a[]) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://nxtgenaiacademy.com/alertandpopup/");

        // 1------> ALERT BOX
        // 2------> Confirm alert BOX
        // 3------> Prompt alert Box
        JavascriptExecutor js;

        js=(JavascriptExecutor)driver;

            //......ALERT BOX--------  1

        By alertBtnLoc=By.name("alertbox");
        WebElement alertBtn=driver.findElement(alertBtnLoc);
        js.executeScript("arguments[0].click();",alertBtn);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

          //......ConfirmAlert Box-----  2

      By confirmAlertBoxLoc=By.xpath("//button[@name='confirmalertbox']");
      WebElement confirmAlertBoxLn=driver.findElement(confirmAlertBoxLoc);
      js.executeScript("arguments[0].click();",confirmAlertBoxLn);
      System.out.println(driver.switchTo().alert().getText());
      driver.switchTo().alert().accept();

            //......Confrim alert box Accept method ------

      By acceptMsg=By.xpath("//p[@id='demo']");

      String expectedMsg="You clicked on OK!";
      String actualMsg=driver.findElement(acceptMsg).getText(),trim;
      if(expectedMsg.equals(actualMsg)) {
          System.out.println("Click Ok");
      }
      else
      {
          System.out.println("You Clicked Not OK");
      }

      //.............Confrim alert box Cancel Method............//


        /*By confirmAlertBoxLoc3=By.xpath("//button[@name='confirmalertbox']");
        WebElement confirmAlertBoxLn3=driver.findElement(confirmAlertBoxLoc3);
        js.executeScript("arguments[0].click();",confirmAlertBoxLn3);
        System.out.println(driver.switchTo().alert().getText());


      driver.switchTo().alert().dismiss();
      By cancelMsg=By.xpath("//p[@id='demo']");
      String expectedMsgf="You clicked on Cancel!";
      String actualMsgf=driver.findElement(cancelMsg).getText().trim();
      if(expectedMsgf.equals(actualMsgf))
      {
          System.out.println("you Click on Cancel");
      }
        else
        {
            System.out.println("Not maching for cancel");

      }*/

                 //...........prompt alert box Yes method................//

        /*By prometAlertBoxLoc=By.xpath("//button[@name='promptalertbox1234']");
        WebElement prometAlertBox=driver.findElement(prometAlertBoxLoc);
        js.executeScript("arguments[0].click();",prometAlertBox);
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().sendKeys("Yes");
        driver.switchTo().alert().accept();
        By yesSelectionMsg=By.xpath("//p[@id='demoone']");
        String expectedMsg2="Thanks for Liking Automation";

        String actualMsg2=driver.findElement(yesSelectionMsg).getText().trim();
        if(expectedMsg2.equals(actualMsg2))
        {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }*/

                    //...........Prompt alert box No Method..............//

        /*By promptAlertBoxLoc1=By.xpath("//button[@name='promptalertbox1234']");
        WebElement promptAlertBox1= driver.findElement(promptAlertBoxLoc1);
        js.executeScript("arguments[0].click();",promptAlertBox1);
        System.out.println(driver.switchTo().alert().getText());



        driver.switchTo().alert().sendKeys("No");
        driver.switchTo().alert().accept();
        By noSelectionMsg=By.xpath("//p[@id='demoone']");
        String expectedMsg4="Sad to hear it ! ";

        String actualMsg4=driver.findElement(noSelectionMsg).getText().trim();
        System.out.println("Checking with expected massage:"+expectedMsg4);

        if(expectedMsg4.equals(actualMsg4))
        {
            System.out.println("No option is not matching");
        }
        else {
            System.out.println("No option is matching");
        }*/




        //....................promet alert box cancel method....................//

        By prometAlertBoxLc2=By.xpath("//button[@name='promptalertbox1234']");
        WebElement prometAlertbox2= driver.findElement(prometAlertBoxLc2);
        js.executeScript("arguments[0].click();",prometAlertbox2);
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().sendKeys("Cancel");
        driver.switchTo().alert().dismiss();
        By selectioncancelMsg=By.xpath("//p[@id='demoone']");
        String expectedMsg5="User cancelled the prompt.";

        String actualMsg5=driver.findElement(selectioncancelMsg).getText().trim();
        System.out.println("Checking with expected massage:"+expectedMsg5);

        if(expectedMsg5.equals(actualMsg5))
        {
            System.out.println("Cancel massage is  matching");
        }
    else {
        System.out.println("Cancel massage is not matching");

        }

        Thread.sleep(2000);


        driver.quit();
    }
}
