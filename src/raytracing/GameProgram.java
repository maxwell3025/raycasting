package raytracing;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameProgram extends Applet implements MouseMotionListener, KeyListener, Runnable{
int[][][] map;
BufferedImage ScreenBuffer = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_ARGB);
Graphics2D graphics = ScreenBuffer.createGraphics();
	public GameProgram(int[][][] map) {
		setSize(1000,1000);
		addKeyListener(this);
		addMouseMotionListener(this);
		setVisible(true);
		this.map=map;
	}
	public void paint(Graphics g){
		g.drawImage(ScreenBuffer, 0, 0, null);
	}
	public void updategraphics(){
		
	}

	public static void main(String[] args) {

	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void run() {
		
	}

}
