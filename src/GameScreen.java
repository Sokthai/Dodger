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
	Point hero = new Point(0, 0);
	long t = 0;
	Random random = new Random();
	
	public GameScreen() throws IOException{
		super.setLayout(new BorderLayout());
		String path = "hero.png";
		int speed = 100;
        img = ImageIO.read(new File(path));
		
		 
		this.setBackground(Color.BLACK);
		
		 
		 ActionListener actionTask = new ActionListener(){
				public void actionPerformed(ActionEvent event){											
					repaint();
					t++;
				}
			};
			
			Timer timer = new Timer(speed, actionTask);
			timer.start();
		
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if (t % 20 == 0){
			for (int i = 0; i < 7; i++){
				int x = random.nextInt(this.getWidth()) + 60;
				x = (x > 1200)? 0 : x;
				g.drawImage(img, x, 0, null);
				enemy.add(new Point(x, 0));
				System.out.println(x);
			}
		}
		
		int end = (t % 5 == 0)? enemy.size() - 7 : enemy.size();
		
		for (int i = 0; i < end; i++){
			int y = random.nextInt(10);
			enemy.set(i, new Point(enemy.get(i).x, enemy.get(i).y + y));
			g.drawImage(img, enemy.get(i).x, enemy.get(i).y, null);		
//			if (hero.x <= enemy.get(i).x && hero.y >= enemy.get(i).x)
		}
		
		
	}
}











