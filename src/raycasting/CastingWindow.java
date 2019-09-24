package raycasting;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CastingWindow extends JFrame implements Runnable, MouseMotionListener, KeyListener {
	boolean ahead = false;
	double playerX = 2;
	double playerY = 3;
	double playerdegree = 2;
	int[][] map = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	BufferedImage screenbuffer = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
	Graphics2D graphics2d = screenbuffer.createGraphics();
	int[] distances = new int[1000];

	public CastingWindow() {
		addKeyListener(this);
		addMouseMotionListener(this);
		setSize(1000, 1000);
		setVisible(true);
	}

	public static void main(String[] args) {
		CastingWindow c = new CastingWindow();
		new Thread(c).start();
		c.redraw();
		System.out.println(c.findforray(3, 2, 0.5, 0.2)[0]);
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 1000, 1000);
		/*
		 * g.clearRect(0, 0, 1000, 1000); for(int i = 0; i<1000;i++){
		 * g.setColor(Color.GREEN); g.fillRect(i, 0, 1, distances[i]); }
		 */
		for (int i = 0; i < 1000; i++) {
			// g.setColor(Color.BLACK);
			double raydirx = Math.sin(-playerdegree) + (Math.cos(playerdegree) * ((double) i / 500 - 1));
			double raydiry = Math.cos(-playerdegree) + (Math.sin(playerdegree) * ((double) i / 500 - 1));
			// g.fillRect((int)(raydirx*100+500), (int)(raydiry*100+500), 1, 1);
			// g.fillOval(490,490, 20, 20);
			raydirx = Math.sin(-playerdegree + (((double) i / 500 - 1)));
			raydiry = Math.cos(-playerdegree + (((double) i / 500 - 1)));
			g.setColor(new Color((int) (findforray(playerX, playerY, raydirx, raydiry)[1] * 5), 255, 255));
			g.fillRect(i, 500 - (int) (500 / findforray(playerX, playerY, raydirx, raydiry)[0]), 1,
					(int) (1000 / findforray(playerX, playerY, raydirx, raydiry)[0]));
		}
	}

	public void redraw() {
		update();
		draw(graphics2d);
		repaint();
	}

	public void paint(Graphics g) {
		g.drawImage(screenbuffer, 0, 0, null);
	}

	public void update() {
		for (int i = 0; i < 1000; i++) {
			double raydirx = Math.sin(playerdegree) + (Math.cos(playerdegree) * (double) (i / 500 - 1));
			double raydiry = Math.cos(playerdegree) + (Math.sin(playerdegree) * (double) (i / 500 - 1));
			distances[i] = (int) (1000 - findforray(playerX, playerY, raydirx, raydiry)[0] * 100);
		}
	}

	public double[] findforray(double playerx, double playery, double rayX, double rayY) {
		return null;
	}
	public double findinitial(double playerx, double playery, double rayX, double rayY, boolean forx){
		
	}
	public int valueat(double x, double y) {
		return map[(int) Math.floor(x)][(int) Math.floor(y)];
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			ahead = true;
		}

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			ahead = false;
		}
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		playerdegree = (double) e.getX() / 100;
		redraw();
		;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (ahead) {
				playerX += Math.sin(-playerdegree) / 8;
				playerY += Math.cos(-playerdegree) / 8;
				redraw();
			}
		}

	}

}
