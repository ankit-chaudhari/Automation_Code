package Basic_Codes;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
//import org.apache.commons.io.FileUtils;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class Screeshot_Code {

    @FindBy (xpath = "//h5[text()='Login']")
    private WebElement text;



    @Test
    public void Take_Screenshot(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (text.isDisplayed()){
            System.out.println("Test Pass and Application Launch");
            System.out.println("The Text is" + text);
        }
        else{
            System.out.println("Test Fail Application Launch but UI not visible");

            // Cast WebDriver instance to TakesScreenshot interface
            // Take screenshot and store it as a File object
            File destFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // Define destination for the screenshot
            File srcFile = new File("scre.png");




        }

    }


}
