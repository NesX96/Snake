import java.awt.*;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Random;

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



    public void removeTurtle(){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getId() == ID.Turtle){
                players.remove(i);
                break;
            }
        }
    }


    public void controlPlayerCollision(Player p){

        GameObject tempObject;

        for(int i = 0; i < players.size(); i++){

            tempObject = players.get(i);

            if(tempObject.getId() != ID.Player){
                if (p.getBounds().intersects(tempObject.getBounds()) && tempObject.getId() == ID.Apple){
                    players.remove(tempObject);
                    p.extendsPlayer();
                    if(p.getPlayerLength()% 15 == 0){
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

    public void controlTurtleCollision(Turtle t){

        GameObject tempObject;

        for(int i = 0; i < players.size(); i++){

            tempObject = players.get(i);

            if(!tempObject.equals(t)) {
                if (t.getBounds().intersects(tempObject.getBounds()) && ((tempObject.getId() == ID.Apple)  ||
                                                                         (tempObject.getId() == ID.PlayerBody))) {
                    t.setSpeed(0);
                } else if (t.getBounds().intersects(tempObject.getBounds()) && tempObject.getId() == ID.Turtle){
                    players.remove(tempObject);
                }
            }
        }
    }

    public boolean isObjectOverlapped(int x, int y){

        boolean overlap = false;

        for (int i = 0; i < this.getSize(); i++){

            if (players.get(i).getId() == ID.Player) {

                if (((Player) players.get(i)).getSafeZone().intersects(x,y,100,100) );

            } else {

                if (players.get(i).getBounds().intersects(x,y,100,100)) {
                   overlap = true;
                   return overlap;
               }
           }


        }

        return overlap;

    }

    public void setRandomDirectionToTurtles(){

        for(int i = 0; i < players.size(); i++){
            if(players.get(i).getId() == ID.Turtle){
                ((Turtle) players.get(i)).setRandomDirection();
            }
        }

    }






}
