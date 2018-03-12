import java.awt.*;

public class PlayerBody extends GameObject{

    Handler handler;
    private GameObject parent;

    private int oldX;
    private int oldY;
    private int headSizeDefault = 15;


    public PlayerBody(int x, int y, final ID id, Handler handler, GameObject parent){
        super(x, y, id);
        this.handler = handler;

        this.parent = parent;
        this.oldX = x;
        this.oldY = y;
    }

    @Override
    public void tick(){

        this.oldX = this.x;
        this.oldY = this.y;

        this.x = parent.getOldX();
        this.y = parent.getOldY();

    }

    @Override
    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.GREEN);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, 15, 15); //TODO abstraction in GameObject

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 15, 15);
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

    public GameObject getParent() {
        return parent;
    }

    /*
    public int clampPlayerBody(int var, final int max, int min) {
        if (var <= min) {
            return max - headSizeDefault;
        } else if (var + headSizeDefault > max) {
            return min ;
        } else {
            return var;
        }
    }
    */

    // TODO getCenter() size 16
}
