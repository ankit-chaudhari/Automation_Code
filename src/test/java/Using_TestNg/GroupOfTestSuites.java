package Using_TestNg;

import org.testng.annotations.Test;

public class GroupOfTestSuites {


    @Test
    public void TestCase_01(){
        System.out.println("Body of Test Case 01");
    }
    @Test (groups = {"Smoke"})
    public void TestCase_02(){
        System.out.println("Body of Test Case 02");
    }
    @Test (groups = {"Smoke"})
    public void TestCase_03(){
        System.out.println("Body of Test Case 03");
    }


}
