package Day8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithMultiDimensionArray {
    //DataProvidersType1 1D Array

    @Test(priority = 1,dataProvider = "dp1")
    public void DataProvidersTypeString1(String[] s){
        System.out.println(s[0]+" >> "+s[1]);
    }

    @Test(priority = 2,dataProvider = "dp1")
    public void DataProvidersTypeString2(String username, String password){
        System.out.println(username+" >> "+password);
    }

    @Test(priority = 3,dataProvider = "dp2")
    public void DataProvidersTypeInteger1(Integer[] i){
        System.out.println(i[0]+" << "+i[1]);
    }

    @Test(priority = 4,dataProvider = "dp2")
    public void DataProvidersTypeInteger2(Integer i1,Integer i2){
        System.out.println(i1+" << "+i2);
    }

    @Test(priority = 5,dataProvider = "dp3")
    public void DataProvidersTypeObject1(Object[] o){
        System.out.println(o[0]+" >> "+o[1]);
    }

    @Test(priority = 6,dataProvider = "dp3")
    public void DataProvidersTypeObject2(Object username, Object password){
        System.out.println(username+" >> "+password);
    }

    @Test(priority = 7,dataProvider = "dp4")
    public void DataProvidersWithJaggedArray(Object[] o){
        int i;
        for (i=0;i<o.length;i++){
            System.out.println(o[i]);
        }
        System.out.println("< Next Array >");
    }

    @DataProvider
    public String[][] dp1(){
        String[][] data = new String[][]{
                {"abc","123"},
                {"xyz","456"}
        };
        return data;
    }

    @DataProvider
    public Integer[][] dp2(){
        Integer[][] data = new Integer[][]{
                {1,2},
                {4,5}
        };
        return data;
    }

    @DataProvider
    public Object[][] dp3(){
        Object[][] data = new Object[][]{
                {"abc","123"},
                {"xyz","456"}
        };
        return data;
    }

    //Jagged Array Example
    @DataProvider
    public Object[][] dp4(){
        Object[][] data = new Object[][]{
                {"abc",123,"pqr"},
                {"xyz",456},
                {"def",789,321}
        };
        return data;
    }
}
