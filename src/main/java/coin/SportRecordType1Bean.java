package coin;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SportRecordType1Bean {
    public static final DecimalFormat df2 = new DecimalFormat( "0.00" );
    public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String INVALID_STRING = "invalid";
    private static final int SWIMMING_STROKE_TYPE_UNKNOWN = 0;
    private static final int SWIMMING_STROKE_TYPE_BREAST = 1;
    private static final int SWIMMING_STROKE_TYPE_FREE = 2;
    private static final int SWIMMING_STROKE_TYPE_BACK = 3;
    private static final int SWIMMING_STROKE_TYPE_BUTTERFLY = 4;
    private long index;
    private String initAltitude;
    private long recordCnt;
    private long resumeTimeStamp;
    private String dtString;
    private short    increaseCalorie ;
    private short    increaseStep    ;
    private short    heartRate       ;
    private short    intergerKM      ;
    private short    heightType      ;
    private float    height          ;
    private float    increaseKm      ;

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
    // v2.12
    private int swAllCalorie;

    public SportRecordType1Bean() {
        this.initAltitude = "Invalid float value";
        this.recordCnt = Long.MIN_VALUE;
        this.resumeTimeStamp = Long.MIN_VALUE;
        this.dtString = "";
        //this.detailDataBeanArrayList = null;
        this.increaseCalorie    = Short.MIN_VALUE;
        this.increaseStep       = Short.MIN_VALUE;
        this.heartRate          = Short.MIN_VALUE;
        this.intergerKM         = Short.MIN_VALUE;
        this.heightType         = Short.MIN_VALUE;
        this.height             = Float.MIN_VALUE;
        this.increaseKm         = Float.MIN_VALUE;

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
        this.swAllCalorie = Integer.MIN_VALUE;
        this.index = Long.MIN_VALUE;
    }

    public void setDtString(long timeStamp) {
        Date date = new Date(timeStamp);
        //String dtStr = df.format(date);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        this.dtString = df.format(date);
    }

    /*public void setDetailDataBeanArrayList(ArrayList<SportRecordType1Detail> detailDataBeanArrayList) {
        this.detailDataBeanArrayList = detailDataBeanArrayList;
    }*/

    public void setInitAltitude(float initAltitude) {
        //System.out.println(initAltitude);
        // String value = df2.format(initAltitude);
        //System.out.println(value);
        this.initAltitude = df2.format(initAltitude);
    }

    public void setRecordCnt(long recordCnt) {
        this.recordCnt = recordCnt;
    }

    public void setResumeTimeStamp(long resumeTimeStamp) {
        this.resumeTimeStamp = resumeTimeStamp;
        setDtString(resumeTimeStamp * 1000);
    }

    /*public ArrayList<SportRecordType1Detail> getDetailDataBeanArrayList() {
        return detailDataBeanArrayList;
    }*/

    public String getInitAltitude() {
        return initAltitude;
    }

    public String getRecordCnt() {
        if (recordCnt == Long.MIN_VALUE)
            return INVALID_STRING;
        return Long.toString(recordCnt);
    }

    public String getResumeTimeStamp() {
        if (resumeTimeStamp == Long.MIN_VALUE)
            return INVALID_STRING;
        Date date = new Date(resumeTimeStamp * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String dtStr = df.format(date);
        return Long.toString(resumeTimeStamp) + "\n" + dtStr;
    }

    public String getDtString() {
        return dtString;
    }

    public void setHeartRate(short heartRete) {
        this.heartRate = heartRete;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setHeightType(short heightType) {
        this.heightType = heightType;
    }

    public void setIncreaseCalorie(short increaseCalorie) {
        this.increaseCalorie = increaseCalorie;
    }

    public void setIncreaseKm(float increaseKm) {
        this.increaseKm = increaseKm;
    }

    public void setIncreaseStep(short increaseStep) {
        this.increaseStep = increaseStep;
    }

    public void setIntergerKM(short intergerKM) {
        this.intergerKM = intergerKM;
    }

    public String getHeartRate() {
        if (heartRate == Short.MIN_VALUE)
            return INVALID_STRING;
        return Short.toString(heartRate);
    }

    public String getHeight() {
        if (height == Float.MIN_VALUE)
            return INVALID_STRING;
        return Float.toString(height);
    }

    public String getHeightType() {
        if (heightType == Short.MIN_VALUE)
            return INVALID_STRING;
        return Short.toString(heightType);
    }

    public String getIncreaseCalorie() {
        if (increaseCalorie == Short.MIN_VALUE)
            return INVALID_STRING;
        return Short.toString(increaseCalorie);
    }

    public String getIncreaseStep() {
        if (increaseStep == Short.MIN_VALUE)
            return INVALID_STRING;
        return Short.toString(increaseStep);
    }

    public String getIntergerKM() {
        if (intergerKM == Short.MIN_VALUE)
            return INVALID_STRING;
        return Short.toString(intergerKM);
    }

    public String getIncreaseKm() {
        if (increaseKm == Float.MIN_VALUE)
            return INVALID_STRING;
        return Float.toString(increaseKm);
    }

    public String getSwCurrBarBackCnt() {
        if (swCurrBarBackCnt == Byte.MIN_VALUE)
            return INVALID_STRING;
        if (swCurrBarBackCnt == Byte.MIN_VALUE + 0x01)
            return "-";
        int ret = swCurrBarBackCnt & 0x00ff;
        return Integer.toString(ret);
    }

    public void setSwCurrBarBackCnt(byte swCurrBarBackCnt) {
        this.swCurrBarBackCnt = swCurrBarBackCnt;
    }

    public String getSwCurrBarBreastCnt() {
        if (swCurrBarBreastCnt == Byte.MIN_VALUE)
            return INVALID_STRING;
        if (swCurrBarBreastCnt == Byte.MIN_VALUE + 0x01)
            return "-";
        int ret = swCurrBarBreastCnt & 0x00ff;
        return Integer.toString(ret);
    }

    public void setSwCurrBarBreastCnt(byte swCurrBarBreastCnt) {
        this.swCurrBarBreastCnt = swCurrBarBreastCnt;
    }

    public String getSwCurrBarButterflyCnt() {
        if (swCurrBarButterflyCnt == Byte.MIN_VALUE)
            return INVALID_STRING;
        if (swCurrBarButterflyCnt == Byte.MIN_VALUE + 0x01)
            return "-";
        int ret = swCurrBarButterflyCnt & 0x00ff;
        return Integer.toString(ret);
    }

    public void setSwCurrBarButterflyCnt(byte swCurrBarButterflyCnt) {
        this.swCurrBarButterflyCnt = swCurrBarButterflyCnt;
    }

    public String getSwCurrBarFq() {
        if (swCurrBarFq == Byte.MIN_VALUE)
            return INVALID_STRING;
        if (swCurrBarFq == Byte.MIN_VALUE + 0x01)
            return "-";
        int ret = swCurrBarFq & 0x00ff;
        return Integer.toString(ret);
    }

    public void setSwCurrBarFq(byte swCurrBarFq) {
        this.swCurrBarFq = swCurrBarFq;
    }

    public String getSwCurrBarFreeCnt() {
        if (swCurrBarFreeCnt == Byte.MIN_VALUE)
            return INVALID_STRING;
        if (swCurrBarFreeCnt == Byte.MIN_VALUE + 0x01)
            return "-";
        int ret = swCurrBarFreeCnt & 0x00ff;
        return Integer.toString(ret);
    }

    public void setSwCurrBarFreeCnt(byte swCurrBarFreeCnt) {
        this.swCurrBarFreeCnt = swCurrBarFreeCnt;
    }

    public String getSwCurrBarUnKnowStrokeCnt() {
        if (swCurrBarUnKnowStrokeCnt == Byte.MIN_VALUE)
            return INVALID_STRING;
        if (swCurrBarUnKnowStrokeCnt == Byte.MIN_VALUE + 0x01)
            return "-";
        int ret = swCurrBarUnKnowStrokeCnt & 0x00ff;
        return Integer.toString(ret);
    }

    public void setSwCurrBarUnKnowStrokeCnt(byte swCurrBarUnKnowStrokeCnt) {
        this.swCurrBarUnKnowStrokeCnt = swCurrBarUnKnowStrokeCnt;
    }

    public String getSwMainStroke() {
        if (swMainStroke == Byte.MIN_VALUE)
            return INVALID_STRING;
        int ret = swMainStroke & 0x00ff;
        String mainSwimTypeName = null;
        switch(ret) {
            case SWIMMING_STROKE_TYPE_UNKNOWN:
                mainSwimTypeName = "混合泳";
            break;
            case SWIMMING_STROKE_TYPE_BREAST:
                mainSwimTypeName = "蛙泳";
            break;
            case SWIMMING_STROKE_TYPE_FREE:
                mainSwimTypeName = "自由泳";
            break;
            case SWIMMING_STROKE_TYPE_BACK:
                mainSwimTypeName = "仰泳";
            break;
            case SWIMMING_STROKE_TYPE_BUTTERFLY:
                mainSwimTypeName = "蝶泳";
            break;
            default:
                mainSwimTypeName = "";
            break;
        }
        return Integer.toString(ret) + "(" + mainSwimTypeName + ")";
    }

    public void setSwMainStroke(byte swMainStroke) {
        this.swMainStroke = swMainStroke;
    }

    public String getSwRecordType() {
        if (swRecordType == Byte.MIN_VALUE)
            return INVALID_STRING;
        int ret = swRecordType & 0x00ff;
        if (ret == 0x00) {
            return Integer.toString(ret) + "(小节)";
        } else {
            return Integer.toString(ret) + "(段落)";
        }
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

    public String getSwTotalCalorie() {
        if (swTotalCalorie == Integer.MIN_VALUE)
            return INVALID_STRING;
        if (swTotalCalorie == Integer.MIN_VALUE + 1)
            return "-";
        return Integer.toString(swTotalCalorie);
    }

    public void setSwTotalCalorie(int swTotalCalorie) {
        this.swTotalCalorie = swTotalCalorie;
    }

    public String getSwTotalKm() {
        if (swTotalKm == Integer.MIN_VALUE)
            return INVALID_STRING;
        if (swTotalKm == Integer.MIN_VALUE + 1)
            return "-";
        return Integer.toString(swTotalKm);
    }

    public void setSwTotalKm(int swTotalKm) {
        this.swTotalKm = swTotalKm;
    }

    public String getSwTotalStroke() {
        if (swTotalStroke == Integer.MIN_VALUE)
            return INVALID_STRING;
        if (swTotalStroke == Integer.MIN_VALUE + 1)
            return "-";
        return Integer.toString(swTotalStroke);
    }

    public void setSwTotalStroke(int swTotalStroke) {
        this.swTotalStroke = swTotalStroke;
    }

    public String getSwTotalTurn() {
        if (swTotalTurn == Integer.MIN_VALUE)
            return INVALID_STRING;
        if (swTotalTurn == Integer.MIN_VALUE + 1)
            return "-";
        return Integer.toString(swTotalTurn);
    }

    public void setSwTotalTurn(int swTotalTurn) {
        this.swTotalTurn = swTotalTurn;
    }

    public String getSwTimeStamp() {
        Date date = new Date(swTimeStamp * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(FileInfoBean.getInstance().getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String dtStr = df.format(date);
        return Long.toString(swTimeStamp) + "\n" + dtStr;
    }

    public void setSwTimeStamp(long swTimeStamp) {
        this.swTimeStamp = swTimeStamp;
    }

    /**
     * @param swAllCalorie the swAllCalorie to set
     */
    public void setSwAllCalorie(int swAllCalorie) {
        this.swAllCalorie = swAllCalorie;
    }

    /**
     * @return the swAllCalorie
     */
    public String getSwAllCalorie() {
        if (swAllCalorie == Integer.MIN_VALUE)
            return INVALID_STRING;
        if (swAllCalorie == Integer.MIN_VALUE + 1)
            return "-";
        return Integer.toString(swAllCalorie);
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
}
