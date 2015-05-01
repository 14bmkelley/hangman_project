import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class HighScoreScreen extends Screen {
    
    //field to store information
    private String title;
    
    //component for field
    private JLabel titleLabel;
    
    //jpanel to be added
    private JPanel panel;
    
    //master panel (<-- look at that panel, lording it over there)
    private JPanel corePanel;
    
	//listener to exit program or restart
	private KeyListener keyListener;

    public HighScoreScreen() {
        
        //initialize fields
        title = "Want to play again? Hit shift to play again or enter to quit.";
        
        //initialize component
        titleLabel = new JLabel(title, SwingConstants.CENTER);
        
        //initialize panel
        panel = new JPanel();
		panel.setOpaque(false);
        
        //initialize lord panel
        corePanel = new BackgroundPanel();

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
					
					System.exit(0);
					
				} else if (keyCode == 16) {

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
