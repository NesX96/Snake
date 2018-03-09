import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;
    protected Direction currentDirection;
    protected int currentSpeed;

    protected ID id;

    public GameObject (int x, int y, final ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }



    //========================================================
    // FUNCTIONS - GAME DYNAMICS
    //========================================================
    public abstract void tick();
    public abstract void render(Graphics g);
    //public abstract Figure getBounds(); // TODO class Figure or Shape




    //========================================================
    // GETTER AND SETTER
    //========================================================

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setDirection(Direction direction){
        this.currentDirection = direction;
    }

    public Direction getDirection(){
        return this.currentDirection;
    }

    public void setSpeed(int speed){
        this.currentSpeed = speed;
    }

    public int getSpeed(){
        return this.currentSpeed;
    }

    public ID getId() {
        return id;
    }

    public void setId(final ID id) {
        this.id = id;
    }


}
