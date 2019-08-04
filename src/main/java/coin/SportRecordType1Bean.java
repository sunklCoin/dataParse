package coin;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SportRecordType1Bean {
    public static final DecimalFormat df2 = new DecimalFormat( "0.00" );
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

    //private ArrayList<SportRecordType1Detail> detailDataBeanArrayList;

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
    }

    public void setDtString(long timeStamp) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date date = new Date(resumeTimeStamp);
        //String dtStr = df.format(date);
        this.dtString = df.format(date);
    }

    /*public void setDetailDataBeanArrayList(ArrayList<SportRecordType1Detail> detailDataBeanArrayList) {
        this.detailDataBeanArrayList = detailDataBeanArrayList;
    }*/

    public void setInitAltitude(float initAltitude) {
        //System.out.println(initAltitude);
        String value = df2.format(initAltitude);
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

    public long getRecordCnt() {
        return recordCnt;
    }

    public long getResumeTimeStamp() {
        return resumeTimeStamp;
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

    public short getHeartRate() {
        return heartRate;
    }

    public float getHeight() {
        return height;
    }

    public short getHeightType() {
        return heightType;
    }

    public short getIncreaseCalorie() {
        return increaseCalorie;
    }

    public short getIncreaseStep() {
        return increaseStep;
    }

    public short getIntergerKM() {
        return intergerKM;
    }

    public float getIncreaseKm() {
        return increaseKm;
    }
}
