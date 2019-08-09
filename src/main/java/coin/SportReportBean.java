package coin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.math.MathContext.DECIMAL32;

public class SportReportBean {
    public static final DecimalFormat df2 = new DecimalFormat("0.00");
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long startTime; // 4 bytes  0~3
    private long endTime;   // 4 bytes  4~7
    private long totalTime; // 4 bytes  8~11
    private long totalDistance; // 4 byte 12~15
    private int calorie; // 2 bytes 16 ~ 17
    private long maxPace; //4 bytes 18~21
    private long minPace; // 4 bytes 22 ~ 25
    private float maxSpeed; //4 bytes 26 ~ 29
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
        this.startTime = Long.MIN_VALUE;
        this.endTime = Long.MIN_VALUE;
        this.totalTime = Long.MIN_VALUE; // 4 bytes
        this.totalDistance = Long.MIN_VALUE; // 4 byte
        this.calorie = Integer.MIN_VALUE; // 2 bytes
        this.maxPace = Long.MIN_VALUE; //4 bytes
        this.minPace = Long.MIN_VALUE; // 4 bytes
        this.maxSpeed = Float.MIN_VALUE; //4 bytes
        this.totalStepCount = Long.MIN_VALUE; //4 bytes
        this.maxStrideFreq = Integer.MIN_VALUE; // 2bytes
        this.aveHeart = Short.MIN_VALUE; //1 bytes
        this.maxHeart = Short.MIN_VALUE; // 1 bytes
        this.minHeart = Short.MIN_VALUE; // 1bytes
        this.asendTotal = "Invalid value"; // 4 bytes
        this.descendTotal = "Invalid value"; // 4 bytes
        this.avgHeight = "Invalid value"; // 4 bytes
        this.maxHeight = "Invalid value"; // 4 bytes
        this.minHeight = "Invalid value"; // 4 bytes
        this.tranEffct = "Invalid value"; // 4 bytes
        this.vo2Max = Short.MIN_VALUE; // bytes
        this.eneryConsum = Short.MIN_VALUE; //1bytes
        this.preRecoverTime = Integer.MIN_VALUE; // 2bytes
        this.heartRateLimitDuration = Long.MIN_VALUE; // 4 bytes
        this.anaerobicEnduranceDuration = Long.MIN_VALUE; // 4 bytes
        this.aerobicEnduranceDuration = Long.MIN_VALUE; // 4 bytes
        this.fatBurningTime = Long.MIN_VALUE; //4 bytes
        this.warmupTime = Long.MIN_VALUE; // 4 bytes
        this.totalStrokes = Integer.MIN_VALUE; //2 bytes
        this.mainSwimType = Short.MIN_VALUE; //1 bytes
        this.maxStrokeFreq = Short.MIN_VALUE; //1 bytes
        this.turnAround = Integer.MIN_VALUE; //2 bytes
        this.aveSwolf = Integer.MIN_VALUE; // 2bytes
        this.bestSwolf = Integer.MIN_VALUE; // 2bytes
        this.poolWidth = Short.MIN_VALUE; // 1bytes
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

    public String getAveSwolf() {
        if (aveSwolf == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(aveSwolf);
    }

    public String getBestSwolf() {
        if (bestSwolf == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(bestSwolf);
    }

    public String getCalorie() {
        if (calorie == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(calorie);
    }

    public String getMaxStrideFreq() {
        if (maxStrideFreq == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(maxStrideFreq);
    }

    public String getPreRecoverTime() {
        if (preRecoverTime == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(preRecoverTime);
    }

    public String getAnaerobicEnduranceDuration() {
        if (anaerobicEnduranceDuration == Long.MIN_VALUE)
            return "null";
        return Long.toString(anaerobicEnduranceDuration);
    }

    public String getTotalStrokes() {
        if (totalStrokes == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(totalStrokes);
    }

    public String getTurnAround() {
        if (turnAround == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(turnAround);
    }

    public String getAerobicEnduranceDuration() {
        if (aerobicEnduranceDuration == Long.MIN_VALUE)
            return "null";
        return Long.toString(aerobicEnduranceDuration);
    }

    public String getEndTime() {
        if (endTime == Long.MIN_VALUE)
            return "null";
        Date temp = new Date(endTime * 1000);
        String tempStr = df.format(temp);
        return Long.toString(endTime) + "\n" + tempStr;
    }

    public String getFatBurningTime() {
        if (fatBurningTime == Long.MIN_VALUE)
            return "null";
        return Long.toString(fatBurningTime);
    }

    public String getHeartRateLimitDuration() {
        if (heartRateLimitDuration == Long.MIN_VALUE)
            return "null";
        return Long.toString(heartRateLimitDuration);
    }

    public String getMaxPace() {
        if (maxPace == Long.MIN_VALUE)
            return "null";
        return Long.toString(maxPace);
    }

    public String getMaxSpeed() {
        if (maxSpeed == Float.MIN_VALUE)
            return "null";
        String maxSpeedStr = df2.format(maxSpeed);
        return maxSpeedStr;
    }

    public String getMinPace() {
        if (minPace == Long.MIN_VALUE)
            return "null";
        return Long.toString(minPace);
    }

    public String getStartTime() {
        if (startTime == Long.MIN_VALUE)
            return "null";
        Date temp = new Date(startTime * 1000);
        String tempStr = df.format(temp);
        return Long.toString(startTime) + "\n" + tempStr;
    }

    public String getTotalDistance() {
        if (totalDistance == Long.MIN_VALUE)
            return "null";
        return Long.toString(totalDistance);
    }

    public String getTotalStepCount() {
        if (totalStepCount == Long.MIN_VALUE)
            return "null";
        return Long.toString(totalStepCount);
    }

    public String getTotalTime() {
        if (totalTime == Long.MIN_VALUE)
            return "null";
        return Long.toString(totalTime);
    }

    public String getWarmupTime() {
        if (warmupTime == Long.MIN_VALUE)
            return "null";
        return Long.toString(warmupTime);
    }

    public String getAveHeart() {
        if (aveHeart == Short.MIN_VALUE)
            return "null";
        return Short.toString(aveHeart);
    }

    public String getEneryConsum() {
        if (eneryConsum == Short.MIN_VALUE)
            return "null";
        return Short.toString(eneryConsum);
    }

    public String getMainSwimType() {
        if (mainSwimType == Short.MIN_VALUE)
            return "null";
        return Short.toString(mainSwimType);
    }

    public String getMaxHeart() {
        if (maxHeart == Short.MIN_VALUE)
            return "null";
        return Short.toString(maxHeart);
    }

    public String getMaxStrokeFreq() {
        if (maxStrokeFreq == Short.MIN_VALUE)
            return "null";
        return Short.toString(maxStrokeFreq);
    }

    public String getMinHeart() {
        if (minHeart == Short.MIN_VALUE)
            return "null";
        return Short.toString(minHeart);
    }

    public String getVo2Max() {
        if (vo2Max == Short.MIN_VALUE)
            return "null";
        return Short.toString(vo2Max);
    }

    public String getPoolWidth() {
        if (poolWidth == Short.MIN_VALUE)
            return "null";
        return Short.toString(poolWidth);
    }

    public void setAerobicEnduranceDuration(long aerobicEnduranceDuration) {
        this.aerobicEnduranceDuration = aerobicEnduranceDuration;
    }

    public void setAnaerobicEnduranceDuration(long anaerobicEnduranceDuration) {
        this.anaerobicEnduranceDuration = anaerobicEnduranceDuration;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAveHeart(short aveHeart) {
        this.aveHeart = aveHeart;
    }

    public void setAsendTotal(float asendTotal) {
        // BigDecimal bigDecimal = new BigDecimal(asendTotal, new MathContext(3, RoundingMode.HALF_EVEN));
        // String newVal = df2.format(asendTotal);
        //System.out.println(newVal);
        this.asendTotal = df2.format(asendTotal); //Double.parseDouble(newVal);
        //System.out.println(this.asendTotal);
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

    public void setAvgHeight(float avgHeight) {
        //String newVal = df2.format(avgHeight);
        this.avgHeight = df2.format(avgHeight);//Double.parseDouble(newVal);
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

    public void setDescendTotal(float descendTotal) {
//        String newVal = df2.format(descendTotal);
        this.descendTotal = df2.format(descendTotal);//Double.parseDouble(newVal);
    }

    public void setMaxPace(long maxPace) {
        this.maxPace = maxPace;
    }

    public void setMaxHeight(float maxHeight) {
        //String newVal = df2.format(maxHeight);
        this.maxHeight = df2.format(maxHeight);//Double.parseDouble(newVal);
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

    public void setMinHeight(float minHeight) {
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

    public void setTranEffct(float tranEffct) {
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
        return "startTime                 = " + startTime + " \n" +
                "endTime                   = " + endTime + " \n" +
                "totalTime                 = " + totalTime + " \n" +
                "totalDistance             = " + totalDistance + " \n" +
                "calorie                   = " + calorie + " \n" +
                "maxPace                   = " + maxPace + " \n" +
                "minPace                   = " + minPace + " \n" +
                "maxSpeed                  = " + maxSpeed + " \n" +
                "totalStepCount            = " + totalStepCount + " \n" +
                "maxStrideFreq             = " + maxStrideFreq + " \n" +
                "aveHeart                  = " + aveHeart + " \n" +
                "maxHeart                  = " + maxHeart + " \n" +
                "minHeart                  = " + minHeart + " \n" +
                "asendTotal                = " + asendTotal + " \n" +
                "descendTotal              = " + descendTotal + " \n" +
                "avgHeight                 = " + avgHeight + " \n" +
                "maxHeight                 = " + maxHeight + " \n" +
                "minHeight                 = " + minHeight + " \n" +
                "tranEffct                 = " + tranEffct + " \n" +
                "vo2Max                    = " + vo2Max + " \n" +
                "eneryConsum               = " + eneryConsum + " \n" +
                "preRecoverTime            = " + preRecoverTime + " \n" +
                "heartRateLimitDuration    = " + heartRateLimitDuration + " \n" +
                "anaerobicEnduranceDuration= " + anaerobicEnduranceDuration + " \n" +
                "aerobicEnduranceDuration  = " + aerobicEnduranceDuration + " \n" +
                "fatBurningTime            = " + fatBurningTime + " \n" +
                "warmupTime                = " + warmupTime + " \n" +
                "totalStrokes              = " + totalStrokes + " \n" +
                "mainSwimType              = " + mainSwimType + " \n" +
                "maxStrokeFreq             = " + maxStrokeFreq + " \n" +
                "turnAround                = " + turnAround + " \n" +
                "aveSwolf                  = " + aveSwolf + " \n" +
                "bestSwolf                 = " + bestSwolf + " \n" +
                "poolWidth                 = " + poolWidth + " \n";
    }
}
