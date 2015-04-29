import javax.swing.JComponent;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class ImageComponent extends JComponent {

	private BufferedImage img;

	public ImageComponent(String imageFileName) {

		try {
			img = ImageIO.read(new File(imageFileName));
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);

	}

}
