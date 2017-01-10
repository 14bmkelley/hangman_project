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
    private String scoreBoard;
    
    //component for field
    private JLabel titleLabel;
    private JLabel scoreLabel;
    
    //jpanel to be added
    private JPanel panel;
    
    //master panel (<-- look at that panel, lording it over there)
    private JPanel corePanel;
    
    //score that will be added to the HighScoreScreen
    private int score;
    List<Integer> scores;
    int[] highScores;
    
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
    //HighScoreScreen constructor for a high score being passed the final score
    public HighScoreScreen(int remainingGuesses) {
        //value to be potentially added to the high score list
        addScore(remainingGuesses);

        //initialize fields
        scoreBoard = "<html>High Scores<br>";
        
        for (int v = 0; v < highScores.length; v++)
            scoreBoard += ((v+1) + ": " + highScores[v] + "<br>");
        scoreBoard += "</html>";


        //initialize component
	scoreLabel = new JLabel(scoreBoard, SwingConstants.CENTER);

        //initialize panel
        panel = new JPanel(new BorderLayout());

        //initialize lord panel
        corePanel = new JPanel();
        corePanel.setLayout(new BorderLayout());
        
        //initialize keylistener
	setKeyListener();

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
    
    public void readScores()
    {
        int max = Integer.MIN_VALUE;
        int index = 0;
        highScores = new int[5];
        try {
            scores = new ArrayList<>();
            for (String line : Files.readAllLines(Paths.get("HighScores.txt"))) {
                for (String part : line.split("\\s")) {
                    Integer i = Integer.valueOf(part);
                    scores.add(i);
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        for (int i = 0; i < 5; i++)
        {
            for (int s = 0; s < scores.size(); s++)
            {
                if ( ((int)scores.get(s)) >= max) {
                    max = (int)scores.get(s);
                    index = s;
                    highScores[i] = max;
                }
            }
            max = Integer.MIN_VALUE;
            scores.set(index, (Integer)0);
        }
    }
    
    public void assemble() {
        
        panel.add(scoreLabel);
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
				else if (keyCode == 8) {
					
					Window window = (Window) SwingUtilities.getRoot(corePanel);
					
					window.setCurrentScreen(new GameScreen("cat"));
				}
					
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
