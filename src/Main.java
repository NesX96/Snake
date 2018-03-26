public class Main {

    private static int aspectRatioX = 16;
    private static int aspectRatioY = 9;
    private static int resolution = 1080;
    private static int HEIGHT = resolution;
    private static int WIDTH = (HEIGHT / aspectRatioY) * aspectRatioX;
    private static String TITLE = "Gioco";

    public enum GAMESTATE { Running(), Stopped()}

    public static GAMESTATE gamestate;

    public static void main(String[] args) {

        Game game = new Game(aspectRatioX, aspectRatioY, resolution);

        Window window = new Window(WIDTH, HEIGHT, TITLE, game);

        while(true){

            System.out.print("");

            if(gamestate == GAMESTATE.Stopped){
                System.out.println("ciao2");
                window.deathScreen(game);
                break;
            }
        }

        //window.setGame(game);
    }

}
