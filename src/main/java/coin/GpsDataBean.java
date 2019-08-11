package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GpsDataBean {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Double lat;
    private Double lon;
    private long timeStamp;

    public GpsDataBean() {
        this.lat = Double.MIN_VALUE;
        this.lon = Double.MIN_VALUE;
        this.timeStamp = Long.MIN_VALUE;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
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
