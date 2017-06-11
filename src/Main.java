import java.io.IOException;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Main {

	public static void main(String[] args) throws IOException{
		Dimension dim = new Dimension(2200, 1700);
		JFrame frame = new JFrame("Alarm Clock");		
		GameScreen game = new GameScreen();
		
		
		frame.add(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(dim);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}

}
