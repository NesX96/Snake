import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> players = new LinkedList<GameObject>();

    //=======================================================
    // HANDLER EDITORS
    //=======================================================
    public void addObject(GameObject player){
        this.players.add(player);
    }

    public void removeObject(GameObject player){
        this.players.remove(player);
    }


    //========================================================
    // FUNCTIONS - GAME DYNAMICS
    //========================================================
    public void tick(){
        for (int i=0 ; i < players.size(); i++){
            final GameObject tempPlayer = players.get(i);
            tempPlayer.tick();
        }
    }


    public void render(Graphics gameGraphics){
        for (int i=0 ; i < players.size(); i++){
            final GameObject tempPlayer = players.get(i);
            tempPlayer.render(gameGraphics);
            Toolkit.getDefaultToolkit().sync(); // IT WORKS!!!!
        }
    }

    public void setPlayerSpeed(int speed){
        getPlayer().setSpeed(speed);
            }


    public void setPlayerDirection(Direction direction){
        getPlayer().setDirection(direction);
    }

    public Direction getPlayerDirection(){
        return getPlayer().getDirection();
    }

    public GameObject getPlayer() {

        GameObject p = null;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).id == ID.Player) {
                p = players.get(i);
            }
        }
        return p;
    }

    public int getSize(){
        return players.size();
    }

    public boolean appleInGame(){

        boolean thereIs  = false;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).id == ID.Apple) {
                thereIs = true;
            }
        }
        return thereIs;
    }


}
