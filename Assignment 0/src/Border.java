public class Border {
    private int l;
    private int w;
    private float p;
    public Sensor[][] matrix;

    Border(int w,int l,float p) {
        this.l = l;
        this.w = w;
        this.p = p;
        this.matrix = new Sensor[w+1][l+1];

        for(int i=0;i<w;i++){
            for(int j=0;j<l;j++){
                this.matrix[i][j] = new Sensor(p);
            }
        }
    }

    public void updateBorder(){
        for(int i=0;i<w;i++){
            for(int j=0;j<l;j++){
                this.matrix[i][j].updateSensor();
            }
        }
    }


}
