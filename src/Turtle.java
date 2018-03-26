import java.awt.*;

public class Turtle extends GameObject {

    Handler handler;

    public Turtle(int x, int y, final ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.size = 100;
    }

    @Override
    public void tick(){}

    @Override
    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.GRAY);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, this.size, this.size);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, this.size, this.size);
    }

}
