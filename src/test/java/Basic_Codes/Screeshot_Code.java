package Basic_Codes;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screeshot_Code {

    static WebDriver driver;

    public static void main (String[] args) throws IOException, InterruptedException {

        initializedBrowser();
        Take_Screenshot();
        tearDown();
    }
    public static void initializedBrowser(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        System.out.println("Application Launched Successfully");
    }
    public static void Take_Screenshot() throws IOException, InterruptedException {

        WebElement textLogin = driver.findElement(By.xpath("//h5[text()='Login']"));

        if (textLogin.isDisplayed()) {
            Thread.sleep(2000);
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
    public static void tearDown(){
        if (driver != null){
            driver.quit();
            System.out.println("Application closed Successfully");
        }
    }
}
