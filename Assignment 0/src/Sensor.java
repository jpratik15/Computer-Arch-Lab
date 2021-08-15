public class Sensor {
    public boolean isOn;
    private float p;
    Sensor(float p){
        this.isOn = false;
        this.p = p;
    }

    public void updateSensor(){
        if(Math.random() < p){
            this.isOn = true;
        }
        else{
            this.isOn = false;
        }
    }

}
