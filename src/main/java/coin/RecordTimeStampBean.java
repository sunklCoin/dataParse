package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RecordTimeStampBean {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long timeStamp;
    private int size;
    public RecordTimeStampBean() {
        this.size = Integer.MIN_VALUE;
        this.timeStamp = Long.MIN_VALUE;
    }

    public String getSize() {
        String ret = Integer.toString(size);
        return ret;
    }

    public void setSize(int size) {
        this.size = size;
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
