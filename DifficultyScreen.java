import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class DifficultyScreen extends Screen {

	//field for storing information
	private String title;
	
	//component for field
	private JLabel titleLabel;
	private JButton easyDifficulty;
	private JButton mediumDifficulty;
	private JButton hardDifficulty;

	//jpanel to be added
	private JPanel titlePanel;
	private JPanel buttonPanel;

	//master panel
	private JPanel corePanel;

	//listener to register keypress
	private KeyListener keyListener;

	public DifficultyScreen() {

		//initialize fields
		title = "This is the difficulty choice screen.";
		
		//initialize component
		titleLabel = new JLabel(title, SwingConstants.CENTER);
		easyDifficulty = new JButton("Easy");
		mediumDifficulty = new JButton("Medium");
		hardDifficulty = new JButton("Hard");

		//initialize working panel
		titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
		
		//initialize master panel
		corePanel = new BackgroundPanel();
		corePanel.setLayout(new FlowLayout());

		//initialize keylistener
		setKeyListener();

	}

	public void assemble() {

		titlePanel.add(titleLabel);
		buttonPanel.add(easyDifficulty);
		buttonPanel.add(mediumDifficulty);
		buttonPanel.add(hardDifficulty);
		corePanel.add(titlePanel);
		corePanel.add(buttonPanel);
		corePanel.addKeyListener(keyListener);

	}

	public JPanel getPanel() {

		return corePanel;

	}

	public void setFocus() {

		corePanel.setFocusable(true);
		corePanel.requestFocus();

	}

	private void setKeyListener() {

		keyListener = new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {

				int keyCode = keyEvent.getKeyCode();

				if (keyCode == 10 || keyCode == 13) {

					Window window = (Window) SwingUtilities.getRoot(corePanel);
					window.setCurrentScreen(new GameScreen("cat"));

				}
		
			}

			@Override
			public void keyReleased(KeyEvent keyEvent) { /* do nothing */ }

			@Override
			public void keyTyped(KeyEvent keyEvent) { /* do nothing */ }

		};

	}

}
