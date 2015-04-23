import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

public class Window {

	private Screen currentScreen;
	private JPanel currentPanel;
	private JFrame window;
	private String word;
	private KeyListener keyListener;
	private int keyDummy;

	public Window() {
		
		window = new JFrame();
		word = "";
		currentScreen = new TitleScreen();
		keyDummy = 0;

	}

	public void startGame(String selectedWord) {
		
		word = selectedWord;
		currentScreen.assemble();
		currentScreen.setFocus();

		setKeyListener();
		window.addKeyListener(keyListener);
		window.setFocusable(true);
		window.requestFocusInWindow();

		currentPanel = currentScreen.getPanel();
		window.add(currentPanel, BorderLayout.CENTER);
		window.setPreferredSize(new Dimension(300, 400));
		window.pack();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}
	
	private void setKeyListener() {
		
		keyListener = new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				
				int keyCode = keyEvent.getKeyCode();
					
				if (currentScreen instanceof TitleScreen) {

					if (keyCode == 10 || keyCode == 13) {

						currentScreen = new GameScreen(word);
						window.remove(currentPanel);
						currentPanel = currentScreen.getPanel();
						window.add(currentPanel, BorderLayout.CENTER);
						currentScreen.assemble();
						window.revalidate();
						window.repaint();
						currentScreen.setFocus();

					}
				
				} else if (currentScreen instanceof GameScreen) {
					
					

				}

			}

			@Override
			public void keyReleased(KeyEvent key) {
				
				keyDummy++;

			}
	
			@Override
			public void keyTyped(KeyEvent key) {
			
				keyDummy--;
			
			}

		};
	
	}

	public static void main(String[] argv) {

		new Window().startGame("cat");

	}

}
