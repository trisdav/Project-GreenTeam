import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Skeleton class for View.java
 * 
 * @author Tristan Davis
 *
 */


public class View implements ActionListener {
	Controller control;
	View(Controller c) {
		control = c;
		//Create the frame
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 615);
		//mainFrame.add(emailDisplay) etc
		DropDownMenu ddm = new DropDownMenu();
		//ddm.addEventListener();
		mainFrame.add(ddm, BorderLayout.WEST);
		mainFrame.setVisible(true);
		ddm.addUser("Tristan Davis"); //For testing purposes
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
