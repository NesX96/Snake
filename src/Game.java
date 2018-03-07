import java.awt.*;
import java.awt.event.ActionListener;

public class Game extends Canvas implements Runnable, ActionListener {
    /*TODO sistemare:
     * - Private/Public
     * - Override
     *
    */
    private State state;

    public Game(){
        state = State.RUNNING;
    }

    private enum State {
        RUNNING, PAUSE
    }

    public synchronized void start(){

    }

    public synchronized void stop(){

    }

    public void run(){

    }

    // @Override da mettere?
    private void tick(){

    }

    // @Override da mettere?
    private void render(){

    }


    public void setState(State state) {  //Pause, Run
    }

    public State getState(){
        return this.STATE;
    }

}

