package Day7;

import org.testng.annotations.Test;

public class TestGroupDependsOnTestGroups {
    @Test(groups = {"smoke"})
    public void test1(){
        System.out.println("Test1 - Smoke");
    }
    @Test(groups = {"smoke"})
    public void test2(){
        System.out.println("Test2 - Smoke");
    }
    @Test(groups = {"sanity"})
    public void test3(){
        System.out.println("Test3 - Sanity");
    }
    @Test(groups = {"sanity"})
    public void test4(){
        System.out.println("Test4 - Sanity");
    }
    @Test(groups = {"regression"})
    public void test5(){
        System.out.println("Test5 - Regression");
    }
    @Test(groups = {"regression"})
    public void test6(){
        System.out.println("Test6 - Regression");
    }
//    @Test(dependsOnGroups = {"smoke","sanity"})
//    public void test0(){
//        System.out.println("Main Test");
//    }

}
