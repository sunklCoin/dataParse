package coin;

public class FileInfoBean {
    private String fileName;
    private long timeStamp;
    private int sportType;
    private String fileType;
    private String version;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setSportType(int sportType) {
        this.sportType = sportType;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getSportType() {
        return sportType;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getVersion() {
        return version;
    }
}
