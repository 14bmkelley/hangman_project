import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	private ActionListener easyListener;
	private ActionListener mediumListener;
	private ActionListener hardListener;

	//jpanel to be added
	private JPanel titlePanel;
	private JPanel buttonPanel;
	private GridBagConstraints buttonPanelFormatting;

	//master panel
	private JPanel corePanel;

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
		setActionListeners();

	}

	public void assemble() {

		titlePanel.add(titleLabel, SwingConstants.CENTER);
		
		buttonPanelFormatting.fill = GridBagConstraints.HORIZONTAL;
		buttonPanelFormatting.gridx = 0;
		buttonPanelFormatting.gridy = 0;
		buttonPanelFormatting.gridwidth = 3;
		buttonPanelFormatting.insets = new Insets(10, 10, 10, 10);
		buttonPanelFormatting.ipady = 80;
		buttonPanelFormatting.ipadx = 80;
		buttonPanelFormatting.anchor = GridBagConstraints.CENTER;

		buttonPanel.add(easyPicture, buttonPanelFormatting);

		buttonPanelFormatting.gridy = 1;
		buttonPanelFormatting.gridx = 2;
		buttonPanelFormatting.gridwidth = 1;
		buttonPanelFormatting.ipady = 20;
		buttonPanelFormatting.ipadx = 20;
		buttonPanelFormatting.fill = GridBagConstraints.NONE;

		buttonPanel.add(easyDifficulty, buttonPanelFormatting);
		
		buttonPanelFormatting.gridy = 2;
		buttonPanelFormatting.gridx = 0;
		buttonPanelFormatting.gridwidth = 3;
		buttonPanelFormatting.ipady = 80;
		buttonPanelFormatting.ipadx = 80;
		buttonPanelFormatting.fill = GridBagConstraints.CENTER;
		
		buttonPanel.add(mediumPicture, buttonPanelFormatting);

		buttonPanelFormatting.gridy = 3;
		buttonPanelFormatting.gridx = 2;
		buttonPanelFormatting.gridwidth = 1;
		buttonPanelFormatting.ipady = 20;
		buttonPanelFormatting.ipadx = 20;
		buttonPanelFormatting.fill = GridBagConstraints.NONE;
		
		buttonPanel.add(mediumDifficulty, buttonPanelFormatting);
		
		buttonPanelFormatting.gridy = 4;
		buttonPanelFormatting.gridx = 0;
		buttonPanelFormatting.gridwidth = 3;
		buttonPanelFormatting.ipady = 80;
		buttonPanelFormatting.ipadx = 80;
		buttonPanelFormatting.fill = GridBagConstraints.CENTER;
	
		buttonPanel.add(hardPicture, buttonPanelFormatting);

		buttonPanelFormatting.gridy = 5;
		buttonPanelFormatting.gridx = 2;
		buttonPanelFormatting.gridwidth = 1;
		buttonPanelFormatting.ipady = 20;
		buttonPanelFormatting.ipadx = 20;
		buttonPanelFormatting.fill = GridBagConstraints.NONE;
		
		buttonPanel.add(hardDifficulty, buttonPanelFormatting);

		corePanel.add(titlePanel, BorderLayout.NORTH);
		corePanel.add(buttonPanel, BorderLayout.CENTER);
		
		easyDifficulty.addActionListener(easyListener);
		mediumDifficulty.addActionListener(mediumListener);
		hardDifficulty.addActionListener(hardListener);

	}

	public JPanel getPanel() {

		return corePanel;

	}

	public void setFocus() {

		corePanel.setFocusable(true);
		corePanel.requestFocus();

	}

	private void setActionListeners() {

		easyListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent action) {

				Window window = (Window) SwingUtilities.getRoot(corePanel);
				window.setCurrentScreen(new GameScreen(Dictionary.getWord(Dictionary.EASY)));

			}

		};

		mediumListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent action) {

				Window window = (Window) SwingUtilities.getRoot(corePanel);
				window.setCurrentScreen(new GameScreen(Dictionary.getWord(Dictionary.MEDIUM)));

			}

		};

		hardListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent action) {

				Window window = (Window) SwingUtilities.getRoot(corePanel);
				window.setCurrentScreen(new GameScreen(Dictionary.getWord(Dictionary.HARD)));

			}

		};

	}
	
}
