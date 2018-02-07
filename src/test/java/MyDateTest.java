import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)public class MyDateTest {

    @Parameters(name = "{index}: {0} - {1}")
    public static Iterable<MyDateTestCase> data() {
        return Arrays.asList(new MyDateTestCase[] { 
        		new MyDateTestCase("1/1/1970", 0),
        		new MyDateTestCase("2/1/1970", 1),
        		new MyDateTestCase("1/3/1970", 59),
        		new MyDateTestCase("31/12/1970", 364),
        		new MyDateTestCase("31/12/1969", -1),
        		new MyDateTestCase("1/1/1972", 730),
        		new MyDateTestCase("29/2/1972", 789),
        		new MyDateTestCase("13/5/1972", 863),
        		new MyDateTestCase("29/2/2000", 11009),
        		new MyDateTestCase("1/1/1968", -730),
        		new MyDateTestCase("29/2/1968", -671),
        		new MyDateTestCase("28/2/1968", -672)
           });
    }
    
    private MyDateTestCase testCase;
    public MyDateTest(MyDateTestCase tc) {
    	this.testCase = tc;
    }

	@Test
	public void testOfEpoch() {
		MyDate m = MyDate.of(testCase.toDateString);
		assertEquals(testCase.expectedDays, m.getEpochDays());
	}

}
