package coin;

public class FileInfoBean {
    private String fileName;
    private long timeStamp;
    private int sportType;
    private String fileType;
    private String version;
    private int timeZone;
    private long recordCount;
    private long fileSize;

    private static FileInfoBean instance;
    public static FileInfoBean getInstance() {
        if (instance == null) {
            instance = new FileInfoBean();
        }
        return instance;
    }

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

    public int getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
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

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public long getFileSize() {
        return fileSize;
    }

    public int getFileVersionNumber() {
        return Integer.parseInt(this.getVersion().substring(1));
    }
}
