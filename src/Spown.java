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

            handler.addObject(new Apple(rand.nextInt(Game.getResolution()), rand.nextInt(Game.getResolution()), ID.Apple, handler));

        }


    }

}
