package coin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.math.MathContext.DECIMAL32;

public class SportReportBean {
    public static final DecimalFormat df2 = new DecimalFormat( "0.00" );
    private long startTime; // 4 bytes  0~3
    private long endTime;   // 4 bytes  4~7
    private long totalTime; // 4 bytes  8~11
    private long totalDistance; // 4 byte 12~15
    private int calorie; // 2 bytes 16 ~ 17
    private long maxPace; //4 bytes 18~21
    private long minPace; // 4 bytes 22 ~ 25
    private long maxSpeed; //4 bytes 26 ~ 29
    private long totalStepCount; //4 bytes 30 ~ 33
    private int maxStrideFreq; // 2bytes 34 ~ 35
    private short aveHeart; //1 bytes 35
    private short maxHeart; // 1 bytes
    private short minHeart; // 1bytes
    private String asendTotal;     // // 4 bytes
    private String descendTotal;   // // 4 bytes
    private String avgHeight;     // // 4 bytes
    private String maxHeight;   // // 4 bytes
    private String minHeight;   // // 4 bytes
    private String tranEffct;   // // 4 bytes
    private short vo2Max; // bytes
    private short eneryConsum; //1bytes
    private int preRecoverTime; // 2bytes
    private long heartRateLimitDuration; // 4 bytes
    private long anaerobicEnduranceDuration;   // 4 bytes //
    private long aerobicEnduranceDuration; // 4 bytes //
    private long fatBurningTime; //4 bytes //
    private long warmupTime; // 4 bytes
    private int totalStrokes; //2 bytes
    private short mainSwimType; //
    private short maxStrokeFreq; //
    private int turnAround; //2 bytes
    private int aveSwolf; // 2bytes
    private int bestSwolf; // 2bytes
    private short poolWidth; //

    public SportReportBean() {
        this.startTime                   = Long.MIN_VALUE;
        this.endTime                     = Long.MIN_VALUE;
        this.totalTime                   = Long.MIN_VALUE; // 4 bytes
        this.totalDistance               = Long.MIN_VALUE; // 4 byte
        this.calorie                     = Integer.MIN_VALUE; // 2 bytes
        this.maxPace                     = Long.MIN_VALUE; //4 bytes
        this.minPace                     = Long.MIN_VALUE; // 4 bytes
        this.maxSpeed                    = Long.MIN_VALUE; //4 bytes
        this.totalStepCount              = Long.MIN_VALUE; //4 bytes
        this.maxStrideFreq               = Integer.MIN_VALUE; // 2bytes
        this.aveHeart                    = Short.MIN_VALUE; //1 bytes
        this.maxHeart                    = Short.MIN_VALUE; // 1 bytes
        this.minHeart                    = Short.MIN_VALUE; // 1bytes
        this.asendTotal                  = "Invalid value"; // 4 bytes
        this.descendTotal                = "Invalid value"; // 4 bytes
        this.avgHeight                   = "Invalid value"; // 4 bytes
        this.maxHeight                   = "Invalid value"; // 4 bytes
        this.minHeight                   = "Invalid value"; // 4 bytes
        this.tranEffct                   = "Invalid value"; // 4 bytes
        this.vo2Max                      = Short.MIN_VALUE; // bytes
        this.eneryConsum                 = Short.MIN_VALUE; //1bytes
        this.preRecoverTime              = Integer.MIN_VALUE; // 2bytes
        this.heartRateLimitDuration      = Long.MIN_VALUE; // 4 bytes
        this.anaerobicEnduranceDuration  = Long.MIN_VALUE; // 4 bytes
        this.aerobicEnduranceDuration    = Long.MIN_VALUE; // 4 bytes
        this.fatBurningTime              = Long.MIN_VALUE; //4 bytes
        this.warmupTime                  = Long.MIN_VALUE; // 4 bytes
        this.totalStrokes                = Integer.MIN_VALUE; //2 bytes
        this.mainSwimType                = Short.MIN_VALUE; //1 bytes
        this.maxStrokeFreq               = Short.MIN_VALUE; //1 bytes
        this.turnAround                  = Integer.MIN_VALUE; //2 bytes
        this.aveSwolf                    = Integer.MIN_VALUE; // 2bytes
        this.bestSwolf                   = Integer.MIN_VALUE; // 2bytes
        this.poolWidth                   = Short.MIN_VALUE; // 1bytes
    }

    public String getAsendTotal() {
        return asendTotal;
    }

    public String getAvgHeight() {
        return avgHeight;
    }

    public String getDescendTotal() {
        return descendTotal;
    }

    public String getMaxHeight() {
        return maxHeight;
    }

    public String getMinHeight() {
        return minHeight;
    }

    public String getTranEffct() {
        return tranEffct;
    }

    public int getAveSwolf() {
        return aveSwolf;
    }

    public int getBestSwolf() {
        return bestSwolf;
    }

    public int getCalorie() {
        return calorie;
    }

    public int getMaxStrideFreq() {
        return maxStrideFreq;
    }

    public int getPreRecoverTime() {
        return preRecoverTime;
    }

    public long getAnaerobicEnduranceDuration() {
        return anaerobicEnduranceDuration;
    }

    public int getTotalStrokes() {
        return totalStrokes;
    }

    public int getTurnAround() {
        return turnAround;
    }

    public long getAerobicEnduranceDuration() {
        return aerobicEnduranceDuration;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getFatBurningTime() {
        return fatBurningTime;
    }

    public long getHeartRateLimitDuration() {
        return heartRateLimitDuration;
    }

    public long getMaxPace() {
        return maxPace;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public long getMinPace() {
        return minPace;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public long getTotalStepCount() {
        return totalStepCount;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public long getWarmupTime() {
        return warmupTime;
    }

    public short getAveHeart() {
        return aveHeart;
    }

    public short getEneryConsum() {
        return eneryConsum;
    }

    public short getMainSwimType() {
        return mainSwimType;
    }

    public short getMaxHeart() {
        return maxHeart;
    }

    public short getMaxStrokeFreq() {
        return maxStrokeFreq;
    }

    public short getMinHeart() {
        return minHeart;
    }

    public short getVo2Max() {
        return vo2Max;
    }

    public short getPoolWidth() {
        return poolWidth;
    }

    public void setAerobicEnduranceDuration(long aerobicEnduranceDuration) {
        this.aerobicEnduranceDuration = aerobicEnduranceDuration;
    }

    public void setAnaerobicEnduranceDuration(long anaerobicEnduranceDuration) {
        this.anaerobicEnduranceDuration = anaerobicEnduranceDuration;
    }

    public void setAsendTotal(double asendTotal) {
        // BigDecimal bigDecimal = new BigDecimal(asendTotal, new MathContext(3, RoundingMode.HALF_EVEN));
        // String newVal = df2.format(asendTotal);
        //System.out.println(newVal);
        this.asendTotal =  df2.format(asendTotal); //Double.parseDouble(newVal);
        //System.out.println(this.asendTotal);
    }

    public void setAveHeart(short aveHeart) {
        this.aveHeart = aveHeart;
    }

    public void setAvgHeight(double avgHeight) {
        //String newVal = df2.format(avgHeight);
        this.avgHeight = df2.format(avgHeight);//Double.parseDouble(newVal);
    }

    public void setAveSwolf(int aveSwolf) {
        this.aveSwolf = aveSwolf;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public void setBestSwolf(int bestSwolf) {
        this.bestSwolf = bestSwolf;
    }

    public void setDescendTotal(double descendTotal) {
//        String newVal = df2.format(descendTotal);
        this.descendTotal = df2.format(descendTotal);//Double.parseDouble(newVal);
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setEneryConsum(short eneryConsum) {
        this.eneryConsum = eneryConsum;
    }

    public void setFatBurningTime(long fatBurningTime) {
        this.fatBurningTime = fatBurningTime;
    }

    public void setHeartRateLimitDuration(long heartRateLimitDuration) {
        this.heartRateLimitDuration = heartRateLimitDuration;
    }

    public void setMaxHeart(short maxHeart) {
        this.maxHeart = maxHeart;
    }

    public void setMainSwimType(short mainSwimType) {
        this.mainSwimType = mainSwimType;
    }

    public void setMaxHeight(double maxHeight) {
        //String newVal = df2.format(maxHeight);
        this.maxHeight = df2.format(maxHeight);//Double.parseDouble(newVal);
    }

    public void setMaxPace(long maxPace) {
        this.maxPace = maxPace;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setMaxStrideFreq(int maxStrideFreq) {
        this.maxStrideFreq = maxStrideFreq;
    }

    public void setMaxStrokeFreq(short maxStrokeFreq) {
        this.maxStrokeFreq = maxStrokeFreq;
    }

    public void setMinHeart(short minHeart) {
        this.minHeart = minHeart;
    }

    public void setMinHeight(double minHeight) {
        //String newVal = df2.format(minHeight);
        this.minHeight = df2.format(minHeight);//Double.parseDouble(newVal);
    }

    public void setMinPace(long minPace) {
        this.minPace = minPace;
    }

    public void setPreRecoverTime(int preRecoverTime) {
        this.preRecoverTime = preRecoverTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setPoolWidth(short poolWidth) {
        this.poolWidth = poolWidth;
    }

    public void setTotalDistance(long totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setTotalStepCount(long totalStepCount) {
        this.totalStepCount = totalStepCount;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public void setTotalStrokes(int totalStrokes) {
        this.totalStrokes = totalStrokes;
    }

    public void setTranEffct(double tranEffct) {
        //String newVal = df2.format(tranEffct);
        this.tranEffct = df2.format(tranEffct);//Double.parseDouble(newVal);
    }

    public void setTurnAround(int turnAround) {
        this.turnAround = turnAround;
    }

    public void setVo2Max(short vo2Max) {
        this.vo2Max = vo2Max;
    }

    public void setWarmupTime(long warmupTime) {
        this.warmupTime = warmupTime;
    }

    @Override
    public String toString() {
        return  "startTime                 = " + startTime                  + " \n" +
                "endTime                   = " + endTime                    + " \n" +
                "totalTime                 = " + totalTime                  + " \n" +
                "totalDistance             = " + totalDistance              + " \n" +
                "calorie                   = " + calorie                    + " \n" +
                "maxPace                   = " + maxPace                    + " \n" +
                "minPace                   = " + minPace                    + " \n" +
                "maxSpeed                  = " + maxSpeed                   + " \n" +
                "totalStepCount            = " + totalStepCount             + " \n" +
                "maxStrideFreq             = " + maxStrideFreq              + " \n" +
                "aveHeart                  = " + aveHeart                   + " \n" +
                "maxHeart                  = " + maxHeart                   + " \n" +
                "minHeart                  = " + minHeart                   + " \n" +
                "asendTotal                = " + asendTotal                 + " \n" +
                "descendTotal              = " + descendTotal               + " \n" +
                "avgHeight                 = " + avgHeight                  + " \n" +
                "maxHeight                 = " + maxHeight                  + " \n" +
                "minHeight                 = " + minHeight                  + " \n" +
                "tranEffct                 = " + tranEffct                  + " \n" +
                "vo2Max                    = " + vo2Max                     + " \n" +
                "eneryConsum               = " + eneryConsum                + " \n" +
                "preRecoverTime            = " + preRecoverTime             + " \n" +
                "heartRateLimitDuration    = " + heartRateLimitDuration     + " \n" +
                "anaerobicEnduranceDuration= " + anaerobicEnduranceDuration + " \n" +
                "aerobicEnduranceDuration  = " + aerobicEnduranceDuration   + " \n" +
                "fatBurningTime            = " + fatBurningTime             + " \n" +
                "warmupTime                = " + warmupTime                 + " \n" +
                "totalStrokes              = " + totalStrokes               + " \n" +
                "mainSwimType              = " + mainSwimType               + " \n" +
                "maxStrokeFreq             = " + maxStrokeFreq              + " \n" +
                "turnAround                = " + turnAround                 + " \n" +
                "aveSwolf                  = " + aveSwolf                   + " \n" +
                "bestSwolf                 = " + bestSwolf                  + " \n" +
                "poolWidth                 = " + poolWidth                  + " \n";
    }
}
