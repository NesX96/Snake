import java.util.Random;


public class Spown {

    private Handler handler;
    Random rand = new Random();

    private boolean addingPlayer = true;

    public Spown(Handler handler) {
        this.handler = handler;
    }

    public void tick(){

        if(addingPlayer){
            handler.addObject(new Player(10, 10, ID.Player, handler));
            handler.setPlayerSpeed(3);
            handler.setPlayerDirection(Direction.DOWN);
            addingPlayer = false;

        } else if (!handler.appleInGame()) {

            handler.addObject(new Apple(screenX(), screenY(), ID.Apple, handler));

        }

    }

    public int randomClamp(int var, int min, int max){

        if (var < min){
            return min + 80;
        } else if (var >= max -30 ){
            return max - 200;
        } else {
            return var;
        }

    }

    private int screenX(){
        return randomClamp(rand.nextInt((Game.getResolution()/ Game.getAspectRatioY())*Game.getAspectRatioX()),
                0,
                (Game.getResolution()/ Game.getAspectRatioY())*Game.getAspectRatioX());
    }

    private int screenY(){
        return randomClamp(rand.nextInt(Game.getResolution()), 0, Game.getResolution());
    }

}
