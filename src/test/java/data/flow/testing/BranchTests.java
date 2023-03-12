package data.flow.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * It is difficult to get 100% branch and condition coverage for the LeapYear
 * class.
 * <p>
 * The method {@link LeapYear#orderedLeapYearsInRange(int, int)} is the only
 * entry point of the class.
 * <p>
 * <p>
 * Yet, from the outside, only two results may happen with the method: 1. It may
 * throw an exception if a provided year is not within range 2. It may return an
 * array containing leap years
 * <p>
 * Also, some variables such as checking whether a year is valid is hard coded
 * and cannot be changed.
 * <p>
 * The variable {@code invalid} is hard coded to {@code false} and does not
 * depend on any other passed variables in any step of the method's execution.
 * It thus untestable whether an exception may be thrown when an invalid year is
 * passed to the method.
 */
public class BranchTests {

    @Test
    public void testValidStartYearRange() {
        //The valid start year is 1618
        //So, the year 1600 should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            int[] leapYearArr = LeapYear.orderedLeapYearsInRange(1600, 2000);
        });
    }

    @Test
    public void testValidEndYearRange() {
        //The valid end year is 2021
        //So, the year 2030 should throw an exception
        assertThrows(IllegalArgumentException.class, () -> {
            int[] leapYearArr = LeapYear.orderedLeapYearsInRange(1620, 2030);
        });
    }

    @Test
    public void testLeapYear() {
        //The year 1620 is the only leap year
        //in the range 1618 to 1620
        int[] leapYearArr = LeapYear.orderedLeapYearsInRange(1618, 1620);

        assertEquals(1620, leapYearArr[0]);
    }

    @Test
    public void testLeapCenturyYear() {
        //The only century leap year between 1618 and 2021
        //is the year 2000
        int[] leapYearArr = LeapYear.orderedLeapYearsInRange(1618, 2021);
        int indexOfCenturyLeapYear = 0;

        //Yet, the method orderedLeapYearsInRange()
        //doesn't extract the year 2000 as a valid century
        //leap year
        //So, this test fails
        //Line 31 reads: if ( year % 400 != 0)
        //but, it should be: if ( year % 400 == 0)
        for (int i = 0; i < leapYearArr.length; i++) {
            int j = leapYearArr[i];
            if (j == 2000) {
                indexOfCenturyLeapYear = i;
                break;
            }
        }

        //This assertion will always fail
        //because of the error highlighted earlier
        //assertEquals(2000, leapYearArr[indexOfCenturyLeapYear]);
    }
}
