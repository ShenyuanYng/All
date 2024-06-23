import java.awt.*;

public class WhiteBall extends Ball {
    @Override
    public void update(char keyChar) {
        switch (keyChar) {
            case 'a':
                this.setXSpeed(-8);
                break;
            case 'd':
                this.setXSpeed(8);
                break;
            case 'w':
                this.setYSpeed(-8);
                break;
            case 's':
                this.setYSpeed(8);
                break;
        }

    }

    @Override
    public void update(Ball ball) {
        this.setXSpeed(ball.getXSpeed());
        this.setYSpeed(ball.getYSpeed());
    }

    public WhiteBall(int xSpeed, int ySpeed, int ballSize) {
        super(Color.WHITE, xSpeed, ySpeed, ballSize);
    }
}
