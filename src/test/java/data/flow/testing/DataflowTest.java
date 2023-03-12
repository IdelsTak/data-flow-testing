package data.flow.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Variable: Boolean invalid
 * Definition: Line 15 of {@link LeapYear}; invalid = false;
 * Use: if invalid == true then an exception is thrown
 * du-path: 15-25-27-39
 * <p>
 * Consider {@link DataflowTest#testInvalidYear()}:
 * There are no leap years between 1618 and 1619
 * So, at {@link LeapYear} line 27, the data flow from the if statement
 * should skip to line 39 which is the next else statement
 * Yet, since at this line the else statement always reads the invalid
 * variable's false value, no exception will ever be thrown
 * from that decision juncture
 */
public class DataflowTest {

    @Test
    public void testInvalidYear() {
        int[] leapYearsArr = LeapYear.orderedLeapYearsInRange(1618, 1619);

        assertNotEquals(1620, leapYearsArr[0]);
    }

}
