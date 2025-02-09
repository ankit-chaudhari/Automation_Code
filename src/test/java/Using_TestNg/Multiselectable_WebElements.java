package Using_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Multiselectable_WebElements {


    WebDriver driver;
    @BeforeClass
    public void LaunchedApplication(){
        driver = new ChromeDriver();
        driver.get("https://letcode.in/test");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Application Launched");

        driver.findElement(By.xpath("(//a[@class='card-footer-item'])[12]")).click();

    }
    @Test
    public void TC01_SelectAllElementsWithUsingActions() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500);");

        Thread.sleep(3000);
        WebElement ele = driver.findElement(By.xpath("//div[text()= ' Playwright ']"));

        Actions a = new Actions(driver);

        a.click(ele);



    }



}
