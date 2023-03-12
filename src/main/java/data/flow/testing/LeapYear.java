package data.flow.testing;

public class LeapYear {

    /**
     * This method identifies leap years in the given range of years, stores
     * them into an array and orders the array elements in ascending order.
     * Finally returns this ordered array.
     *
     * @param startYear The starting year of the leap year range.
     * @param endYear The ending year of the leap year range.
     * @return an ordered array of leap years. The rest (unfilled out of size
     * 100) of the array (all trailing) elements should be left as 0s.
     * @throws IllegalArgumentException if the year is "invalid" or out of
     * 1618-2021 year range
     */
    public static int[] orderedLeapYearsInRange(int startYear, int endYear) {
        boolean isLeap = false;
        boolean invalid = false;
        int numberOfYears[] = new int[100];
        int k = 0;

        //Validating the year range
        if (startYear < 1618 || endYear > 2021) {
            throw new IllegalArgumentException("Invalid year range: " + startYear + " to " + endYear);
        }

        //Iterating through years between start and end years
        for (int year = startYear; year <= endYear; year++) {
            //Code for checking if the year is a leap year begins
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 != 0) {
                        isLeap = true;
                    } else {
                        isLeap = false;
                    }
                } else {
                    isLeap = true;
                }
            } else if (invalid) {
                throw new IllegalArgumentException("Invalid year: " + year);
            } else {
                isLeap = false;
            }

            //store a leap year in the array
            if (isLeap) {
                numberOfYears[k] = year;
                k++;
            }
        }

        int n = numberOfYears.length;

        //traversing unsorted year array
        for (int i = 0; i < n - 1; i++) {
            //locating the minimum element in array 
            int indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if ((numberOfYears[j] < numberOfYears[indexMin]) && (numberOfYears[j] != 0)) {
                    indexMin = j;
                }
            }

            //swapping elements as required 
            int adhoc = numberOfYears[indexMin];
            numberOfYears[indexMin] = numberOfYears[i];
            numberOfYears[i] = adhoc;
        }

        return numberOfYears;
    }
}
