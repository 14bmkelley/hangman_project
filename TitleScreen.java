import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class TitleScreen extends Screen {

	//field to store information
	private String title;

	//component for field
	private JLabel titleLabel;
	private ImageComponent hangmanPicture;

	//jpanel to be added
	private JPanel panel;
	private JPanel imagePanel;

	//master panel
	private JPanel corePanel;
	
	//listener to register enter keypress
	private KeyListener keyListener;

	public TitleScreen() {
		
		//initialize fields
		title = "Welcome to Hangman!";
		
		//initialize component
		titleLabel = new JLabel(title, SwingConstants.CENTER);
		
		//initialze panel
		panel = new JPanel();
		imagePanel = new JPanel();
		hangmanPicture = new ImageComponent("hangman.jpg");
		
		//initialize master panel
		corePanel = new BackgroundPanel();
		
		//initialize keylistener
		setKeyListener();
		
	}

	public void assemble() {
		
		panel.setBorder(new EmptyBorder(50, 0, 0, 0));
		panel.add(titleLabel);
		panel.setOpaque(false);
		hangmanPicture.setPreferredSize(new Dimension(300, 300));
		hangmanPicture.setOpaque(false);
		imagePanel.setBorder(new EmptyBorder(100, 0, 0, 0));
		imagePanel.setOpaque(false);
		imagePanel.add(hangmanPicture);
		corePanel.add(imagePanel, BorderLayout.CENTER);
		corePanel.add(panel, BorderLayout.NORTH);
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
					window.setCurrentScreen(new DifficultyScreen());
					
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent key) {
				
				//do nothing
				
			}
			
			@Override
			public void keyTyped(KeyEvent key) {
				
				//do nothing
				
			}
			
		};
		
	}

}
