import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_UP){
            handler.setPlayerDirection(Direction.UP);

        } else if (key == KeyEvent.VK_RIGHT){
            handler.setPlayerDirection(Direction.RIGHT);

        } else if (key == KeyEvent.VK_DOWN){
            handler.setPlayerDirection(Direction.DOWN);

        } else if (key == KeyEvent.VK_LEFT){
            handler.setPlayerDirection(Direction.LEFT);

        }

    }

}
