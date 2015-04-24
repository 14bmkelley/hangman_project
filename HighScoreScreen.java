import java.awt.BorderLayout;
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
    
    public HighScoreScreen() {
        
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
    
    public void assemble() {
        
        panel.add(titleLabel);
        corePanel.add(panel, BorderLayout.CENTER);
        
    }
    
    public JPanel getPanel() {
        
        return corePanel;
        
    }
    
    public void setFocus() {
        
        corePanel.setFocusable(true);
        corePanel.requestFocus();
        
    }
    
}