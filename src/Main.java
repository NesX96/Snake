public class Main {

    private static int aspectRatioX = 16;
    private static int aspectRatioY = 9;
    private static int resolution = 720;
    private static int HEIGHT = resolution;
    private static int WIDTH = (HEIGHT / aspectRatioY) * aspectRatioX;
    private static String TITLE = "Snake";


    public enum GAMESTATE { Running(), Stopped()}

    public static GAMESTATE gamestate;

    public static void main(String[] args) {

        Game game = new Game(aspectRatioX, aspectRatioY, resolution);

        Window window = new Window(WIDTH, HEIGHT, TITLE, game);

        while(true){

            System.out.print("");

            if(gamestate == GAMESTATE.Stopped){

                window.deathScreen(game);
                break;
            }
        }

        //window.setGame(game);
    }


    //===============================================
    // GETTER AND SETTER
    //===============================================


    public static int getAspectRatioX() {
        return aspectRatioX;
    }

    public static int getAspectRatioY() {
        return aspectRatioY;
    }

    public static GAMESTATE getGamestate() {
        return gamestate;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getResolution() {
        return resolution;
    }

    public static String getTITLE() {
        return TITLE;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setAspectRatioX(int aspectRatioX) {
        Main.aspectRatioX = aspectRatioX;
    }

    public static void setAspectRatioY(int aspectRatioY) {
        Main.aspectRatioY = aspectRatioY;
    }

    public static void setGamestate(GAMESTATE gamestate) {
        Main.gamestate = gamestate;
    }

    public static void setHEIGHT(int HEIGHT) {
        Main.HEIGHT = HEIGHT;
    }

    public static void setResolution(int resolution) {
        Main.resolution = resolution;
    }

    public static void setTITLE(String TITLE) {
        Main.TITLE = TITLE;
    }

    public static void setWIDTH(int WIDTH) {
        Main.WIDTH = WIDTH;
    }

}
