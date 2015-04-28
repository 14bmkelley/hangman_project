import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Window extends JFrame {

	private Screen currentScreen;
	private JPanel currentPanel;
	private String word;

	public Window() {
		
		word = "";
		this.setCurrentScreen(new TitleScreen());
		
	}

	public void startGame(String selectedWord) {
		
		word = selectedWord;
		
		this.setPreferredSize(new Dimension(400, 600));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void setCurrentScreen(Screen newScreen) {
		
		currentScreen = newScreen;
		
		if (!(currentScreen instanceof TitleScreen)) {
			
			this.remove(currentPanel);
			
		}
		
		currentPanel = currentScreen.getPanel();
		this.add(currentPanel, BorderLayout.CENTER);
		
		currentScreen.assemble();
		
		if (!(currentScreen instanceof TitleScreen)) {
			
			this.revalidate();
			this.repaint();
			
		}
		
		currentScreen.setFocus();
		
	}

	public static void main(String[] argv) {
		
		new Window().startGame("cat");
		
	}

}
