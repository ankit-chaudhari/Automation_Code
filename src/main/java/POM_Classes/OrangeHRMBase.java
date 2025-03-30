package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrangeHRMBase {


    WebDriver driver;



    public OrangeHRMBase(WebDriver driver){
        this.driver = driver;

    }

    public void loginHRM(String username,String password){

//        WebElement usernameField = driver.findElement(By.xpath("//*[@name='username' and @placeholder='Username']"));
//
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(WebElement usernameField));
//
//        usernameField.click();
//        usernameField.sendKeys(username);
//
//        WebElement passwordField = driver.findElement(By.xpath("//*[@name='password' and @type='password']"));
//        passwordField.click();
//        passwordField.sendKeys(password);
//
//        WebElement submitButton = driver.findElement(By.xpath("//*[@type='submit']"));
//        submitButton.click();

    }



}
