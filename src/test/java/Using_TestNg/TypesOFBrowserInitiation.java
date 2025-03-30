package Using_TestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class TypesOFBrowserInitiation {


    public static void CloseBrowser(WebDriver driver){
        driver.quit();
    }
    public static void InputBrowserFromUser() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        WebDriver driver = null;
        System.out.println("Enter Browser Name -");
        String BrowserName = sc.nextLine();

        if (BrowserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (BrowserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid Browser");
        }
        Thread.sleep(2000);
        try {
            CloseBrowser(driver);
        } catch (Exception e) {
            // System.out.println(e);
        }
    }
    public static void DependsOnUserInput() {
        //Open and Close the browser depends on User input (Yes/No)
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Do you want to open browser (Yes/No) ");
            String InputResult = sc.nextLine();

            WebDriver driver = null;
            if (InputResult.equalsIgnoreCase("Yes")) {
                driver = new ChromeDriver();
                System.out.println("Browser Opened");
                System.out.println("Do you want to close browser (Yes/No) ");
                String InputResultForClose = sc.nextLine();
                if (InputResultForClose.equalsIgnoreCase("Yes") && driver != null) {
                    CloseBrowser(driver);
                    System.out.println("Browser Closed");
                } else if (InputResultForClose.equalsIgnoreCase("No")) {
                    System.out.println("Continue Work");
                } else {
                    System.out.println("Invalid Input");
                }
            } else if (InputResult.equalsIgnoreCase("No")) {
                System.out.println("No need to open browser");
            } else {
                System.out.println("Invalid Input");
            }
        } catch (Exception e) {

        }

    }


}
