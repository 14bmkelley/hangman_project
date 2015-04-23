import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class TitleScreen extends Screen {

	//field to store information
	private String title;

	//component for field
	private JLabel titleLabel;

	//jpanel to be added
	private JPanel panel;

	//master panel
	private JPanel corePanel;

	public TitleScreen() {
		
		//initialize fields
		title = "Welcome to Hangman!";

		//initalize component
		titleLabel = new JLabel(title, SwingConstants.CENTER);

		//initialze panel
		panel = new JPanel();

		//initalize master panel
		corePanel = new JPanel();
		corePanel.setLayout(new BorderLayout());
		
	}

	public void assemble() {
		
		panel.add(titleLabel);
		corePanel.add(panel, BorderLayout.CENTER);
		
	}

	public JPanel getPanel() {
		
		return corePanel;

	}

	public void setFocus() {

		corePanel.requestFocus();

	}

}
