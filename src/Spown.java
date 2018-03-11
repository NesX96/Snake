import java.util.Random;


public class Spown {

    private Handler handler;
    private Player player;
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
            //System.out.println("eccolo");
            handler.addObject(new Apple(rand.nextInt(Game.getResolution()) -20, rand.nextInt(Game.getResolution()) -20, ID.Apple, handler));
            //System.out.println(handler.getSize());
        }


    }

}
