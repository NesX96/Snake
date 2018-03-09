import java.awt.*;

public class Player extends GameObject {

    Handler handler;
    /*
    private int x, y;
    private int speedX;
    private int speedY; // TODO change with directions.... work in progress
    */

    private int headSizeX;  // TODO it works if the head is a rectangle
    private int headSizeY;
    private int headSizeDefault = 30;





    public Player(int x, int y, final ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.headSizeX = headSizeDefault;
        this.headSizeY = headSizeDefault;
        this.currentDirection = Direction.RIGHT;
        this.currentSpeed = 1;
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
        //this.x = x + speedX;
        //this.y = y + speedY;
        if(this.currentDirection == Direction.UP){

            this.y = this.y - currentSpeed;

        } else if(this.currentDirection == Direction.RIGHT){

            this.x = this.x + currentSpeed;

        } else if(this.currentDirection == Direction.DOWN){

            this.y = this.y + currentSpeed;

        } else if(this.currentDirection == Direction.LEFT){

            this.x = this.x - currentSpeed;

        }

    }

    @Override
    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.black);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, this.headSizeX, this.headSizeY);
    }


    public Rectangle getBounds() { // TODO it must be modified to fit the superclass
        return new Rectangle((int) x, (int) y, this.headSizeX, this.headSizeY);
    }



}
