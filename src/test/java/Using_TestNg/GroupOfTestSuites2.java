package Using_TestNg;

import org.testng.annotations.Test;

public class GroupOfTestSuites2 {

    @Test (groups = {"Smoke"})
    public void TestCase_05(){
        System.out.println("Smoke Test Pass 1");
    }
    @Test (groups = {"Smoke"})
    public void TestCase_06(){
        System.out.println("Smoke Test Pass 2");
    }
    @Test
    public void TestCase_07(){
        System.out.println("Smoke Test Pass 3");
    }


}
