package Using_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Refresh_Page {

    WebDriver driver;

    @BeforeClass
    public void initialization(){
        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Application Launched Successfully");
        driver.findElement(By.id("refreshtest")).click();
    }
    @Test
    public void TC_RefreshTheAndValidateData() throws InterruptedException {

        String previousData = driver.findElement(By.xpath("//span[@id='refreshdate']")).getText();
        System.out.println("Previous Data :- " + previousData);

        driver.findElement(By.xpath("//input[@id='button']")).click();

        Thread.sleep(3000);
        String latestData = driver.findElement(By.xpath("//span[@id='refreshdate']")).getText();
        System.out.println("Latest Data :- "+latestData);

        if (!previousData.equals(latestData)){
            System.out.println("Page Refresh Successfully");
        }
        else {
            System.out.println("Error");
        }

    }


}
