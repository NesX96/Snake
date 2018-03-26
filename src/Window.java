import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;


public class Window extends Canvas {

    private int WIDTH;
    private int HEIGHT;
    private String TITLE;
    private JFrame frame;

    public Window(int width, int height,String title, Game game) {
        WIDTH = width;
        HEIGHT = height;
        TITLE = title;

        System.out.println("Window" +WIDTH + " " + HEIGHT);


        frame = new JFrame(TITLE); //final?

        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //frame.setMaximumSize(new Dimension(WIDTH+20, HEIGHT+20));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT+37));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        frame.add(game);
        frame.setVisible(true);
        game.start();

        System.out.print((int) frame.getContentPane().getBounds().getWidth() + " ");
        System.out.println((int) frame.getContentPane().getBounds().getHeight());


        //HEIGHT = HEIGHT + ( HEIGHT - (int) frame.getContentPane().getBounds().getHeight());
        //frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        //System.out.println((int) frame.getContentPane().getBounds().getHeight());

        // System.out.println(frame.getContentPane().getAlignmentX());
    }

    public void deathScreen(Game game) {

        this.frame.remove(game);

        BufferedImage image = null;

        try{
            File file = new File("./death.jpg");
            image = ImageIO.read(file);
        } catch (IOException e){
            e.printStackTrace();
        }

        java.awt.Image dimg = image.getScaledInstance(frame.getWidth(), frame.getHeight(), java.awt.Image.SCALE_SMOOTH);

        ImageIcon imageIcon =  new ImageIcon(dimg);
        JLabel label = new JLabel(imageIcon);

        this.frame.getContentPane().add(label);
        this.frame.pack();

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
