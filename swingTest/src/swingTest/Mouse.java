package swingTest;

import java.awt.event.*;
import javax.swing.*;

/**
 * Mouse.java
 * Purpose: Activates and tracks the mouse movement for the draggable cards.
 * Resources: Some code found on a question on www.stackoverflow.com
 * 
 * @author Samuel Robertson
 *
 */
@SuppressWarnings("serial")
public class Mouse extends JFrame implements MouseListener, MouseMotionListener {

	private boolean drag = false;
	public static final int CARD_HEIGHT = 100;
	public static final int CARD_WIDTH = 75;
	public int labelX;
	public int labelY;

	@Override
	/**
	 * Grabs the pressed mouse event and locates the card that was clicked.
	 * 
	 * @param e Tracking and using the mouse.
	 */
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed on " + e.getComponent());
		labelX = e.getX();
		labelY = e.getY();
		e.getComponent().getParent().setComponentZOrder(e.getComponent(), 0); 
        e.getComponent().getParent().repaint(); 
		drag = true;
	}

	@Override
	/**
	 * @param e Tracking and using the mouse.
	 */
	public void mouseReleased(MouseEvent e) {
		drag = false;
	}

	@Override
	/**
	 * Keeps track of where the mouse is moving while dragging
	 * and updates the card's location.
	 * 
	 * @param e Tracking and using the mouse.
	 */
	public void mouseDragged(MouseEvent e) {
		if (drag == true) 
	    {
			JPanel panel = (JPanel) e.getComponent().getParent();
			
	        //Saves new X coordinate.
	        int newX = e.getComponent().getX() + e.getX() - labelX; 
	        
	        //Saves new Y coordinate.
	        int newY = e.getComponent().getY() + e.getY() - labelY;  
	        
	        //Makes sure you do not move the card out of the frame.
	        if(newX > panel.getWidth() - CARD_WIDTH) {
	            newX = panel.getWidth() - CARD_WIDTH;                             
	        }                                                                     
	        if(newY > panel.getHeight() - CARD_HEIGHT) {                          
	            newY = panel.getHeight() - CARD_HEIGHT;                           
	        }                                                                     
	        if(newX < 0) { newX = 0; }                                            
	        if(newY < 0) { newY = 0; }
	        e.getComponent().setLocation(newX, newY);
	    }
	}
	
	//Currently unused block of mouse events, left for future implementation.
	/**
	 * @param e Tracking and using the mouse.
	 */
	public void mouseMoved(MouseEvent e) {}
	
	/**
	 * @param e Tracking and using the mouse.
	 */
	public void mouseEntered(MouseEvent e) {}
	
	/**
	 * @param e Tracking and using the mouse.
	 */
	public void mouseExited(MouseEvent e) {}
	
	/**
	 * @param e Tracking and using the mouse.
	 */
	public void mouseClicked(MouseEvent e) {}
}