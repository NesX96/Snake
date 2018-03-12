import java.awt.*;

public class Player extends GameObject {

    Handler handler;

    private GameObject tail;


    private int oldX;
    private int oldY;

    // private Vector<> players = new Vector<GameObject>();



    public Player(int x, int y, final ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        this.size = 16;

        this.currentDirection = Direction.RIGHT;
        this.currentSpeed = 1;
        this.oldX = x;
        this.oldY = y;

        this.tail = this;
    }


    public int getsize() {
        return this.size;
    }

    public Direction getPlayerDirection(){
        return this.currentDirection;
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

    public GameObject getTail() {
        return tail;
    }

    //========================================================
    // FUNCTIONS - GAME DYNAMICS
    //========================================================
    @Override
    public void tick(){

        this.oldY = this.y;
        this.oldX = this.x;

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
        this.y = clampPlayer(this.y, Game.getResolution() - size -25,0 );

        //System.out.println(x +" "+ y);

        handler.controlCollision(this);

    }

    @Override
    public void render(Graphics gameGraphics){
        gameGraphics.setColor(Color.GREEN);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, this.size, this.size);
        //gameGraphics2D.fillOval(x+30, y, this.size+20, this.size );

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

    }



}
