package Day8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithSingleDimensionArray {

    //DataProvidersType1 1D Array

    @Test(priority = 1,dataProvider = "dp1")
    public void DataProvidersType1String(String s){
        System.out.println(s);
    }

    @Test(priority = 2,dataProvider = "dp2")
    public void DataProvidersType1Integer(Integer i){
        System.out.println(i);
    }

    @Test(priority = 3,dataProvider = "dp3")
    public void DataProvidersType1Object(Object o){
        System.out.println(o);
    }

    @DataProvider
    public String[] dp1(){
        String[] data = new String[]{
                "Hello",
                "World"
        };
        return data;
    }

    @DataProvider
    public Integer[] dp2(){
        Integer[] data = new Integer[]{
                1,
                2
        };
        return data;
    }

    @DataProvider
    public Object[] dp3(){
        Object[] data = new Object[]{
                     1,
                "Hello",
                2,
                "World"
        };
        return data;
    }
}
