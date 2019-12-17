package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SleepStatusBean {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long timeStamp;
    private long status;
    public SleepStatusBean() {
        this.status = Long.MIN_VALUE;
        this.timeStamp = Long.MIN_VALUE;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        String ret = Long.toString(status);
        return ret;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(long status) {
        this.status = status;
    }

    public String getTimeStamp() {
        // return timestamp;
        if (timeStamp == Long.MIN_VALUE)
            return "Invaild value";
        Date temp = new Date(timeStamp * 1000);
        String tempStr = df.format(temp);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        return Long.toString(timeStamp) + "\n" + tempStr;
    }

    public void setTimeStamp(long timestamp) {
        this.timeStamp = timestamp;
    }
}
