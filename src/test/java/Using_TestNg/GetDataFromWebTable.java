package Using_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetDataFromWebTable {

    WebDriver driver;

    @BeforeClass
    public void intiateBrowser(){

        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

    }

    @Test
    public void WebTable(){

        //Get Row Cell Values with entering input data

        int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int cellCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();

        System.out.println("No of Row "+rowCount);
        System.out.println("No of Col "+cellCount);

        for (int i=1;i<rowCount;i++){
            for (int j=1;j<=cellCount;j++){

                String actValue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();

                if(actValue.equals("Mexico")){
                    System.out.println(i+" "+j);
                    break;
                }
            }
        }
    }
    @Test
    public void PrintDataFromTable(){

        //Get Data From The Table
        int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int cellCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();

        //Retrieve the specific data from as row
        String value = driver.findElement(By.xpath("//table[@id='customers']//tr[2]//td[2]")).getText();
        System.out.println(value);

        //Retrieve all the data from the table
        for (int i=1;i<=rowCount;i++){
            for (int j=1;j<=cellCount;j++){
                String data = driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/td["+j+"]")).getText();
                System.out.print(data+" ");
            }
            System.out.println();
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
