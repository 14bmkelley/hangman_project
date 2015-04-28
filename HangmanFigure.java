import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HangmanFigure extends JPanel {
	
	private int guesses;
	private int centerX, centerY;

	public HangmanFigure(int centerX, int centerY) {
		super();
		guesses = 0;
		this.centerX = centerX;
		this.centerY = centerY;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		
		// base
		if(guesses > 0) {
			g.drawLine(centerX - 149, centerY + 149, centerX + 149, centerY + 149);
		}
		
		// right wall
		if(guesses > 1) {
			g.drawLine(centerX + 149, centerY + 149, centerX + 149, centerY - 149);
		}
		
		// top line
		if(guesses > 2) {
			g.drawLine(centerX, centerY - 149, centerX + 149, centerY - 149);
		}
		
		// hanging line
		if(guesses > 3) {
			g.drawLine(centerX, centerY - 149, centerX, centerY - 80);
		}
		
		// face
		if(guesses > 4) {
			g.drawOval(centerX - 25, centerY - 80, 50, 50);
		}
		
		// body
		if(guesses > 5) {
			g.drawLine(centerX, centerY - 30, centerX, centerY + 50);
		}
		
		// left hand
		if(guesses > 6) {
			g.drawLine(centerX, centerY, centerX - 40, centerY - 10);
		}
		
		// right hand
		if(guesses > 7) {
			g.drawLine(centerX, centerY, centerX + 40, centerY - 10);
		}
		
		// left leg
		if(guesses > 8) {
			g.drawLine(centerX, centerY + 50, centerX - 30, centerY + 100);
		}
		
		// right leg
		if(guesses > 9) {
			g.drawLine(centerX, centerY + 50, centerX + 30, centerY + 100);
		}
	}
	
	public void set() {
		guesses++;
		paintComponent(getGraphics());
	}
	
}
