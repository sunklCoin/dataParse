package coin;

public class AverageDataBean {
    private long timeStamp;
    private byte timeZone;
    private byte averagePress;
    private byte resetingHR;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public byte getAveragePress() {
        return averagePress;
    }

    public void setAveragePress(byte averagePress) {
        this.averagePress = averagePress;
    }

    public byte getResetingHR() {
        return resetingHR;
    }

    public void setResetingHR(byte resetingHR) {
        this.resetingHR = resetingHR;
    }

    public byte getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(byte timeZone) {
        this.timeZone = timeZone;
    }
}
