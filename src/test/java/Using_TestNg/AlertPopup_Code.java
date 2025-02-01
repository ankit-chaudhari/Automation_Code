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
    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }



}
