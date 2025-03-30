package Using_TestNg;

import Basic_Codes.AutomateBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindMultipleElements extends TypesOFBrowserInitiation {

    WebDriver driver;

    @FindBy (xpath = "//*[contains(@class,'_1ch8e_')]")
    private WebElement Products;

    @BeforeTest
    public void initiateBrowser() throws InterruptedException {

       driver = new ChromeDriver();
       driver.get("https://www.flipkart.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    //Get Multiple Element One By One
    public void GetMultipleElementOneByOne(){

        String elements = Products.getText();
        System.out.println(elements);



    }


}
