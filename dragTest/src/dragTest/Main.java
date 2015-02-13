package dragTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame implements MouseListener, MouseMotionListener {

	private JPanel panel = new JPanel(null);    
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private int mouseX = 200;
	private int mouseY = 100;
	private boolean drag = false;

	public Main() {
		this.add(panel);
		panel.setBackground(Color.WHITE);

		panel.add(label1);
		label1.setOpaque(true); 
		label1.setBackground(Color.BLUE);
		label1.setBounds(mouseX, mouseY, 100, 50);
		label1.addMouseMotionListener(this);
		label1.addMouseListener(this);

		panel.add(label2);
		label2.setOpaque(true); 
		label2.setBackground(Color.RED);
		label2.setBounds(mouseX + 200, mouseY, 100, 50);
		label2.addMouseMotionListener(this);
		label2.addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == label1) {
			drag = true;
		} 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drag = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (drag == true) 
	    {
	        JComponent jc = (JComponent)e.getSource();
	        jc.setLocation(jc.getX()+e.getX(), jc.getY()+e.getY());
	    }
	}

	public void mouseMoved(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}

	public static void main(String[] args) {
		Main frame = new Main();
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}