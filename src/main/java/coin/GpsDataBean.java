package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
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
        return Long.toString(timeStamp) + "\n" + tempStr;
    }

    public void setTimeStamp(long timestamp) {
        this.timeStamp = timestamp;
    }
}
