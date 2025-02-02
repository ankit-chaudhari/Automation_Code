package Using_TestNg;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Handle_Cookies {

    WebDriver driver;
    @BeforeClass
    public void LaunchedApplication() {
        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("Application Launched");
    }
    @Test
    public void TC01_HandleCookiesOnThisPage() throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath("//a[text()='Cookies Controlling Page Access']"));
        String cookies = ele.getText();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",ele);
        System.out.println("Page Scrolling.....");
        if (cookies.contains("Cookies")) {
            ele.click();
            System.out.println("Clicked on Cookies");
            WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
            userName.sendKeys("Admin");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("AdminPass");
            WebElement Subbtn = driver.findElement(By.xpath("//button[@type='submit']"));
            Subbtn.click();
            driver.findElement(By.xpath("//a[text()='Go To Login']")).click();
            Thread.sleep(5000);
            String title = driver.getTitle();
            System.out.println("Title >>" + title);

            // Check if the userName element is displayed
            if (title.equals("Cookie Controlled Admin")) {
                // If the userName is not displayed, print cookies
                Set<Cookie> Cookies = driver.manage().getCookies();
                for (Cookie cookie : Cookies) {
                    System.out.println(cookie.getName() + ": " + cookie.getValue());
                    String cookieText = cookie.getValue();
                    if (cookieText.equals("Admin")){
                        driver.manage().deleteCookie(cookie);
                        System.out.println("Cookie Deleted Succesfully");
                        driver.findElement(By.xpath("//a[@id='gologin']")).click();
                        System.out.println("Cookies for this page Handled Successfully");
                    }
                    else {
                        driver.quit();
                    }
                }
            } else {
                System.out.println("Page Redirect");
            }

        }}






}
