import java.awt.*;

public class Player extends GameObject {

    Handler handler;

    private GameObject tail;
    private int playerLength;


    public Player(int x, int y, final ID id, Handler handler){
        super(x, y, id);
        this.oldX = x;
        this.oldY = y;
        this.handler = handler;
        this.size = 16;
        this.currentDirection = Direction.RIGHT;
        this.oldDirection = currentDirection;
        this.currentSpeed = 1;
        this.tail = this;
        this.playerLength = 1;
    }

    //========================================================
    // FUNCTIONS - GAME DYNAMICS
    //========================================================
    @Override
    public void tick(){

        this.oldY = this.y;
        this.oldX = this.x;
        this.oldDirection = this.currentDirection;

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
        this.y = clampPlayer(this.y, Game.getResolution() ,0 );

        //System.out.println(x +" "+ y);

        handler.controlPlayerCollision(this);

    }

    @Override
    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.GREEN);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, this.size, this.size);

    }

    public int clampPlayer(int var, final int max, int min) {
        if (var <= min) {
            return max - size;
        } else if (var + size > max) {
            return min ;
        } else {
            return var;
        }
    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, this.size, this.size);
    }

    public void extendsPlayer(){

        this.tail = new PlayerBody(this.getOldX(), this.getOldY(), ID.PlayerBody, handler, this.tail);
        handler.addObject(this.tail);
        this.playerLength = this.playerLength+1;
        System.out.println(this.playerLength);
    }

    public int getPlayerLength() {
        return playerLength;
    }

    public void setPlayerLength(int playerLength) {
        this.playerLength = playerLength;
    }





}
