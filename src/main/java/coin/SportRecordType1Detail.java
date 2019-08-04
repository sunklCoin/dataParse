package coin;

public class SportRecordType1Detail {
        private short    increaseCalorie ;
        private short    increaseStep    ;
        private short    heartRate       ;
        private short    intergerKM      ;
        private short    heightType      ;
        private float    height          ;
        private float    increaseKm      ;

        public SportRecordType1Detail() {
            this.increaseCalorie    = Short.MIN_VALUE;
            this.increaseStep       = Short.MIN_VALUE;
            this.heartRate          = Short.MIN_VALUE;
            this.intergerKM         = Short.MIN_VALUE;
            this.heightType         = Short.MIN_VALUE;
            this.height             = Float.MIN_VALUE;
            this.increaseKm         = Float.MIN_VALUE;
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
