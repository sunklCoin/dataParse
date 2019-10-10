package coin;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class DataConverTool {
    public static final boolean DEBUG_DAILY_RECORD = false;
    public static final int OUTDOOR_RUNNING_FILE_SIZE = 87;
    public static final int OUTDOOR_WALKING_FILE_SIZE = 87;
    public static final int CROSS_COUNTRY_FILE_SIZE = 87;
    public static final int MOUNTAINEERING_FILE_SIZE = 87;
    public static final int INDOOR_RUNNING_FILE_SIZE = 63;
    public static final int OUTDOOR_RIDING_FILE_SIZE = 81;
    public static final int INDOOR_BICYCLE_FILE_SIZE = 44;
    public static final int FREE_TRAIAING_FILE_SIZE = 44;
    public static final int INDOOR_SWIMMING_FILE_SIZE = 40;
    public static final int OPEN_WATER_SWIMMING_FILE_SIZE = 40;
    public static final int SPORT_REPORT_V2_FILE_SIZE_GAP = 2;
    public static final int DAILY_ACTIVITY_REPORT_FILE_SIZE = 25;
    public static final int DAILY_ACTIVITY_REPORT_FILE_SIZE_V2 = 29;
    public static final int USER_PROFLE_FILE_SIZE = 20;
    public static final int DAILY_RECORD_DYNAMIC_BUFF_MAX_SIZE = 11;
    public static final int DAILY_RECORD_DYNAMIC_BUFF_MIN_SIZE = 10;

    public static final int SPORT_RECORD_TYPE1_DYNAMIC_BUFF_SIZE = 4;
    public static final int SPORT_RECORD_TYPE2_DYNAMIC_BUFF_SIZE = 3;
    public static final int SPORT_RECORD_TYPE3_DYNAMIC_BUFF_SIZE = 3;
    public static final int SPORT_RECORD_TYPE4_DYNAMIC_BUFF_SIZE = 2;
    public static final int SPORT_RECORD_TYPE5_DYNAMIC_BUFF_MIN_SIZE = 10;
    public static final int SPORT_RECORD_TYPE5_DYNAMIC_BUFF_LEFT_SIZE = 14;
    public static final int SPORT_RECORD_TYPE5_DYNAMIC_BUFF_V2_LEFT_SIZE = 16;

    public static final int DAILY_RECORD_HAS_SLEEP_FLAG_BIT = 15;
    public static final int DAILY_RECORD_EXCEPTION_HEART_FLAG_BIT = 14;
    public static final int DAILY_RECORD_ACTIVITY_TYPE_SHIFT_BIT = 4;
    public static final int DAILY_RECORD_ACTIVITY_TYPE_SHIFT_BIT_V2 = 6;
    public static final int DAILY_RECORD_ACT_STRONG_SHIFT_BIT = 5;

    public static final int DAILY_RECORD_SLEEP_MODE_SHIFT_BIT = 13;
    public static final int DAILY_RECORD_SLEEP_MODE_SHIFT_BIT_V2 = 10;
    public static final int DAILY_RECORD_ENERGY_STATE_SHIFT_BIT = 11;
    public static final int DAILY_RECORD_ENERGY_STATE_SHIFT_BIT_V2 = 8;
    public static final int GPS_DATA_FIX_SIZE = 12;
    public static final int DAILY_DISTRIBUTE_FILE_SIZE = 18;

    public static final int OUTDOOR_RUNNING = 1;
    public static final int OUTDOOR_WALKING = 2;
    public static final int CROSS_COUNTRY = 5;
    public static final int MOUNTAINEERING = 4;
    public static final int INDOOR_RUNNING = 3;
    public static final int OUTDOOR_RIDING = 6;
    public static final int INDOOR_BICYCLE = 7;
    public static final int FREE_TRAIAING = 8;
    public static final int INDOOR_SWIMMING = 9;
    public static final int OPEN_WATER_SWIMMING = 10;

    public static final int SPORT_FILE_TYPE = 0;
    public static final int DAILY_FILE_TYPE = 1;
    public static final int USER_PROFILE_TYPE = 2;
    public static final int GPS_DATA_TYPE = 3;
    public static final int SLEEP_DATA_TYPE = 4;
    public static final int AVERAGE_DATA_TYPE = 4;
    public static final int RECORD_TIME_STAMP_DATA_TYPE = 100;
    private FileInfoBean fileInfo;

    private int parseTimeZone(String dir[]) {
        if (dir == null)
            return Integer.MIN_VALUE;
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].length() < 4 && (dir[i].startsWith("p") || dir[i].startsWith("n"))) {
                char preFix = dir[i].charAt(0);
                String timeZoneStr = dir[i].substring(1);
                System.out.println("preFix " + preFix + " timeZoneStr " + timeZoneStr);
                int realTimeZone = Integer.valueOf(timeZoneStr);
                if (preFix == 'n')
                    realTimeZone = -realTimeZone;
                return realTimeZone;
            }
        }
        return Integer.MIN_VALUE;
    }

    private FileInfoBean ParserFileInfo(String file, int fileType) {
        String destFile = file;
        int tz = Integer.MIN_VALUE;
        if (file.contains("\\")) {
            String temp[] = file.split("\\\\");
            tz = parseTimeZone(temp);
            String fileName = temp[temp.length - 1];
            destFile = fileName;
        }

        String fileFormat[] = destFile.split("_");
        for (String str : fileFormat) {
            System.out.println(str);
        }
        FileInfoBean fileInfoBean = FileInfoBean.getInstance();//new FileInfoBean();
        fileInfoBean.setFileName(destFile);
        if (fileType != RECORD_TIME_STAMP_DATA_TYPE) {
            int index = fileFormat.length - 1;
            fileInfoBean.setVersion(fileFormat[index--]);
            fileInfoBean.setFileType(fileFormat[index--]);
            if (fileType == SPORT_FILE_TYPE || fileType == GPS_DATA_TYPE) {
                fileInfoBean.setSportType(Integer.parseInt(fileFormat[index--]));
            }
            fileInfoBean.setTimeStamp(Long.parseLong(fileFormat[index]));
        }
        fileInfoBean.setTimeZone(tz);
        this.fileInfo = fileInfoBean;
        return fileInfoBean;
    }

    public FileInfoBean getFileInfo() {
        return this.fileInfo;
    }

    private int getSportReportFileSize(int type) {
        int size = 0;
        switch (type) {
            case 0:
                size = 0;
                break;
            case OUTDOOR_RUNNING:
                size = OUTDOOR_RUNNING_FILE_SIZE;
                break;
            case OUTDOOR_WALKING:
                size = OUTDOOR_WALKING_FILE_SIZE;
                break;
            case CROSS_COUNTRY:
                size = CROSS_COUNTRY_FILE_SIZE;
                break;
            case MOUNTAINEERING:
                size = MOUNTAINEERING_FILE_SIZE;
                break;
            case INDOOR_RUNNING:
                size = INDOOR_RUNNING_FILE_SIZE;
                break;
            case OUTDOOR_RIDING:
                size = OUTDOOR_RIDING_FILE_SIZE;
                break;
            case INDOOR_BICYCLE:
                size = INDOOR_BICYCLE_FILE_SIZE;
                break;
            case FREE_TRAIAING:
                size = FREE_TRAIAING_FILE_SIZE;
                break;
            case INDOOR_SWIMMING:
                size = INDOOR_SWIMMING_FILE_SIZE;
                break;
            case OPEN_WATER_SWIMMING:
                size = OPEN_WATER_SWIMMING_FILE_SIZE;
                break;
        }
        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            size += SPORT_REPORT_V2_FILE_SIZE_GAP;
        }
        return size;
    }

    public SportReportBean parserSportReportData(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, SPORT_FILE_TYPE);
        final int byteSize = getSportReportFileSize(fileInfoBean.getSportType());
        if (byteSize == 0) {
            return null;
        }
        File reportFile = new File(file);
        byte[] fileContent = new byte[byteSize];
        fileInfoBean.setFileSize(reportFile.length());
        try {
            FileInputStream in = new FileInputStream(reportFile);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileInfoBean.setRecordCount(1);
        switch (fileInfoBean.getSportType()) {
            case OUTDOOR_RUNNING:
            case OUTDOOR_WALKING:
            case CROSS_COUNTRY:
            case MOUNTAINEERING:
                return parserOutdoorRunning(fileContent);
            case INDOOR_RUNNING:
                return parserIndoorRunning(fileContent);
            case OUTDOOR_RIDING:
                return parserOutdoorRiding(fileContent);
            case INDOOR_BICYCLE:
            case FREE_TRAIAING:
                return parseIndoorBicycle(fileContent);
            case INDOOR_SWIMMING:
            case OPEN_WATER_SWIMMING:
                return parseSwimming(fileContent);
            default:
                return null;
        }
    }

    private SportReportBean parserOutdoorRunning(final byte[] fileContent) {
        SportReportBean sportReportBean = new SportReportBean();
        sportReportBean.setStartTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 0, 4)));

        sportReportBean.setEndTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 4, 8)));

        sportReportBean.setTotalTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 8, 12)));

        sportReportBean.setTotalDistance(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 12, 16)));

        sportReportBean.setCalorie(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 16, 18)));


        sportReportBean.setMaxPace(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 18, 22)));

        sportReportBean.setMinPace(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 22, 26)));

        sportReportBean.setMaxSpeed(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 26, 30)));

        sportReportBean.setTotalStepCount(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 30, 34)));

        sportReportBean.setMaxStrideFreq(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 34, 36)));

        sportReportBean.setAveHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 36, 37)));

        sportReportBean.setMaxHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 37, 38)));

        sportReportBean.setMinHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 38, 39)));

        sportReportBean.setAsendTotal(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 39, 43)));

        sportReportBean.setDescendTotal(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 43, 47)));

        sportReportBean.setAvgHeight(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 47, 51)));

        sportReportBean.setMaxHeight(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 51, 55)));

        sportReportBean.setMinHeight(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 55, 59)));

        sportReportBean.setTranEffct(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 59, 63)));

        sportReportBean.setVo2Max(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 63, 64)));

        sportReportBean.setEneryConsum(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 64, 65)));

        sportReportBean.setPreRecoverTime(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 65, 67)));

        sportReportBean.setHeartRateLimitDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 67, 71)));

        sportReportBean.setAnaerobicEnduranceDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 71, 75)));

        sportReportBean.setAerobicEnduranceDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 75, 79)));

        sportReportBean.setFatBurningTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 79, 83)));

        sportReportBean.setWarmupTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 83, 87)));
        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            sportReportBean.setTotalCalorie(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 87, 89)));
        }
        return sportReportBean;
    }

    private SportReportBean parserIndoorRunning(final byte[] fileContent) {
        SportReportBean sportReportBean = new SportReportBean();
        //byte[] temp = Arrays.copyOfRange(fileContent, 0, 4);
        sportReportBean.setStartTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 0, 4)));

        sportReportBean.setEndTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 4, 8)));

        sportReportBean.setTotalTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 8, 12)));

        sportReportBean.setTotalDistance(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 12, 16)));

        sportReportBean.setCalorie(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 16, 18)));

        sportReportBean.setMaxPace(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 18, 22)));

        sportReportBean.setMinPace(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 22, 26)));

        sportReportBean.setTotalStepCount(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 26, 30)));

        sportReportBean.setMaxStrideFreq(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 30, 32)));

        sportReportBean.setAveHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 32, 33)));

        sportReportBean.setMaxHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 33, 34)));

        sportReportBean.setMinHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 34, 35)));

        sportReportBean.setTranEffct(ByteUtil.getFloat(Arrays.copyOfRange(fileContent, 35, 39)));

        sportReportBean.setVo2Max(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 39, 40)));

        sportReportBean.setEneryConsum(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 40, 41)));

        sportReportBean.setPreRecoverTime(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 41, 43)));

        sportReportBean.setHeartRateLimitDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 43, 47)));

        sportReportBean.setAnaerobicEnduranceDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 47, 51)));

        sportReportBean.setAerobicEnduranceDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 51, 55)));

        sportReportBean.setFatBurningTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 55, 59)));

        sportReportBean.setWarmupTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 59, 63)));
        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            sportReportBean.setTotalCalorie(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 63, 65)));
        }
        return sportReportBean;
    }

    private SportReportBean parserOutdoorRiding(final byte[] fileContent) {
        SportReportBean sportReportBean = new SportReportBean();
        //byte[] temp = Arrays.copyOfRange(fileContent, 0, 4);
        sportReportBean.setStartTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 0, 4)));

        sportReportBean.setEndTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 4, 8)));

        sportReportBean.setTotalTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 8, 12)));

        sportReportBean.setTotalDistance(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 12, 16)));

        sportReportBean.setCalorie(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 16, 18)));

        sportReportBean.setMaxPace(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 18, 22)));

        sportReportBean.setMinPace(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 22, 26)));

        sportReportBean.setMaxSpeed(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 26, 30)));


        sportReportBean.setAveHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 30, 31)));

        sportReportBean.setMaxHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 31, 32)));

        sportReportBean.setMinHeart(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 32, 33)));

        sportReportBean.setAsendTotal(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 33, 37)));

        sportReportBean.setDescendTotal(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 37, 41)));

        sportReportBean.setAvgHeight(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 41, 45)));

        sportReportBean.setMaxHeight(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 45, 49)));

        sportReportBean.setMinHeight(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 49, 53)));

        sportReportBean.setTranEffct(ByteUtil.getFloat(
                Arrays.copyOfRange(fileContent, 53, 57)));

        sportReportBean.setVo2Max(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 57, 58)));

        sportReportBean.setEneryConsum(ByteUtil.getUnsignedChar(
                Arrays.copyOfRange(fileContent, 58, 59)));

        sportReportBean.setPreRecoverTime(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 59, 61)));

        sportReportBean.setHeartRateLimitDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 61, 65)));

        sportReportBean.setAnaerobicEnduranceDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 65, 69)));

        sportReportBean.setAerobicEnduranceDuration(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 69, 73)));

        sportReportBean.setFatBurningTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 73, 77)));

        sportReportBean.setWarmupTime(ByteUtil.getUnsignedInt(
                Arrays.copyOfRange(fileContent, 77, 81)));
        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            sportReportBean.setTotalCalorie(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 81, 83)));
        }
        return sportReportBean;
    }


    private SportReportBean parseIndoorBicycle(final byte[] fileContent) {
        SportReportBean sportReportBean = new SportReportBean();
        byte[] fourBytebuff = Arrays.copyOfRange(fileContent, 0, 4);  // 4 bytes
        sportReportBean.setStartTime(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 4, 8);  // 4 bytes
        sportReportBean.setEndTime(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 8, 12);  // 4 bytes
        sportReportBean.setTotalTime(ByteUtil.getUnsignedInt(fourBytebuff));

        byte[] doubleBytebuff = Arrays.copyOfRange(fileContent, 12, 14);  // 2 bytes
        sportReportBean.setCalorie(ByteUtil.getUnsignedShort(doubleBytebuff));

        byte[] singleBytebuff = Arrays.copyOfRange(fileContent, 14, 15);  // 1 byte
        sportReportBean.setAveHeart(ByteUtil.getUnsignedChar(singleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 15, 16);  // 1 byte
        sportReportBean.setMaxHeart(ByteUtil.getUnsignedChar(singleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 16, 17);  // 1 byte
        sportReportBean.setMinHeart(ByteUtil.getUnsignedChar(singleBytebuff));

        fourBytebuff = Arrays.copyOfRange(fileContent, 17, 21);   // 4 bytes
        sportReportBean.setTranEffct(ByteUtil.getFloat(fourBytebuff));

        singleBytebuff = Arrays.copyOfRange(fileContent, 21, 22);  // 1 byte
        sportReportBean.setEneryConsum(ByteUtil.getUnsignedChar(singleBytebuff));
        doubleBytebuff = Arrays.copyOfRange(fileContent, 22, 24);  // 2 bytes
        sportReportBean.setPreRecoverTime(ByteUtil.getUnsignedShort(doubleBytebuff));

        fourBytebuff = Arrays.copyOfRange(fileContent, 24, 28);  // 4 bytes
        sportReportBean.setHeartRateLimitDuration(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 28, 32);  // 4 bytes
        sportReportBean.setAnaerobicEnduranceDuration(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 32, 36);  // 4 bytes
        sportReportBean.setAerobicEnduranceDuration(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 36, 40);  // 4 bytes
        sportReportBean.setFatBurningTime(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 40, 44);  // 4 bytes
        sportReportBean.setWarmupTime(ByteUtil.getUnsignedInt(fourBytebuff));
        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            sportReportBean.setTotalCalorie(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 44, 46)));
        }
        return sportReportBean;
    }

    private SportReportBean parseSwimming(final byte[] fileContent) {
        SportReportBean sportReportBean = new SportReportBean();
        byte[] fourBytebuff = Arrays.copyOfRange(fileContent, 0, 4);  // 4 bytes
        sportReportBean.setStartTime(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 4, 8);     // 4 bytes
        sportReportBean.setEndTime(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 8, 12);        // 4 bytes
        sportReportBean.setTotalTime(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 12, 16);       // 4 bytes
        sportReportBean.setTotalDistance(ByteUtil.getUnsignedInt(fourBytebuff));
        byte[] doubleBytebuff = Arrays.copyOfRange(fileContent, 16, 18);       // 2 bytes
        sportReportBean.setCalorie(ByteUtil.getUnsignedShort(doubleBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 18, 22);       // 4 bytes
        sportReportBean.setMaxPace(ByteUtil.getUnsignedInt(fourBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 22, 26);       // 4 bytes
        sportReportBean.setMinPace(ByteUtil.getUnsignedInt(fourBytebuff));

        byte[] singleBytebuff = Arrays.copyOfRange(fileContent, 26, 27);
        sportReportBean.setEneryConsum(ByteUtil.getUnsignedChar(singleBytebuff));
        doubleBytebuff = Arrays.copyOfRange(fileContent, 27, 29);
        sportReportBean.setPreRecoverTime(ByteUtil.getUnsignedShort(doubleBytebuff));

        doubleBytebuff = Arrays.copyOfRange(fileContent, 29, 31);       // 2 bytes
        sportReportBean.setTotalStrokes(ByteUtil.getUnsignedChar(doubleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 31, 32);       // 1 byte
        sportReportBean.setMainSwimType(ByteUtil.getUnsignedChar(singleBytebuff));

        singleBytebuff = Arrays.copyOfRange(fileContent, 32, 33);       // 1 byte
        sportReportBean.setMaxStrokeFreq(ByteUtil.getUnsignedChar(singleBytebuff));
        doubleBytebuff = Arrays.copyOfRange(fileContent, 33, 35);       // 2 bytes
        sportReportBean.setTurnAround(ByteUtil.getUnsignedShort(doubleBytebuff));
        doubleBytebuff = Arrays.copyOfRange(fileContent, 35, 37);       // 2 bytes
        sportReportBean.setAveSwolf(ByteUtil.getUnsignedShort(doubleBytebuff));
        doubleBytebuff = Arrays.copyOfRange(fileContent, 37, 39);       // 2 bytes
        sportReportBean.setBestSwolf(ByteUtil.getUnsignedShort(doubleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 39, 40);       // 1 byte
        sportReportBean.setPoolWidth(ByteUtil.getUnsignedChar(singleBytebuff));
        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            sportReportBean.setTotalCalorie(ByteUtil.getUnsignedShort(
                Arrays.copyOfRange(fileContent, 40, 42)));
        }
        return sportReportBean;
    }

    public DailyReportBean parseDailyReport(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, DAILY_FILE_TYPE);
        int extraByte = 0;
        if (fileInfoBean.getFileVersionNumber() >= 2){
            extraByte = DAILY_ACTIVITY_REPORT_FILE_SIZE_V2 - DAILY_ACTIVITY_REPORT_FILE_SIZE;
        }
        final int byteSize = DAILY_ACTIVITY_REPORT_FILE_SIZE + extraByte;
        if (byteSize == 0) {
            return null;
        }
        File reportFile = new File(file);
        fileInfoBean.setFileSize(reportFile.length());
        byte[] fileContent = new byte[byteSize];
        try {
            FileInputStream in = new FileInputStream(reportFile);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DailyReportBean mDailyReportBean = parserDailyReportData(fileContent);
        fileInfoBean.setRecordCount(mDailyReportBean != null ? 1 : 0);
        return mDailyReportBean;
    }

    private DailyReportBean parserDailyReportData(final byte[] fileContent) {
        DailyReportBean mDailyReportBean = new DailyReportBean();
        byte[] fourBytebuff = Arrays.copyOfRange(fileContent, 0, 4);    // 4 bytes
        mDailyReportBean.setTotalStepCount(ByteUtil.getUnsignedInt(fourBytebuff));
        byte[] doubleBytebuff = Arrays.copyOfRange(fileContent, 4, 6);   // 2 bytes
        mDailyReportBean.setTotalCalorie(ByteUtil.getUnsignedShort(doubleBytebuff));
        byte[] singleBytebuff = Arrays.copyOfRange(fileContent, 6, 7);  // 1 bytes
        mDailyReportBean.setCurrHeartRate(ByteUtil.getUnsignedChar(singleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 7, 8);       // 1 bytes
        mDailyReportBean.setRestingHeartRate(ByteUtil.getUnsignedChar(singleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 8, 9);         // 1 byte
        mDailyReportBean.setMaxHeartRate(ByteUtil.getUnsignedChar(singleBytebuff));
        fourBytebuff = Arrays.copyOfRange(fileContent, 9, 13);         // 4 byte
        mDailyReportBean.setTimeOfmaxHeartRate(ByteUtil.getUnsignedInt(fourBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 13, 14);         // 1 byte
        mDailyReportBean.setMinHeartRate(ByteUtil.getUnsignedChar(singleBytebuff));

        fourBytebuff = Arrays.copyOfRange(fileContent, 14, 18);         // 4 byte
        mDailyReportBean.setTimeOfminHeartRate(ByteUtil.getUnsignedInt(fourBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 18, 19);         // 1 byte
        mDailyReportBean.setAvgHeartRate(ByteUtil.getUnsignedChar(singleBytebuff));

        singleBytebuff = Arrays.copyOfRange(fileContent, 19, 20);         // 1 byte
        mDailyReportBean.setAvgPressure(ByteUtil.getUnsignedChar(singleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 20, 21);         // 1 byte
        mDailyReportBean.setMaxPressure(ByteUtil.getUnsignedChar(singleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 21, 22);         // 1 byte
        mDailyReportBean.setMinPressure(ByteUtil.getUnsignedChar(singleBytebuff));

        byte[] threeBytebuff = Arrays.copyOfRange(fileContent, 22, 25); // 3 bytes
        mDailyReportBean.setStandFlag(ByteUtil.toHexString(threeBytebuff));
        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            doubleBytebuff = Arrays.copyOfRange(fileContent, 25, 27);
            mDailyReportBean.setCurrTotalCal(ByteUtil.getUnsignedShort(doubleBytebuff));
            doubleBytebuff = Arrays.copyOfRange(fileContent, 27, 29);
            mDailyReportBean.setRemainRecoverTime(ByteUtil.getUnsignedShort(doubleBytebuff));
        }
        return mDailyReportBean;
    }


    public UserInfoBean parseUserProfile(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, USER_PROFILE_TYPE);
        final int byteSize = USER_PROFLE_FILE_SIZE;
        // if (byteSize == 0) {
        //     return null;
        // }
        File reportFile = new File(file);
        fileInfoBean.setFileSize(reportFile.length());
        byte[] fileContent = new byte[byteSize];
        try {
            FileInputStream in = new FileInputStream(reportFile);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserInfoBean mUserInfoBean = parseUserProfileData(fileContent);
        fileInfoBean.setRecordCount(mUserInfoBean != null ? 1 : 0);
        return mUserInfoBean;
    }

    private UserInfoBean parseUserProfileData(final byte[] fileContent) {
        UserInfoBean mUserInfoBean = new UserInfoBean();
        byte[] singleBytebuff = Arrays.copyOfRange(fileContent, 0, 1); // 1 byte
        mUserInfoBean.setHeight(ByteUtil.getUnsignedChar(singleBytebuff));

        byte[] fourBytebuff = Arrays.copyOfRange(fileContent, 1, 5);  // 4 byte
        mUserInfoBean.setWeight(ByteUtil.getFloat(fourBytebuff));

        fourBytebuff = Arrays.copyOfRange(fileContent, 5, 9); // 4 byte
        mUserInfoBean.setBirthday(ByteUtil.getUnsignedInt(fourBytebuff));

        singleBytebuff = Arrays.copyOfRange(fileContent, 9, 10);    // 1 byte
        mUserInfoBean.setGender(ByteUtil.getUnsignedChar(singleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 10, 11);   // 1 byte
        mUserInfoBean.setVo2Max(ByteUtil.getUnsignedChar(singleBytebuff));

        byte[] doubleBytebuff = Arrays.copyOfRange(fileContent, 11, 13); // 2 byte
        mUserInfoBean.setMaxHeartRate(ByteUtil.getUnsignedShort(doubleBytebuff));
        singleBytebuff = Arrays.copyOfRange(fileContent, 13, 14);   // 1 byte
        mUserInfoBean.setMinHisHR(ByteUtil.getUnsignedChar(singleBytebuff));

        doubleBytebuff = Arrays.copyOfRange(fileContent, 14, 16);   // 2 byte
        mUserInfoBean.setMaxHisHR(ByteUtil.getUnsignedShort(doubleBytebuff));
        doubleBytebuff = Arrays.copyOfRange(fileContent, 16, 18);   // 2 byte
        mUserInfoBean.setEverydayMaxCalorie(ByteUtil.getUnsignedShort(doubleBytebuff));
        doubleBytebuff = Arrays.copyOfRange(fileContent, 18, 20);   // 2 byte
        mUserInfoBean.setEverydayMaxStep(ByteUtil.getUnsignedShort(doubleBytebuff));
        return mUserInfoBean;
    }

    public ArrayList<DailyRecordBean> parseDynamicDailyFile(String file) {
        ArrayList<DailyRecordBean> arrayList = new ArrayList<DailyRecordBean>();
        FileInfoBean fileInfoBean = ParserFileInfo(file, DAILY_FILE_TYPE);
        int extraByte = 0;
        if (DEBUG_DAILY_RECORD) {
            extraByte = 8;
        }
        final int buffSize = DAILY_RECORD_DYNAMIC_BUFF_MIN_SIZE + extraByte;

        byte[] fileContent = new byte[buffSize];
        File reportFile = new File(file);
        fileInfoBean.setFileSize(reportFile.length());
        final long fileSize = reportFile.length();
        int startPos = 0;
        int dataCount = 0;
        int version = 1;
        version = fileInfoBean.getFileVersionNumber();
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            int ret = 0;
            System.out.println("buffSize " + buffSize + " fileSize " + fileSize);
            while ((ret = raf.read(fileContent)) >= (DAILY_RECORD_DYNAMIC_BUFF_MIN_SIZE + extraByte)) {
                System.out.println("startPos " + startPos);
                // int ret = raf.read(fileContent, 0, DAILY_RECORD_DYNAMIC_BUFF_MIN_SIZE);
                System.out.println("raf.read ret " + ret);
                DailyRecordBean parseDailyRecordBean = parseFixLenBuffOfDailyRecord(fileContent, version);
                startPos += (DAILY_RECORD_DYNAMIC_BUFF_MIN_SIZE + extraByte);
                dataCount += 1;
                if (parseDailyRecordBean == null) {
                    System.out.println("parseDailyRecordBean is null");
                    raf.close();
                    break;
                }

                if (parseDailyRecordBean.getHasExceptionHeart() == 1) {
                    byte[] buff = new byte[1];
                    raf.read(buff, 0, 1);
                    startPos += 1;
                    short recordData8 = ByteUtil.getUnsignedChar(buff);
                    parseDailyRecordBean.setExceptionHeartRate(recordData8);
                }
                arrayList.add(parseDailyRecordBean);
            }
            raf.close();
            fileInfoBean.setRecordCount(dataCount);
            System.out.println("parseDailyRecordBean dataCount = " + dataCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private DailyRecordBean parseFixLenBuffOfDailyRecord(byte[] buff, int version) {
        int extraByte = 0;
        if (DEBUG_DAILY_RECORD) {
            extraByte = 8;
        }
        if (buff == null || buff.length != (DAILY_RECORD_DYNAMIC_BUFF_MIN_SIZE + extraByte))
            return null;
        DailyRecordBean mDailyRecordBean = new DailyRecordBean();
        byte[] temp = Arrays.copyOfRange(buff, 0, 2); // 2 byte
        int recordData1 = ByteUtil.getUnsignedShort(temp);
        if (version == 1) {
            mDailyRecordBean.setHasSleepData((byte)
                ((recordData1 & 0x00008000) >> DAILY_RECORD_HAS_SLEEP_FLAG_BIT));
        }
        mDailyRecordBean.setHasExceptionHeart((byte)
                ((recordData1 & 0x00004000) >> DAILY_RECORD_EXCEPTION_HEART_FLAG_BIT));
        mDailyRecordBean.setIncreaseStepCnt(recordData1 & 0x00003FFF);

        byte[] recordData2Buff = Arrays.copyOfRange(buff, 2, 3); // 1 byte
        short recordData2 = ByteUtil.getUnsignedChar(recordData2Buff);
        if (version >= 2) {
            mDailyRecordBean.setActivityType((byte)
                ((recordData2 & 0x00C0) >> DAILY_RECORD_ACTIVITY_TYPE_SHIFT_BIT_V2));
            mDailyRecordBean.setIncreaseCalorie((byte)(recordData2 & 0x003F));
        } else {
            mDailyRecordBean.setActivityType((byte)
                ((recordData2 & 0x00F0) >> DAILY_RECORD_ACTIVITY_TYPE_SHIFT_BIT));
            mDailyRecordBean.setIncreaseCalorie((byte)
                    (recordData2 & 0x000F));
        }

        byte[] recordData3Buff = Arrays.copyOfRange(buff, 3, 4); // 1 byte
        short recordData3 = ByteUtil.getUnsignedChar(recordData3Buff);
        mDailyRecordBean.setActStrong((byte)
                ((recordData3 & 0x00e0) >> DAILY_RECORD_ACT_STRONG_SHIFT_BIT));
        mDailyRecordBean.setSportType((byte) (recordData3 & 0x001f));

        byte[] recordData4Buff = Arrays.copyOfRange(buff, 4, 6); // 2 byte
        int recordData4 = ByteUtil.getUnsignedShort(recordData4Buff);
        mDailyRecordBean.setIncreaseDistance(recordData4);

        byte[] recordData5Buff = Arrays.copyOfRange(buff, 6, 7); // 1 byte
        short recordData5 = ByteUtil.getUnsignedChar(recordData5Buff);
        mDailyRecordBean.setHeartRate(recordData5);

        byte[] recordData6Buff = Arrays.copyOfRange(buff, 7, 8); // 1 byte
        short recordData6 = ByteUtil.getUnsignedChar(recordData6Buff);
        mDailyRecordBean.setDumpEnergy(recordData6);

        byte[] recordData7Buff = Arrays.copyOfRange(buff, 8, 10); // 2 byte
        int recordData7 = ByteUtil.getUnsignedShort(recordData7Buff);
        System.out.println("recordData7 " + recordData7);

        if (version >= 2) {
            mDailyRecordBean.setNewIncreaseTotalCal((byte)
                ((recordData7 & 0x0000FC00) >> DAILY_RECORD_SLEEP_MODE_SHIFT_BIT_V2));
            mDailyRecordBean.setEnergyState((byte)
                    ((recordData7 & 0x00000300) >> DAILY_RECORD_ENERGY_STATE_SHIFT_BIT_V2));
            int sign = (recordData7 & 0x00000080) == 0 ? -1 : 1;
            mDailyRecordBean.setEnergyStateValue((short) (sign * (recordData7 & 0x0000007f)));
        } else {
            mDailyRecordBean.setSleepMode((byte)
                ((recordData7 & 0x0000e000) >> DAILY_RECORD_SLEEP_MODE_SHIFT_BIT));
            mDailyRecordBean.setEnergyState((byte)
                    ((recordData7 & 0x00001800) >> DAILY_RECORD_ENERGY_STATE_SHIFT_BIT));
            int sign = (recordData7 & 0x00000400) == 0 ? -1 : 1;
            mDailyRecordBean.setEnergyStateValue((short) (sign * (recordData7 & 0x000003ff)));
        }

        if (DEBUG_DAILY_RECORD) {
            byte[] timeBuff = Arrays.copyOfRange(buff, 10, 14); // 4 byte
            mDailyRecordBean.setTimeOfAp(ByteUtil.getUnsignedInt(timeBuff));
            timeBuff = Arrays.copyOfRange(buff, 14, 18); // 4 byte
            mDailyRecordBean.setTimeOfModem(ByteUtil.getUnsignedInt(timeBuff));
        }
        return mDailyRecordBean;
    }


    public ArrayList<SportRecordType1Bean> parserSportRecordData(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, SPORT_FILE_TYPE);
        final int byteSize = getSportReportFileSize(fileInfoBean.getSportType());
        if (byteSize == 0) {
            return null;
        }
        System.out.println("file " + file);
        switch (fileInfoBean.getSportType()) {
            case OUTDOOR_RUNNING:
            case OUTDOOR_WALKING:
            case CROSS_COUNTRY:
            case MOUNTAINEERING:
                return parseSportRecordType1(file);
            case INDOOR_RUNNING:
                return parseSportRecordType2(file);
            case OUTDOOR_RIDING:
                return parseSportRecordType3(file);
            case INDOOR_BICYCLE:
            case FREE_TRAIAING:
                return parseSportRecordType4(file);
            case INDOOR_SWIMMING:
            case OPEN_WATER_SWIMMING:
                return parseSportRecordType5(file);
            default:
                return null;
        }
    }

    // type1 include outdoor running/walking ; cross country ; mountaineering
    private ArrayList<SportRecordType1Bean> parseSportRecordType1(String file) {
        ArrayList<SportRecordType1Bean> arrayList = new ArrayList<SportRecordType1Bean>();
        final int buffSize = SPORT_RECORD_TYPE1_DYNAMIC_BUFF_SIZE;
        byte[] fileContent = new byte[buffSize];
        File reportFile = new File(file);
        int readRet = 0;
        final long fileSize = reportFile.length();
        getFileInfo().setFileSize(fileSize);
        DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        int startPos = 0;
        long recCount = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            byte[] headBuff = new byte[12];
            readRet = raf.read(headBuff);
            do {
                final float initAltitude = ByteUtil.getFloat(Arrays.copyOfRange(headBuff, 0, 4));
                long recordeCnt = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 4, 8));
                long resumeTimeStamp = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 8, 12));
                System.out.println("recordeCnt " + recordeCnt + " resumeTimeStamp " + resumeTimeStamp);
                startPos += readRet;
                Date date = new Date(resumeTimeStamp);
                String dtStr = df.format(date);
                System.out.println("startPos " + startPos + " filePointer " + raf.getFilePointer() + " dtStr " + dtStr);
                if (recordeCnt * SPORT_RECORD_TYPE1_DYNAMIC_BUFF_SIZE >= fileSize) {
                    break;
                }
                for (int step = 0; step < recordeCnt; step++) {
                    readRet = raf.read(fileContent);
                    System.out.println("raf.read start pos " + startPos + " " + ByteUtil.toHexString(fileContent));
                    startPos += readRet;
                    if (readRet >= SPORT_RECORD_TYPE1_DYNAMIC_BUFF_SIZE) {
                        recCount += 1;
                        startPos += readRet;
                        SportRecordType1Bean sportRecordType1Bean = new SportRecordType1Bean();
                        sportRecordType1Bean.setInitAltitude(initAltitude);
                        sportRecordType1Bean.setRecordCnt(recordeCnt);
                        sportRecordType1Bean.setResumeTimeStamp(resumeTimeStamp);
                        //sportRecordType1Bean.setDateTime(dtStr);
                        sportRecordType1Bean.setIncreaseCalorie((short) ((fileContent[0] & 0x00f0) >> 4));
                        sportRecordType1Bean.setIncreaseStep((short) (fileContent[0] & 0x000f));
                        sportRecordType1Bean.setHeartRate((short) (fileContent[1] & 0x00ff));
                        sportRecordType1Bean.setIntergerKM((short) ((fileContent[2] & 0x0080) >> 7));
                        sportRecordType1Bean.setHeightType((short) ((fileContent[2] & 0x0040) >> 6));
                        int h = fileContent[2] & 0x003f;
                        sportRecordType1Bean.setHeight(h / 10.0f);
                        int km = fileContent[3] & 0x00ff;
                        sportRecordType1Bean.setIncreaseKm(km / 10.0f);
                        arrayList.add(sportRecordType1Bean);
                    } else {
                        break;
                    }
                }
            } while ((readRet = raf.read(headBuff)) >= 12);
            getFileInfo().setRecordCount(recCount);
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    // include indoor running
    private ArrayList<SportRecordType1Bean> parseSportRecordType2(String file) {
        ArrayList<SportRecordType1Bean> arrayList = new ArrayList<SportRecordType1Bean>();
        final int buffSize = SPORT_RECORD_TYPE2_DYNAMIC_BUFF_SIZE;
        byte[] fileContent = new byte[buffSize];
        File reportFile = new File(file);
        int readRet = 0;
        final long fileSize = reportFile.length();
        System.out.println("parseSportRecordType2 fileSize " + fileSize);
        getFileInfo().setFileSize(fileSize);
        DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        int startPos = 0;
        long recCount = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            byte[] headBuff = new byte[8];
            readRet = raf.read(headBuff);
            do {
                long recordeCnt = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 0, 4));
                long resumeTimeStamp = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 4, 8));
                startPos += readRet;
                Date date = new Date(resumeTimeStamp);
                String dtStr = df.format(date);
                System.out.println("startPos " + startPos + " filePointer " + raf.getFilePointer() + " dtStr " + dtStr);
                if (recordeCnt * SPORT_RECORD_TYPE2_DYNAMIC_BUFF_SIZE >= fileSize) {
                    break;
                }
                for (int step = 0; step < recordeCnt; step++) {
                    readRet = raf.read(fileContent);
                    System.out.println("raf.read start pos " + startPos + " " + ByteUtil.toHexString(fileContent));
                    startPos += readRet;
                    if (readRet >= SPORT_RECORD_TYPE2_DYNAMIC_BUFF_SIZE) {
                        recCount += 1;
                        SportRecordType1Bean sportRecordType1Bean = new SportRecordType1Bean();
                        sportRecordType1Bean.setRecordCnt(recordeCnt);
                        sportRecordType1Bean.setResumeTimeStamp(resumeTimeStamp);
                        //sportRecordType1Bean.setDateTime(dtStr);
                        sportRecordType1Bean.setIncreaseCalorie((short) ((fileContent[0] & 0x00f0) >> 4));
                        sportRecordType1Bean.setIncreaseStep((short) (fileContent[0] & 0x000f));
                        sportRecordType1Bean.setHeartRate((short) (fileContent[1] & 0x00ff));
                        int km = fileContent[2] & 0x00ff;
                        sportRecordType1Bean.setIncreaseKm(km / 10.0f);
                        arrayList.add(sportRecordType1Bean);
                    }
                }
            } while ((readRet = raf.read(headBuff)) >= 8);
            getFileInfo().setRecordCount(recCount);
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    // include outdoor riding
    private ArrayList<SportRecordType1Bean> parseSportRecordType3(String file) {
        ArrayList<SportRecordType1Bean> arrayList = new ArrayList<SportRecordType1Bean>();
        final int buffSize = SPORT_RECORD_TYPE3_DYNAMIC_BUFF_SIZE;
        byte[] fileContent = new byte[buffSize];
        File reportFile = new File(file);
        int readRet = 0;
        final long fileSize = reportFile.length();
        getFileInfo().setFileSize(fileSize);
        DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        int startPos = 0;
        long recCount = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            byte[] headBuff = new byte[12];
            readRet = raf.read(headBuff);
            do {
                final float initAltitude = ByteUtil.getFloat(Arrays.copyOfRange(headBuff, 0, 4));
                long recordeCnt = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 4, 8));
                long resumeTimeStamp = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 8, 12));
                startPos += readRet;
                System.out.println("startPos " + startPos + " filePointer " + raf.getFilePointer());
                Date date = new Date(resumeTimeStamp);
                String dtStr = df.format(date);
                System.out.println("startPos " + startPos + " filePointer " + raf.getFilePointer() + " dtStr " + dtStr);
                if (recordeCnt * SPORT_RECORD_TYPE3_DYNAMIC_BUFF_SIZE >= fileSize) {
                    break;
                }
                for (int step = 0; step < recordeCnt; step++) {
                    readRet = raf.read(fileContent);
                    System.out.println("raf.read start pos " + startPos + " " + ByteUtil.toHexString(fileContent));
                    startPos += readRet;
                    if (readRet >= SPORT_RECORD_TYPE3_DYNAMIC_BUFF_SIZE) {
                        //SportRecordType1Detail bean = new SportRecordType1Detail();
                        recCount += 1;
                        SportRecordType1Bean sportRecordType1Bean = new SportRecordType1Bean();
                        sportRecordType1Bean.setInitAltitude(initAltitude);
                        sportRecordType1Bean.setRecordCnt(recordeCnt);
                        sportRecordType1Bean.setResumeTimeStamp(resumeTimeStamp);
                        //sportRecordType1Bean.setDateTime(dtStr);
                        sportRecordType1Bean.setIncreaseCalorie((short) (fileContent[0] & 0x00ff));
                        sportRecordType1Bean.setHeartRate((short) (fileContent[1] & 0x00ff));
                        sportRecordType1Bean.setIntergerKM((short) ((fileContent[2] & 0x0080) >> 7));
                        sportRecordType1Bean.setHeightType((short) ((fileContent[2] & 0x0040) >> 6));
                        int h = fileContent[2] & 0x3f;
                        sportRecordType1Bean.setHeight((float) (h / 10.0f));
                        arrayList.add(sportRecordType1Bean);
                    }
                }
            } while ((readRet = raf.read(headBuff)) > 12);
            raf.close();
            getFileInfo().setRecordCount(recCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    // include indoor bycircle / free trainning
    private ArrayList<SportRecordType1Bean> parseSportRecordType4(String file) {
        ArrayList<SportRecordType1Bean> arrayList = new ArrayList<SportRecordType1Bean>();
        final int buffSize = SPORT_RECORD_TYPE4_DYNAMIC_BUFF_SIZE;
        byte[] fileContent = new byte[buffSize];
        File reportFile = new File(file);
        int readRet = 0;
        long recCount = 0;
            final long fileSize = reportFile.length();
        getFileInfo().setFileSize(fileSize);
        // DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        int startPos = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            do {
                byte[] headBuff = new byte[8];
                readRet = raf.read(headBuff);
                long recordeCnt = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 0, 4));
                long resumeTimeStamp = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 4, 8));
                startPos += readRet;
                System.out.println("startPos " + startPos + " filePointer " + raf.getFilePointer());
                // Date date = new Date(resumeTimeStamp);
                // String dtStr = df.format(date);
                if (recordeCnt * SPORT_RECORD_TYPE4_DYNAMIC_BUFF_SIZE >= fileSize) {
                    break;
                }
                for (int step = 0; step < recordeCnt; step++) {
                    readRet = raf.read(fileContent);
                    System.out.println("raf.read start pos " + startPos + " " + ByteUtil.toHexString(fileContent));
                    startPos += readRet;
                    if (readRet >= SPORT_RECORD_TYPE4_DYNAMIC_BUFF_SIZE) {
                        recCount += 1;
                        //SportRecordType1Detail bean = new SportRecordType1Detail();
                        SportRecordType1Bean sportRecordType1Bean = new SportRecordType1Bean();
                        sportRecordType1Bean.setRecordCnt(recordeCnt);
                        sportRecordType1Bean.setResumeTimeStamp(resumeTimeStamp);
                        //sportRecordType1Bean.setDateTime(resumeTimeStamp);
                        sportRecordType1Bean.setHeartRate((short) (fileContent[0] & 0xff));
                        sportRecordType1Bean.setIncreaseCalorie((short) (fileContent[1] & 0xff));
                        arrayList.add(sportRecordType1Bean);
                    }
                }
                // sportRecordType1Bean.setDetailDataBeanArrayList(detailDataBeanArrayList);
                // arrayList.add(sportRecordType1Bean);
            } while ((fileSize - startPos) > SPORT_RECORD_TYPE4_DYNAMIC_BUFF_SIZE);
            raf.close();
            getFileInfo().setRecordCount(recCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<GpsDataBean> parseGpsDataFile(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, GPS_DATA_TYPE);
        File reportFile = new File(file);
        getFileInfo().setFileSize(reportFile.length());
        final int byteSize = GPS_DATA_FIX_SIZE;
        long recCount = 0;
        ArrayList<GpsDataBean> arrayList = new ArrayList<GpsDataBean>();
        // if (byteSize == 0) {
        //     return null;
        // }
        byte[] fileContent = new byte[byteSize];
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            while (raf.read(fileContent) > 0) {
                GpsDataBean gpsDataBean = new GpsDataBean();
                long timeStamp = ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 0, 4));
                gpsDataBean.setTimeStamp(timeStamp);
                recCount += 1;
                /*long lon = ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 4, 8));
                int temp = (int) lon & 0x7ff00000 >> 30;
                int first = ((lon & 0x80000000 >> 31) == 0 ? temp : -temp);
                int sec = (int) (lon & 0x000fffff);
                double val = (first + (double) sec / 1000000);
                gpsDataBean.setLon(val);
                long lat = ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 8, 12));
                temp = (int) lat & 0x7ff00000 >> 30;
                first = ((lat & 0x80000000 >> 31) == 0 ? temp : -temp);
                sec = (int) (lat & 0x000fffff);
                val = (first + (double) sec / 1000000);
                gpsDataBean.setLat(val);*/
                gpsDataBean.setLon(ByteUtil.getFloat(Arrays.copyOfRange(fileContent, 4, 8)));
                gpsDataBean.setLat(ByteUtil.getFloat(Arrays.copyOfRange(fileContent, 8, 12)));
                arrayList.add(gpsDataBean);
            }
            raf.close();
            fileInfoBean.setRecordCount(recCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


    public DailyDistributeBean parseDailyDistribute(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, USER_PROFILE_TYPE);
        final int byteSize = DAILY_DISTRIBUTE_FILE_SIZE;
        // if (byteSize == 0) {
        //     return null;
        // }
        File dataFile = new File(file);
        fileInfoBean.setFileSize(dataFile.length());
        byte[] fileContent = new byte[byteSize];
        try {
            FileInputStream in = new FileInputStream(dataFile);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DailyDistributeBean mDailyDistributeBean = parseDailyDistributeData(fileContent);
        getFileInfo().setRecordCount(mDailyDistributeBean != null ? 1 : 0);
        return mDailyDistributeBean;
    }

    private DailyDistributeBean parseDailyDistributeData(final byte[] fileContent) {
        DailyDistributeBean mDailyDistributeBean = new DailyDistributeBean();

        // byte[] doubleBytebuff = Arrays.copyOfRange(fileContent, 0, 2); // 2 byte
        mDailyDistributeBean.setSeriousPressDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 0, 2)));

        mDailyDistributeBean.setModeratePressDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 2, 4)));

        mDailyDistributeBean.setMildPressDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 4, 6)));

        mDailyDistributeBean.setRelaxPressDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 6, 8)));

        mDailyDistributeBean.setLimitHeartDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 8, 10)));

        mDailyDistributeBean.setAnaerobicHeartDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 10, 12)));

        mDailyDistributeBean.setAerobcHeartDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 12, 14)));

        mDailyDistributeBean.setFatBurningHeartDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 14, 16)));

        mDailyDistributeBean.setWarmUpHeartDur(
                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 16, 18)));
        return mDailyDistributeBean;
    }

    // include indoor swimming / open water swimming
    private ArrayList<SportRecordType1Bean> parseSportRecordType5(String file) {
        ArrayList<SportRecordType1Bean> arrayList = new ArrayList<SportRecordType1Bean>();
        final int buffSize = SPORT_RECORD_TYPE5_DYNAMIC_BUFF_MIN_SIZE;
        byte[] fileContent = new byte[buffSize];
        File reportFile = new File(file);
        int readRet = 0;
        final long fileSize = reportFile.length();
        getFileInfo().setFileSize(fileSize);
        // DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        int startPos = 0;
        long recCount = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            byte[] headBuff = new byte[8];
            readRet = raf.read(headBuff);
            do {
                long recordeCnt = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 0, 4));
                long resumeTimeStamp = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 4, 8));
                startPos += readRet;
                System.out.println("startPos " + startPos + " filePointer " + raf.getFilePointer());
                if (recordeCnt * SPORT_RECORD_TYPE5_DYNAMIC_BUFF_MIN_SIZE >= fileSize) {
                    break;
                }
                for (int step = 0; step < recordeCnt; step++) {
                    readRet = raf.read(fileContent);
                    if (readRet >= SPORT_RECORD_TYPE5_DYNAMIC_BUFF_MIN_SIZE) {
                        recCount += 1;
                        startPos += readRet;
                        System.out.println("raf.read ret " + readRet);
                        SportRecordType1Bean sportRecordType1Bean = new SportRecordType1Bean();
                        sportRecordType1Bean.setRecordCnt(recordeCnt);
                        sportRecordType1Bean.setResumeTimeStamp(resumeTimeStamp);
                        sportRecordType1Bean.setSwRecordType(fileContent[0]);
                        sportRecordType1Bean.setSwTimeStamp(
                                ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 1, 5)));
                        sportRecordType1Bean.setSwMainStroke(fileContent[5]);
                        sportRecordType1Bean.setSwCurrBarPace(
                                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 6, 8)));
                        sportRecordType1Bean.setSwCurrBarSwolf(
                                ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 8, 10)));
                        if (fileContent[0] == 0x00) {
                            int extraByte = 0;
                            if (getFileInfo().getFileVersionNumber() >= 2) {
                                extraByte = SPORT_RECORD_TYPE5_DYNAMIC_BUFF_V2_LEFT_SIZE
                                    - SPORT_RECORD_TYPE5_DYNAMIC_BUFF_LEFT_SIZE;
                            }
                            final int leftBuffSize = SPORT_RECORD_TYPE5_DYNAMIC_BUFF_LEFT_SIZE + extraByte;
                            byte[] leftBuff = new byte[leftBuffSize];
                            readRet = raf.read(leftBuff);
                            if (readRet >= leftBuffSize) {
                                startPos += readRet;
                                System.out.println("raf.read ret " + readRet);
                                sportRecordType1Bean.setSwTotalKm(
                                        ByteUtil.getUnsignedShort(Arrays.copyOfRange(leftBuff, 0, 2)));
                                sportRecordType1Bean.setSwTotalCalorie(
                                        ByteUtil.getUnsignedShort(Arrays.copyOfRange(leftBuff, 2, 4)));
                                sportRecordType1Bean.setSwTotalStroke(
                                        ByteUtil.getUnsignedShort(Arrays.copyOfRange(leftBuff, 4, 6)));
                                sportRecordType1Bean.setSwTotalTurn(
                                        ByteUtil.getUnsignedShort(Arrays.copyOfRange(leftBuff, 6, 8)));
                                sportRecordType1Bean.setSwCurrBarFq(leftBuff[8]);
                                sportRecordType1Bean.setSwCurrBarUnKnowStrokeCnt(leftBuff[9]);
                                sportRecordType1Bean.setSwCurrBarBreastCnt(leftBuff[10]);
                                sportRecordType1Bean.setSwCurrBarFreeCnt(leftBuff[11]);
                                sportRecordType1Bean.setSwCurrBarBackCnt(leftBuff[12]);
                                sportRecordType1Bean.setSwCurrBarButterflyCnt(leftBuff[13]);
                                if (getFileInfo().getFileVersionNumber() >= 2) {
                                    sportRecordType1Bean.setSwAllCalorie(
                                        ByteUtil.getUnsignedShort(Arrays.copyOfRange(leftBuff, 14, 16)));
                                }
                            }
                        }
                        arrayList.add(sportRecordType1Bean);
                    }
                }
            } while ((readRet = raf.read(headBuff)) >= 8);
            raf.close();
            getFileInfo().setRecordCount(recCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<DailySleepBean> parseDailySleepBean(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, SLEEP_DATA_TYPE);
        ArrayList<DailySleepBean> arrayList = new ArrayList<DailySleepBean>();
        byte[] fileContent = new byte[5];
        File reportFile = new File(file);
        int readRet = 0;
        long recCount = 0;
        final long fileSize = reportFile.length();
        getFileInfo().setFileSize(fileSize);
        if (fileSize <= 0) {
            return null;
        }
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            byte[] headBuff = new byte[2];
            readRet = raf.read(headBuff);
            if (readRet < 2) {
                raf.close();
                return null;
            }
            int sleepDur = ByteUtil.getUnsignedShort(Arrays.copyOfRange(headBuff, 0, 2));
            DailySleepBean dailyHead = new DailySleepBean();
            dailyHead.setSleepDuration(sleepDur);
            if (raf.read(fileContent) >= 5) {
                dailyHead.setChangeOfTimeStamp(
                        ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 0, 4)));
                dailyHead.setSleepMode(fileContent[4]);
            }
            recCount += 1;
            arrayList.add(dailyHead);

            while ((readRet = raf.read(fileContent)) >= 5) {
                recCount += 1;
                System.out.println("raf.read ret " + readRet);
                DailySleepBean dailySleepBean = new DailySleepBean();
                dailySleepBean.setChangeOfTimeStamp(
                        ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 0, 4)));
                dailySleepBean.setSleepMode(fileContent[4]);
                arrayList.add(dailySleepBean);
            }
            raf.close();
            fileInfoBean.setRecordCount(recCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("raf.read ret " + readRet);
        return arrayList;
    }

    public ArrayList<NightSleepBean> parseNightSleepBean(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, SLEEP_DATA_TYPE);
        ArrayList<NightSleepBean> arrayList = new ArrayList<NightSleepBean>();
        byte[] fileContent = new byte[5];
        File reportFile = new File(file);
        int readRet = 0;
        long recCount = 0;
        final long fileSize = reportFile.length();
        getFileInfo().setFileSize(fileSize);
        if (fileSize <= 0) {
            return null;
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            int extraByte = 0;
            if (fileInfoBean.getFileVersionNumber() >= 2) {
                extraByte = 1;
            }
            byte[] headBuff = new byte[26 + extraByte];
            readRet = raf.read(headBuff);
            if (readRet < 26 + extraByte) {
                return null;
            }
            short totalSleepScore = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 0, 1));
            short totalSleepQualityScore = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 1, 2));
            short totalSleepDurationScore = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 2, 3));
            short sleepSummary = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 3, 4));
            short sleepAdvise = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 4, 5));

            int sleepDuration = ByteUtil.getUnsignedShort(Arrays.copyOfRange(headBuff, 5, 7));
            long aSleepTimeStamp = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 7, 11));
            long wakeupTimeStamp = ByteUtil.getUnsignedInt(Arrays.copyOfRange(headBuff, 11, 15));

            short sleepResumeScore = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 15, 16));
            short sleepUneasyScore = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 16, 17));
            short wakeupCount = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 17, 18));

            int deepDuration = ByteUtil.getUnsignedShort(Arrays.copyOfRange(headBuff, 18, 20));
            int lightDuration = ByteUtil.getUnsignedShort(Arrays.copyOfRange(headBuff, 20, 22));
            int eyeMoveDuration = ByteUtil.getUnsignedShort(Arrays.copyOfRange(headBuff, 22, 24));
            int soberDuration = ByteUtil.getUnsignedShort(Arrays.copyOfRange(headBuff, 24, 26));
            //int soberDuration = ByteUtil.getUnsignedShort(Arrays.copyOfRange(headBuff, 24, 26));
            NightSleepBean nightSleepHead = new NightSleepBean();
            nightSleepHead.setTotalSleepScore(totalSleepScore);
            nightSleepHead.setTotalSleepQualityScore(totalSleepQualityScore);
            nightSleepHead.setTotalSleepDurationScore(totalSleepDurationScore);
            nightSleepHead.setSleepSummary(sleepSummary);
            nightSleepHead.setSleepAdvise(sleepAdvise);
            nightSleepHead.setSleepDuration(sleepDuration);
            nightSleepHead.setSleepTimeStamp(aSleepTimeStamp);
            nightSleepHead.setWakeupTimeStamp(wakeupTimeStamp);
            nightSleepHead.setSleepResumeScore(sleepResumeScore);
            nightSleepHead.setSleepUneasyScore(sleepUneasyScore);
            nightSleepHead.setWakeupCount(wakeupCount);
            nightSleepHead.setDeepDuration(deepDuration);
            nightSleepHead.setLightDuration(lightDuration);
            nightSleepHead.setEyeMoveDuration(eyeMoveDuration);
            nightSleepHead.setSoberDuration(soberDuration);

            if (fileInfoBean.getFileVersionNumber() >= 2) {
                short totalScoreFriendly = ByteUtil.getUnsignedChar(Arrays.copyOfRange(headBuff, 26, 27));
                nightSleepHead.setTotalScoreFriendly(totalScoreFriendly);
            }

            if (raf.read(fileContent) >= 5) {
                nightSleepHead.setChangeOfTimeStamp(
                        ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 0, 4)));
                nightSleepHead.setSleepMode(fileContent[4]);
            }
            recCount += 1;
            arrayList.add(nightSleepHead);

            while ((readRet = raf.read(fileContent)) >= 5) {
                recCount += 1;
                System.out.println("raf.read ret " + readRet);
                NightSleepBean nightSleepBean = new NightSleepBean();
                System.out.println(ByteUtil.toHexString(fileContent));
                nightSleepBean.setChangeOfTimeStamp(
                        ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 0, 4)));
                nightSleepBean.setSleepMode(fileContent[4]);
                arrayList.add(nightSleepBean);
            }
            raf.close();
            getFileInfo().setRecordCount(recCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


    public ArrayList<AverageDataBean> parseAverageData(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, AVERAGE_DATA_TYPE);
        ArrayList<AverageDataBean> arrayList = new ArrayList<AverageDataBean>();
        byte[] fileContent = new byte[7];
        File reportFile = new File(file);
        int readRet = 0;
        long recCount = 0;
        final long fileSize = reportFile.length();
        getFileInfo().setFileSize(fileSize);
        if (fileSize <= 0) {
            return null;
        }
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            while ((readRet = raf.read(fileContent)) >= 7) {
                recCount += 1;
                System.out.println("raf.read ret " + readRet);
                AverageDataBean averageDataBean = new AverageDataBean();
                averageDataBean.setTimeStamp(ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 0, 4)));
                averageDataBean.setTimeZone(fileContent[4]);
                averageDataBean.setAveragePress(fileContent[5]);
                averageDataBean.setResetingHR(fileContent[6]);
                arrayList.add(averageDataBean);
            }
            raf.close();
            fileInfoBean.setRecordCount(recCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<RecordTimeStampBean> parseRecordTimeStampData(String file) {
        FileInfoBean fileInfoBean = ParserFileInfo(file, RECORD_TIME_STAMP_DATA_TYPE);
        ArrayList<RecordTimeStampBean> arrayList = new ArrayList<RecordTimeStampBean>();
        byte[] fileContent = new byte[6];
        File reportFile = new File(file);
        int readRet = 0;
        long recCount = 0;
        final long fileSize = reportFile.length();
        fileInfoBean.setFileSize(fileSize);
        fileInfoBean.setFileType(" ");
        fileInfoBean.setTimeStamp(0);
        fileInfoBean.setVersion(" ");
        if (fileSize <= 0) {
            return null;
        }
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            while ((readRet = raf.read(fileContent)) >= 6) {
                recCount += 1;
                System.out.println("raf.read ret " + readRet);
                RecordTimeStampBean dataBean = new RecordTimeStampBean();
                dataBean.setTimeStamp(ByteUtil.getUnsignedInt(Arrays.copyOfRange(fileContent, 0, 4)));
                dataBean.setSize(ByteUtil.getUnsignedShort(Arrays.copyOfRange(fileContent, 4, 6)));
                arrayList.add(dataBean);
            }
            raf.close();
            fileInfoBean.setRecordCount(recCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
