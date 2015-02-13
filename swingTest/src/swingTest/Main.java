package swingTest;

/**
 * Main.java
 * Purpose: Solitaire Layout with Draggable Cards
 * 
 * @author Samuel Robertson
 * @version 2.0
 *
 */

public class Main
{	
	GameWindow game;
	
	/**
	 * Constructor
	 * 
	 * @param none
	 */
	public Main() {
		game = new GameWindow();
	}
	
	/**
	 * Main method of Main.java
	 * 
	 * @param args Not used
	 */
    public static void main(String[] args)
    {
    	new Main();
    }
}