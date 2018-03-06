import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Skeleton class for View.java
 * 
 * @author Lydia McGovern and Tristan Davis
 */


public class View implements ActionListener {
// A GUI has a controller and 4 functional blocks
	private Controller control;
	private DropDownMenu ddm;
	private ButtonBlock bb;
	private UserAndAccountControl ua;
	private EmailBlock eb;
	
/**
 * Constructs a GUI for the Simple Email System with four functional blocks
 * @param c the controller for the MVC application
 */
	View() {
		
	}
	
/**
 * Runs the Simple Email System GUI with four functional blocks
 * @param c the controller
 */
	public void run(Controller c) {
		control = c;
// Set up the frame
		BorderLayout layout = new BorderLayout();
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 615);
		mainFrame.setLayout(layout);
//Create a preferred dimension for ddm
		Dimension ddmDim = new Dimension( 200,550 );
// Initialize the four functional blocks
		ddm = new DropDownMenu(this, ddmDim);
		bb = new ButtonBlock(this);
		ua = new UserAndAccountControl(this);
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
			break;
		case "Trash":
			control.assumeControl("TRASH");
			break;
		case "emailSelected":
			System.out.println(e.getActionCommand());
			break;
		default:
			eb.hideComponents();
			break;			
		}
		
	}
//*********************************************************************
//*********************************************************************
	
// All the functions hereafter are for the controller to interact with
// the four functional blocks through this GUI
	
//*********************************************************************
//*********************************************************************
	
/**
 * Add a user to the dropdown menu
 * @param newUserName the username to add to the dropdown menu
 */
	public void addUser(String newUserName) {
		ddm.addUser(newUserName);
	}
	
/**
 * Returns the selected node from the dropdown menu
 * @return the selected node from the dropdown menu
 */
	public String getSelection() {
		return ddm.getSelection();
	}
	
/**
 * Returns the path length of the selected node
 * @return the path length of the selected node
 */
	public int getPathLength() {
		return ddm.getPathLength();
	}
	
/**
 * Deletes the selected user from the dropdown menu
 */
	public void deleteUser() {
		ddm.deleteUser();
	}
	
/**
 * Add an account to the dropdown menu
 * @param accountName the name of the account to be added to the dropdown menu
 */
	public void addAccount(String accountName) {
		ddm.addAccount(accountName);
	}
	
/**
 * Delete the selected account from the dropdown menu
 */
	public void deleteAccount() {
		ddm.deleteAccount();
	}
	
/**
 * Display the email form in the GUI frame
 */
	public void showEmailView() {
		eb.showComponents();
	}
	
/**
 * Set the email composer
 * @param composer the email composer
 */
	public void setComposer(String composer) {
		ddm.setComposer(composer);
	}
	
/**
 * Return the email composer
 * @return the email composer
 */
	public String getComposer() {
		return ddm.getComposer();
	}
	
/**
 * Return the email title
 * @return the email title
 */
	public String getEmailTitle() {
		return eb.getTitle();
	}
	
/**
 * Return the account name of the email recipient
 * @return the account name of the email recipient
 */
	public String getEmailRecipient() {
		return eb.getRecipient();
	}
	
/**
 * Return the email message
 * @return the email message
 */
	public String getEmailMessage() {
		return eb.getEmailText();
	}
	
/**
 * Add an email to the dropdown menu
 * @param account the name of the account the email will be added to
 * @param title the title of the email
 * @param mailboxNumber 0 for inbox, 1 for sent, 2 for trash
 */
	public void addEmail(String account, String title, int mailboxNumber) {
		ddm.addEmail(account, title, mailboxNumber);
	}
	
/**
 * Hide the email form from the GUI frame
 */
	public void hideEmailView() {
		eb.hideComponents();
	}
	
/**
 * Reset the default email form
 */
	public void resetEmailForm() {
		eb.resetEmailForm();
	}
}
