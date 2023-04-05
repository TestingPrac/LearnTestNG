package ParallelExecutionTypes;

import org.testng.annotations.Test;

public class TestClass3 {
    @Test
    public void testMethod9(){
        System.out.println("TestClass3 -> TestMethod9 -> "+Thread.currentThread().getId());
    }

    @Test
    public void testMethod10(){
        System.out.println("TestClass3 -> TestMethod10 -> "+Thread.currentThread().getId());
    }

    @Test
    public void testMethod11(){
        System.out.println("TestClass3 -> TestMethod11 -> "+Thread.currentThread().getId());
    }

    @Test
    public void testMethod12(){
        System.out.println("TestClass3 -> TestMethod12 -> "+Thread.currentThread().getId());
    }
}
