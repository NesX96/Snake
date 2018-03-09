import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<Player> players = new LinkedList<Player>();

    //=======================================================
    // HANDLER EDITORS
    //=======================================================
    public void addObject(Player player){
        this.players.add(player);
    }

    public void removeObject(Player player){
        this.players.remove(player);
    }


    //========================================================
    // FUNCTIONS - GAME DYNAMICS
    //========================================================
    public void tick(){
        for (int i=0 ; i < players.size(); i++){
            final Player tempPlayer = players.get(i);
            tempPlayer.tick();
        }
    }


    public void render(Graphics gameGraphics){
        for (int i=0 ; i < players.size(); i++){
            final Player tempPlayer = players.get(i);
            tempPlayer.render(gameGraphics);
            Toolkit.getDefaultToolkit().sync(); // IT WORKS!!!!
        }
    }

    public void setPlayerSpeed(int speed){
        for (int i = 0; i < players.size(); i++){
            if(players.get(i).id == ID.Player){
                players.get(i).setSpeed(speed);
            }
        }
    }

    public void setPlayerDirection(Direction direction){
        for (int i = 0; i < players.size(); i++){
            if(players.get(i).id == ID.Player){
                players.get(i).setDirection(direction);
            }
        }
    }



}
