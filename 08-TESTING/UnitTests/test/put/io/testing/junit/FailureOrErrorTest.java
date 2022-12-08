package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FailureOrErrorTest {
    @Test
    public void test1(){
        assertEquals(5,10);
    }
    @Test
    public void test2() throws Exception {
        throw new Exception("DOESNT WORK");
    }
    @Test
    public void test3(){
        try{
            assertEquals(3,5);
        }catch(Throwable ex){
            ex.printStackTrace();//AssertionFailedError
        }
    }
}
