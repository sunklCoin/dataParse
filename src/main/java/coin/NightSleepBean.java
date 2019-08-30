package coin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class NightSleepBean {
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private short totalSleepScore;
    private short totalSleepQualityScore;
    private short totalSleepDurationScore;
    private short sleepSummary;
    private short sleepAdvise;

    private int sleepDuration;
    private long sleepTimeStamp;
    private long wakeupTimeStamp;

    private short sleepResumeScore;
    private short sleepUneasyScore;
    private short wakeupCount;

    private int deepDuration;
    private int lightDuration;
    private int eyeMoveDuration;
    private int soberDuration;

    private long changeOfTimeStamp;
    private byte sleepMode;

    public NightSleepBean() {
        totalSleepScore              = Short.MIN_VALUE;
        totalSleepQualityScore       = Short.MIN_VALUE;
        totalSleepDurationScore      = Short.MIN_VALUE;
        sleepSummary                 = Short.MIN_VALUE;
        sleepAdvise                  = Short.MIN_VALUE;

        sleepDuration                = Integer.MIN_VALUE;
        sleepTimeStamp               =  Long.MIN_VALUE;
        wakeupTimeStamp              =  Long.MIN_VALUE;

        sleepResumeScore             = Short.MIN_VALUE;
        sleepUneasyScore             = Short.MIN_VALUE;
        wakeupCount                  = Short.MIN_VALUE;

        deepDuration                 = Integer.MIN_VALUE;
        lightDuration                = Integer.MIN_VALUE;
        eyeMoveDuration              = Integer.MIN_VALUE;
        soberDuration                = Integer.MIN_VALUE;
        changeOfTimeStamp            = Long.MIN_VALUE;
        sleepMode                    = Byte.MIN_VALUE;
    }

    public void setChangeOfTimeStamp(long changeTimeStamp) {
        this.changeOfTimeStamp = changeTimeStamp;
    }

    public String getSleepMode() {
        String errorStr = "";
        if (sleepMode == Byte.MIN_VALUE)
            return "";
        if (sleepMode < 0 || sleepMode > 5) {
            errorStr = "(error data)";
        }
        return Byte.toString(sleepMode) + errorStr;
    }

    public void setSleepMode(byte sleepMode) {
        this.sleepMode = sleepMode;
    }

    public String getDeepDuration() {
        if (deepDuration == Integer.MIN_VALUE)
            return "";
        return Integer.toString(deepDuration);
    }

    public void setDeepDuration(int deepDuration) {
        this.deepDuration = deepDuration;
    }

    public String getEyeMoveDuration() {
        if (eyeMoveDuration == Integer.MIN_VALUE)
            return "";
        return Integer.toString(eyeMoveDuration);
    }

    public void setEyeMoveDuration(int eyeMoveDuration) {
        this.eyeMoveDuration = eyeMoveDuration;
    }

    public String getSleepDuration() {
        if (sleepDuration == Integer.MIN_VALUE)
            return "";
        return Integer.toString(sleepDuration);
    }

    public void setSleepDuration(int sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    public String getLightDuration() {
        if (lightDuration == Integer.MIN_VALUE)
            return "";
        return Integer.toString(lightDuration);
    }

    public void setLightDuration(int lightDuration) {
        this.lightDuration = lightDuration;
    }

    public String getSoberDuration() {
        if (soberDuration == Integer.MIN_VALUE)
            return "";
        return Integer.toString(soberDuration);
    }

    public void setSoberDuration(int soberDuration) {
        this.soberDuration = soberDuration;
    }

    public String getSleepTimeStamp() {
        if (sleepTimeStamp == Long.MIN_VALUE)
            return "";
        Date temp = new Date(sleepTimeStamp * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String tempStr = df.format(temp);
        return Long.toString(sleepTimeStamp) + "\n" + tempStr;
    }

    public void setSleepTimeStamp(long sleepTimeStamp) {
        this.sleepTimeStamp = sleepTimeStamp;
    }

    public String getChangeOfTimeStamp() {
        if (changeOfTimeStamp == Long.MIN_VALUE)
            return "";
        Date temp = new Date(changeOfTimeStamp * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String tempStr = df.format(temp);
        return Long.toString(changeOfTimeStamp) + "\n" + tempStr;
    }

    public String getWakeupTimeStamp() {
        if (wakeupTimeStamp == Long.MIN_VALUE)
            return "";
        Date temp = new Date(wakeupTimeStamp * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String tempStr = df.format(temp);
        return Long.toString(wakeupTimeStamp) + "\n" + tempStr;
    }

    public void setWakeupTimeStamp(long wakeupTimeStamp) {
        this.wakeupTimeStamp = wakeupTimeStamp;
    }

    public String getSleepAdvise() {
        if (sleepAdvise == Short.MIN_VALUE)
            return "";
        return Short.toString(sleepAdvise);
    }

    public void setSleepAdvise(short sleepAdvise) {
        this.sleepAdvise = sleepAdvise;
    }

    public String getSleepResumeScore() {
        if (sleepResumeScore == Short.MIN_VALUE)
            return " ";
        return Short.toString(sleepResumeScore);
    }

    public void setSleepResumeScore(short sleepResumeScore) {
        this.sleepResumeScore = sleepResumeScore;
    }

    public String getSleepSummary() {
        if (sleepSummary == Short.MIN_VALUE)
            return "";
        return Short.toString(sleepSummary);
    }

    public void setSleepSummary(short sleepSummary) {
        this.sleepSummary = sleepSummary;
    }

    public String getSleepUneasyScore() {
        if (sleepUneasyScore == Short.MIN_VALUE)
            return "";
        return Short.toString(sleepUneasyScore);
    }

    public void setSleepUneasyScore(short sleepUneasyScore) {
        this.sleepUneasyScore = sleepUneasyScore;
    }

    public String getTotalSleepDurationScore() {
        if (totalSleepDurationScore == Short.MIN_VALUE)
            return "";
        return Short.toString(totalSleepDurationScore);
    }

    public void setTotalSleepDurationScore(short totalSleepDurationScore) {
        this.totalSleepDurationScore = totalSleepDurationScore;
    }

    public String getTotalSleepQualityScore() {
        if (totalSleepQualityScore == Short.MIN_VALUE)
            return "";
        return Short.toString(totalSleepQualityScore);
    }

    public void setTotalSleepQualityScore(short totalSleepQualityScore) {
        this.totalSleepQualityScore = totalSleepQualityScore;
    }

    public String getTotalSleepScore() {
        if (totalSleepScore == Short.MIN_VALUE)
            return "";
        return Short.toString(totalSleepScore);
    }

    public void setTotalSleepScore(short totalSleepScore) {
        this.totalSleepScore = totalSleepScore;
    }

    public String getWakeupCount() {
        if (wakeupCount == Short.MIN_VALUE)
            return "";
        return Short.toString(wakeupCount);
    }

    public void setWakeupCount(short wakeupCount) {
        this.wakeupCount = wakeupCount;
    }
}
