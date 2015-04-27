import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class DifficultyScreen extends Screen {

	//field for storing information
	private String title;
	
	//component for field
	private JLabel titleLabel;

	//jpanel to be added
	private JPanel panel;

	//master panel
	private JPanel corePanel;

	//listener to register keypress
	private KeyListener keyListener;

	public DifficultyScreen() {

		//initialize fields
		title = "This is the difficulty choice screen.";
		
		//initialize component
		titleLabel = new JLabel(title, SwingConstants.CENTER);

		//initialize working panel
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
			public void keyReleased(KeyEvent keyEvent) { /* do nothing */ }

			@Override
			public void keyTyped(KeyEvent keyEvent) { /* do nothing */ }

		};

	}

}
