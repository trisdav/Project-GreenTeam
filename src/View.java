import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Skeleton class for View.java
 * 
 * @author Tristan Davis
 * edited by Lydia McGovern
 */


public class View implements ActionListener {
	private Controller control;
	//Create variables for various components of the gui
	private DropDownMenu ddm;
	private ButtonBlock bb;
	private UserAndAccountControl ua; // LM
	
/**
 * Constructs a GUI for the Simple Email System with four functional blocks
 * @param c the controller for the MVC application
 */
	View(Controller c) {
		control = c;
//		GridLayout layout = new GridLayout();//create the layout
		BorderLayout layout = new BorderLayout(); // LM
		//Create the frame
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 615);
		mainFrame.setLayout(layout);
		//Create a preferred dimension for ddm
		Dimension ddmDim = new Dimension( 200,550 );
		ddm = new DropDownMenu(ddmDim);
		bb = new ButtonBlock(this);
		ua = new UserAndAccountControl(this); // LM
		mainFrame.add(ddm, layout.WEST); // LM
		mainFrame.add(bb, BorderLayout.EAST); // LM
		mainFrame.add(ua, layout.NORTH); // LM
		mainFrame.setVisible(true);		
	}
	@Override
// Currently covers the actions of the button block and the UnA control
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
		case "Add User":
			String newUsername = JOptionPane.showInputDialog("Enter the username: ");
			break;
		case "Delete User":
		    if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete <username>?",
		    		"Confirm Delete", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
		    	break;
		    }
		    break;
		case "Add Account":
			String newAccountName = JOptionPane.showInputDialog("Enter the account name: ");
			break;
		case "Delete Account":
			 if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete <account name>?",
			    		"Confirm Delete", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
				 break;
			 }
			 break;
		case "Compose":
		case "Send":
		case "Reply":
		case "Trash":
		default:
			System.out.println(e.getActionCommand());
			break;
			
		}
		
	}
	
}
