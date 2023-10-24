public class Time {

    private int second;
    private int minute;
    private int hour;

    public Time(int second, int minute, int hour) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getSecond() {
        return this.second;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getHour() {
        return this.hour;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
