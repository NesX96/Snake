import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    // https://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html
    // https://stackoverflow.com/questions/22741215/how-to-use-key-bindings-instead-of-key-listeners
    // https://docs.oracle.com/javase/7/docs/api/javax/swing/KeyStroke.html
    
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
    
    public void keyPressed(KeyEvent e){
        keysPressed[e.getKeyCode()] = false;
    }

    private void update() {
    	
    	if (keysPressed[KeyEvent.VK_UP]) {
    		if (handler.getPlayer().getDirection() != Direction.DOWN) {
    		 handler.setPlayerDirection(Direction.UP);
    		}
    	}
    	if (keysPressed[KeyEvent.VK_RIGHT]) {
    		if (handler.getPlayer().getDirection() != Direction.LEFT) {
    		 handler.setPlayerDirection(Direction.RIGHT);
    		}
    	}
    	if (keysPressed[KeyEvent.VK_DOWN]) {
    		if (handler.getPlayer().getDirection() != Direction.UP) {
    		 handler.setPlayerDirection(Direction.DOWN);
    		}
    	}
    	if (keysPressed[KeyEvent.VK_LEFT]) {
    		if (handler.getPlayer().getDirection() != Direction.RIGHT) {
    		 handler.setPlayerDirection(Direction.LEFT);
    		}
    	}
    }
    
    private void changeDirectionOnLastKey() {
        
    


}
