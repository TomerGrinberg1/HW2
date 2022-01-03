public class Clock {
     static final int HOUR_MIN_VALUE = 0;
     static final int HOUR_MAX_VALUE = 23;
     static final int MINUTE_MIN_VALUE = 0;
     static final int MINUTE_MAX_VALUE = 59;
     static final int HOUR_DEFAULT_VALUE = 0;
     static final int MINUTE_DEFAULT_VALUE = 0;
      int hour;
      int minute;
    /**
     * initializes a clock
     * @param hour: the hour of the clock
       @param minute: the minute of the clock
     */
    public Clock(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
    }

    /**
     * checks if the time is in range limit
     * @param num
     * @param lowerBound
     * @param upperBound
     * @return true if in range ,else return false
     */
    public boolean inRange(int num, int lowerBound, int upperBound) {
        return num >= lowerBound && num <= upperBound;
    }

    /**
     * set hour for the clock
     * @param hour
     */
    public void setHour(int hour) {
        if (!inRange(hour, HOUR_MIN_VALUE, HOUR_MAX_VALUE)) {
            this.hour = HOUR_DEFAULT_VALUE;
        } else {
            this.hour = hour;
        }
    }

    /**
     * set minutes for the clock
     * @param minute
     */
    public void setMinute(int minute) {
        if (!inRange(minute, MINUTE_MIN_VALUE, MINUTE_MAX_VALUE)) {
            this.minute = MINUTE_DEFAULT_VALUE;
        } else {
            this.minute = minute;
        }
    }

    /**
     * checks if the clock is equal to other clock
     * @param other
     * @return true if the clocks are equal, else return false
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Clock) || this.hashCode()!=other.hashCode()) {
            return false;
        }
        Clock otherClock = (Clock) other;
        return this.hour == otherClock.hour && this.minute == otherClock.minute;
    }

    /**
     * generate a hashcode for a clock
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return 60 * hour + minute-1;
    }

    /**
     * print a clock as required(military time)
     * @return a string contains the time
     */
    @Override
    public String toString() {
        String hours = Integer.valueOf(this.hour).toString(),
               minutes = Integer.valueOf(this.minute).toString();

        if(this.hour<10)
            hours = "0" + hours;
        if(this.minute<10)
            minutes = "0" +minutes;

        return hours + ":" + minutes;
    }
}
