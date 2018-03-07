import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{

    private int WIDTH;
    private int HEIGHT;
    private String TITLE;

    public Window(){
        WIDTH = 800;
        HEIGHT = 600;
        JFrame frame = new JFrame() //final?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //========================================================
    // SET FUNCTIONS
    //========================================================
    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setTitle(String TITLE){
        this.TITLE = TITLE;
    }


    public void setGame(Game game){
        this.add(game);
        //game.start(); / qua o toglierlo?
    }


    //========================================================
    // GET FUNCTIONS
    //========================================================
    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setTitle(String TITLE){
        this.TITLE = TITLE;
    }


    public void getGameState(Game game){
        this.add(game);
    }



}
