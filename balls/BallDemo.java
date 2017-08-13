import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Class BallDemo - provides a demonstration of the
 * BouncingBall and Canvas classes. 
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2010.11.30
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;
    private static final int xPosStart = 20;
    private static final int yPosStart = 20;

    /**
     * Create a BallDemo object.
     * Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", WIDTH, HEIGHT);
        myCanvas.setVisible(true);
    }
    
    /**
     * Desenha um retângulo dentro do Canvas, obedecendo sempre uma margem de 20px das bordas
     */
    public void drawFrame(){
        //int xPos = 20;
        //int yPos = 20;
        Rectangle rect = new Rectangle(xPosStart, yPosStart, WIDTH-xPosStart*2, HEIGHT-yPosStart*2);
        myCanvas.draw(rect);
    }
    
    /**
     * Simulate n bouncing balls
     */
    public void bounce(int nBalls)
    {
        int ground = HEIGHT-yPosStart*5;   // position of the ground line
        int xStart = xPosStart;    // x-start of the ground line
        int xLimit = WIDTH-xPosStart;   // x-limit of the ground line
        drawFrame();
        myCanvas.setVisible(true);
        
        // draw the ground
        myCanvas.setForegroundColor(Color.blue);
        myCanvas.drawLine(xStart, ground, xLimit, ground);

        // crate and show the balls
        ArrayList balls = new ArrayList();
        //BouncingBall[] balls = new BouncingBall[nBalls];
        for(BouncingBall i : nBalls){
            balls.add(new BouncingBall(xStart, 50, 16, Color.blue, ground, myCanvas));
            BouncingBall b = balls.get(i);
            b.draw();
        }
        
        BouncingBall ball = new BouncingBall(xStart, 50, 16, Color.blue, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(xStart + 20, 80, 20, Color.red, ground, myCanvas);
        ball2.draw();

        // Make them bounce until both have gone beyond the xLimit.
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= xLimit && ball2.getXPosition() >= xLimit) {
                finished = true;
            }
        }
        ball.erase();
        ball2.erase();
    }
    
}
