import java.util.Random;


public class Spown {

    private Handler handler;
    Random rand = new Random();

    private int turtlesSpownRate = 2;
    private int maxNumerOfTurtle = 10;

    private boolean addingPlayer = true;

    public Spown(Handler handler) {
        this.handler = handler;
    }

    public void tick(){

        //Player Creation
        if(addingPlayer){
            handler.addObject(new Player(10, 10, ID.Player, handler));
            handler.setPlayerSpeed(3);
            handler.setPlayerDirection(Direction.DOWN);
            addingPlayer = false;

        // Apple creation
        } else if (!handler.appleInGame()) {

            Coordinate appleCoordinates = setValidVariables();

            handler.addObject(new Apple(appleCoordinates.getX(),
                                        appleCoordinates.getY(),
                                        ID.Apple,
                                        handler));

        // Turtle creation
        } else if (handler.numberOfTurtles() != ((Player) handler.getPlayer()).getPlayerLength() / turtlesSpownRate) {

                // Turtle spown
                if (((Player) handler.getPlayer()).getPlayerLength() < 20 || handler.numberOfTurtles() < maxNumerOfTurtle ) {

                    Coordinate turtleCoordinates = setValidVariables();

                    handler.addObject(new Turtle(turtleCoordinates.getX(),
                                                 turtleCoordinates.getY(),
                                                 ID.Turtle,
                                                 handler));
                //Turtle movement
                } else if (((Player) handler.getPlayer()).getPlayerLength()% turtlesSpownRate == 0){
                    handler.setRandomDirectionToTurtles();
                }
            }



    }

    public int randomClamp(int var, int min, int max){

        if (var < min){
            return min + 80;
        } else if (var >= max -101 ){
            return max - 200;
        } else {
            return var;
        }

    }

    private int screenX(){
        return randomClamp(rand.nextInt((Game.getResolution()/ Game.getAspectRatioY())*Game.getAspectRatioX()),
                0,
                (Game.getResolution()/ Game.getAspectRatioY())*Game.getAspectRatioX() );
    }

    private int screenY(){
        return randomClamp(rand.nextInt(Game.getResolution()), 0, Game.getResolution());
    }

    private Coordinate setValidVariables(){

        int x = screenX();
        int y = screenY();

        while(handler.isObjectOverlapped(x,y)){
            x = resetVariableX(x);
            y = resetVariableY(y);
            System.out.format("x: %d ,y: %d \n", x, y);
        }

        return new Coordinate(x, y);
    }

    private int resetVariableX(int x){
        return screenX();
    }

    private int resetVariableY(int y){
        return screenY();
    }

}


