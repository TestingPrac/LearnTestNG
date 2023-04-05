package Day8;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProvidersWithIteratorOfArray {

    @Test(priority = 1,dataProvider = "dp1")
    public void DataProvidersWithIteratorString(String[] s){
        System.out.println(s[0]+">>"+s[1]);
    }

    @Test(priority = 2,dataProvider = "dp2")
    public void DataProvidersWithIteratorInteger(Integer[] i){
        System.out.println(i[0]+"<<"+i[1]+"<<"+i[2]);
    }

    @Test(priority = 3,dataProvider = "dp3")
    public void DataProvidersWithIteratorObject(Object[] o){
        System.out.println(o[0]+">>"+o[1]);
    }

    @DataProvider
    public Iterator<String[]> dp1(){
        List<String[]> data = new ArrayList<>();
        data.add(new String[] {"Hello","Hello"});
        data.add(new String[] {"World","World"});
        return data.iterator();
    }

    @DataProvider
    public Iterator<Integer[]> dp2(){
        List<Integer[]> data = new ArrayList<>();
        data.add(new Integer[] {1,2,3});
        data.add(new Integer[] {4,5,6});
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dp3(){
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[] {"Hello",123});
        data.add(new Object[] {"World",456});
        return data.iterator();
    }
}
