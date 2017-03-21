package diceRollGUI;

import java.util.Random;


public class Die {
    private Random rand;	// Random object used to perform rolls
    private int faces;		// Number of faces on the die
    
    /**
     *  The constructor sets the number of faces and creates a random object.
     *  @param faces The number of faces on the die
     */
    public Die(int faces) {
        this.rand = new Random();
        this.faces = faces;
    }
    
    /**
     * No-arg constructor. Creates a die without setting a number of faces.
     */
    public Die() {
        this.rand = new Random();
    }
    
    /**
     * The roll function returns an integer that represents the
     * result of a simulated dice roll.
     * @return The result of the roll
     */
    public int roll() {
        return rand.nextInt(faces) + 1;
    }
    
    /**
     * Sets the number of faces on a die.
     * @param newFaces The number of faces
     */
    public void setFaces(int newFaces){
    	faces = newFaces;
    }
    
    /**
     * Sets the number of faces on a die and rolls it. Used for convenience in quickRollPanel
     * for setting and rolling in one line.
     * @param faces The number of faces
     * @return The result of the roll
     */
    public int setAndRoll(int faces){
    	setFaces(faces);
    	return roll();
    }

}
