package coin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.prefs.Preferences;

public class Controller implements Initializable {

    //Create instance
    private ObservableList<Object> list = FXCollections.observableArrayList();
    public static Controller instance = null;
    public ArrayList<String> listFile = new ArrayList<String>();
    private static final int UNKNOWN_FILE = -1;
    private static final int DAILY_RECORD = 0;
    private static final int DAILY_REPORT = 1;
    private static final int SPORT_RECORD = 2;
    private static final int SPORT_REPORT = 3;
    private static final int GPS_FILE = 4;
    private static final int USER_PROFILE = 5;
    private static final int DAILY_DISTRIBUTE = 6;
    private static final int DAY_SLEEP = 7;
    private static final int NIGHT_SLEEP = 8;
    private static final int AVERAGE_DATA = 9;
    private static final int REC_TS_DATA = 10;
    private static final int SLEEP_STATUS = 11;
    private String dataFilePath = null;
    private DirectoryChooser directoryChooser;
    private Preferences pref = Preferences.userRoot().node(this.getClass().getName());
    public Controller() {
        directoryChooser = new DirectoryChooser();
        String lastPath = pref.get("lastPath", "");
        if(!lastPath.equals("")) {
            File lastFile = new File(lastPath);
            if (lastFile.exists()) {
                directoryChooser.setInitialDirectory(lastFile);
            }
        }
    }

    @FXML
    private JFXButton selectDirButton;

    @FXML
    private HBox topHBox;

    @FXML
    private Label title;

    @FXML
    private JFXListView<String> listView;

    @FXML
    private TableView<Object> tableView;

    @FXML
    private Label fileInfo;

    private ObservableList<String> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        topHBox.toFront();
        selectDirButton.setGraphic(new ImageView("Images/settings.png"));
        listView.setItems(dataList);
        instance = this;
        tableView.setItems(list);
        listView.propagateMouseEventsToParent();
        listView.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            new Thread(() -> {
                Platform.runLater(() -> {
                    if (newVal != null) {
                        System.out.println(newVal);
                        startConverData(newVal);
                    }
                });
            }).start();
        });
    }

    //Get instance
    public static Controller getInstance() {
        return instance;
    }

    /**
     * Get the static string header and use instance to pass header to setTitle
     *
     * @param header
     */
    public static void getTitle(String header) throws IOException {
        getInstance().setTitle(header);
    }

    //Set non-static header as Title
    private void setTitle(String header) {
        title.setText(header);
    }

    private void setFileInfo(String info) {
        fileInfo.setText(info);
    }

    private void addList() {
        // listFile.setItems();
    }

    @FXML
    private void selectDirView(ActionEvent event) throws IOException {
        if (directoryChooser == null) {
            return;
        }
        File file = directoryChooser.showDialog(Main.mainStage);

        if (file != null && file.exists()) {
            directoryChooser.setInitialDirectory(file);
            dataFilePath = file.getPath();//选择的文件夹路径
            pref.put("lastPath", dataFilePath);
            System.out.println("select path " + dataFilePath);
            dataList.clear();
            setTitle(dataFilePath);
            recursiveFiles(dataFilePath);
        }
    }

    @FXML
    private void freshDirView(ActionEvent event) throws IOException {
        if (dataFilePath != null) {
            dataList.clear();
            setTitle(dataFilePath);
            recursiveFiles(dataFilePath);
        }
    }

    private void recursiveFiles(String path) {
        // 创建 File对象
        File file = new File(path);
        // 取 文件/文件夹
        File files[] = file.listFiles();
        // 对象为空 直接返回
        if (files == null) {
            return;
        }
        //listView.getStyleClass().clear();
        // 目录下文件
        if (files.length == 0) {
            System.out.println(path + "该文件夹下没有文件");
        }
        // 存在文件 遍历 判断
        for (File f : files) {
            // 判断是否为 文件夹
            if (f.isDirectory()) {
                System.out.print("文件夹: ");
                System.out.println(f.getAbsolutePath());
                // 为 文件夹继续遍历
                recursiveFiles(f.getAbsolutePath());
                // 判断是否为 文件
            } else if (f.isFile()) {
                if (f.getName().contains("report") || f.getName().contains("record") ||
                        f.getName().contains("gps") || f.getName().contains("profile") ||
                        f.getName().contains("distribute") || f.getName().contains("dsleep") ||
                        f.getName().contains("nsleep") || f.getName().contains("average")
                        || f.getName().contains("rec_ts") || f.getName().contains("sleep_status")) {
                    listFile.add(f.getPath());
                    //listFile.add(f.getAbsolutePath());
                    dataList.add(f.getPath());
                }
                System.out.print("文件: ");
                System.out.println(f.getAbsolutePath());
            } else {
                System.out.print("未知错误文件");
            }
        }
    }

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

            if (filePathName.contains("distribute")) {
                return DAILY_DISTRIBUTE;
            }

            if (filePathName.contains("dsleep")) {
                return DAY_SLEEP;
            }

            if (filePathName.contains("nsleep")) {
                return NIGHT_SLEEP;
            }

            if (filePathName.contains("sleep_status")) {
                return SLEEP_STATUS;
            }

            if (filePathName.contains("average")) {
                return AVERAGE_DATA;
            }

            if (filePathName.contains("rec_ts")) {
                return REC_TS_DATA;
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
        } else if (filePathName.contains("profile")) {
            return USER_PROFILE;
        }
        return UNKNOWN_FILE;
    }

    private void startConverData(final String fileName) {
        int fileType = parseFileType(fileName);
        DataConverTool dataConverTool = new DataConverTool();
        switch (fileType) {
            case UNKNOWN_FILE:
                break;
            case DAILY_RECORD: {
                ArrayList<DailyRecordBean> mDailyRecordList = dataConverTool.parseDynamicDailyFile(fileName);
                setFileInfoByBean(dataConverTool.getFileInfo());
                loadDailyRecordData(mDailyRecordList);
            }
            break;
            case DAILY_REPORT: {
                DailyReportBean mDailyReportBean = dataConverTool.parseDailyReport(fileName);
                setFileInfoByBean(dataConverTool.getFileInfo());
                loadDailyReportData(mDailyReportBean);
            }
            break;
            case SPORT_RECORD:
                ArrayList<SportRecordType1Bean> mSportRecordList = dataConverTool.parserSportRecordData(fileName);
                setFileInfoByBean(dataConverTool.getFileInfo());
                loadSportRecordData(mSportRecordList, dataConverTool.getFileInfo().getSportType());
                break;
            case SPORT_REPORT: {
                SportReportBean mSportReport = dataConverTool.parserSportReportData(fileName);
                setFileInfoByBean(dataConverTool.getFileInfo());
                loadSportReportData(mSportReport, dataConverTool.getFileInfo().getSportType());
            }
            break;
            case GPS_FILE:
                ArrayList<GpsDataBean> mGpsDataBeanList = dataConverTool.parseGpsDataFile(fileName);
                setFileInfoByBean(dataConverTool.getFileInfo());
                loadGpsData(mGpsDataBeanList, dataConverTool.getFileInfo().getSportType());
                break;
            case USER_PROFILE: {
                UserInfoBean mUserInfoBean = dataConverTool.parseUserProfile(fileName);
                FileInfoBean mFileInfoBean = dataConverTool.getFileInfo();
                setFileInfoByBean(mFileInfoBean);
                System.out.println(mUserInfoBean.toString());
                loadUserProfileData(mUserInfoBean);
            }
            break;
            case DAILY_DISTRIBUTE: {
                DailyDistributeBean mDailyDistributeBean = dataConverTool.parseDailyDistribute(fileName);
                FileInfoBean mFileInfoBean = dataConverTool.getFileInfo();
                setFileInfoByBean(mFileInfoBean);
                loadDailyDistributeData(mDailyDistributeBean);
            }
            break;
            case DAY_SLEEP: {
                ArrayList<DailySleepBean> mDailySleepList = dataConverTool.parseDailySleepBean(fileName);
                FileInfoBean mFileInfoBean = dataConverTool.getFileInfo();
                setFileInfoByBean(mFileInfoBean);
                loadDaySleepData(mDailySleepList);
            }
            break;
            case NIGHT_SLEEP: {
                ArrayList<NightSleepBean> mNightSleepList = dataConverTool.parseNightSleepBean(fileName);
                FileInfoBean mFileInfoBean = dataConverTool.getFileInfo();
                setFileInfoByBean(mFileInfoBean);
                loadNightSleepData(mNightSleepList);
            }
            break;
            case AVERAGE_DATA: {
                ArrayList<AverageDataBean> mNAverageData = dataConverTool.parseAverageData(fileName);
                FileInfoBean mFileInfoBean = dataConverTool.getFileInfo();
                setFileInfoByBean(mFileInfoBean);
                loadAverageData(mNAverageData);
            }
            break;
            case REC_TS_DATA: {
                ArrayList<RecordTimeStampBean> data = dataConverTool.parseRecordTimeStampData(fileName);
                FileInfoBean mFileInfoBean = dataConverTool.getFileInfo();
                setFileInfoByBean(mFileInfoBean);
                loadRecordTimeStamp(data);
            }
            break;

            case SLEEP_STATUS: {
                ArrayList<SleepStatusBean> data = dataConverTool.parseSleepStatusBeanData(fileName);
                FileInfoBean mFileInfoBean = dataConverTool.getFileInfo();
                setFileInfoByBean(mFileInfoBean);
                loadSleepStatus(data);
            }
            break;
        }
    }

    private void setFileInfoByBean(FileInfoBean mFileInfoBean) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(mFileInfoBean.getTimeStamp() * 1000);
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(mFileInfoBean.getTimeZone() * 15 * 60 * 1000);
        df.setTimeZone(timeZone);
        String time = df.format(date);
        String fileInfo = "文件名 : " + mFileInfoBean.getFileName() + "; 时间戳 : " + time
                + "; 文件大小(字节数) : " + mFileInfoBean.getFileSize() + "; 成功匹配的记录条数 : " + mFileInfoBean.getRecordCount();
        setFileInfo(fileInfo);
    }

    private void loadDailyRecordData(ArrayList<DailyRecordBean> mDailyRecordBeanList) {
        list.clear();
        //list.add(mDailyRecordBean);
        list.addAll(mDailyRecordBeanList);
        tableView.getColumns().clear();
        int verNo = FileInfoBean.getInstance().getFileVersionNumber();
        TableColumn index = new TableColumn("ID");
        index.setCellValueFactory(new PropertyValueFactory<Object, Object>("index"));
        tableView.getColumns().add(index);

        if (verNo == 1) {
            TableColumn hasSleepDataColumn = new TableColumn("是否包含睡眠数据");
            hasSleepDataColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("hasSleepData"));
            tableView.getColumns().add(hasSleepDataColumn);
        }
        TableColumn hasExceptionHeartColumn = new TableColumn("是否包含异常心率升高记录");
        hasExceptionHeartColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("hasExceptionHeart"));
        TableColumn increaseStepCntColumn = new TableColumn("新增步数");
        increaseStepCntColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("increaseStepCnt"));

        TableColumn activityTypeColumn = new TableColumn("活动类型");;
        TableColumn increaseCalorieColumn = new TableColumn("新增卡路里");

        if (verNo >= 2) {
            activityTypeColumn = new TableColumn("活动类型\n0）未知；1）静止；2）走；3）跑");
            increaseCalorieColumn = new TableColumn("新增活动卡路里");
        }
        activityTypeColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("activityType"));
        increaseCalorieColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("increaseCalorie"));


        TableColumn actStrongColumn = new TableColumn("活动强度等级\n0[静止]1[微弱]2[低强度]\n3[中等强度]4[高强度]\n5[剧烈]7[未知]");
        actStrongColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("actStrong"));
        TableColumn sportTypeColumn = new TableColumn("运动类型\n0[无]1[户外跑步]2[户外健走]\n3[室内跑步]4[登山]5[越野]\n6[户外骑行]7[室内骑行]8[自由训练]\n9[泳池游泳]10[开放水域游泳]");
        sportTypeColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("sportType"));
        TableColumn increaseDistanceColumn = new TableColumn("新增里程");
        increaseDistanceColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("increaseDistance"));
        TableColumn heartRateColumn = new TableColumn("心率值");
        heartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("heartRate"));
        TableColumn dumpEnergyColumn = new TableColumn("剩余能量（0~100）");
        dumpEnergyColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("dumpEnergy"));
        if (verNo == 1) {
            TableColumn sleepModeColumn = new TableColumn("睡眠模式\n0[未睡觉]2[深睡]\n3[浅睡]4[快速眼动]5[清醒]");
            sleepModeColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepMode"));
            tableView.getColumns().add(sleepModeColumn);
        }

        if (verNo >= 2) {
            TableColumn newIncreaseTotalCal = new TableColumn("新增总卡路里");
            newIncreaseTotalCal.setCellValueFactory(new PropertyValueFactory<Object, Object>("newIncreaseTotalCal"));
            tableView.getColumns().add(newIncreaseTotalCal);
        }

        TableColumn energyStateColumn = new TableColumn("能量状态\n0[未知]1[运动(0~100)]\n" + "2[压力(-100~0)]3[恢复(0~100)]");
        energyStateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("energyState"));
        TableColumn energyStateValueColumn = new TableColumn("能量状态值[-100~+100]");
        energyStateValueColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("energyStateValue"));
        TableColumn exceptionHeartRateColumn = new TableColumn("异常前心率值");
        exceptionHeartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("exceptionHeartRate"));

        TableColumn timeOfAp = new TableColumn("AP Time");
        timeOfAp.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeOfAp"));

        TableColumn timeOfModem = new TableColumn("Modem Time");
        timeOfModem.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeOfModem"));

        tableView.getColumns().addAll(hasExceptionHeartColumn, increaseStepCntColumn,
                activityTypeColumn, increaseCalorieColumn, actStrongColumn,
                sportTypeColumn, increaseDistanceColumn, heartRateColumn,
                dumpEnergyColumn, energyStateColumn,
                energyStateValueColumn, exceptionHeartRateColumn);

        if (DataConverTool.DEBUG_DAILY_RECORD) {
            tableView.getColumns().add(timeOfAp);
            tableView.getColumns().add(timeOfModem);
        }
        long statisticsStep = 0;
        for (DailyRecordBean dailyRecordBeanList: mDailyRecordBeanList) {
            System.out.println(" IncreaseStepCnt " + dailyRecordBeanList.getIncreaseStepCnt());
            statisticsStep += Long.parseLong(dailyRecordBeanList.getIncreaseStepCnt());
        }
        System.out.println(" statisticsStep " + statisticsStep);
    }

    private void loadUserProfileData(UserInfoBean mUserInfoBean) {
        list.clear();
        list.add(mUserInfoBean);
        tableView.getColumns().clear();
        TableColumn heightColumn = new TableColumn("Height");
        heightColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("height"));
        TableColumn weightColumn = new TableColumn("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("weight"));
        TableColumn birthdayColumn = new TableColumn("Birthday");
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("birthday"));
        TableColumn genderColumn = new TableColumn("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("gender"));
        TableColumn vo2MaxColumn = new TableColumn("Vo2Max");
        vo2MaxColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("vo2Max"));
        TableColumn maxHeartRateColumn = new TableColumn("MaxHeartRate");
        maxHeartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxHeartRate"));
        TableColumn minHisHRColumn = new TableColumn("MinHisHR");
        minHisHRColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("minHisHR"));
        TableColumn maxHisHRColumn = new TableColumn("MaxHisHR");
        maxHisHRColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxHisHR"));
        TableColumn everydayMaxCalorieColumn = new TableColumn("EverydayMaxCalorie");
        everydayMaxCalorieColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("everydayMaxCalorie"));
        TableColumn everydayMaxStepColumn = new TableColumn("everydayMaxStep");
        everydayMaxStepColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("everydayMaxStep"));
        tableView.getColumns().addAll(heightColumn, weightColumn, birthdayColumn, genderColumn, vo2MaxColumn,
                maxHeartRateColumn, minHisHRColumn, maxHisHRColumn, everydayMaxCalorieColumn, everydayMaxStepColumn);
        int verNo = FileInfoBean.getInstance().getFileVersionNumber();
        if (verNo >= 2) {
            TableColumn maximal_met = new TableColumn("maximal_met");
            maximal_met.setCellValueFactory(new PropertyValueFactory<Object, Object>("maximalMet"));
            tableView.getColumns().add(maximal_met);
        }
    }

    private void loadDailyReportData(DailyReportBean mDailyReportBean) {
        list.clear();
        list.add(mDailyReportBean);
        tableView.getColumns().clear();

        int verNo = FileInfoBean.getInstance().getFileVersionNumber();

        TableColumn totalStepCountColumn = new TableColumn("当前总步数\n(步)");
        totalStepCountColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalStepCount"));
        TableColumn totalCalorieColumn = new TableColumn("当前总卡路里\n(千卡)");
        if (verNo >= 2) {
            totalCalorieColumn = new TableColumn("当前总活动卡路里\n(千卡)");
        }
        totalCalorieColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalCalorie"));

        TableColumn currHeartRateCntColumn = new TableColumn("当前心率\n(次/分钟)");
        currHeartRateCntColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("currHeartRate"));
        TableColumn restingHeartRateColumn = new TableColumn("当日静息心率\n(次/分钟)");
        restingHeartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("restingHeartRate"));
        TableColumn maxHeartRateColumn = new TableColumn("当日最大心率\n(次/分钟)");
        maxHeartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxHeartRate"));
        TableColumn timeOfmaxHeartRateColumn = new TableColumn("当日最大心率出现时间");
        timeOfmaxHeartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeOfmaxHeartRate"));
        TableColumn minHeartRateColumn = new TableColumn("当日最小心率\n(次/分钟)");
        minHeartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("minHeartRate"));
        TableColumn timeOfminHeartRateColumn = new TableColumn("当日最小心率出现时间");
        timeOfminHeartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeOfminHeartRate"));
        TableColumn avgHeartRateColumn = new TableColumn("当日平均心率\n(次/分钟)");
        avgHeartRateColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("avgHeartRate"));
        TableColumn avgPressureColumn = new TableColumn("当日平均压力");
        avgPressureColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("avgPressure"));
        TableColumn maxPressureColumn = new TableColumn("当日最大压力");
        maxPressureColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxPressure"));
        TableColumn minPressureColumn = new TableColumn("当日最小压力");
        minPressureColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("minPressure"));
        TableColumn standFlagColumn = new TableColumn("有效站立标示");
        standFlagColumn.setCellValueFactory(new PropertyValueFactory<Object, Object>("standFlag"));
        tableView.getColumns().addAll(totalStepCountColumn, totalCalorieColumn,
                currHeartRateCntColumn, restingHeartRateColumn, maxHeartRateColumn,
                timeOfmaxHeartRateColumn, minHeartRateColumn, timeOfminHeartRateColumn,
                avgHeartRateColumn, avgPressureColumn, maxPressureColumn,
                minPressureColumn, standFlagColumn);
        if (verNo >= 2) {
            TableColumn currTotalCal = new TableColumn("当前总卡路里");
            currTotalCal.setCellValueFactory(new PropertyValueFactory<Object, Object>("currTotalCal"));
            tableView.getColumns().add(currTotalCal);
            TableColumn remainRecoverTime = new TableColumn("剩余恢复时间");
            remainRecoverTime.setCellValueFactory(new PropertyValueFactory<Object, Object>("remainRecoverTime"));
            tableView.getColumns().add(remainRecoverTime);
        }
    }

    private void loadSportReportData(SportReportBean mSportReportBean, int sportType) {
        list.clear();
        list.add(mSportReportBean);
        tableView.getColumns().clear();
        TableColumn startTime = new TableColumn("运动开始时间");
        startTime.setCellValueFactory(new PropertyValueFactory<Object, Object>("startTime"));

        TableColumn endTime = new TableColumn("运动结束时间");
        endTime.setCellValueFactory(new PropertyValueFactory<Object, Object>("endTime"));

        TableColumn totalTime = new TableColumn("运动总时长\n(秒)");
        totalTime.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalTime"));
        TableColumn totalDistance = new TableColumn("总里程\n(米)");
        totalDistance.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalDistance"));

        TableColumn calorie = new TableColumn("卡路里\n(千卡)");
        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            calorie = new TableColumn("活动卡路里\n(千卡)");
        }
        calorie.setCellValueFactory(new PropertyValueFactory<Object, Object>("calorie"));

        TableColumn maxPace = new TableColumn("最快配速\n(秒/公里 | 秒/百米)");
        maxPace.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxPace"));
        TableColumn minPace = new TableColumn("最慢配速\n(秒/公里 | 秒/百米)");
        minPace.setCellValueFactory(new PropertyValueFactory<Object, Object>("minPace"));
        TableColumn maxSpeed = new TableColumn("最快速度\n(公里/小时)");
        maxSpeed.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxSpeed"));

        TableColumn totalStepCount = new TableColumn("总步数\n(步)");
        totalStepCount.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalStepCount"));
        TableColumn maxStrideFreq = new TableColumn("最大步频\n(步/分钟)");
        maxStrideFreq.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxStrideFreq"));

        TableColumn aveHeart = new TableColumn("平均心率\n(次/分钟)");
        aveHeart.setCellValueFactory(new PropertyValueFactory<Object, Object>("aveHeart"));
        TableColumn maxHeart = new TableColumn("最大心率\n(次/分钟)");
        maxHeart.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxHeart"));
        TableColumn minHeart = new TableColumn("最小心率\n(次/分钟)");
        minHeart.setCellValueFactory(new PropertyValueFactory<Object, Object>("minHeart"));

        TableColumn asendTotal = new TableColumn("累计上升\n(米)");
        asendTotal.setCellValueFactory(new PropertyValueFactory<Object, Object>("asendTotal"));

        TableColumn descendTotal = new TableColumn("累计下降\n(米)");
        descendTotal.setCellValueFactory(new PropertyValueFactory<Object, Object>("descendTotal"));
        TableColumn avgHeight = new TableColumn("平均高度\n(米)");
        avgHeight.setCellValueFactory(new PropertyValueFactory<Object, Object>("avgHeight"));
        TableColumn maxHeight = new TableColumn("最大高度\n(米)");
        maxHeight.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxHeight"));
        TableColumn minHeight = new TableColumn("最小高度\n(米)");
        minHeight.setCellValueFactory(new PropertyValueFactory<Object, Object>("minHeight"));

        TableColumn tranEffct = new TableColumn("训练效果");
        tranEffct.setCellValueFactory(new PropertyValueFactory<Object, Object>("tranEffct"));
        TableColumn vo2Max = new TableColumn("最大摄氧量\n(毫升/千克/分钟)");
        vo2Max.setCellValueFactory(new PropertyValueFactory<Object, Object>("vo2Max"));
        TableColumn eneryConsum = new TableColumn("身体能量消耗（0~100）");
        eneryConsum.setCellValueFactory(new PropertyValueFactory<Object, Object>("eneryConsum"));
        TableColumn preRecoverTime = new TableColumn("预计恢复时间\n(小时)");
        preRecoverTime.setCellValueFactory(new PropertyValueFactory<Object, Object>("preRecoverTime"));

        TableColumn heartRateLimitDuration = new TableColumn("心率-极限时长\n(秒)");
        heartRateLimitDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("heartRateLimitDuration"));
        TableColumn anaerobicEnduranceDuration = new TableColumn("心率-无氧耐力时长\n(秒)");
        anaerobicEnduranceDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("anaerobicEnduranceDuration"));
        TableColumn aerobicEnduranceDuration = new TableColumn("心率-有氧耐力时长\n(秒)");
        aerobicEnduranceDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("aerobicEnduranceDuration"));
        TableColumn fatBurningTime = new TableColumn("心率-燃脂时长\n(秒)");
        fatBurningTime.setCellValueFactory(new PropertyValueFactory<Object, Object>("fatBurningTime"));


        TableColumn warmupTime = new TableColumn("心率-热身时长\n(秒)");
        warmupTime.setCellValueFactory(new PropertyValueFactory<Object, Object>("warmupTime"));
        TableColumn totalStrokes = new TableColumn("总划水次数\n(次)");
        totalStrokes.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalStrokes"));
        TableColumn mainSwimType = new TableColumn("主泳姿");
        mainSwimType.setCellValueFactory(new PropertyValueFactory<Object, Object>("mainSwimType"));

        TableColumn maxStrokeFreq = new TableColumn("最大划频\n(次/分钟)");
        maxStrokeFreq.setCellValueFactory(new PropertyValueFactory<Object, Object>("maxStrokeFreq"));

        TableColumn turnAround = new TableColumn("转身次数");
        turnAround.setCellValueFactory(new PropertyValueFactory<Object, Object>("turnAround"));
        TableColumn aveSwolf = new TableColumn("平均swolf");
        aveSwolf.setCellValueFactory(new PropertyValueFactory<Object, Object>("aveSwolf"));
        TableColumn bestSwolf = new TableColumn("最佳swolf");
        bestSwolf.setCellValueFactory(new PropertyValueFactory<Object, Object>("bestSwolf"));

        TableColumn poolWidth = new TableColumn("泳池宽度\n(米)");
        poolWidth.setCellValueFactory(new PropertyValueFactory<Object, Object>("poolWidth"));
        switch (sportType) {
            case DataConverTool.OUTDOOR_RUNNING:
            case DataConverTool.CROSS_COUNTRY:
            case DataConverTool.OUTDOOR_WALKING:
            case DataConverTool.MOUNTAINEERING: {
                tableView.getColumns().addAll(startTime, endTime, totalTime, totalDistance, calorie, maxPace
                        , minPace, maxSpeed, totalStepCount, maxStrideFreq, aveHeart, maxHeart, minHeart, asendTotal
                        , descendTotal, avgHeight, maxHeight, minHeight, tranEffct, vo2Max, eneryConsum, preRecoverTime
                        , heartRateLimitDuration, anaerobicEnduranceDuration, aerobicEnduranceDuration, fatBurningTime
                        , warmupTime);
            }
            break;
            case DataConverTool.INDOOR_RUNNING: {
                tableView.getColumns().addAll(startTime, endTime, totalTime, totalDistance, calorie, maxPace, minPace
                        , totalStepCount, maxStrideFreq, aveHeart, maxHeart, minHeart, tranEffct, vo2Max, eneryConsum
                        , preRecoverTime, heartRateLimitDuration, anaerobicEnduranceDuration, aerobicEnduranceDuration
                        , fatBurningTime, warmupTime);
            }
            break;
            case DataConverTool.OUTDOOR_RIDING: {
                tableView.getColumns().addAll(startTime, endTime, totalTime, totalDistance, calorie, maxPace, minPace
                        , maxSpeed, aveHeart, maxHeart, minHeart, asendTotal, descendTotal, avgHeight, maxHeight
                        , minHeight, tranEffct, vo2Max, eneryConsum, preRecoverTime, heartRateLimitDuration
                        , anaerobicEnduranceDuration, aerobicEnduranceDuration, fatBurningTime, warmupTime);
            }
            break;
            case DataConverTool.INDOOR_BICYCLE:
            case DataConverTool.FREE_TRAIAING: {
                tableView.getColumns().addAll(startTime, endTime, totalTime, calorie, aveHeart, maxHeart, minHeart
                        , tranEffct, eneryConsum, preRecoverTime, heartRateLimitDuration, anaerobicEnduranceDuration
                        , aerobicEnduranceDuration, fatBurningTime, warmupTime);
            }
            break;
            case DataConverTool.INDOOR_SWIMMING:
            case DataConverTool.OPEN_WATER_SWIMMING: {
                tableView.getColumns().addAll(startTime, endTime, totalTime, totalDistance, calorie
                        , maxPace, minPace, eneryConsum, preRecoverTime, totalStrokes, mainSwimType, maxStrokeFreq
                        , turnAround, aveSwolf, bestSwolf, poolWidth);
            }
            break;
        }

        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            TableColumn totalCalorie = new TableColumn("总卡路里\n(千卡)");
            totalCalorie.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalCalorie"));
            tableView.getColumns().add(totalCalorie);
        }
        /*tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                int index = tableView.getSelectionModel().getSelectedIndex();
                System.out.println("selection change " + index);
            }
        });*/
    }


    private void loadSportRecordData(ArrayList<SportRecordType1Bean> mSportRecordList, int sportType) {
        list.clear();
        //list.add(mDailyRecordBean);
        list.addAll(mSportRecordList);
        tableView.getColumns().clear();

        TableColumn index = new TableColumn("ID");
        index.setCellValueFactory(new PropertyValueFactory<Object, Object>("index"));
        tableView.getColumns().add(index);

        TableColumn recordCnt = new TableColumn("记录的数据条数");
        recordCnt.setCellValueFactory(new PropertyValueFactory<Object, Object>("recordCnt"));
        TableColumn resumeTimeStamp = new TableColumn("恢复运动时的时间戳");
        resumeTimeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("resumeTimeStamp"));

        TableColumn heartRate = new TableColumn("心率");
        heartRate.setCellValueFactory(new PropertyValueFactory<Object, Object>("heartRate"));
        TableColumn increaseCalorie = new TableColumn("新增卡路里");
        increaseCalorie.setCellValueFactory(new PropertyValueFactory<Object, Object>("increaseCalorie"));

        switch (sportType) {
            case DataConverTool.OUTDOOR_RUNNING:
            case DataConverTool.CROSS_COUNTRY:
            case DataConverTool.OUTDOOR_WALKING:
            case DataConverTool.MOUNTAINEERING: {
                TableColumn initAltitude = new TableColumn("初始海拔信息");
                initAltitude.setCellValueFactory(new PropertyValueFactory<Object, Object>("initAltitude"));

                TableColumn increaseStep = new TableColumn("新增步数");
                increaseStep.setCellValueFactory(new PropertyValueFactory<Object, Object>("increaseStep"));

                TableColumn intergerKM = new TableColumn("是否整公里");
                intergerKM.setCellValueFactory(new PropertyValueFactory<Object, Object>("intergerKM"));

                TableColumn heightType = new TableColumn("高度变化类型");
                heightType.setCellValueFactory(new PropertyValueFactory<Object, Object>("heightType"));

                TableColumn height = new TableColumn("高度变化");
                height.setCellValueFactory(new PropertyValueFactory<Object, Object>("height"));

                TableColumn increaseKm = new TableColumn("新增里程");
                increaseKm.setCellValueFactory(new PropertyValueFactory<Object, Object>("increaseKm"));
                tableView.getColumns().addAll(recordCnt, resumeTimeStamp, heartRate, increaseCalorie, initAltitude,
                        increaseStep, intergerKM,
                        heightType, height, increaseKm);
            }
            break;
            case DataConverTool.INDOOR_RUNNING: {
                TableColumn increaseStep = new TableColumn("新增步数");
                increaseStep.setCellValueFactory(new PropertyValueFactory<Object, Object>("increaseStep"));

                TableColumn increaseKm = new TableColumn("新增里程");
                increaseKm.setCellValueFactory(new PropertyValueFactory<Object, Object>("increaseKm"));
                tableView.getColumns().addAll(recordCnt, resumeTimeStamp, heartRate, increaseCalorie,
                        increaseStep, increaseKm);
            }
            break;
            case DataConverTool.OUTDOOR_RIDING: {
                TableColumn initAltitude = new TableColumn("初始海拔信息");
                initAltitude.setCellValueFactory(new PropertyValueFactory<Object, Object>("initAltitude"));

                TableColumn intergerKM = new TableColumn("是否整公里");
                intergerKM.setCellValueFactory(new PropertyValueFactory<Object, Object>("intergerKM"));

                TableColumn heightType = new TableColumn("高度变化类型");
                heightType.setCellValueFactory(new PropertyValueFactory<Object, Object>("heightType"));

                TableColumn height = new TableColumn("高度变化");
                height.setCellValueFactory(new PropertyValueFactory<Object, Object>("height"));

                tableView.getColumns().addAll(recordCnt, resumeTimeStamp, heartRate, increaseCalorie,
                        initAltitude, intergerKM, heightType, height);
            }
            break;
            case DataConverTool.INDOOR_BICYCLE:
            case DataConverTool.FREE_TRAIAING:
                tableView.getColumns().addAll(recordCnt, resumeTimeStamp, heartRate, increaseCalorie);
                break;
            case DataConverTool.INDOOR_SWIMMING:
            case DataConverTool.OPEN_WATER_SWIMMING:
                TableColumn swRecordType = new TableColumn("数据类型");
                swRecordType.setCellValueFactory(new PropertyValueFactory<Object, Object>("swRecordType"));

                TableColumn swTimeStamp = new TableColumn("时间戳");
                swTimeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("swTimeStamp"));

                TableColumn swMainStroke = new TableColumn("本小节主泳姿");
                swMainStroke.setCellValueFactory(new PropertyValueFactory<Object, Object>("swMainStroke"));

                TableColumn swCurrBarPace = new TableColumn("本小节配速（秒/百米）");
                swCurrBarPace.setCellValueFactory(new PropertyValueFactory<Object, Object>("swCurrBarPace"));

                TableColumn swCurrBarSwolf = new TableColumn("本小节swolf");
                swCurrBarSwolf.setCellValueFactory(new PropertyValueFactory<Object, Object>("swCurrBarSwolf"));

                TableColumn swTotalKm = new TableColumn("累计里程（米）");
                swTotalKm.setCellValueFactory(new PropertyValueFactory<Object, Object>("swTotalKm"));

                TableColumn swTotalCalorie = new TableColumn("累计卡路里（千卡）");
                if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
                    swTotalCalorie = new TableColumn("累计活动卡路里（千卡）");
                }
                swTotalCalorie.setCellValueFactory(new PropertyValueFactory<Object, Object>("swTotalCalorie"));

                TableColumn swTotalStroke = new TableColumn("累计划水次数（次）");
                swTotalStroke.setCellValueFactory(new PropertyValueFactory<Object, Object>("swTotalStroke"));

                TableColumn swTotalTurn = new TableColumn("累计转身次数（次）");
                swTotalTurn.setCellValueFactory(new PropertyValueFactory<Object, Object>("swTotalTurn"));

                TableColumn swCurrBarFq = new TableColumn("本小节划频（次/分钟）");
                swCurrBarFq.setCellValueFactory(new PropertyValueFactory<Object, Object>("swCurrBarFq"));

                TableColumn swCurrBarUnKnowStrokeCnt = new TableColumn("本小节未知泳姿划水次数（次）");
                swCurrBarUnKnowStrokeCnt.setCellValueFactory(new PropertyValueFactory<Object, Object>("swCurrBarUnKnowStrokeCnt"));

                TableColumn swCurrBarBreastCnt = new TableColumn("本小节蛙泳划水次数（次）");
                swCurrBarBreastCnt.setCellValueFactory(new PropertyValueFactory<Object, Object>("swCurrBarBreastCnt"));

                TableColumn swCurrBarFreeCnt = new TableColumn("本小节自由泳划水次数（次）");
                swCurrBarFreeCnt.setCellValueFactory(new PropertyValueFactory<Object, Object>("swCurrBarFreeCnt"));

                TableColumn swCurrBarBackCnt = new TableColumn("本小节仰泳划水次数（次）");
                swCurrBarBackCnt.setCellValueFactory(new PropertyValueFactory<Object, Object>("swCurrBarBackCnt"));

                TableColumn swCurrBarButterflyCnt = new TableColumn("本小节蝶泳划水次数（次）");
                swCurrBarButterflyCnt.setCellValueFactory(new PropertyValueFactory<Object, Object>("swCurrBarButterflyCnt"));

                tableView.getColumns().addAll(recordCnt, resumeTimeStamp, swRecordType, swTimeStamp, swMainStroke,
                        swCurrBarPace, swCurrBarSwolf, swTotalKm, swTotalCalorie, swTotalStroke, swTotalTurn,
                        swCurrBarFq, swCurrBarUnKnowStrokeCnt, swCurrBarBreastCnt, swCurrBarFreeCnt,
                        swCurrBarBackCnt, swCurrBarButterflyCnt);
                if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
                    TableColumn swAllCalorie = new TableColumn("累计总卡路里（千卡）");
                    swAllCalorie.setCellValueFactory(new PropertyValueFactory<Object, Object>("swAllCalorie"));
                    tableView.getColumns().add(swAllCalorie);
                }
                break;
        }
    }

    private void loadGpsData(ArrayList<GpsDataBean> mGpsDataBeanList, int sportType) {
        list.clear();
        //list.add(mDailyRecordBean);
        list.addAll(mGpsDataBeanList);
        tableView.getColumns().clear();

        TableColumn index = new TableColumn("ID");
        index.setCellValueFactory(new PropertyValueFactory<Object, Object>("index"));
        tableView.getColumns().add(index);

        TableColumn timeStamp = new TableColumn("Unix时间戳");
        timeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeStamp"));

        TableColumn lon = new TableColumn("经度");
        lon.setCellValueFactory(new PropertyValueFactory<Object, Object>("lon"));

        TableColumn lat = new TableColumn("纬度");
        lat.setCellValueFactory(new PropertyValueFactory<Object, Object>("lat"));

        tableView.getColumns().add(timeStamp);
        tableView.getColumns().add(lon);
        tableView.getColumns().add(lat);
    }


    private void loadDailyDistributeData(DailyDistributeBean mDailyDistributeBean) {
        list.clear();
        list.add(mDailyDistributeBean);
        tableView.getColumns().clear();
        TableColumn seriousPressDur = new TableColumn("压力-重度时长\n(分钟)");
        seriousPressDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("seriousPressDur"));
        TableColumn moderatePressDur = new TableColumn("压力-中度时长\n(分钟)");
        moderatePressDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("moderatePressDur"));
        TableColumn mildPressDur = new TableColumn("压力-轻度时长\n(分钟)");
        mildPressDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("mildPressDur"));
        TableColumn relaxPressDur = new TableColumn("压力-放松时长\n(分钟)");
        relaxPressDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("relaxPressDur"));
        TableColumn limitHeartDur = new TableColumn("心率-极限时长\n(分钟)");
        limitHeartDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("limitHeartDur"));
        TableColumn anaerobicHeartDur = new TableColumn("心率-无氧耐力时长\n(分钟)");
        anaerobicHeartDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("anaerobicHeartDur"));
        TableColumn aerobcHeartDur = new TableColumn("心率-有氧耐力时长\n(分钟)");
        aerobcHeartDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("aerobcHeartDur"));
        TableColumn fatBurningHeartDur = new TableColumn("心率-燃脂时长\n(分钟)");
        fatBurningHeartDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("fatBurningHeartDur"));
        TableColumn warmUpHeartDur = new TableColumn("心率-热身时长\n(分钟)");
        warmUpHeartDur.setCellValueFactory(new PropertyValueFactory<Object, Object>("warmUpHeartDur"));

        tableView.getColumns().addAll(seriousPressDur, moderatePressDur, mildPressDur, relaxPressDur, limitHeartDur,
                anaerobicHeartDur, aerobcHeartDur, fatBurningHeartDur, warmUpHeartDur);
    }


    private void loadDaySleepData(ArrayList<DailySleepBean> mDaySleepList) {
        list.clear();
        list.addAll(mDaySleepList);
        tableView.getColumns().clear();
        TableColumn sleepDuration = new TableColumn("白天睡眠累计时长(分钟)");
        sleepDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepDuration"));

        TableColumn changeOfTimeStamp = new TableColumn("睡眠模式变动的时间戳");
        changeOfTimeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("changeOfTimeStamp"));

        TableColumn sleepMode = new TableColumn("变动过后的睡眠模式");
        sleepMode.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepMode"));

        tableView.getColumns().addAll(sleepDuration, changeOfTimeStamp, sleepMode);
    }

    private void loadNightSleepData(ArrayList<NightSleepBean> mNightSleepList) {
        list.clear();
        list.addAll(mNightSleepList);
        tableView.getColumns().clear();
        TableColumn totalSleepScore = new TableColumn("夜间睡眠总分");
        totalSleepScore.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalSleepScore"));

        TableColumn totalSleepQualityScore = new TableColumn("夜间睡眠质量得分");
        totalSleepQualityScore.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalSleepQualityScore"));

        TableColumn totalSleepDurationScore = new TableColumn("夜间睡眠时长得分");
        totalSleepDurationScore.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalSleepDurationScore"));

        TableColumn sleepSummary = new TableColumn("夜间睡眠总结");
        sleepSummary.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepSummary"));

        TableColumn sleepAdvise = new TableColumn("夜间睡眠建议");
        sleepAdvise.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepAdvise"));

        TableColumn sleepDuration = new TableColumn("夜间睡眠时长(分钟)");
        sleepDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepDuration"));

        TableColumn aSleepTimeStamp = new TableColumn("夜间睡眠入睡时间");
        aSleepTimeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepTimeStamp"));

        TableColumn wakeupTimeStamp = new TableColumn("夜间睡眠醒来时间");
        wakeupTimeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("wakeupTimeStamp"));

        TableColumn sleepResumeScore = new TableColumn("夜间睡眠恢复得分");
        sleepResumeScore.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepResumeScore"));

        TableColumn sleepUneasyScore = new TableColumn("夜间睡眠不安得分");
        sleepUneasyScore.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepUneasyScore"));

        TableColumn wakeupCount = new TableColumn("夜间睡眠清醒次数(次)");
        wakeupCount.setCellValueFactory(new PropertyValueFactory<Object, Object>("wakeupCount"));

        TableColumn deepDuration = new TableColumn("夜间睡眠-深睡时长(分钟)");
        deepDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("deepDuration"));

        TableColumn lightDuration = new TableColumn("夜间睡眠-浅睡时长(分钟)");
        lightDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("lightDuration"));

        TableColumn eyeMoveDuration = new TableColumn("夜间睡眠-眼动时长(分钟)");
        eyeMoveDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("eyeMoveDuration"));

        TableColumn soberDuration = new TableColumn("夜间睡眠-清醒时长(分钟)");
        soberDuration.setCellValueFactory(new PropertyValueFactory<Object, Object>("soberDuration"));

        if (FileInfoBean.getInstance().getFileVersionNumber() >= 2) {
            TableColumn totalScoreFriendly = new TableColumn("夜间睡眠总分友好版");
            totalScoreFriendly.setCellValueFactory(new PropertyValueFactory<Object, Object>("totalScoreFriendly"));
            tableView.getColumns().add(totalScoreFriendly);
        }

        TableColumn changeOfTimeStamp = new TableColumn("睡眠模式变动的时间戳");
        changeOfTimeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("changeOfTimeStamp"));

        TableColumn sleepMode = new TableColumn("变动过后的睡眠模式");
        sleepMode.setCellValueFactory(new PropertyValueFactory<Object, Object>("sleepMode"));

        tableView.getColumns().addAll( changeOfTimeStamp, sleepMode, totalSleepScore, totalSleepQualityScore, totalSleepDurationScore, sleepSummary,
                sleepAdvise, sleepDuration, aSleepTimeStamp, wakeupTimeStamp, sleepResumeScore, sleepUneasyScore,
                wakeupCount, deepDuration, lightDuration, eyeMoveDuration, soberDuration);
    }


    private void loadAverageData(ArrayList<AverageDataBean> averageDataList) {
        list.clear();
        list.addAll(averageDataList);
        tableView.getColumns().clear();
        TableColumn timeStamp = new TableColumn("时间戳");
        timeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeStamp"));

        TableColumn timeZone = new TableColumn("时区");
        timeZone.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeZone"));

        TableColumn averagePress = new TableColumn("当日平均压力");
        averagePress.setCellValueFactory(new PropertyValueFactory<Object, Object>("averagePress"));

        TableColumn resetingHR = new TableColumn("当日静息心率(次/分钟)");
        resetingHR.setCellValueFactory(new PropertyValueFactory<Object, Object>("resetingHR"));
        tableView.getColumns().addAll(timeStamp, timeZone, averagePress, resetingHR);
    }

    private void loadRecordTimeStamp(ArrayList<RecordTimeStampBean> dataList) {
        list.clear();
        list.addAll(dataList);
        tableView.getColumns().clear();
        TableColumn timeStamp = new TableColumn("TimeStamp");
        timeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeStamp"));

        TableColumn size = new TableColumn("Size");
        size.setCellValueFactory(new PropertyValueFactory<Object, Object>("size"));
        tableView.getColumns().addAll(timeStamp, size);
    }

    private void loadSleepStatus(ArrayList<SleepStatusBean> dataList) {
        list.clear();
        list.addAll(dataList);
        tableView.getColumns().clear();
        TableColumn timeStamp = new TableColumn("TimeStamp");
        timeStamp.setCellValueFactory(new PropertyValueFactory<Object, Object>("timeStamp"));

        TableColumn status = new TableColumn("Status");
        status.setCellValueFactory(new PropertyValueFactory<Object, Object>("status"));
        tableView.getColumns().addAll(timeStamp, status);
    }
}
