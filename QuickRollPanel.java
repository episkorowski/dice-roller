package diceRollGUI;


import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class QuickRollPanel extends JPanel{
	
	private JButton d4Button, d6Button, d8Button, d10Button, d12Button, d20Button, d100Button;	// Buttons for various die types
	private JButton clearButton;				// The "Clear" button
	protected static JTextField resultField;	// Field that displays the result of the roll
	//private JTextField historyField;			// Field that displays roll history. Not done. 
	private JPanel buttonPanel;     			// Panel that holds the button
	protected static JPanel resultPanel;		// Panel that holds resultField
	private int roll;  							// Holds the value for the roll
    private Font bigFont;						// Font that the result is displayed in
    private Die die;							// Die object
	
	public QuickRollPanel(){
        setLayout(new FlowLayout());
        buildButtonPanel();
        buildResultPanel();
        add(buttonPanel);
        add(resultPanel);
        setVisible(true);
	}

	/**
     * The buildButtonPanel method constructs a JPanel that contains a JButton that
     * rolls the dice when clicked. The dice images are changed depending on the 
     * number rolled
     */
    public void buildButtonPanel(){
        // Initializes Panel and Button
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,2));
        
        // Initializes the buttons
        d4Button = new JButton("d4");
        d6Button = new JButton("d6");
        d8Button = new JButton("d8");
        d10Button = new JButton("d10");
        d12Button = new JButton("d12");
        d20Button = new JButton("d20");
        d100Button = new JButton("d100");
        clearButton = new JButton("Clear");
        
        // Adds action listener to the buttons
        d4Button.addActionListener(new RollListener());
        d6Button.addActionListener(new RollListener());
        d8Button.addActionListener(new RollListener());
        d10Button.addActionListener(new RollListener());
        d12Button.addActionListener(new RollListener());
        d20Button.addActionListener(new RollListener());
        d100Button.addActionListener(new RollListener());
        clearButton.addActionListener(new RollListener());
        
        // Adds buttons to panel
        buttonPanel.add(d4Button);
        buttonPanel.add(d6Button);
        buttonPanel.add(d8Button);
        buttonPanel.add(d10Button);
        buttonPanel.add(d12Button);
        buttonPanel.add(d20Button);
        buttonPanel.add(d100Button);
        buttonPanel.add(clearButton);
        
        TitledBorder border = BorderFactory.createTitledBorder("Quick Roll");
        border.setTitleJustification(TitledBorder.CENTER);
    	buttonPanel.setBorder(border);
    }
    
    /**
     * Builds the result panel. Makes it not editable and makes the font really big.
     */
    public void buildResultPanel(){
    	resultPanel = new JPanel();
    	resultPanel.setLayout(new FlowLayout());
    	resultField = new JTextField(2);
    	resultField.setEditable(false);
    	resultField.setHorizontalAlignment(JTextField.CENTER);
    	
    	bigFont = resultField.getFont().deriveFont(Font.PLAIN, 55f);
    	resultField.setFont(bigFont);
    	
    	TitledBorder border = BorderFactory.createTitledBorder("Result");
    	border.setTitleJustification(TitledBorder.CENTER);
    	resultField.setBorder(border);
    	resultPanel.add(resultField);
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
            
            // Sets the number of faces and rolls the die according to the relevant button
            
            if(e.getActionCommand() == "d4"){
            	roll = die.setAndRoll(4);
            }
            if(e.getActionCommand() == "d6"){
            	roll = die.setAndRoll(6);
            }
            if(e.getActionCommand() == "d8"){
            	roll = die.setAndRoll(8);
            }
            if(e.getActionCommand() == "d10"){
            	roll = die.setAndRoll(10);
            }
            if(e.getActionCommand() == "d12"){
            	roll = die.setAndRoll(12);
            }
            if(e.getActionCommand() == "d20"){
            	roll = die.setAndRoll(20);
            }
            if(e.getActionCommand() == "d100"){
            	roll = die.setAndRoll(100);
            }
            resultField.setText(String.valueOf(roll));
            
            if(e.getActionCommand() == "Clear"){
            	resultField.setText("");
            }
            
        }    
    }

}
