package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GpsDataBean {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private float lat;
    private float lon;
    private long timeStamp;

    public GpsDataBean() {
        this.lat = Float.MIN_VALUE;
        this.lon = Float.MIN_VALUE;
        this.timeStamp = Long.MIN_VALUE;
    }

    public String getLat() {
        String ret = String.format("%.7f",lat);

        return ret;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public String getLon() {
        String ret = String.format("%.7f",lon);
        return ret;
    }

    public void setLon(float lon) {
        this.lon = lon;
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
