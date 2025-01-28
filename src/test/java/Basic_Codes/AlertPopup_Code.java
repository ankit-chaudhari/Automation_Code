package Basic_Codes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertPopup_Code {

    static WebDriver driver;

    public static void main(String[] args){

        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Alerts();
        HandleFakeAlter();
        CloseApplication();

    }
    public static void Alerts(){

        driver.findElement(By.xpath("//a[@id='alerttest']")).click();
        driver.findElement(By.xpath("//input[@id='alertexamples']")).click();

        Alert alt = driver.switchTo().alert();

        alt.accept();
        System.out.println("Alert Handle Successfully");

        driver.navigate().back();

    }
    public static void HandleFakeAlter(){
        driver.findElement(By.xpath("//a[@id='fakealerttest']")).click();
        driver.findElement(By.xpath("//input[@id='fakealert']")).click();
        driver.findElement(By.xpath("//button[@class='dialog-button']")).click();
        System.out.println("Fake Alert Handle Successfully");

    }
    public static void CloseApplication(){
        driver.quit();
        System.out.println("Application Closed Successfully");
    }


}
