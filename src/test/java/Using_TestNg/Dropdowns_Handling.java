package Using_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.internal.TestNamesMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdowns_Handling {

    WebDriver driver;

    @BeforeClass
    public void LaunchedApplication(){
        driver = new ChromeDriver();
        driver.get("https://letcode.in/test");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Application Launched");

        driver.findElement(By.xpath("//a[text()='Drop-Down']")).click();

    }
    @Test
    public void TC01_SimpleDropdown() throws InterruptedException {

        WebElement simpleDrop = driver.findElement(By.xpath("//select[@id='fruits']"));

        Select drop = new Select(simpleDrop);

        drop.selectByVisibleText("Apple");
        System.out.println("Apple Selected");
        Thread.sleep(5000);
        drop.selectByIndex(3);
        System.out.println("Orange Selected");
        Thread.sleep(5000);
        drop.selectByVisibleText("Pine Apple");
        System.out.println("Pine Apple Selected");

        System.out.println("TC01_SimpleDropdown Pass");

    }
    @Test
    public void TC02_MultiSelectableDropdown(){

        WebElement scrollDropdown = driver.findElement(By.id("superheros"));

        // Create Select object
        Select scrolldrop = new Select(scrollDropdown);

        // Get all options
        List<WebElement> options = scrolldrop.getOptions();

        // Convert dropdown options to a list of Strings
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : options){
            optionsText.add(option.getText());         // Extract text
        }
        System.out.println(optionsText);
        System.out.println("TC02_MultiSelectableDropdown");

    }
    @Test
    public void TC03_SelectTheLastProgrammingLanguageAndPrintAllTheOptions(){

        WebElement drop = driver.findElement(By.xpath("//select[@id='lang']"));

        //Create Select Object
        Select dropdown = new Select(drop);

        //Get all options
        List<WebElement> options = dropdown.getOptions();

        // Convert dropdown options into list
        for (WebElement option : options){
            dropdown.selectByVisibleText(option.getText());

        }
        System.out.println("TC03_Pass");

        // Example: Verify that all options are selected
        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        System.out.println("Selected options: ");
        for (WebElement selectedOption : selectedOptions) {
            System.out.println(selectedOption.getText());
        }

    }
    @Test
    public void TC04_SelectIndiausingvalueandprinttheselectedvalue(){

        WebElement drop = driver.findElement(By.xpath("//select[@id='country']"));

        Select dp = new Select(drop);
        dp.selectByIndex(6);
        String ele = dp.getFirstSelectedOption().getText();
        System.out.println(ele);
        System.out.println("TC04_Pass");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
