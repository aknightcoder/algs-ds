package problems;

import static org.junit.Assert.*;
import org.junit.Test;

public class TwentyFourHourTimeTest {

    @Test
    public void TestFourHourTimeTest()
    {
        TwentyFourHourTime twentyFourHourTime = new TwentyFourHourTime();

        String result = twentyFourHourTime.timeConversion("07:45:17PM");

        assertEquals("19:45:17", result);
    }
}
