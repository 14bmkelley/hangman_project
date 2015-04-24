import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class TitleScreen extends Screen {

	//field to store information
	private String title;
	private int keyDummy;

	//component for field
	private JLabel titleLabel;

	//jpanel to be added
	private JPanel panel;

	//master panel
	private JPanel corePanel;
	
	//listener to register enter keypress
	private KeyListener keyListener;

	public TitleScreen() {
		
		//initialize fields
		title = "Welcome to Hangman!";
		keyDummy = 0;
		
		//initialize component
		titleLabel = new JLabel(title, SwingConstants.CENTER);
		
		//initialze panel
		panel = new JPanel();
		
		//initialize master panel
		corePanel = new JPanel();
		corePanel.setLayout(new BorderLayout());
		
		//initialize keylistener
		setKeyListener();
		
	}

	public void assemble() {
		
		panel.add(titleLabel);
		corePanel.add(panel, BorderLayout.CENTER);
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
