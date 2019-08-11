package coin;

public class DailyDistributeBean {
    private int seriousPressDur;
    private int moderatePressDur;
    private int mildPressDur;
    private int relaxPressDur;
    private int limitHeartDur;
    private int anaerobicHeartDur;
    private int aerobcHeartDur;
    private int fatBurningHeartDur;
    private int warmUpHeartDur;

    public DailyDistributeBean() {
        this.seriousPressDur = Integer.MIN_VALUE;
        this.moderatePressDur = Integer.MIN_VALUE;
        this.mildPressDur = Integer.MIN_VALUE;
        this.relaxPressDur = Integer.MIN_VALUE;
        this.limitHeartDur = Integer.MIN_VALUE;
        this.anaerobicHeartDur = Integer.MIN_VALUE;
        this.aerobcHeartDur = Integer.MIN_VALUE;
        this.fatBurningHeartDur = Integer.MIN_VALUE;
        this.warmUpHeartDur = Integer.MIN_VALUE;
    }

    public int getAerobcHeartDur() {
        return aerobcHeartDur;
    }

    public void setAerobcHeartDur(int aerobcHeartDur) {
        this.aerobcHeartDur = aerobcHeartDur;
    }

    public int getAnaerobicHeartDur() {
        return anaerobicHeartDur;
    }

    public void setAnaerobicHeartDur(int anaerobicHeartDur) {
        this.anaerobicHeartDur = anaerobicHeartDur;
    }

    public int getFatBurningHeartDur() {
        return fatBurningHeartDur;
    }

    public void setFatBurningHeartDur(int fatBurningHeartDur) {
        this.fatBurningHeartDur = fatBurningHeartDur;
    }

    public int getLimitHeartDur() {
        return limitHeartDur;
    }

    public void setLimitHeartDur(int limitHeartDur) {
        this.limitHeartDur = limitHeartDur;
    }

    public int getMildPressDur() {
        return mildPressDur;
    }

    public void setMildPressDur(int mildPressDur) {
        this.mildPressDur = mildPressDur;
    }

    public int getModeratePressDur() {
        return moderatePressDur;
    }

    public void setModeratePressDur(int moderatePressDur) {
        this.moderatePressDur = moderatePressDur;
    }

    public int getRelaxPressDur() {
        return relaxPressDur;
    }

    public void setRelaxPressDur(int relaxPressDur) {
        this.relaxPressDur = relaxPressDur;
    }

    public int getSeriousPressDur() {
        return seriousPressDur;
    }

    public void setSeriousPressDur(int seriousPressDur) {
        this.seriousPressDur = seriousPressDur;
    }

    public int getWarmUpHeartDur() {
        return warmUpHeartDur;
    }

    public void setWarmUpHeartDur(int warmUpHeartDur) {
        this.warmUpHeartDur = warmUpHeartDur;
    }
}
