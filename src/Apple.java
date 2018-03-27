import javafx.scene.shape.Circle;

import java.awt.*;

public class Apple extends GameObject {

    Handler handler;

    private int size;

    public Apple(int x, int y, final ID id, Handler handler){
        super(x, y, id);
        this.size = 20;
    }

    @Override
    public void tick(){ }


    @Override
    public void render(Graphics gameGraphics) {
        gameGraphics.setColor(Color.RED);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillOval(this.x, this.y, this.size, this.size);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, this.size, this.size);
    }


}
