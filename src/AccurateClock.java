class AccurateClock extends Clock {


    private int seconds;
    static final int SECONDS_MIN_VALUE = 0;
    static final int SECONDS_MAX_VALUE = 59;
    static final int SECONDS_DEFAULT_VALUE = 0;
    /**
     * initializes an accurate  clock
     * @param hour: the hour of the clock
     @param minute: the minute of the clock
     @param seconds: the seconds of the clock
     */
    public AccurateClock(int hour, int minute, int seconds) {
       super(hour,minute);
       setSeconds(seconds);
    }
    /**
     * set seconds for the clock
     * @param seconds integer [0,59]
     */
    public void setSeconds(int seconds) {
        if (!inRange(seconds, SECONDS_MIN_VALUE, SECONDS_MAX_VALUE)) {
            this.seconds = SECONDS_DEFAULT_VALUE;
        } else {
            this.seconds = seconds;
        }
    }
    /**
     * checks if the accurate clock is equal to other accurate clock
     * @param other another object(clock \ accurate clock)
     * @return true if the clocks are equal, else return false
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AccurateClock) ) {
            return false;
        }
        AccurateClock otherClock = (AccurateClock) other;
        return super.hour== otherClock.hour && super.minute == otherClock.minute
                && this.seconds==otherClock.seconds ;

    }
    /**
     * generate a hashcode for an accurate clock
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return -(60* super.hour + super.minute +this.seconds);
    }
    /**
     * print an accurate clock as required(military time)
     * @return a string contains the time
     */
    @Override
    public String toString() {
       if(this.seconds<10)
            return super.toString()+":0"+this.seconds;
       else
           return super.toString()+":"+this.seconds;
    }
}