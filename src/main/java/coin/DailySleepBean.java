package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DailySleepBean {
    public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int sleepDuration;
    private long changeOfTimeStamp;
    private byte sleepMode;

    public DailySleepBean() {
        this.sleepDuration = Integer.MIN_VALUE;
        this.changeOfTimeStamp = Long.MIN_VALUE;
        this.sleepMode = Byte.MIN_VALUE;
    }

    public String getSleepMode() {
        String errorStr = "";
        if (sleepMode == Byte.MIN_VALUE)
            return "";
        if (sleepMode < 0 || sleepMode > 5) {
            errorStr = "(error data)";
        }
        return Byte.toString(sleepMode) + errorStr;
    }

    public void setSleepMode(byte sleepMode) {
        this.sleepMode = sleepMode;
    }

    public String getChangeOfTimeStamp() {
        if (changeOfTimeStamp == Long.MIN_VALUE)
            return "";
        Date date = new Date(changeOfTimeStamp * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String dtStr = df.format(date);
        return Long.toString(changeOfTimeStamp) + "\n" + dtStr;
    }

    public void setChangeOfTimeStamp(long changeOfTimeStamp) {
        this.changeOfTimeStamp = changeOfTimeStamp;
    }

    public String getSleepDuration() {
        if (sleepDuration == Integer.MIN_VALUE) {
            return "";
        }
        return Integer.toString(sleepDuration);
    }

    public void setSleepDuration(int sleepDuration) {
        this.sleepDuration = sleepDuration;
    }
}
