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
                return p;
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

    public boolean turtleInGame(){

        boolean thereIs  = false;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).id == ID.Turtle) {
                thereIs = true;
            }
        }
        return thereIs;
    }

    public int numberOfTurtles(){

        int n = 0;

        for (int i = 0; i < players.size(); i++){
            if(players.get(i).id == ID.Turtle){
                n++;
            }
        }

        return n;

    }


    /*
    public void removeApple(){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getId() == ID.Apple){
                players.remove(i);
            }
        }
    }
    */

    public void controlCollision(Player p){
        for(int i = 0; i < players.size(); i++){
            GameObject tempObject = players.get(i);

            if(tempObject.getId() != ID.Player){
                if (p.getBounds().intersects(tempObject.getBounds()) && tempObject.getId() == ID.Apple){
                    players.remove(tempObject);
                    p.extendsPlayer();
                    if(p.getPlayerLength()%7 == 0){
                        p.setSpeed(p.getCurrentSpeed()+1);
                    }
                }
                if (p.getBounds().intersects(tempObject.getBounds()) && tempObject.getId() == ID.PlayerBody){
                    //p.setSpeed(0);
                }
                if (p.getBounds().intersects(tempObject.getBounds()) && tempObject.getId() == ID.Turtle){
                    p.setSpeed(0);

                }


            }
        }
    }





}
