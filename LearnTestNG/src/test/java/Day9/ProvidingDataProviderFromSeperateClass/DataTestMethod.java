package Day9.ProvidingDataProviderFromSeperateClass;

import org.testng.annotations.Test;

public class DataTestMethod {

    @Test(dataProvider = "dp1",dataProviderClass = DataSupplier.class)
    public void DataProvidersType1String(Object o){
        System.out.println(o);
    }
}
