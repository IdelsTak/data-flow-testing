/*
 * Copyright 2021
 */
package data.flow.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Whereas the tests in {@link BranchTests} checked whether
 * {@link LeapYear#orderedLeapYearsInRange(int, int)} returned some valid leap
 * years, it did not check whether it returned no leap year when given a range
 * that did not contain leap years.
 * <p>
 * The purpose of this test class is to thus test whether {@link LeapYear} would
 * return an {@code Array} filled with only zeros when it is tested with a range
 * which does not have any valid leap years.
 * <p>
 * So, if passed the range {@code (2001, 2003)} and {@code (2009, 2011)} the
 * class {@link LeapYear} should return an {@code Array} filled with {@code 0}.
 */
public class EquivalenceTest {

    @Test
    public void testNotLeapYear() {
        int[] leapYearArr = LeapYear.orderedLeapYearsInRange(2001, 2003);

        assertEquals(0, leapYearArr[0]);

        leapYearArr = LeapYear.orderedLeapYearsInRange(2009, 2011);

        for (int i = 0; i < leapYearArr.length; i++) {
            assertEquals(0, leapYearArr[i]);
        }
    }

}
