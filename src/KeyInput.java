import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    // https://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html
    // https://stackoverflow.com/questions/22741215/how-to-use-key-bindings-instead-of-key-listeners
    // https://docs.oracle.com/javase/7/docs/api/javax/swing/KeyStroke.html
    
    private Handler handler;
    private boolean[] keysPressed;
    private int keyPressed;
    private int keyPressedLast;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
    	this.keyPressedLast = this.keyPressed;
    	this.keyPressed = e.getKeyCode();
        update();
    }
    
    public void keyReleased(KeyEvent e){
    	if (keyPressed == e.getKeyCode()) {
    		keyPressed = -1;
    		update();
    	} else if (keyPressedLast == e.getKeyCode()) {
    		keyPressedLast = -1;
    		update();
    	}
    }

    private void update() {
    	
    	switch (keyPressed) {
    	case (KeyEvent.VK_UP) : 
    		if (handler.getPlayer().getDirection() != Direction.DOWN) {
       		 handler.setPlayerDirection(Direction.UP);
       		}    	
    	case (KeyEvent.VK_RIGHT) :
    		if (handler.getPlayer().getDirection() != Direction.LEFT) {
    		 handler.setPlayerDirection(Direction.RIGHT);
    		}
    	case (KeyEvent.VK_DOWN) :
    		if (handler.getPlayer().getDirection() != Direction.UP) {
    		 handler.setPlayerDirection(Direction.DOWN);
    		}
    	case (KeyEvent.VK_LEFT) :
    		if (handler.getPlayer().getDirection() != Direction.RIGHT) {
    		 handler.setPlayerDirection(Direction.LEFT);
    		}
    	}
    }
    

}
