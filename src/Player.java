import java.awt.*;

public class Player extends GameObject {

    Handler handler;// TODO add handler
    /*
    private int x, y;
    private int speedX;
    private int speedY; // TODO change with directions
    */

    private int headSizeX;
    private int headSizeY;
    private int headSizeDefault = 30;

    public Player(int x, int y, final ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.headSizeX = headSizeDefault;
        this.headSizeY = headSizeDefault;
    }

    public void setHeadSizeX(int x){
        this.headSizeX = x;
    }

    public void setHeadSizeY(int y){
        this.headSizeY = y;
    }

    public int getHeadSizeX(){
        return this.headSizeX;
    }

    public int getHeadSizeY(){
        return this.headSizeY;
    }

    //========================================================
    // FUNCTIONS - GAME DYNAMICS
    //========================================================
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
        gameGraphics2D.fillRect((int) x, (int) y, this.headSizeX, this.headSizeY);
    }

    // TODO getBounds()
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, this.headSizeX, this.headSizeY);
    }


}
