package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailySleepBean {
    public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int sleepDuration;
    private long changeOfTimeStamp;
    private byte sleepMode;

    public byte getSleepMode() {
        return sleepMode;
    }

    public void setSleepMode(byte sleepMode) {
        this.sleepMode = sleepMode;
    }

    public String getChangeOfTimeStamp() {
        if (changeOfTimeStamp == Long.MIN_VALUE)
            return "null";
        Date date = new Date(changeOfTimeStamp * 1000);
        String dtStr = df.format(date);
        return Long.toString(changeOfTimeStamp) + "\n" + dtStr;
    }

    public void setChangeOfTimeStamp(long changeOfTimeStamp) {
        this.changeOfTimeStamp = changeOfTimeStamp;
    }

    public int getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(int sleepDuration) {
        this.sleepDuration = sleepDuration;
    }
}
