public class Infiltrator {
    public boolean reached;
    public int x;
    public int y;
    private float p;

    Infiltrator(int w,int l,float p){
        this.x = -1;
        this.y = l/2;
        this.p = p;
        this.reached = false;
    }

    public boolean isReached() {
        return this.reached;
    }

    public void moveForward(Sensor[][] matrix,int w,int l){
        if(this.x!=-1 && matrix[this.x][this.y].isOn){
            return;
        }
        int p = this.x + 1;
        int q = this.y;

        if(p==w){
            this.reached = true;
            return;
        }
         if(matrix[p][q].isOn==false){
            this.x = p;
            this.y  = q;
            return;
        }
        else if(q - 1 >=0 && matrix[p][q-1].isOn==false){
            this.x = p;
            this.y  = q-1;
            return;
        }
        else if(q + 1 <l && matrix[p][q].isOn==false){
            this.x = p;
            this.y  = q+1;
            return;
        }
        else{
            return;
        }


    }



}
