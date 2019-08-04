package coin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataConvert {
    private static final int UNKNOWN_FILE = -1;
    private static final int DAILY_RECORD = 0;
    private static final int DAILY_REPORT = 1;
    private static final int SPORT_RECORD = 2;
    private static final int SPORT_REPORT = 3;
    private static final int GPS_FILE = 4;
    private static final int USER_PROFILE = 5;

    public int parseFileType(String filePathName) {
        if (filePathName == null) {
            return UNKNOWN_FILE;
        }

        if (filePathName.contains("daily")) {
            if (filePathName.contains("record")) {
                return DAILY_RECORD;
            }

            if (filePathName.contains("report")) {
                return DAILY_REPORT;
            }
        } else if (filePathName.contains("sport")) {
            if (filePathName.contains("record")) {
                return SPORT_RECORD;
            }

            if (filePathName.contains("report")) {
                return SPORT_REPORT;
            }

            if (filePathName.contains("gps")) {
                return GPS_FILE;
            }
        } else if (filePathName.contains("gps")) {
            return USER_PROFILE;
        }

        return UNKNOWN_FILE;
    }
}
