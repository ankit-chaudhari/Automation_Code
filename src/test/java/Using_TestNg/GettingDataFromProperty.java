package Using_TestNg;

import Basic_Codes.Parameterized_Property;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class GettingDataFromProperty extends Parameterized_Property {


    WebDriver driver;

    private String propertyFilePath = "C:\\Users\\A1\\IdeaProjects\\Basic_Automation_Codes\\Propertie";


    @Test
    public void Login_GettingDataFromProperty() throws IOException {

        try {
            File file = new File(propertyFilePath);

            Properties prop = new Properties();

            FileInputStream propFile = new FileInputStream(file);

            prop.load(propFile);

            String username = prop.getProperty("Username");
            String password = prop.getProperty("Password");

            System.out.println("Username - " + username);
            System.out.println("Password - " + password);

        }
        catch (Exception e){
            System.out.println("Error Occured due to - " + e.getMessage());
            Assert.fail();
        }

    }


}
