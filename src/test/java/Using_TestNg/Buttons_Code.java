package Using_TestNg;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.systeminfo.model.Size;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Buttons_Code {

    WebDriver driver;
    @BeforeClass
    public void LaunchedApplication() {
        driver = new ChromeDriver();
        driver.get("https://letcode.in/test");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Application Launched");
    }

    @Test
    public void TC01_GotoHomeAndComeBackHereUsingDriverCommand(){

        WebElement buttons = driver.findElement(By.xpath("//a[text()='Click']"));
        buttons.click();
        WebElement gotoHome = driver.findElement(By.xpath("//button[@id='home']"));
        gotoHome.click();
        driver.navigate().to("https://letcode.in/buttons");
        System.out.println("TC01_Passed");

    }
    @Test
    public void TC02_GetTheXAndYCordinates(){
       WebElement butn =   driver.findElement(By.xpath("//button[@id='position']"));
       Point location =  butn.getLocation();
       int xCoordinates = location.x;
       int yCoordinates = location.y;
        System.out.println("X -" + xCoordinates);
        System.out.println("Y -" + yCoordinates);
    }
    @Test
    public void TC03_FindTheColorOfTheButton(){

        String color = driver.findElement(By.xpath("//button[@id='color']")).getCssValue("color");
        System.out.println("Color" +color);
    }
    @Test
    public void TC04_FindTheHeightAndWidthofTheButton() {

        Dimension size = driver.findElement(By.xpath("//button[@id='property']")).getSize();
        int width = size.width;
        int height = size.height;
        System.out.println("Width - " + width);
        System.out.println("Height - " + height);
    }
    @Test
    public void TC05_ConfirmButtonisDisabled(){

        WebElement butn = driver.findElement(By.xpath("(//button[@id='isDisabled'])[1]"));
        boolean isButtonEnabled = butn.isEnabled();
        System.out.println(isButtonEnabled);

        if (isButtonEnabled){
            System.out.println("Button is enabled");
        }
        else {
            System.out.println("Buttton is disabled");
        }

    }
    @Test
    public void TC06_ClickAndHoldButton(){
       try {
           WebElement butn = driver.findElement(By.xpath("(//button[@id='isDisabled'])[2]"));
           Actions actions = new Actions(driver);
           actions.clickAndHold(butn).perform();
           System.out.println("TC06_Passed");
       }
       catch (Exception e){
           System.out.println("Error" + e);
           System.out.println("TC06_Fail");
       }
    }
}
