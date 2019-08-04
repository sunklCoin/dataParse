package coin;

public class DailyReportBean {
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
    private int     standFlag;          // 3 bytes

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
        this.standFlag           = Integer.MIN_VALUE ;
    }

    public long getTotalStepCount() {
        return totalStepCount;
    }

    public int getStandFlag() {
        return standFlag;
    }

    public int getTotalCalorie() {
        return totalCalorie;
    }

    public long getTimeOfmaxHeartRate() {
        return timeOfmaxHeartRate;
    }

    public long getTimeOfminHeartRate() {
        return timeOfminHeartRate;
    }

    public short getAvgHeartRate() {
        return avgHeartRate;
    }

    public short getAvgPressure() {
        return avgPressure;
    }

    public short getCurrHeartRate() {
        return currHeartRate;
    }

    public short getMaxHeartRate() {
        return maxHeartRate;
    }

    public short getMaxPressure() {
        return maxPressure;
    }

    public short getMinHeartRate() {
        return minHeartRate;
    }

    public short getMinPressure() {
        return minPressure;
    }

    public short getRestingHeartRate() {
        return restingHeartRate;
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

    public void setStandFlag(int standFlag) {
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
