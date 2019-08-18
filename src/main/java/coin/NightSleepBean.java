package coin;

public class NightSleepBean {
    private short totalSleepScore;
    private short totalSleepQualityScore;
    private short totalSleepDurationScore;
    private short sleepSummary;
    private short sleepAdvise;

    private int sleepDuration;
    private long aSleepTimeStamp;
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

    public void setChangeOfTimeStamp(long changeTimeStamp) {
        this.changeOfTimeStamp = changeTimeStamp;
    }

    public byte getSleepMode() {
        return sleepMode;
    }

    public void setSleepMode(byte sleepMode) {
        this.sleepMode = sleepMode;
    }

    public int getDeepDuration() {
        return deepDuration;
    }

    public void setDeepDuration(int deepDuration) {
        this.deepDuration = deepDuration;
    }

    public int getEyeMoveDuration() {
        return eyeMoveDuration;
    }

    public void setEyeMoveDuration(int eyeMoveDuration) {
        this.eyeMoveDuration = eyeMoveDuration;
    }

    public int getSleepDuration() {
        return sleepDuration;
    }

    public void setSleepDuration(int sleepDuration) {
        this.sleepDuration = sleepDuration;
    }

    public int getLightDuration() {
        return lightDuration;
    }

    public void setLightDuration(int lightDuration) {
        this.lightDuration = lightDuration;
    }

    public int getSoberDuration() {
        return soberDuration;
    }

    public void setSoberDuration(int soberDuration) {
        this.soberDuration = soberDuration;
    }

    public long getaSleepTimeStamp() {
        return aSleepTimeStamp;
    }

    public void setaSleepTimeStamp(long aSleepTimeStamp) {
        this.aSleepTimeStamp = aSleepTimeStamp;
    }

    public long getChangeOFTimeStamp() {
        return changeOfTimeStamp;
    }

    public long getWakeupTimeStamp() {
        return wakeupTimeStamp;
    }

    public void setWakeupTimeStamp(long wakeupTimeStamp) {
        this.wakeupTimeStamp = wakeupTimeStamp;
    }

    public short getSleepAdvise() {
        return sleepAdvise;
    }

    public void setSleepAdvise(short sleepAdvise) {
        this.sleepAdvise = sleepAdvise;
    }

    public short getSleepResumeScore() {
        return sleepResumeScore;
    }

    public void setSleepResumeScore(short sleepResumeScore) {
        this.sleepResumeScore = sleepResumeScore;
    }

    public short getSleepSummary() {
        return sleepSummary;
    }

    public void setSleepSummary(short sleepSummary) {
        this.sleepSummary = sleepSummary;
    }

    public short getSleepUneasyScore() {
        return sleepUneasyScore;
    }

    public void setSleepUneasyScore(short sleepUneasyScore) {
        this.sleepUneasyScore = sleepUneasyScore;
    }

    public short getTotalSleepDurationScore() {
        return totalSleepDurationScore;
    }

    public void setTotalSleepDurationScore(short totalSleepDurationScore) {
        this.totalSleepDurationScore = totalSleepDurationScore;
    }

    public short getTotalSleepQualityScore() {
        return totalSleepQualityScore;
    }

    public void setTotalSleepQualityScore(short totalSleepQualityScore) {
        this.totalSleepQualityScore = totalSleepQualityScore;
    }

    public short getTotalSleepScore() {
        return totalSleepScore;
    }

    public void setTotalSleepScore(short totalSleepScore) {
        this.totalSleepScore = totalSleepScore;
    }

    public short getWakeupCount() {
        return wakeupCount;
    }

    public void setWakeupCount(short wakeupCount) {
        this.wakeupCount = wakeupCount;
    }
}
