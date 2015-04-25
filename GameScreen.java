import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GameScreen extends Screen {
	
	//fields for game information
	private int remainingGuesses;
	private String wrongGuesses;
	private String word;
	private String visible;	

	//components to hold fields
	private JLabel status;
	private JLabel wrong;
	private JLabel visibleLabel;
	private JTextField input;

	//actionlistener for text input
	private ActionListener inputListener;
	
	//transitioning
	private int delay;
	private Timer transitionTimeout;
	private ActionListener transitionListener;

	//jpanels to be added
	private HangmanFigure hangmanPanel;
	private JPanel UIPanel;

	//jpanel to hold all panel (master panel!!!)
	private JPanel corePanel;

	public GameScreen(String toGuess) {
		
		//initialize fields
		remainingGuesses = 10;
		wrongGuesses = "";
		word = toGuess;
		visible = "";
		
		for (int i = 0; i < word.length(); ++i) {
			visible += "_ ";
		}
		
		//initialize components
		status = new JLabel("You have " + remainingGuesses + " remaining", SwingConstants.CENTER);
		wrong = new JLabel("Wrong guesses so far: " + wrongGuesses);
		visibleLabel = new JLabel(visible, SwingConstants.CENTER);
		input = new JTextField();
		
		//initialize panels
		hangmanPanel = new HangmanFigure();
		UIPanel = new JPanel(new GridLayout(4, 1));
		
		//initialize main panel (master race)
		corePanel = new JPanel();
		corePanel.setLayout(new BorderLayout());

		setInputListener();
		setTransitionListener();
		
		delay = 2000;
		transitionTimeout = new Timer(delay, transitionListener);
		transitionTimeout.setRepeats(false);

	}

	public void assemble() {
		
		input.addActionListener(inputListener);
		
		UIPanel.add(status);
		UIPanel.add(visibleLabel);
		UIPanel.add(input);
		UIPanel.add(wrong);
		
		corePanel.add(UIPanel, BorderLayout.SOUTH);
		corePanel.add(hangmanPanel, BorderLayout.CENTER);
		
	}

	public void setFocus() {
		
		input.requestFocus();
		
	}

	public JPanel getPanel() {
		
		return corePanel;
		
	}

	private void setInputListener() {
		
		inputListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				String text = input.getText();
				
				if (text.length() == 1 && text.matches("[a-z]")) {
					
					boolean guessFound = false;
					
					for (int i = 0; i < word.length(); ++i) {
						
						if (text.charAt(0) == word.charAt(i)) {
							
							guessFound = true;
							String newVisible = "";
							
							for (int j = 0; j < visible.length(); ++j) {

								if (j == (i * 2)) {
									
									newVisible += word.charAt(i);
									
								} else {
									
									newVisible += visible.charAt(j);
									
								}
								
							}
							
							visible = newVisible;
							visibleLabel.setText(visible);
							
						}
						
					}
					
					if (!guessFound) {
						
						if (--remainingGuesses >= 0) {
							
							status.setText("You have " + remainingGuesses + " guesses remaining");
							wrongGuesses += text + " ";
							wrong.setText("Wrong guesses so far: " + wrongGuesses);
							hangmanPanel.set();
							
						} else {
							
							status.setText("You lost: the word was " + word);
							input.setEnabled(false);
							
							Window window = (Window) SwingUtilities.getRoot(corePanel);
							window.revalidate();
							window.repaint();
							
							transitionTimeout.start();

						}
						
					} else {
						
						String actualVisible = "";
						for (int i = 0; i < visible.length(); i += 2) {
							
							actualVisible += visible.charAt(i);
							
						}
						
						if (actualVisible.equals(word)) {
							
							status.setText("Congratulations, you have won!");
							input.setEnabled(false);
							
							Window window = (Window) SwingUtilities.getRoot(corePanel);

							window.revalidate();
							window.repaint();
							
							transitionTimeout.start();

						}
						
					}
					
				} else {
					
					System.out.println("Invalid input!");
					
				}
				
				input.setText("");
				
			}
			
		};
		
	}
	
	private void setTransitionListener() {

		transitionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				Window window = (Window) SwingUtilities.getRoot(corePanel);
				window.setCurrentScreen(new HighScoreScreen());
				
			}
			
		};
		
	}
	
}
