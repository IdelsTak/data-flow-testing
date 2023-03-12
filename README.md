# Data Flow Testing

Given the class [`LeapYear`](https://github.com/IdelsTak/data-flow-testing/blob/master/src/main/java/data/flow/testing/LeapYear.java):

- The graph starts with a decision node checking if the `startYear` and `endYear` are within the acceptable range. 
  - If the range is invalid, an exception is thrown; 
  - Otherwise, the loop for iterating through the years between `startYear` and `endYear` starts.
- Within the loop, there is another decision node for checking if the current year is a leap year. 
  - If the year is a leap year, it is stored in the `numberOfYears` array. 
  - If it's not a leap year, the execution flows to another decision node for checking if the year is invalid (less than `1618`). 
  - If the year is invalid, an exception is thrown; otherwise, the loop continues to the next year.
- Once all the years have been checked and stored in the array, the code traverses the unsorted `numberOfYears` array and sorts it in ascending order.
- Finally, the sorted array is returned.

