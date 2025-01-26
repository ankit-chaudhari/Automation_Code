package Basic_Codes;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screeshot_Code {

    WebDriver driver;

    @BeforeClass
    public void initializedBrowser(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test
    public void Take_Screenshot() throws IOException {

        WebElement textLogin = driver.findElement(By.xpath("//h5[text()='Login']"));

        if (textLogin.isDisplayed()) {
            // Cast WebDriver instance to TakesScreenshot interface
            // Take screenshot and store it as a File object
            File destFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define destination for the screenshot
            File srcFile = new File("D://New folder//Failed TC" +"_" + System.currentTimeMillis() + ".png");

            //Copy the screeshot from desired location to expected
            FileHandler.copy(destFile, srcFile);

            System.out.println("Screenshot stored in file");

        }
    }
    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
            System.out.println("Application closed Successfully");
        }
    }
}
