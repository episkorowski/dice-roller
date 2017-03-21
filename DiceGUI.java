package diceRollGUI;

import javax.swing.*;

import java.awt.*;

public class DiceGUI extends JFrame{
	
	private JPanel quickRollPanel;		// The quickRoll Panel
	private JPanel fullRollPanel;		// The fullRoll Panel
	//private JPanel historyPanel;		// The currently not finished history Panel
	private ImageIcon imgIcon;			// Holds the icon
	
	
	public DiceGUI(){
        setTitle("Dice Roller");
        imgIcon = new ImageIcon("d20.png");
        setIconImage(imgIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        quickRollPanel = new QuickRollPanel();
        fullRollPanel = new FullRollPanel();
        add(quickRollPanel);
        add(fullRollPanel);
        pack();
        setVisible(true);
    }
	
	
	public static void main(String[] args) {
		// This whole try-catch block is necessary to use the Windows Look And Feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
		new DiceGUI();
	}

}
