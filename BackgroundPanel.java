import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

class BackgroundPanel extends JPanel {

	public BackgroundPanel() {

		super();
		this.setLayout(new BorderLayout());
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setBackground(new Color(173, 216, 230));

	}


}
