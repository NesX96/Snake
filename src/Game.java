import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

    private Thread thread;
    public static boolean running = false;

    private int aspectRatioX = 16;
    private int aspectRatioY = 9;
    private int resolution = 720;
    private int WIDTH;
    private int HEIGHT;
    private String TITLE;

    //private boolean firstTimeCreation = true; // TODO modificare nello spown
    public Handler handler;


    public Game(){
        HEIGHT = resolution;
        WIDTH = (HEIGHT / aspectRatioY) * aspectRatioX;
        TITLE = "Gioco";

        Window window = new Window(WIDTH, HEIGHT, TITLE, this);

        handler = new Handler();
        handler.addObject(new Player(10, 10, ID.Player, handler));
        handler.setPlayerSpeed(1);
        handler.setPlayerDirection(Player.Direction.DOWN);


    }

    //========================================================
    // FUNCTIONS - GAME DYNAMICS
    //========================================================

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while (running) {
            final long now = System.nanoTime();
            delta = delta + (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                //System.out.println("eccolo");
                render();
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer = timer + 1000;
            }
        }
        stop();
    }


    public void tick(){
        handler.tick();
    }

    private void render() {

        final BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            //System.out.println("buffer");
            return;
        }

        final Graphics gameGraphics = bs.getDrawGraphics();
        gameGraphics.setColor(Color.CYAN);
        gameGraphics.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(gameGraphics);

        gameGraphics.dispose();
        bs.show();
    }

    //=================================================
    // SCREEN PROPERTIES
    //=================================================

    public int getAspectRatioX() {
        return aspectRatioX;
    }

    public void setAspectRatio(int aspectRatioX, int aspectRatioY) {
        this.aspectRatioX = aspectRatioX;
        this.aspectRatioY = aspectRatioY;
    }

    public int getAspectRatioY() {
        return aspectRatioY;
    }


    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }



}
