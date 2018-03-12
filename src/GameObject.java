import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;
    protected int oldX;
    protected int oldY;
    protected Direction currentDirection;
    protected Direction oldDirection;
    protected int currentSpeed;
    protected int size;

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
    public abstract Rectangle getBounds();


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

    public int getOldX() {
        return oldX;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public int getOldY() {
        return oldY;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Direction getOldDirection() {
        return oldDirection;
    }

    public void setOldDirection(Direction oldDirection) {
        this.oldDirection = oldDirection;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

}
