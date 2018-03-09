import javax.swing.*;
import java.awt.*;


public class Window extends Canvas {

    private int WIDTH;
    private int HEIGHT;
    private String TITLE;


    public Window(int width, int height,String title, Game game) {
        WIDTH = width;
        HEIGHT = height;
        TITLE = title;

        JFrame frame = new JFrame(TITLE); //final?

        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH+20, HEIGHT+20));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true); // TODO modify dimension via setSize
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }



























    //========================================================
    // GETTER AND SETTER
    //========================================================

    public int getWIDTH() {
        return this.WIDTH;
    }

    public int getHEIGHT() {
        return this.HEIGHT;
    }

    public String getTitle() {
        return this.TITLE;
    }

    /*
    public void getGameState(Game game) {
        this.add(game);
    }
    */


    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setTitle(String TITLE) {
        this.TITLE = TITLE;
    }

    /*
    public void setGame(Game game) {
        this.add(game);
        //game.start(); // qua o toglierlo?
    }
    */


}
