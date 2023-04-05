package Day9.ProvidingDataProviderFromSeperateClass;

import org.testng.annotations.DataProvider;

public class DataSupplier {
    @DataProvider
    public Object[] dp1(){
        Object[] data = new Object[]{
                "India",
                "Pakistan",
                "USA",
                "UK"
        };
        return data;
    }
}
