package Using_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Iframes_Handling {

    WebDriver driver;

    @BeforeClass
    public void initializedBrowser(){
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void TC_IframeHandling(){
        driver.findElement(By.xpath("//a[@id='framestest']")).click();

        driver.switchTo().frame(0);
        System.out.println("Iframe Swicthed Successfully");

        //To know how many iframes are present on this page
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        System.out.println("Number of iframes on the page: " + iframes.size());

//        WebElement iframeEle = driver.findElement(By.xpath("//h1[text()='Left']"));
//        String a = iframeEle.getText();
//        System.out.println(a);

    }


}
