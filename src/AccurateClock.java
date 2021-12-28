class AccurateClock extends Clock {


    private int seconds;
    static final int SECONDS_MIN_VALUE = 0;
    static final int SECONDS_MAX_VALUE = 59;
    static final int SECONDS_DEFAULT_VALUE = 0;

    public AccurateClock(int hour, int minute, int seconds) {
       super(hour,minute);
       setSeconds(seconds);
    }
    public void setSeconds(int seconds) {
        if (!inRange(seconds, SECONDS_MIN_VALUE, SECONDS_MAX_VALUE)) {
            this.seconds = SECONDS_DEFAULT_VALUE;
        } else {
            this.seconds = seconds;
        }
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AccurateClock) ) {
            return false;
        }
        AccurateClock otherClock = (AccurateClock) other;
        return super.hour == otherClock.hour && super.minute == otherClock.minute
                && this.seconds==otherClock.seconds ;

    }
    @Override
    public int hashCode() {
        return -(60* super.hour + super.minute +this.seconds);
    }

    @Override
    public String toString() {
       if(this.seconds<10)
            return super.toString()+":0"+this.seconds;
       else
           return super.toString()+":"+this.seconds;
    }



}