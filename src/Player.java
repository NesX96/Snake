import java.awt.*;

public class Player extends GameObject {

    // TODO add handler
    /*
    private int x, y;
    private int speedX;
    private int speedY; // TODO change with directions
    */

    public Player(int x, int y, Handler handler){
        //this.x = x;
        //this.y = y; // TODO remove these comments leave only super
        super(x, y);

    }

    @Override
    public void tick(){
        this.x = x + speedX;
        this.y = y + speedY;
    }

    @Override
    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.black);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, 32, 32);
    }

    // TODO getBounds()


}
