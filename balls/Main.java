import javax.swing.JOptionPane;

/**
 * Classe Main com m�todo main
 */
public class Main{
	/**
	 * M�todo main
	 */
	public static void main(String[] args){
		BallDemo balls = new BallDemo();
		int nBalls=0;
		while(nBalls<1){
			nBalls = Integer.parseInt(JOptionPane.showInputDialog("Digite uma quantidade de bolas que dever�o ser criadas: "));
		}
		balls.bounce(nBalls);
		
	}

}
