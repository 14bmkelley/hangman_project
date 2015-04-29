import javax.swing.JComponent;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Dimension;

public class ImageComponent extends JComponent {

	private BufferedImage img;

	public ImageComponent(String imageFileName) {

		try {
			img = ImageIO.read(new File(imageFileName));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		this.setPreferredSize(new Dimension(100, 100));
	
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);

	}

}
