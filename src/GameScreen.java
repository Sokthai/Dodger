import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;

public class GameScreen  extends JPanel{
	ArrayList<Point> enemy;
	final BufferedImage img;
	Point p;
	public GameScreen() throws IOException{
		super.setLayout(new BorderLayout());
		String path = "hero.png";
		int speed = 1;
        img = ImageIO.read(new File(path));
		 p = new Point(0, 0);
		 
		 
		 
		 
		 ActionListener actionTask = new ActionListener(){
				public void actionPerformed(ActionEvent event){				
					p.x = p.x;
					p.y = p.y + 1;
					repaint();
				}
			};
			
			Timer timer = new Timer(speed, actionTask);
			timer.start();
		
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(img, p.x, p.y, null);
	}
}
