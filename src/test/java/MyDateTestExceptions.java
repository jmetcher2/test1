import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/*
 * Putting all the exceptional cases in a different test class, easier
 * to do it this way with parameterized tests
 */
@RunWith(Parameterized.class)
public class MyDateTestExceptions {

    @Parameters(name = "{index}: {0} - {1}")
    public static Iterable<MyDateTestCase> data() {
        return Arrays.asList(new MyDateTestCase[] { 
        		new MyDateTestCase("a/1/1970", 0),
        		new MyDateTestCase("2/b/1970", 1),
        		new MyDateTestCase("1/3/c", 59),
        		new MyDateTestCase("0/12/1970", 364),
        		new MyDateTestCase("31/0/1969", -1),
        		new MyDateTestCase("32/3/1970", 59),
        		new MyDateTestCase("29/2/1970", 59),
        		new MyDateTestCase("29/2/1900", 59),
        		new MyDateTestCase("31/9/1970", 59),
        		new MyDateTestCase("31/1970", 59),
        		new MyDateTestCase("", 59),
        		new MyDateTestCase(null, 59),
        		new MyDateTestCase("1/13/1970", 59)
           });
    }
    
    private MyDateTestCase testCase;
    public MyDateTestExceptions(MyDateTestCase tc) {
    	this.testCase = tc;
    }

	@Test(expected=java.lang.Exception.class)
	public void testOfEpoch() {
		MyDate m = MyDate.of(testCase.toDateString);
		assertEquals(testCase.expectedDays, m.getEpochDays());
	}

}
