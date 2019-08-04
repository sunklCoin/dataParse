package coin;

public class DailyRecordBean {
    /* 2 bytes
    * 15 bit hasSleepData
    * 14 bit hasExceptionHeart
    * 13 ~ 0 increaseStepCnt
    */
    private byte    hasSleepData;
    private byte    hasExceptionHeart;
    private int     increaseStepCnt;
    /* 1 byte
     * 7~4 activityType
     * 3~0 increaseCalorie
     */
    private byte    activityType;
    private byte    increaseCalorie;
    /* 1 byte
     * 7~5 actStrong
     * 4~0 sportType
     */
    private byte    actStrong;
    private byte    sportType;
    /* 2 byte
     * increaseDistance
     */
    private int     increaseDistance;
    /* 1 byte
     * heartRate
     */
    private short   heartRate;
    /* 1 byte
     * dumpEnergy
     */
    private short   dumpEnergy;
    /* 2 bytes
     * 15~13  bit sleepMode
     * 12~11  bit energyState
     * 10~0   bit energyStateValue
     */
    private byte    sleepMode;
    private byte    energyState;
    private short   energyStateValue;
    /* 1 byte
     * exceptionHeartRate
     */
    private short   exceptionHeartRate;

    public DailyRecordBean() {
        this.hasSleepData        = Byte.MIN_VALUE;
        this.hasExceptionHeart   = Byte.MIN_VALUE;
        this.increaseStepCnt     = Integer.MIN_VALUE;
        this.activityType        = Byte.MIN_VALUE;
        this.increaseCalorie     = Byte.MIN_VALUE;
        this.actStrong           = Byte.MIN_VALUE;
        this.sportType           = Byte.MIN_VALUE;
        this.increaseDistance    = Integer.MIN_VALUE;
        this.heartRate           = Short.MIN_VALUE;
        this.dumpEnergy          = Short.MIN_VALUE;
        this.sleepMode           = Byte.MIN_VALUE;
        this.energyState         = Byte.MIN_VALUE;
        this.energyStateValue    = Short.MIN_VALUE;
        this.exceptionHeartRate  = Short.MIN_VALUE;
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

    public byte getActivityType() {
        return activityType;
    }

    public byte getActStrong() {
        return actStrong;
    }

    public byte getEnergyState() {
        return energyState;
    }

    public byte getHasExceptionHeart() {
        return hasExceptionHeart;
    }

    public byte getHasSleepData() {
        return hasSleepData;
    }

    public byte getIncreaseCalorie() {
        return increaseCalorie;
    }

    public byte getSleepMode() {
        return sleepMode;
    }

    public byte getSportType() {
        return sportType;
    }

    public int getIncreaseDistance() {
        return increaseDistance;
    }

    public int getIncreaseStepCnt() {
        return increaseStepCnt;
    }

    public short getDumpEnergy() {
        return dumpEnergy;
    }

    public short getEnergyStateValue() {
        return energyStateValue;
    }

    public short getExceptionHeartRate() {
        return exceptionHeartRate;
    }

    public short getHeartRate() {
        return heartRate;
    }

    @Override
    public String toString() {
        return  "hasSleepData                  = " + hasSleepData                   + " \n" +
                "hasExceptionHeart             = " + hasExceptionHeart              + " \n" +
                "increaseStepCnt               = " + increaseStepCnt                + " \n" +
                "activityType                  = " + activityType                   + " \n" +
                "increaseCalorie               = " + increaseCalorie                + " \n" +
                "actStrong                     = " + actStrong                      + " \n" +
                "sportType                     = " + sportType                      + " \n" +
                "increaseDistance              = " + increaseDistance               + " \n" +
                "heartRate                     = " + heartRate                      + " \n" +
                "dumpEnergy                    = " + dumpEnergy                     + " \n" +
                "sleepMode                     = " + sleepMode                      + " \n" +
                "energyState                   = " + energyState                    + " \n" +
                "energyStateValue              = " + energyStateValue               + " \n" +
                "exceptionHeartRate            = " + exceptionHeartRate             + " \n";
    }
}
