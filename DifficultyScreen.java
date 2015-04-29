import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Insets;

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
	private ImageComponent easyPicture;
	private ImageComponent mediumPicture;
	private ImageComponent hardPicture;

	//jpanel to be added
	private JPanel titlePanel;
	private JPanel buttonPanel;
	private GridBagConstraints buttonPanelFormatting;

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
		easyPicture = new ImageComponent("easy.jpg");
		mediumPicture = new ImageComponent("medium.jpg");
		hardPicture = new ImageComponent("hard.jpg");

		//initialize working panel
		titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
		buttonPanelFormatting = new GridBagConstraints();

		//initialize master panel
		corePanel = new BackgroundPanel();
		corePanel.setLayout(new BorderLayout());

		//initialize keylistener
		setKeyListener();

	}

	public void assemble() {

		titlePanel.add(titleLabel, SwingConstants.CENTER);
		
		buttonPanelFormatting.fill = GridBagConstraints.HORIZONTAL;
		buttonPanelFormatting.gridx = 0;
		buttonPanelFormatting.gridy = 0;
		buttonPanelFormatting.gridwidth = 3;
		buttonPanelFormatting.insets = new Insets(10, 10, 10, 10);

		buttonPanel.add(easyPicture, buttonPanelFormatting);

		buttonPanelFormatting.gridy = 1;

		buttonPanel.add(easyDifficulty, buttonPanelFormatting);
		
		buttonPanelFormatting.gridy = 2;
		
		buttonPanel.add(mediumPicture, buttonPanelFormatting);
		
		buttonPanelFormatting.gridy = 3;
		
		buttonPanel.add(mediumDifficulty, buttonPanelFormatting);
		
		buttonPanelFormatting.gridy = 4;
		
		buttonPanel.add(hardPicture, buttonPanelFormatting);
		
		buttonPanelFormatting.gridy = 5;
		
		buttonPanel.add(hardDifficulty, buttonPanelFormatting);

		corePanel.add(titlePanel, BorderLayout.NORTH);
		corePanel.add(buttonPanel, BorderLayout.CENTER);
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
