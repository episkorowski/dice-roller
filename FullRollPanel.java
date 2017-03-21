package diceRollGUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.*;

public class FullRollPanel extends JPanel{
	
	private JTextField rollField;		// Holds the text string for the roll
	private JButton rollButton;			// Button to roll using the string in rollField
	
	private Die die;					// Die object
	private String[] rollContents;		// String array that stores the contents of the roll string
	private int quantity;				// Number of dice to be rolled
	private int rollAcc;				// Accumulator for holding the value of multiple dice rolls
	private int faceType;				// Number of faces on the die
	private int modifier;				// Modifier to add (or subtract) from the end result
	private int roll;					// Holds an individual raw roll
	
	
	public FullRollPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		rollField = new JTextField(10);
		
		// Default text, so the user knows it should be in this format
		rollField.setText("1d6+0");
		rollField.setHorizontalAlignment(JTextField.CENTER);
		
		rollButton = new JButton("Roll");
		rollButton.addActionListener(new RollListener());
		
		add(rollField);
		add(rollButton);
		
		TitledBorder border = BorderFactory.createTitledBorder("Full Roll");
        border.setTitleJustification(TitledBorder.CENTER);
    	this.setBorder(border);
    	
		setVisible(true);
	}
	
	/**
     * RollListener is an action listener class for the roll button.
     */
    private class RollListener implements ActionListener{
        /**
         * The actionPerformed method executes when the user clicks on the Roll button.
         * @param e     The event object
         */
        public void actionPerformed(ActionEvent e){
            die = new Die();
            
            // Splits the string in the roll field by 'd' and '+', getting the 3 relevant integers
            rollContents = rollField.getText().split("[d+]");
            
            
            if(rollContents.length == 3){
	            // Sets the quantity, faceType, and modifier based on the relevant info retrieved from the string
	            quantity = Integer.parseInt(rollContents[0]);
	            faceType = Integer.parseInt(rollContents[1]);
	            modifier = Integer.parseInt(rollContents[2]);
	            
	            die.setFaces(faceType);
	            rollAcc = 0;
	            
	            // Rolls the appropriate number of dice, updating rollAcc
	            for(int i = 0; i < quantity ; i++){
	            	roll = die.roll();
	            	rollAcc = rollAcc + roll;
	            }
	            // Adds the modifier and updates the result field
	            rollAcc = rollAcc + modifier;
	            QuickRollPanel.resultField.setText(String.valueOf(rollAcc));
	        } 
            // Simple way to avoid processing nonsense. Needs a proper exception. Doesn't handle when user enters only strings.
            else{
                rollField.setText("Invalid Format");
            }
            
        }
    }
}
