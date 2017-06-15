import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.util.Random;

public class GameScreen  extends JPanel{
	ArrayList<Point> enemy = new ArrayList<Point>();
	final BufferedImage img;
	Point p;
	long t = 0;
	Random random = new Random();
	
	public GameScreen() throws IOException{
		super.setLayout(new BorderLayout());
		String path = "hero.png";
		int speed = 1000;
        img = ImageIO.read(new File(path));
		 p = new Point(0, 0);
		 
		this.setBackground(Color.BLACK);
		
		 
		 ActionListener actionTask = new ActionListener(){
				public void actionPerformed(ActionEvent event){						
					p.x = p.x;
					p.y = p.y + 1;
					repaint();
					t++;
				}
			};
			
			Timer timer = new Timer(speed, actionTask);
			timer.start();
		
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if (t % 5 == 0){
			for (int i = 0; i < 5; i++){
				int x = random.nextInt(this.getWidth()) + 100;
				x = (x > 2200)? 0 : x;
				g.drawImage(img, x, 0, null);
				enemy.add(new Point(x, 0));
				System.out.println(this.getWidth());
			}
		}
		
		int end = (t % 5 == 0)? enemy.size() - 10 : enemy.size();
		
//		for (int i = 0; i < end; i++){
//			int y = random.nextInt(10);
//			enemy.set(i, new Point(enemy.get(i).x, y));
//			g.drawImage(img, enemy.get(i).x, enemy.get(i).y,null);
//			
//			
//		}
		
		
	}
}











