package coin;

// inlcude indoor runing
public class SportRecordType2Bean {
    private byte swRecordType;
    private long swTimeStamp;
    private byte swMainStroke;
    private int swCurrBarPace;
    private int swCurrBarSwolf;
    private int swTotalKm;
    private int swTotalCalorie;
    private int swTotalStroke;
    private int swTotalTurn;
    private byte swCurrBarFq;
    private byte swCurrBarUnKnowStrokeCnt;
    private byte swCurrBarBreastCnt;
    private byte swCurrBarFreeCnt;
    private byte swCurrBarBackCnt;
    private byte swCurrBarButterflyCnt;

    public SportRecordType2Bean() {
        this.swRecordType = Byte.MIN_VALUE;
        this.swTimeStamp = Long.MIN_VALUE;
        this.swMainStroke = Byte.MIN_VALUE;
        this.swCurrBarPace = Integer.MIN_VALUE;
        this.swCurrBarSwolf = Integer.MIN_VALUE;
        this.swTotalKm = Integer.MIN_VALUE;
        this.swTotalCalorie = Integer.MIN_VALUE;
        this.swTotalStroke = Integer.MIN_VALUE;
        this.swTotalTurn = Integer.MIN_VALUE;
        this.swCurrBarFq = Byte.MIN_VALUE;
        this.swCurrBarUnKnowStrokeCnt = Byte.MIN_VALUE;
        this.swCurrBarBreastCnt = Byte.MIN_VALUE;
        this.swCurrBarFreeCnt = Byte.MIN_VALUE;
        this.swCurrBarBackCnt = Byte.MIN_VALUE;
        this.swCurrBarButterflyCnt = Byte.MIN_VALUE;
    }

    public byte getSwCurrBarBackCnt() {
        return swCurrBarBackCnt;
    }

    public void setSwCurrBarBackCnt(byte swCurrBarBackCnt) {
        this.swCurrBarBackCnt = swCurrBarBackCnt;
    }

    public byte getSwCurrBarBreastCnt() {
        return swCurrBarBreastCnt;
    }

    public void setSwCurrBarBreastCnt(byte swCurrBarBreastCnt) {
        this.swCurrBarBreastCnt = swCurrBarBreastCnt;
    }

    public byte getSwCurrBarButterflyCnt() {
        return swCurrBarButterflyCnt;
    }

    public void setSwCurrBarButterflyCnt(byte swCurrBarButterflyCnt) {
        this.swCurrBarButterflyCnt = swCurrBarButterflyCnt;
    }

    public byte getSwCurrBarFq() {
        return swCurrBarFq;
    }

    public void setSwCurrBarFq(byte swCurrBarFq) {
        this.swCurrBarFq = swCurrBarFq;
    }

    public byte getSwCurrBarFreeCnt() {
        return swCurrBarFreeCnt;
    }

    public void setSwCurrBarFreeCnt(byte swCurrBarFreeCnt) {
        this.swCurrBarFreeCnt = swCurrBarFreeCnt;
    }

    public byte getSwCurrBarUnKnowStrokeCnt() {
        return swCurrBarUnKnowStrokeCnt;
    }

    public void setSwCurrBarUnKnowStrokeCnt(byte swCurrBarUnKnowStrokeCnt) {
        this.swCurrBarUnKnowStrokeCnt = swCurrBarUnKnowStrokeCnt;
    }

    public byte getSwMainStroke() {
        return swMainStroke;
    }

    public void setSwMainStroke(byte swMainStroke) {
        this.swMainStroke = swMainStroke;
    }

    public byte getSwRecordType() {
        return swRecordType;
    }

    public void setSwRecordType(byte swRecordType) {
        this.swRecordType = swRecordType;
    }

    public int getSwCurrBarPace() {
        return swCurrBarPace;
    }

    public void setSwCurrBarPace(int swCurrBarPace) {
        this.swCurrBarPace = swCurrBarPace;
    }

    public int getSwCurrBarSwolf() {
        return swCurrBarSwolf;
    }

    public void setSwCurrBarSwolf(int swCurrBarSwolf) {
        this.swCurrBarSwolf = swCurrBarSwolf;
    }

    public int getSwTotalCalorie() {
        return swTotalCalorie;
    }

    public void setSwTotalCalorie(int swTotalCalorie) {
        this.swTotalCalorie = swTotalCalorie;
    }

    public int getSwTotalKm() {
        return swTotalKm;
    }

    public void setSwTotalKm(int swTotalKm) {
        this.swTotalKm = swTotalKm;
    }

    public int getSwTotalStroke() {
        return swTotalStroke;
    }

    public void setSwTotalStroke(int swTotalStroke) {
        this.swTotalStroke = swTotalStroke;
    }

    public int getSwTotalTurn() {
        return swTotalTurn;
    }

    public void setSwTotalTurn(int swTotalTurn) {
        this.swTotalTurn = swTotalTurn;
    }

    public long getSwTimeStamp() {
        return swTimeStamp;
    }

    public void setSwTimeStamp(long swTimeStamp) {
        this.swTimeStamp = swTimeStamp;
    }
}
