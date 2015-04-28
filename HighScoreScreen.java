import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.File;
import java.io.IOException;


public class HighScoreScreen extends Screen {
    
    //field to store information
    private String title;
    
    //component for field
    private JLabel titleLabel;
    
    //jpanel to be added
    private JPanel panel;
    
    //master panel (<-- look at that panel, lording it over there)
    private JPanel corePanel;
    
    //score that will be added to the HighScoreScreen
    private int score;
    
    //listener to exit program or restart
	private KeyListener keyListener;

    public HighScoreScreen() {
        
        //initialize fields
        title = "This is the high score screen";
        
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
    //HighScoreScreen constructor for a high score being passed the final score
    public HighScoreScreen(int remainingGuesses) {
        //value to be potentially added to the high score list
        addScore(remainingGuesses);

        //initialize fields
        title = "This is the high score screen";

        //initialize component
        titleLabel = new JLabel(title, SwingConstants.CENTER);

        //initialize panel
        panel = new JPanel();

        //initialize lord panel
        corePanel = new JPanel();
        corePanel.setLayout(new BorderLayout());

    }
    
    //Adds the value of the score to the txt file "HighScores.txt"
    public void addScore(int score){
        try{
            String data = " " + String.valueOf(score) + " ";

            File file = new File("HighScores.txt");

            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }

            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(data);
            bufferWritter.close();
            System.out.println("Success");
        }
        
        catch(IOException e){
            e.printStackTrace();
        }
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
