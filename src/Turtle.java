import java.awt.*;
import java.util.Random;

public class Turtle extends GameObject {

    Handler handler;

    public Turtle(int x, int y, final ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.size = 100;
        this.currentSpeed = 0;
        this.currentDirection = null;
    }

    @Override
    public void tick() {

        if (this.currentDirection == Direction.UP) {

            this.y = this.y - currentSpeed;

        } else if (this.currentDirection == Direction.RIGHT) {

            this.x = this.x + currentSpeed;

        } else if (this.currentDirection == Direction.DOWN) {

            this.y = this.y + currentSpeed;

        } else if (this.currentDirection == Direction.LEFT) {

            this.x = this.x - currentSpeed;

        }

        turtleBox(this.x, Game.getResolution() * Game.getAspectRatio(), 0,
                this.y, Game.getResolution(), 0);


        handler.controlTurtleCollision(this);

    }

    @Override
    public void render(Graphics gameGraphics) {
        gameGraphics.setColor(Color.GRAY);
        final Graphics2D gameGraphics2D = (Graphics2D) gameGraphics;
        gameGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gameGraphics2D.fillRect((int) x, (int) y, this.size, this.size);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, this.size, this.size);
    }

    public void setRandomDirection() {

        Random random = new Random();
        int n = random.nextInt(4);


        switch (n) {
            case 0:
                if (this.getY() > 0 ) {
                    this.setCurrentDirection(Direction.UP);
                    break;
                }
            case 1:
                if (this.getX() < Game.getWIDTH()-this.getSize()) {
                    this.setCurrentDirection(Direction.RIGHT);
                    break;
                }
            case 2:
                if (this.getY() < Game.getHEIGHT()-this.getSize()) {
                    this.setCurrentDirection(Direction.DOWN);
                    break;
                }
            case 3:
                if (this.getX() > 0) {
                    this.setCurrentDirection(Direction.LEFT);
                    break;
                }
        }

        this.setCurrentSpeed(1);

    }

    private void turtleBox(int varX, final int maxX, int minX, int varY, int maxY, int minY) {

        // X controller
        if (varX + this.size > maxX || varX < minX) {
            this.setCurrentSpeed(0);
        }

        // Y controller
        if (varY + this.size > maxY || varY < minY) {
            this.setCurrentSpeed(0);
        }

    }
}

