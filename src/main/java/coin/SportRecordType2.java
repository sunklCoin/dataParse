package coin;

import java.util.ArrayList;
// inlcude indoor runing
public class SportRecordType2 {
    private long recordCnt;
    private long resumeTimeStamp;
    private String dateTime;

    private ArrayList<SportRecordType1Detail> detailDataBeanArrayList;

    public SportRecordType2() {
        this.recordCnt = Long.MIN_VALUE;
        this.resumeTimeStamp = Long.MIN_VALUE;
        this.dateTime = "data error";
        this.detailDataBeanArrayList = null;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setDetailDataBeanArrayList(ArrayList<SportRecordType1Detail> detailDataBeanArrayList) {
        this.detailDataBeanArrayList = detailDataBeanArrayList;
    }

    public void setRecordCnt(long recordCnt) {
        this.recordCnt = recordCnt;
    }

    public void setResumeTimeStamp(long resumeTimeStamp) {
        this.resumeTimeStamp = resumeTimeStamp;
    }

    public ArrayList<SportRecordType1Detail> getDetailDataBeanArrayList() {
        return detailDataBeanArrayList;
    }

    public long getRecordCnt() {
        return recordCnt;
    }

    public long getResumeTimeStamp() {
        return resumeTimeStamp;
    }

    public String getDateTIme() {
        return dateTime;
    }
}
