import java.awt.*;

public class PlayerBody extends GameObject{

    Handler handler;
    private GameObject parent;

    public PlayerBody(int x, int y, final ID id, Handler handler, GameObject parent){
        super(x, y, id);
        this.handler = handler;

        this.size = parent.getSize();

        this.parent = parent;
        this.oldX = x;
        this.oldY = y;
        this.oldDirection = parent.getOldDirection();

    }

    @Override
    public void tick(){

        this.oldX = this.x;
        this.oldY = this.y;
        this.oldDirection = parent.getOldDirection();

        /*
        //System.out.println(this.oldDirection);
        this.x = setXCentered(parent.getOldX(), this.getSize()) ;
        this.y = setYCentered(parent.getOldY(), this.getSize()) ;
        */

        this.x = parent.getOldX();
        this.y = parent.getOldY();
    }

    @Override
    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.GREEN);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect(x, y, size, size);

    }

    public Rectangle getBounds() {
        return new Rectangle( x, y, size, size);
    }

    public GameObject getParent() {
        return parent;
    }

    /*
    public int setXCentered(int x, int size){

        if (this.oldDirection == Direction.RIGHT){
            x = x - size;
        }
        return x;
    }

    public int setYCentered(int y, int size){

        if (this.oldDirection == Direction.DOWN){
            y = y - size;
        }
        return y;
    }
    */
}
