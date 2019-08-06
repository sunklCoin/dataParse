package coin;

public class UserInfoBean {
    private short   height              ; // 1byte
    private float   weight              ; // 4 byte
    private long    birthday            ; // 4 byte
    private short   gender              ; // 1 byte
    private short   vo2Max              ; // 1 byte
    private int     maxHeartRate        ;
    private short   minHisHR            ;
    private int     maxHisHR            ;
    private int     everydayMaxCalorie  ;
    private int     everydayMaxStep     ;

    public UserInfoBean() {
        this.height                          = Short.MIN_VALUE;
        this.weight                          = Long.MIN_VALUE;
        this.birthday                        = Long.MIN_VALUE; // 4 bytes
        this.gender                          = Short.MIN_VALUE; // 4 byte
        this.vo2Max                          = Short.MIN_VALUE; // 2 bytes
        this.maxHeartRate                    = Integer.MIN_VALUE; //4 bytes
        this.minHisHR                        = Short.MIN_VALUE; // 4 bytes
        this.maxHisHR                        = Integer.MIN_VALUE; //4 bytes
        this.everydayMaxCalorie              = Integer.MIN_VALUE; //4 bytes
        this.everydayMaxStep                 = Integer.MIN_VALUE; // 2bytes
    }

    public void setMaxHeartRate(int maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public void setVo2Max(short vo2Max) {
        this.vo2Max = vo2Max;
    }

    public void setEverydayMaxStep(int everydayMaxStep) {
        this.everydayMaxStep = everydayMaxStep;
    }

    public void setEverydayMaxCalorie(int everydayMaxCalorie) {
        this.everydayMaxCalorie = everydayMaxCalorie;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(short height) {
        this.height = height;
    }

    public void setGender(short gender) {
        this.gender = gender;
    }

    public void setMaxHisHR(int maxHisHR) {
        this.maxHisHR = maxHisHR;
    }

    public void setMinHisHR(short minHisHR) {
        this.minHisHR = minHisHR;
    }

    public String getVo2Max() {
        if (vo2Max == Short.MIN_VALUE)
            return "null";
        return Short.toString(vo2Max);
    }

    public String getMaxHeartRate() {
        if (maxHeartRate == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(maxHeartRate);
    }

    public String getEverydayMaxStep() {
        if (everydayMaxStep == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(everydayMaxStep);
    }

    public String getEverydayMaxCalorie() {
        if (everydayMaxCalorie == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(everydayMaxCalorie);
        // return everydayMaxCalorie;
    }

    public String getWeight() {
        if (weight == Float.MIN_VALUE)
            return "null";
        return Float.toString(weight);
    }

    public String getMaxHisHR() {
        if (maxHisHR == Integer.MIN_VALUE)
            return "null";
        return Integer.toString(maxHisHR);
    }

    public String getBirthday() {
        if (birthday == Long.MIN_VALUE)
            return "null";
        return Long.toString(birthday);
    }

    public String getGender() {
        if (gender == Short.MIN_VALUE)
            return "null";
        return Short.toString(gender);
    }

    public String getHeight() {
        if (height == Short.MIN_VALUE)
            return "null";
        return Short.toString(height);
    }

    public String getMinHisHR() {
        if (minHisHR == Short.MIN_VALUE)
            return "null";
        return Short.toString(minHisHR);
    }

    @Override
    public String toString() {
        return  "height                        = " + height                         + " \n" +
                "weight                        = " + weight                         + " \n" +
                "birthday                      = " + birthday                       + " \n" +
                "gender                        = " + gender                         + " \n" +
                "vo2Max                        = " + vo2Max                         + " \n" +
                "maxHeartRate                  = " + maxHeartRate                   + " \n" +
                "minHisHR                      = " + minHisHR                       + " \n" +
                "maxHisHR                      = " + maxHisHR                       + " \n" +
                "everydayMaxCalorie            = " + everydayMaxCalorie             + " \n" +
                "everydayMaxStep               = " + everydayMaxStep                + " \n";
    }
}

