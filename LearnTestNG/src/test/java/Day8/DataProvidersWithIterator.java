package Day8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProvidersWithIterator {

    @Test(priority = 1,dataProvider = "dp1")
    public void DataProvidersWithIteratorString(String s){
        System.out.println(s);
    }

    @Test(priority = 2,dataProvider = "dp2")
    public void DataProvidersWithIteratorInteger(Integer i){
        System.out.println(i);
    }

    @Test(priority = 3,dataProvider = "dp3")
    public void DataProvidersWithIteratorObject(Object o){
        System.out.println(o);
    }

    @DataProvider
    public Iterator<String> dp1(){
        List<String> data = new ArrayList<>();
        data.add("Hello");
        data.add("World");
        return data.iterator();
    }

    @DataProvider
    public Iterator<Integer> dp2(){
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object> dp3(){
        List<Object> data = new ArrayList<>();
        data.add("Hello");
        data.add("World");
        return data.iterator();
    }
}
