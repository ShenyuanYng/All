import java.awt.*;
import java.util.Random;

public class RedBall extends Ball{
    Random random = new Random();
    @Override
    public void update(Ball ball){
        if (this.isIntersect(ball)){
            this.setXSpeed(ball.getXSpeed());
            this.setYSpeed(ball.getYSpeed());
        }
    }
    @Override
    public void update(char keyChar) {
        switch (keyChar) {
            case 'a':
                this.setXSpeed(-random.nextInt(3) - 1);
                break;
            case 'd':
                this.setXSpeed(random.nextInt(3) + 1);
                break;
            case 'w':
                this.setYSpeed(-random.nextInt(3) - 1);
                break;
            case 's':
                this.setYSpeed(random.nextInt(3) + 1);
        }

    }
    public RedBall(int xSpeed, int ySpeed, int ballSize) {
        super(Color.RED, xSpeed, ySpeed, ballSize);
    }
}
