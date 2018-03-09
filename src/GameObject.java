import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;
    protected int speedX; // TODO change with directions?
    protected int speedY;
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

    public int getSpeedX() {
        return this.speedX;
    }

    public int getSpeedY() {
        return this.speedY;
    }

    public ID getId() {
        return id;
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

    public void setId(final ID id) {
        this.id = id;
    }


}
