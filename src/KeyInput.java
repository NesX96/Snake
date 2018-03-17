import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keysPressed;

    public KeyInput(Handler handler){
        this.handler = handler;
        this.keysPressed = new boolean[50];
    }

    public void keyPressed(KeyEvent e){
        keysPressed[e.getKeyCode()] = true;
        update();
    }

    private void update() {
    	
    	if (keysPressed[KeyEvent.VK_UP]) {
    		if (handler.getPlayer().getDirection() != Direction.DOWN) {
    		 handler.setPlayerDirection(Direction.UP);
    		}
    		keysPressed[KeyEvent.VK_UP] = false;
    	}
    	if (keysPressed[KeyEvent.VK_RIGHT]) {
    		if (handler.getPlayer().getDirection() != Direction.LEFT) {
    		 handler.setPlayerDirection(Direction.RIGHT);
    		}
    		keysPressed[KeyEvent.VK_RIGHT] = false;
    	}
    	if (keysPressed[KeyEvent.VK_DOWN]) {
    		if (handler.getPlayer().getDirection() != Direction.UP) {
    		 handler.setPlayerDirection(Direction.DOWN);
    		}
    		keysPressed[KeyEvent.VK_DOWN] = false;
    	}
    	if (keysPressed[KeyEvent.VK_LEFT]) {
    		if (handler.getPlayer().getDirection() != Direction.RIGHT) {
    		 handler.setPlayerDirection(Direction.LEFT);
    		}
    		keysPressed[KeyEvent.VK_LEFT] = false;
    	}
    }
    


}
