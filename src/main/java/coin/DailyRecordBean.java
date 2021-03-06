package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DailyRecordBean {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long index;
    /* 2 bytes
     * 15 bit hasSleepData
     * 14 bit hasExceptionHeart
     * 13 ~ 0 increaseStepCnt
     */
    /* V2.12
     * 2 bytes
     * 15 bit N/A
     * 14 bit hasExceptionHeart
     * 13 ~ 0 increaseStepCnt
     */
    private byte hasSleepData;
    private byte hasExceptionHeart;
    private int increaseStepCnt;
    /* 1 byte
     * 7~4 activityType
     * 3~0 increaseCalorie
     */

    /* V2.12
     * 1 byte
     * 7~6 activityType
     * 5~0 increaseCalorie
     */
    private byte activityType;
    private byte increaseCalorie;
    /* 1 byte
     * 7~5 actStrong
     * 4~0 sportType
     */
    private byte actStrong;
    private byte sportType;
    /* 2 byte
     * increaseDistance
     */
    private int increaseDistance;
    /* 1 byte
     * heartRate
     */
    private short heartRate;
    /* 1 byte
     * dumpEnergy
     */
    private short dumpEnergy;
    /* 2 bytes
     * 15~13  bit sleepMode
     * 12~11  bit energyState
     * 10~0   bit energyStateValue
     */

    /* v2.12
     * 2 bytes
     * 15~10 bit new increase total calorie
     * 9~8  bit energyState
     * 7~0  bit energyStateValue
     */
    private byte sleepMode;
    private byte newIncreaseTotalCal;
    private byte energyState;
    private short energyStateValue;
    /* 1 byte
     * exceptionHeartRate
     */
    private short exceptionHeartRate;

    private long timeOfAp;
    private long timeOfModem;

    public DailyRecordBean() {
        this.index = Long.MIN_VALUE;
        this.hasSleepData = Byte.MIN_VALUE;
        this.hasExceptionHeart = Byte.MIN_VALUE;
        this.increaseStepCnt = Integer.MIN_VALUE;
        this.activityType = Byte.MIN_VALUE;
        this.increaseCalorie = Byte.MIN_VALUE;
        this.actStrong = Byte.MIN_VALUE;
        this.sportType = Byte.MIN_VALUE;
        this.increaseDistance = Integer.MIN_VALUE;
        this.heartRate = Short.MIN_VALUE;
        this.dumpEnergy = Short.MIN_VALUE;
        this.sleepMode = Byte.MIN_VALUE;
        this.energyState = Byte.MIN_VALUE;
        this.energyStateValue = Short.MIN_VALUE;
        this.exceptionHeartRate = Short.MIN_VALUE;
        this.timeOfAp = Long.MIN_VALUE;
        this.timeOfModem = Long.MIN_VALUE;
        this.newIncreaseTotalCal = Byte.MIN_VALUE;
    }

    public void setSportType(byte sportType) {
        this.sportType = sportType;
    }

    public void setActivityType(byte activityType) {
        this.activityType = activityType;
    }

    public void setActStrong(byte actStrong) {
        this.actStrong = actStrong;
    }

    public void setDumpEnergy(short dumpEnergy) {
        this.dumpEnergy = dumpEnergy;
    }

    public void setEnergyState(byte energyState) {
        this.energyState = energyState;
    }

    public void setEnergyStateValue(short energyStateValue) {
        this.energyStateValue = energyStateValue;
    }

    public void setExceptionHeartRate(short exceptionHeartRate) {
        this.exceptionHeartRate = exceptionHeartRate;
    }

    public void setHasExceptionHeart(byte hasExceptionHeart) {
        this.hasExceptionHeart = hasExceptionHeart;
    }

    public void setHasSleepData(byte hasSleepData) {
        this.hasSleepData = hasSleepData;
    }

    public void setHeartRate(short heartRate) {
        this.heartRate = heartRate;
    }

    public void setIncreaseCalorie(byte increaseCalorie) {
        this.increaseCalorie = increaseCalorie;
    }

    public void setIncreaseDistance(int increaseDistance) {
        this.increaseDistance = increaseDistance;
    }

    public void setIncreaseStepCnt(int increaseStepCnt) {
        this.increaseStepCnt = increaseStepCnt;
    }

    public void setSleepMode(byte sleepMode) {
        this.sleepMode = sleepMode;
    }

    /**
     * @param newIncreaseTotalCal the newIncreaseTotalCal to set
     */
    public void setNewIncreaseTotalCal(byte newIncreaseTotalCal) {
        this.newIncreaseTotalCal = newIncreaseTotalCal;
    }

    public String getActivityType() {
        /*return activityType;*/
        if (activityType == Byte.MIN_VALUE)
            return "null";
        return Byte.toString(activityType);
    }

    public String getActStrong() {
        /*return actStrong;*/
        if (actStrong == Byte.MIN_VALUE)
            return "null";
        return Byte.toString(actStrong);
    }

    public String getEnergyState() {
        /*return energyState;*/
        if (energyState == Byte.MIN_VALUE)
            return "null";
        return Byte.toString(energyState);
    }

    public byte getHasExceptionHeart() {
        return hasExceptionHeart;
    }

    public String getHasSleepData() {
        /*return hasSleepData;*/
        if (hasSleepData == Byte.MIN_VALUE)
            return "null";
        return Byte.toString(hasSleepData);
    }

    public String getIncreaseCalorie() {
        /*return increaseCalorie;*/
        if (increaseCalorie == Byte.MIN_VALUE)
            return "null";
        return Byte.toString(increaseCalorie);
    }

    public String getSleepMode() {
        if (sleepMode == Byte.MIN_VALUE)
            return "null";
        return Byte.toString(sleepMode);
        // return sleepMode;
    }

    /**
     * @return the newIncreaseTotalCal
     */
    public String getNewIncreaseTotalCal() {
        if (newIncreaseTotalCal == Byte.MIN_VALUE)
            return "null";
        return Byte.toString(newIncreaseTotalCal);
    }

    public String getSportType() {
        // return sportType;
        if (sportType == Byte.MIN_VALUE)
            return "null";
        return Byte.toString(sportType);
    }

    public String getIncreaseDistance() {
        if (increaseDistance == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(increaseDistance);
    }

    public String getIncreaseStepCnt() {
        if (increaseStepCnt == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(increaseStepCnt);
    }

    public String getDumpEnergy() {
        if (dumpEnergy == Short.MIN_VALUE)
            return "null";
        return Short.toString(dumpEnergy);
    }

    public String getEnergyStateValue() {
        if (energyStateValue == Short.MIN_VALUE)
            return "null";
        return Short.toString(energyStateValue);
    }

    public String getExceptionHeartRate() {
        if (exceptionHeartRate == Short.MIN_VALUE)
            return "-";
        return Short.toString(exceptionHeartRate);
    }

    public String getHeartRate() {
        if (heartRate == Short.MIN_VALUE)
            return "null";
        return Short.toString(heartRate);
    }

    public void setTimeOfAp(long timeOfAp) {
        this.timeOfAp = timeOfAp;
    }

    public void setTimeOfModem(long timeOfModem) {
        this.timeOfModem = timeOfModem;
    }

    public String getTimeOfAp() {
        if (timeOfAp == Long.MIN_VALUE)
            return "null";
        Date temp = new Date(timeOfAp * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String tempStr = df.format(temp);
        return Long.toString(timeOfAp) + "\n" + tempStr;
    }

    public String getTimeOfModem() {
        if (timeOfModem == Long.MIN_VALUE)
            return "null";
        Date temp = new Date(timeOfModem * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String tempStr = df.format(temp);
        return Long.toString(timeOfModem) + "\n" + tempStr;
    }
    
    /**
     * @param index the index to set
     */
    public void setIndex(long index) {
        this.index = index;
    }

    /**
     * @return the index
     */
    public long getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "hasSleepData                  = " + hasSleepData + " \n" +
                "hasExceptionHeart             = " + hasExceptionHeart + " \n" +
                "increaseStepCnt               = " + increaseStepCnt + " \n" +
                "activityType                  = " + activityType + " \n" +
                "increaseCalorie               = " + increaseCalorie + " \n" +
                "actStrong                     = " + actStrong + " \n" +
                "sportType                     = " + sportType + " \n" +
                "increaseDistance              = " + increaseDistance + " \n" +
                "heartRate                     = " + heartRate + " \n" +
                "dumpEnergy                    = " + dumpEnergy + " \n" +
                "sleepMode                     = " + sleepMode + " \n" +
                "energyState                   = " + energyState + " \n" +
                "energyStateValue              = " + energyStateValue + " \n" +
                "exceptionHeartRate            = " + exceptionHeartRate + " \n";
    }
}
