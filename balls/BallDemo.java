import java.awt.Color;
import java.awt.Rectangle;
//import java.util.HashMap;
//import java.util.Map;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.concurrent.ThreadLocalRandom;


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
     * Desenha um retÃ¢ngulo dentro do Canvas, obedecendo sempre uma margem de 20px das bordas
     */
    public void drawFrame(){
        //int xPos = 20;
        //int yPos = 20;
        Rectangle rect = new Rectangle(xPosStart, yPosStart, WIDTH-xPosStart*2, HEIGHT-yPosStart*2);
        myCanvas.draw(rect);
    }
    
    /**
     * Cria e retorna um objeto Color aleatório
     */
    public Color randomColor(){
         int randomNum = ThreadLocalRandom.current().nextInt(1, 12 + 1);
         Color cor = new Color(0,0,0); 
         switch(randomNum){
             case 1:
                cor = Color.black;
             break;
             case 2:
                cor = Color.blue;
             break;
             case 3:
                cor = Color.cyan;
             break;
             case 4:
                cor = Color.darkGray;
             break;
             case 5:
                cor = Color.gray;
             break;
             case 6:
                cor = Color.green;
             break;
             case 7:
                cor = Color.lightGray;
             break;
             case 8:
                cor = Color.magenta;
             break;
             case 9:
                cor = Color.orange;
             break;
             case 10:
                cor = Color.pink;
             break;
             case 11:
                cor = Color.red;
             break;
             case 12:
                cor = Color.yellow;
             break;
         }
         return cor;
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
        
        ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>();
        
        for(int i=0; i<nBalls; i++){
            int randomX = ThreadLocalRandom.current().nextInt(xPosStart, WIDTH + 1);
            int randomY = ThreadLocalRandom.current().nextInt(yPosStart, HEIGHT/3 + 1);
            int randomTam = ThreadLocalRandom.current().nextInt(10, 30 + 1);
            int randomColor = ThreadLocalRandom.current().nextInt(1, 13 + 1);
            balls.add(new BouncingBall(randomX, randomY, randomTam, randomColor(), ground, myCanvas));
            balls.get(i).draw();
        }
        boolean finished=true;
        while(finished) {
            myCanvas.wait(30);     
            for(int i=0; i<balls.size(); i++){
                      // small delay
                balls.get(i).move();
                if(balls.get(i).getXPosition() >= xLimit) {
                    balls.get(i).erase();
                    balls.remove(i);
                    if(balls.isEmpty()){
                        finished = false;
                    }
                }
            }
        }
    }    
}

