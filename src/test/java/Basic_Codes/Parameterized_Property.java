package Basic_Codes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Parameterized_Property {

    static WebDriver driver;
    private static String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    //private static String filePath = "C:\\Users\\A1\\IdeaProjects\\Basic_Automation_Codes\\Properties";


    public static String[] ParameterizationOfPropertyFile(String filePath) {

        try {
            File file = new File(filePath);

            Properties prop = new Properties();

            FileInputStream propFile = new FileInputStream(file);

            prop.load(propFile);

            String username = prop.getProperty("Username");
            String password = prop.getProperty("Password");

            System.out.println("Username - " + username);
            System.out.println("Password - " + password);

            return new String[]{username,password};

        } catch (Exception e) {
            System.out.println("Error Occured due to - " + e.getMessage());
            Assert.fail();
        }
        return null;
    }



}
