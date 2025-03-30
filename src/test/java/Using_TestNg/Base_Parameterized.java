package Using_TestNg;

import Basic_Codes.Parameterized_Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.PropertyUtils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base_Parameterized extends Parameterized_Property {

    WebDriver driver;

    Parameterized_Property pr;
    static String filePath = "C:\\Users\\A1\\IdeaProjects\\Basic_Automation_Codes\\Properties";

    @BeforeTest
    public void setUp(){


        driver = new ChromeDriver();
        try {
            if (driver != null) {
                driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            } else {
                System.out.println("Driver not found.");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void Login_WithPropertyDetails(){

        try {
            // Getting fetched credentials from property file to base/utility class
            String credentials[] = Parameterized_Property.ParameterizationOfPropertyFile(filePath);

            // Fetched the credentials one by one
            String username = credentials[0];
            String password = credentials[1];

            WebElement usernameFild = driver.findElement(By.xpath("//*[@name='username' and @placeholder='Username']"));
            usernameFild.sendKeys(username);

            WebElement passwordFild = driver.findElement(By.xpath("//*[@name='password' and @placeholder='password']"));
            usernameFild.sendKeys(password);

        } catch (Exception e) {
            System.out.println("Error due to :- "+e.getMessage());
            System.out.println("Test Case Failed");
            Assert.fail();
        }
    }
    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
            System.out.println("Browser Closed");
        }
    }

}
