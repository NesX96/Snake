import java.awt.*;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected ID id;
    protected float velX, velY;

    public GameObject(final float x, final float y, final ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public collision(GameObject eater, GameObject eaten){

    }

    public setX(){

    }

    public setY(){

    }

    public getX(){

    }

    public getY(){

    }

    public setSpeed(int speed){

    }

    public getSpeed(){

    }

    public abstract tick(){

    }

    public abstract render(Graphics graph){

    }

    public abstract Rectangle getBounds(){

    }


}
