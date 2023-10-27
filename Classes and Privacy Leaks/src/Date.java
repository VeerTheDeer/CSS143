/**
 * Represents a date with the month, day, and year.
 * By Veer Saini
 * 10/27/23
 */
public class Date {
    private int month;
    private int day;
    private int year;

    /**
     * Constructs a Date object with the specified month, day, and year.
     *
     * @param month The month value (1-12).
     * @param day   The day value (1-31).
     * @param year  The year value (2016-2026).
     * @throws IllegalArgumentException if the provided values are out of range.
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        isValid();
    }

    /**
     * Constructs a Date object using the values from another Date object.
     *
     * @param other Another Date object.
     */
    public Date(Date other) {
        this.month = other.month;
        this.day = other.day;
        this.year = other.year;
    }

    /**
     * Retrieves the year value.
     *
     * @return The year value.
     */
    public int getYear() {
        return year;
    }

    /**
     * Retrieves the month value.
     *
     * @return The month value.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Retrieves the day value.
     *
     * @return The day value.
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the year value of the Date object.
     *
     * @param year The year value to set.
     * @throws IllegalArgumentException if the provided value is out of range.
     */
    public void setYear(int year) {
        this.year = year;
        isValid();
    }

    /**
     * Sets the month value of the Date object.
     *
     * @param month The month value to set.
     * @throws IllegalArgumentException if the provided value is out of range.
     */
    public void setMonth(int month) {
        this.month = month;
        isValid();
    }

    /**
     * Sets the day value of the Date object.
     *
     * @param day The day value to set.
     * @throws IllegalArgumentException if the provided value is out of range.
     */
    public void setDay(int day) {
        this.day = day;
        isValid();
    }

    /**
     * Compares the Date object with another Date object to check if it's after.
     *
     * @param compareTo Another Date object for comparison.
     * @return True if the Date object is after the provided Date object; otherwise, false.
     */
    public boolean isAfter(Date compareTo) {
        int thisDays = day + (month * 31) + (year * 365);
        int otherDays = compareTo.day + (compareTo.month * 31) + (compareTo.year * 365);
        return otherDays > thisDays;
    }

    /**
     * Checks equality between Date objects.
     *
     * @param o The object to compare.
     * @return True if the Date objects are equal; otherwise, false.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Date that)) {
            return false;
        }
        return this.year == that.year && this.month == that.month && this.day == that.day;
    }

    /**
     * Converts the Date object to a string.
     *
     * @return A string representation of the Date object in "MM/DD/YYYY" format.
     */
    @Override
    public String toString() {
        String finalStr = "";

        if (month < 10) {
            finalStr += "0" + month + "/";
        } else {
            finalStr += month + "/";
        }

        if (day < 10) {
            finalStr += "0" + day + "/";
        } else {
            finalStr += day + "/";
        }

        return finalStr + year;
    }

    /**
     * Checks and ensures the Date object's validity.
     *
     * @throws IllegalArgumentException if the month, day, or year values are out of range.
     */
    private void isValid() {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month is not between 1 or 12.");
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day is not between 1 or 31.");
        }

        if (year < 2016 || year > 2026) {
            throw new IllegalArgumentException("Year is not between 2016 or 2026");
        }
    }
}
