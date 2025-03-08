package Using_TestNg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPopup_Code {

    WebDriver driver;

    @BeforeClass
    public void initialization(){
        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Application Launched Successfully");
    }
    @Test
    public void TC01_ValidateAlertPopup(){
        driver.findElement(By.xpath("//a[@id='alerttest']")).click();
        driver.findElement(By.xpath("//input[@id='alertexamples']")).click();

        Alert alt = driver.switchTo().alert();

        alt.accept();
        System.out.println("Alert Handle Successfully");

        driver.navigate().back();
    }
    @Test
    public void TC02_ValidateHandleFakeAlter(){
        driver.findElement(By.xpath("//a[@id='fakealerttest']")).click();
        driver.findElement(By.xpath("//input[@id='fakealert']")).click();
        driver.findElement(By.xpath("//button[@class='dialog-button']")).click();
        System.out.println("Fake Alert Handle Successfully");
        driver.navigate().back();
    }
    @Test
    public void TC03_HandleAltersFromJavaScript(){

        driver.findElement(By.xpath("//a[@id='alerttest']")).click();
        driver.findElement(By.xpath("(//input[@class='styled-click-button'])[1]")).click();
        String txt = driver.switchTo().alert().getText();
        System.out.println(txt);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmexample")).click();
        driver.switchTo().alert().accept();
        String retnData = driver.findElement(By.xpath("//p[@id='confirmreturn' or @text='true' or @text='false']")).getText();
        System.out.println(retnData);
        if (retnData.equalsIgnoreCase("True")){
            System.out.println("True is shown");
        }
        else {
            System.out.println("Instead of True is shown");
        }

       // driver.switchTo().alert().dismiss();


        driver.findElement(By.xpath("(//input[@class='styled-click-button'])[3]")).click();
        String testData = "Test Value";
        driver.switchTo().alert().sendKeys(testData);
        driver.switchTo().alert().accept();

        String prmtReturn = driver.findElement(By.xpath("//p[@id='promptreturn']")).getText();
        if (testData.equals(prmtReturn)){
            System.out.println("Test Data Validate Successfully");
        }else {
            System.out.println("Something went wrong");
        }


    }






//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }



}
