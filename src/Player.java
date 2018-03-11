import java.awt.*;

public class Player extends GameObject {

    Handler handler;

    private int headSizeX;
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

        if(this.currentDirection == Direction.UP){

            this.y = this.y - currentSpeed;

        } else if(this.currentDirection == Direction.RIGHT){

            this.x = this.x + currentSpeed;

        } else if(this.currentDirection == Direction.DOWN){

            this.y = this.y + currentSpeed;

        } else if(this.currentDirection == Direction.LEFT){

            this.x = this.x - currentSpeed;

        }

        this.x = clampPlayer(this.x, (Game.getResolution() / Game.getAspectRatioY())* Game.getAspectRatioX(), 0 );
        this.y = clampPlayer(this.y, Game.getResolution() - headSizeDefault,0 );

        //System.out.println(x +" "+ y);

    }

    @Override
    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.GREEN);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, this.headSizeX, this.headSizeY);
        //gameGraphics2D.fillOval(x+30, y, this.headSizeX+20, this.headSizeY );

    }

    public int clampPlayer(int var, final int max, int min) {
        if (var <= min) {
            return var = max - headSizeDefault;
        } else if (var + headSizeDefault > max) {
            return var = min ;
        } else {
            return var;
        }
    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, this.headSizeX, this.headSizeY);
    }



}
