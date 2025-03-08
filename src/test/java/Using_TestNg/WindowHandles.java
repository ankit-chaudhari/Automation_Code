package Using_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandles {

    WebDriver driver ;
    @Test
    public void WindowHandle() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Windows.html");

        driver.findElement(By.xpath("(//a[contains(text(),'Open') and contains (@class,'analystic')])[2]")).click();

        driver.findElement(By.xpath("//button[contains(@onclick,'newwindow()')]")).click();
        Thread.sleep(2000);
        String mainWindow = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();

        for (String window : allwindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println(window);
                break;
            }
        }
    }

}
