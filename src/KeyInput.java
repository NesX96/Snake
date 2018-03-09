import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean keyPressed = false;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();

        if(!keyPressed){

            if(key == KeyEvent.VK_UP){
                handler.setPlayerDirection(Direction.UP);
                keyPressed = true;
            } else if (key == KeyEvent.VK_RIGHT){
                handler.setPlayerDirection(Direction.RIGHT);
                keyPressed = true;
            } else if (key == KeyEvent.VK_DOWN){
                handler.setPlayerDirection(Direction.DOWN);
                keyPressed = true;
            } else if (key == KeyEvent.VK_LEFT){
                handler.setPlayerDirection(Direction.LEFT);
                keyPressed = true;
            }

        }
    }

    public void keyReleased(final KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_LEFT ){
            keyPressed = false;
        }

    }

}
