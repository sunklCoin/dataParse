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

    public short getVo2Max() {
        return vo2Max;
    }

    public int getMaxHeartRate() {
        return maxHeartRate;
    }

    public int getEverydayMaxStep() {
        return everydayMaxStep;
    }

    public int getEverydayMaxCalorie() {
        return everydayMaxCalorie;
    }

    public float getWeight() {
        return weight;
    }

    public int getMaxHisHR() {
        return maxHisHR;
    }

    public long getBirthday() {
        return birthday;
    }

    public short getGender() {
        return gender;
    }

    public short getHeight() {
        return height;
    }

    public short getMinHisHR() {
        return minHisHR;
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

