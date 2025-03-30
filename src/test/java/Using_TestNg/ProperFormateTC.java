package Using_TestNg;

import POM_Classes.OrangeHRMBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProperFormateTC {


    WebDriver driver = new ChromeDriver();

    OrangeHRMBase hrm;


    @BeforeTest
    public void setUp(){

        hrm = new OrangeHRMBase(driver);

        String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(baseUrl);

        hrm.loginHRM("Admin","admin123");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void succesfullLoginTest(){

        String pagetitleText = driver.getTitle();
        String ExpectedpagetitleText = "Dashboard";

        Assert.assertEquals(pagetitleText,ExpectedpagetitleText);


    }

}
