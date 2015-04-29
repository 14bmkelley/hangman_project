import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;

class ArrowComponent extends JPanel {

	private int posX, posY;

	public ArrowComponent(int initialPosX, int initialPosY) {

		super();
		posX = initialPosX;
		posY = initialPosY;
		this.setPreferredSize(new Dimension(60, 60));

	}

	public void setVerticalPos(int newPosY) {

		posY = newPosY;

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);

		g2.drawLine(posX + 10, posY, posX - 10, posY + 10);
		g2.drawLine(posX - 10, posY + 10, posX - 5, posY);
		g2.drawLine(posX - 5, posY, posX - 10, posY - 10);
		g2.drawLine(posX - 10, posY - 10, posX + 10, posY);

	}

}
