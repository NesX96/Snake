import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;
    protected int speedX;
    protected int speedY;
    //protected   ID id; // TODO add ID enum external

    public GameObject (int x, int y) {
        this.x = x;
        this.y = y;
    }



    //========================================================
    // FUNCTIONS
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

    public int getSpeedX() {
        return this.speedX;
    }

    public int getSpeedY() {
        return this.speedY;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }


}
