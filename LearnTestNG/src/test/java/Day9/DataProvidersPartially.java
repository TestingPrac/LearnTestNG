package Day9;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersPartially {

    @Test(priority = 1,dataProvider = "dp1")
    public void DataProvidersType1String(String s){
        System.out.println(s);
    }

    @DataProvider(indices = {0,3})
    public String[] dp1(){
        String[] data = new String[]{
                "India",
                "Pakistan",
                "USA",
                "UK"
        };
        return data;
    }
}
