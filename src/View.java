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
	private EmailBlock eb;
	
/**
 * Constructs a GUI for the Simple Email System with four functional blocks
 * @param c the controller for the MVC application
 */
	View() {
		
	}
	
	public void run(Controller c) {
		control = c;
// Set up the frame
		BorderLayout layout = new BorderLayout(); // LM
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 615);
		mainFrame.setLayout(layout);
//Create a preferred dimension for ddm
		Dimension ddmDim = new Dimension( 200,550 );
// Initialize the four functional blocks
		ddm = new DropDownMenu(this, ddmDim);
		bb = new ButtonBlock(this);
		ua = new UserAndAccountControl(this); // LM
		eb = new EmailBlock(this);
// Create a sub panel that contains the email and button blocks
		JPanel subBlock = new JPanel();
		subBlock.add(bb, BorderLayout.NORTH);
		subBlock.add(eb, BorderLayout.CENTER);
// Add the panels to the frame
		mainFrame.add(ddm, layout.WEST);
		mainFrame.add(ua, layout.NORTH);
		mainFrame.add(subBlock, layout.CENTER);
// Set the visibility
		eb.hideComponents();
		mainFrame.setVisible(true);		
	}
	
/**
 * The actions for the four functional blocks are named and passed to the controller
 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Add User":
			control.assumeControl("ADD_USER");
			break;
		case "Delete User":
			control.assumeControl("DELETE_USER");
		    break;
		case "Add Account":
			control.assumeControl("ADD_ACCOUNT");
			break;
		case "Delete Account":
			control.assumeControl("DELETE_ACCOUNT");
			 break;
		case "Compose":
			control.assumeControl("COMPOSE");
			break;
		case "Send":
			control.assumeControl("SEND");
			break;
		case "Reply":
			control.assumeControl("REPLY");
//			break;
		case "Trash":
			control.assumeControl("TRASH");
//			break;
		default:
			System.out.println("Default debugging break");
			eb.hideComponents();
			System.out.println(e.getActionCommand());
			break;			
		}
		
	}
//*********************************************************************
//*********************************************************************
	
// All the functions hereafter are for the controller to interact with
// the four functional blocks through this GUI
	
//*********************************************************************
//*********************************************************************
	
	public void addUser(String newUserName) {
		ddm.addUser(newUserName);
	}
	
	public String getSelection() {
		return ddm.getSelection();
	}
	
	public int getPathLength() {
		return ddm.getPathLength();
	}
	
	public void deleteUser() {
		ddm.deleteUser();
	}
	
	public void addAccount(String accountName) {
		ddm.addAccount(accountName);
	}
	
	public void deleteAccount() {
		ddm.deleteAccount();
	}
	
	public void showEmailView() {
		eb.showComponents();
	}
	
	public void setComposer(String composer) {
		ddm.setComposer(composer);
	}
	
	public String getComposer() {
		return ddm.getComposer();
	}
	
	public String getEmailTitle() {
		return eb.getTitle();
	}
	
	public String getEmailRecipient() {
		return eb.getRecipient();
	}
	
	public void addEmail(String recipient, String title, int mailboxNumber) {
		ddm.addEmail(recipient, title, mailboxNumber);
	}
	
	public void hideEmailView() {
		eb.hideComponents();
	}
}
