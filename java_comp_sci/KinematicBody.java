public class KinematicBody {
    private int[] position = {0,0};
    private int[] velocity = {0,0};

    private String name;

    public KinematicBody(String s){
        name = s;
    }
    public KinematicBody(String s, int[] pos){
        name = s;
        position = pos;
    }

    public void updatePosition(int[] newPos){
        position = newPos;
    }

    public int[] getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void setVelocity(int[] newVel){
        velocity = newVel;
    }

    public void move(){
        //linearly interpolate from position to position + velocity
    }

}
