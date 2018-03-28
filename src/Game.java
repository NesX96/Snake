import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    public static boolean running = false;

    private static int aspectRatioX ;
    private static int aspectRatioY ;
    private static int resolution ;
    private static int HEIGHT ;
    private static int WIDTH ;


    public Handler handler;
    private Spown spowner;


    public Game(int aspectRatioX, int aspectRatioY, int resolution){

        this.aspectRatioX = aspectRatioX;
        this.aspectRatioY = aspectRatioY;
        this.resolution = resolution;
        this.HEIGHT = this.resolution;
        this.WIDTH = (HEIGHT / this.aspectRatioY) * this.aspectRatioX;


        handler = new Handler();

        spowner = new Spown(handler);

        this.addKeyListener(new KeyInput(handler));

        System.out.println(WIDTH + " " + HEIGHT);


    }

    //========================================================
    // FUNCTIONS - GAME DYNAMICS
    //========================================================

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
        Main.gamestate = Main.GAMESTATE.Running;
    }

    public synchronized void stop() {
        try {

            Main.gamestate = Main.GAMESTATE.Stopped;

            running = false;

            thread.join();

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
        spowner.tick();
        if (handler.getPlayer().getSpeed() == 0){
            this.stop();
        }

    }

    private void render() {


        final BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            //System.out.println("buffer");
            return;
        }

        final Graphics gameGraphics = bs.getDrawGraphics();
        gameGraphics.setColor(Color.DARK_GRAY);
        gameGraphics.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(gameGraphics);

        gameGraphics.dispose();
        bs.show();
    }


    //=================================================
    // SCREEN PROPERTIES
    //=================================================

    public static int getAspectRatioX() {
        return aspectRatioX;
    }

    public static int getAspectRatioY() {
        return aspectRatioY;
    }

    public static int getAspectRatio() { return (aspectRatioX/aspectRatioY); }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getResolution() {
        return resolution;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public void setAspectRatio(int aspectRatioX, int aspectRatioY) {
        this.aspectRatioX = aspectRatioX;
        this.aspectRatioY = aspectRatioY;
    }

    public static void setHEIGHT(int HEIGHT) {
        Game.HEIGHT = HEIGHT;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public static void setWIDTH(int WIDTH) {
        Game.WIDTH = WIDTH;
    }


}
