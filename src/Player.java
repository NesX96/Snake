import java.awt.*;

public class Player {

    // TODO add handler
    private int x, y;
    private int speedX;
    private int speedY;




    // TODO change with directions

    public Player(int x, int y, Handler handler){
        this.x = x;
        this.y = y;

    }

    public void tick(){
        this.x = x + speedX;
        this.y = y + speedY;
    }

    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.black);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, 32, 32);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

}
