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

        if(keyPressed) {

            if(key == KeyEvent.VK_UP && handler.getPlayerDirection() == Direction.UP){
                keyPressed = false;
            } else if (key == KeyEvent.VK_RIGHT && handler.getPlayerDirection() == Direction.RIGHT){
                keyPressed = false;
            } else if (key == KeyEvent.VK_DOWN && handler.getPlayerDirection() == Direction.DOWN){
                keyPressed = false;
            } else if (key == KeyEvent.VK_LEFT && handler.getPlayerDirection() == Direction.LEFT){
                keyPressed = false;
            }

        }

    }

}
