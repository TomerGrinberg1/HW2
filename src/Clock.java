public class Clock {
     static final int HOUR_MIN_VALUE = 0;
     static final int HOUR_MAX_VALUE = 23;
     static final int MINUTE_MIN_VALUE = 0;
     static final int MINUTE_MAX_VALUE = 59;
     static final int HOUR_DEFAULT_VALUE = 0;
     static final int MINUTE_DEFAULT_VALUE = 0;
      int hour;
      int minute;

    public Clock(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
    }

    public boolean inRange(int num, int lowerBound, int upperBound) {
        return num >= lowerBound && num <= upperBound;
    }
    public void setHour(int hour) {
        if (!inRange(hour, HOUR_MIN_VALUE, HOUR_MAX_VALUE)) {
            this.hour = HOUR_DEFAULT_VALUE;
        } else {
            this.hour = hour;
        }
    }
    public void setMinute(int minute) {
        if (!inRange(minute, MINUTE_MIN_VALUE, MINUTE_MAX_VALUE)) {
            this.minute = MINUTE_DEFAULT_VALUE;
        } else {
            this.minute = minute;
        }
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Clock) || this.hashCode()!=other.hashCode()) {
            return false;
        }
        Clock otherClock = (Clock) other;
        return this.hour == otherClock.hour && this.minute == otherClock.minute;
    }
    @Override
    public int hashCode() {
        return 60 * hour + minute-1;
    }

    @Override
    public String toString() {
        String hours = Integer.valueOf(this.hour).toString(),
               minutes = Integer.valueOf(this.minute).toString();

        if(this.hour<10)
            hours = "0" + hours;
        if(this.minute<10)
            minutes = "0" +minutes;

        return hours + ":" + minutes;




        /*
        if(this.hour<10 && this.minute<10)
            return "0"+this.hour+":0"+this.minute;
        if(this.hour<10)
        return "0"+this.hour+":"+this.minute;
        if(this.minute<10)
            return this.hour+":0"+this.minute;
        return this.hour+":"+this.minute;

        */
    }

}
