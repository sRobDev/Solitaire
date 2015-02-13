package swingTest;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * GameWindow.java
 * @author Samuel Robertson
 *
 */
public class GameWindow {

	Mouse mouse = new Mouse();

	/**
	 * Constructor
	 * 
	 * @param none
	 */
	public GameWindow(){
		GridLayout cardLayout = new GridLayout(4,13);
		ImageIcon[] initialSet = new ImageIcon[52];
		Color paleGreen = new Color(100, 200, 102);

		//create a panel displaying the card image
		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1L;
		};

		setCards(initialSet);

		//This block sets up the look of the game.
		cardLayout.setHgap(5);
		cardLayout.setVgap(10);
		panel.setBackground(paleGreen);
		panel.setLayout(cardLayout);
		panel.setBorder(new EmptyBorder(15, 15, 15, 15));

		JLabel[] cards = new JLabel[56];

		//This loop assigns each card as a JLabel so that they 
		//can be displayed on the screen using a GridLayout
		ImageIcon[] cardSet = randomize(initialSet);
		for(int i = 0; i < cardSet.length; i++){
			cards[i] = new JLabel(cardSet[i]);
			System.out.println("Adding mouse listeners");
			if(i % 14 != 0){
				cards[i].addMouseMotionListener(mouse);
				cards[i].addMouseListener(mouse);
			}
			panel.add(cards[i]);
		}

		//create & make visible a JFrame to contain the panel
		JFrame window = new JFrame("Solitaire"); 
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		window.setPreferredSize(new Dimension(1095,470));
		window.pack();
		window.setVisible(true);

		//Extra Credit section.  Makes sure user actually wants to exit.
		//If yes, closes down the frame on exit.
		window.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				JFrame frame = (JFrame)e.getSource();

				int result = JOptionPane.showConfirmDialog(
						frame,
						"Are you sure you want to exit the application?",
						"Exit Application",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION)
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	/**
	 * Loads in the card images and sets them into an array.
	 * 
	 * @param	cardSet		array that takes the cards as imageicons
	 * @return 				void
	 */
	public static void setCards(ImageIcon[] cardSet){

		//Spades block
		cardSet[0] = new ImageIcon("cardImages/aceSpades.gif");
		cardSet[1] = new ImageIcon("cardImages/twoSpades.gif");
		cardSet[2] = new ImageIcon("cardImages/threeSpades.gif");
		cardSet[3] = new ImageIcon("cardImages/fourSpades.gif");
		cardSet[4] = new ImageIcon("cardImages/fiveSpades.gif");
		cardSet[5] = new ImageIcon("cardImages/sixSpades.gif");
		cardSet[6] = new ImageIcon("cardImages/sevenSpades.gif");
		cardSet[7] = new ImageIcon("cardImages/eightSpades.gif");
		cardSet[8] = new ImageIcon("cardImages/nineSpades.gif");
		cardSet[9] = new ImageIcon("cardImages/tenSpades.gif");
		cardSet[10] = new ImageIcon("cardImages/jackSpades.gif");
		cardSet[11] = new ImageIcon("cardImages/queenSpades.gif");
		cardSet[12] = new ImageIcon("cardImages/kingSpades.gif");

		//Hearts block
		cardSet[13] = new ImageIcon("cardImages/aceHearts.gif");
		cardSet[14] = new ImageIcon("cardImages/twoHearts.gif");
		cardSet[15] = new ImageIcon("cardImages/threeHearts.gif");
		cardSet[16] = new ImageIcon("cardImages/fourHearts.gif");
		cardSet[17] = new ImageIcon("cardImages/fiveHearts.gif");
		cardSet[18] = new ImageIcon("cardImages/sixHearts.gif");
		cardSet[19] = new ImageIcon("cardImages/sevenHearts.gif");
		cardSet[20] = new ImageIcon("cardImages/eightHearts.gif");
		cardSet[21] = new ImageIcon("cardImages/nineHearts.gif");
		cardSet[22] = new ImageIcon("cardImages/tenHearts.gif");
		cardSet[23] = new ImageIcon("cardImages/jackHearts.gif");
		cardSet[24] = new ImageIcon("cardImages/queenHearts.gif");
		cardSet[25] = new ImageIcon("cardImages/kingHearts.gif");

		//Diamonds block
		cardSet[26] = new ImageIcon("cardImages/aceDiamonds.gif");
		cardSet[27] = new ImageIcon("cardImages/twoDiamonds.gif");
		cardSet[28] = new ImageIcon("cardImages/threeDiamonds.gif");
		cardSet[29] = new ImageIcon("cardImages/fourDiamonds.gif");
		cardSet[30] = new ImageIcon("cardImages/fiveDiamonds.gif");
		cardSet[31] = new ImageIcon("cardImages/sixDiamonds.gif");
		cardSet[32] = new ImageIcon("cardImages/sevenDiamonds.gif");
		cardSet[33] = new ImageIcon("cardImages/eightDiamonds.gif");
		cardSet[34] = new ImageIcon("cardImages/nineDiamonds.gif");
		cardSet[35] = new ImageIcon("cardImages/tenDiamonds.gif");
		cardSet[36] = new ImageIcon("cardImages/jackDiamonds.gif");
		cardSet[37] = new ImageIcon("cardImages/queenDiamonds.gif");
		cardSet[38] = new ImageIcon("cardImages/kingDiamonds.gif");

		//Clubs block
		cardSet[39] = new ImageIcon("cardImages/aceClubs.gif");
		cardSet[40] = new ImageIcon("cardImages/twoClubs.gif");
		cardSet[41] = new ImageIcon("cardImages/threeClubs.gif");
		cardSet[42] = new ImageIcon("cardImages/fourClubs.gif");
		cardSet[43] = new ImageIcon("cardImages/fiveClubs.gif");
		cardSet[44] = new ImageIcon("cardImages/sixClubs.gif");
		cardSet[45] = new ImageIcon("cardImages/sevenClubs.gif");
		cardSet[46] = new ImageIcon("cardImages/eightClubs.gif");
		cardSet[47] = new ImageIcon("cardImages/nineClubs.gif");
		cardSet[48] = new ImageIcon("cardImages/tenClubs.gif");
		cardSet[49] = new ImageIcon("cardImages/jackClubs.gif");
		cardSet[50] = new ImageIcon("cardImages/queenClubs.gif");
		cardSet[51] = new ImageIcon("cardImages/kingClubs.gif");
	}

	/**
	 * Randomizes the cards using a temporary array and two for loops. 
	 * Loads the cards from the cardSet into an ArrayList of ImageIcons
	 * and then shuffles these images using the collections library.
	 * <p>
	 * 
	 * @param	cardSet 	array of ImageIcons to be shuffled.
	 * @return 	tempSet		the array of shuffled ImageIcons.
	 */
	public static ImageIcon[] randomize(ImageIcon[] cardSet){
		//A temporary set to hold the cards for this method.
		//And an ArrayList of Icons to shuffle the cards.
		ImageIcon[] tempSet = new ImageIcon[56];
		ArrayList<Icon> cards = new ArrayList<Icon>();

		//Puts each card from the cardSet parameter into the ArrayList
		for(ImageIcon image : cardSet){
			cards.add(image);
		}
		Collections.shuffle(cards);

		//Variable for keeping track of gray card locations.
		int grayCheck = 0;

		//Puts the cards in the tempSet.
		//If the location is a mod of 14, a gray card is put there.
		for(Icon icon : cards){
			if(grayCheck % 14 == 0){
				tempSet[grayCheck] = new ImageIcon("cardImages/gray.gif");
				tempSet[grayCheck + 1] = (ImageIcon) icon;
				grayCheck++;
			} else { 
				tempSet[grayCheck] = (ImageIcon) icon;
			}
			grayCheck++;
		}
		return tempSet;
	}
}

