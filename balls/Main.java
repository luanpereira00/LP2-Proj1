import javax.swing.JOptionPane;

/**
 * Classe Main com método main
 */
public class Main{
	/**
	 * Método main
	 */
	public static void main(String[] args){
		BallDemo balls = new BallDemo();
		int nBalls=0;
		while(nBalls<1){
			nBalls = Integer.parseInt(JOptionPane.showInputDialog("Digite uma quantidade de bolas que deverão ser criadas: "));
		}
		balls.bounce(nBalls);
		
	}

}
