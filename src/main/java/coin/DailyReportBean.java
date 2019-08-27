package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DailyReportBean {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long    totalStepCount;     // 4 bytes  0~3
    private int     totalCalorie;       // 2 bytes
    private short   currHeartRate;      // 1 bytes
    private short   restingHeartRate;   // 1 bytes
    private short   maxHeartRate;       // 1 bytes
    private long    timeOfmaxHeartRate; // 4 bytes
    private short   minHeartRate;       // 1 bytes
    private long    timeOfminHeartRate; // 4 bytes
    private short   avgHeartRate;       // 1 bytes
    private short   avgPressure;        // 1 bytes
    private short   maxPressure;        // 1 bytes
    private short   minPressure;        // 1 bytes
    private String     standFlag;          // 3 bytes

    public DailyReportBean() {
        this.totalStepCount      = Long.MIN_VALUE ;
        this.totalCalorie        = Integer.MIN_VALUE ;
        this.currHeartRate       = Short.MIN_VALUE ;
        this.restingHeartRate    = Short.MIN_VALUE ;
        this.maxHeartRate        = Short.MIN_VALUE ;
        this.timeOfmaxHeartRate  = Long.MIN_VALUE ;
        this.minHeartRate        = Short.MIN_VALUE ;
        this.timeOfminHeartRate  = Long.MIN_VALUE ;
        this.avgHeartRate        = Short.MIN_VALUE ;
        this.avgPressure         = Short.MIN_VALUE ;
        this.maxPressure         = Short.MIN_VALUE ;
        this.minPressure         = Short.MIN_VALUE ;
        this.standFlag           = "none" ;
    }

    public String getTotalStepCount() {
        /*return totalStepCount;*/
        if (totalStepCount == Long.MIN_VALUE)
            return "null";
        return Long.toString(totalStepCount);
    }

    public String getStandFlag() {
        /*return standFlag;*/
        return standFlag;
    }

    public String getTotalCalorie() {
        /*return totalCalorie;*/
        if (totalCalorie == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(totalCalorie);
    }

    public String getTimeOfmaxHeartRate() {
        /*return timeOfmaxHeartRate;*/
        if (timeOfmaxHeartRate == Long.MIN_VALUE)
            return "null";
        Date temp = new Date(timeOfmaxHeartRate * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String tempStr = df.format(temp);
        return Long.toString(timeOfmaxHeartRate) + "\n" + tempStr;
    }

    public String getTimeOfminHeartRate() {
        /*return timeOfminHeartRate;*/
        if (timeOfminHeartRate == Long.MIN_VALUE)
            return "null";
        Date temp = new Date(timeOfminHeartRate * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String tempStr = df.format(temp);
        return Long.toString(timeOfminHeartRate) + "\n" + tempStr;
    }

    public String getAvgHeartRate() {
        /*return avgHeartRate;*/
        if (avgHeartRate == Short.MIN_VALUE)
            return "null";
        return Short.toString(avgHeartRate);
    }

    public String getAvgPressure() {
        /*return avgPressure;*/
        if (avgPressure == Short.MIN_VALUE)
            return "null";
        return Short.toString(avgPressure);
    }

    public String getCurrHeartRate() {
        /*return currHeartRate;*/
        if (currHeartRate == Short.MIN_VALUE)
            return "null";
        return Short.toString(currHeartRate);
    }

    public String getMaxHeartRate() {
        /*return maxHeartRate;*/
        if (maxHeartRate == Short.MIN_VALUE)
            return "null";
        return Short.toString(maxHeartRate);
    }

    public String getMaxPressure() {
        /*return maxPressure;*/
        if (maxPressure == Short.MIN_VALUE)
            return "null";
        return Short.toString(maxPressure);
    }

    public String getMinHeartRate() {
        /*return minHeartRate;*/
        if (minHeartRate == Short.MIN_VALUE)
            return "null";
        return Short.toString(minHeartRate);
    }

    public String getMinPressure() {
        /*return minPressure;*/
        if (minPressure == Short.MIN_VALUE)
            return "null";
        return Short.toString(minPressure);
    }

    public String getRestingHeartRate() {
        /*return restingHeartRate;*/
        if (restingHeartRate == Short.MIN_VALUE)
            return "null";
        return Short.toString(restingHeartRate);
    }

    public void setTotalStepCount(long totalStepCount) {
        this.totalStepCount = totalStepCount;
    }

    public void setMaxHeartRate(short maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public void setAvgHeartRate(short avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }

    public void setAvgPressure(short avgPressure) {
        this.avgPressure = avgPressure;
    }

    public void setCurrHeartRate(short currHeartRate) {
        this.currHeartRate = currHeartRate;
    }

    public void setMaxPressure(short maxPressure) {
        this.maxPressure = maxPressure;
    }

    public void setMinHeartRate(short minHeartRate) {
        this.minHeartRate = minHeartRate;
    }

    public void setMinPressure(short minPressure) {
        this.minPressure = minPressure;
    }

    public void setRestingHeartRate(short restingHeartRate) {
        this.restingHeartRate = restingHeartRate;
    }

    public void setStandFlag(String standFlag) {
        this.standFlag = standFlag;
    }

    public void setTimeOfmaxHeartRate(long timeOfmaxHeartRate) {
        this.timeOfmaxHeartRate = timeOfmaxHeartRate;
    }

    public void setTimeOfminHeartRate(long timeOfminHeartRate) {
        this.timeOfminHeartRate = timeOfminHeartRate;
    }

    public void setTotalCalorie(int totalCalorie) {
        this.totalCalorie = totalCalorie;
    }

    @Override
    public String toString() {
        return  "totalStepCount     = " + totalStepCount     + " \n" +
                "totalCalorie       = " + totalCalorie       + " \n" +
                "currHeartRate      = " + currHeartRate      + " \n" +
                "restingHeartRate   = " + restingHeartRate   + " \n" +
                "maxHeartRate       = " + maxHeartRate       + " \n" +
                "timeOfmaxHeartRate = " + timeOfmaxHeartRate + " \n" +
                "minHeartRate       = " + minHeartRate       + " \n" +
                "timeOfminHeartRate = " + timeOfminHeartRate + " \n" +
                "avgHeartRate       = " + avgHeartRate       + " \n" +
                "avgPressure        = " + avgPressure        + " \n" +
                "maxPressure        = " + maxPressure        + " \n" +
                "minPressure        = " + minPressure        + " \n" +
                "standFlag          = " + standFlag          + " \n";
    }
}
