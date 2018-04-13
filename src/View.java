import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Skeleton class for View.java
 * 
 * @author Tristan Davis and Lydia McGovern
 */


public class View implements ActionListener {
// A GUI has a controller and 4 functional blocks
	private Controller control;
	private DropDownMenu ddm;
	private ButtonBlock bb;
	private UserAndAccountControl ua;
	private EmailBlock eb;
	private JFrame mainFrame;
	
/**
 * Constructor does nothing; the GUI is enabled when the run function is called
 */
	View() {}
	
/**
 * Runs the Simple Email System GUI with four functional blocks
 * @param c the controller
 */
	public void run(Controller c) {
		control = c;
// Set up the frame
		BorderLayout layout = new BorderLayout();
		mainFrame = new JFrame("Simple Email");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 615);
	//	mainFrame.setLayout(layout);
		int frameWidth = mainFrame.getWidth();
		int frameHeight = mainFrame.getHeight();
//Create a preferred dimension for ddm
		Dimension ddmDim = new Dimension(300, 800);
// Initialize the four functional blocks
		ddm = new DropDownMenu(this, ddmDim);
		ddm.setLayout(new GridLayout(0, 1));
		bb = new ButtonBlock(this);
		ua = new UserAndAccountControl(this);
		eb = new EmailBlock(frameWidth, frameHeight);
// Create a sub panel that contains the email and button blocks
		JPanel subBlock = new JPanel();
		subBlock.setLayout(new BoxLayout(subBlock, BoxLayout.Y_AXIS));
		bb.setMaximumSize(new Dimension(500, 50));
		eb.setMaximumSize(new Dimension(750, 750));
		subBlock.add(bb, BorderLayout.NORTH);
		subBlock.add(eb, BorderLayout.SOUTH);		
// Add the panels to the frame
		mainFrame.add(ddm, BorderLayout.WEST);
		mainFrame.setJMenuBar(ua);
		mainFrame.add(subBlock, BorderLayout.CENTER);
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
			if(eb.getTitle().compareTo("") != 0)
			{
				control.assumeControl("SEND");
			}
			else
			{
				JOptionPane.showMessageDialog(mainFrame,"Email must have a title.\n Please add a title.", null, 0);
			}
			
			break;
		case "Reply":
			control.assumeControl("REPLY");
			break;
		case "Trash":
			control.assumeControl("TRASH");
			break;
		case "emailSelected":
			control.assumeControl("READ_EMAIL");
			break;
		case "setLF":
			JMenuItem temp = (JMenuItem) e.getSource();
			try {
		            // Set cross-platform Java L&F (also called "Metal")
		       UIManager.setLookAndFeel(temp.getText());
		       SwingUtilities.updateComponentTreeUI(mainFrame);
			} 
		    catch (UnsupportedLookAndFeelException e1) {
		       // handle exception
		    }
		    catch (ClassNotFoundException e1) {
		       // handle exception
		    }
		    catch (InstantiationException e1) {
		       // handle exception
		    }
		    catch (IllegalAccessException e1) {
		       // handle exception
		    }
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
 * Returns the path length of the selected node; root = 1, user = 2, site = 3, account = 4, email box = 5, email = 6
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
	public void composeEmailView() {
		eb.composeEmailForm();
	}
	
/**
 * Display the email form for replying to an email
 * @param title the email title
 * @param composer the email composer
 */
	public void replyEmailView(String title, String composer) {
		eb.replyEmailForm(title, composer);
	}
	
/**
 * Set the email composer in the dropdown menu
 * @param composer the email composer
 */
	public void setComposer(String composer) {
		ddm.setComposer(composer);
	}
	
/**
 * Return the email composer from the dropdown menu
 * @return the email composer
 */
	public String getComposer() {
		return ddm.getComposer();
	}
	
/**
 * Return the email sender from the email form
 * @return the email sender
 */
	public String getSender() {
		return eb.getSender();
	}
	
/**
 * Return the email title of a newly-created email
 * @return the email title
 */
	public String getEmailTitle() {
		return eb.getTitle();
	}
	
/**
 * Return the account name of the email recipient of a newly-created email
 * @return the account name of the email recipient
 */
	public String getEmailRecipient() {
		return eb.getRecipient();
	}
	
/**
 * Return the email message of a newly-created email
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
	
/**
 * Returns the name of the user node that is selected or that is the user ancestor of a selected node	
 * @return the name of the user that is selected, or the user that possesses a site, account, email box, or email that is selected
 */
	public String getSelectedUser() {
		int length = ddm.getPathLength();
		if (length == 2)
			return ddm.getSelection();
		else if (length > 2 && length <= 6)
			return (ddm.getNthAncestor(length - 2));
		else
			return null;
	}
	
/**
 * Returns the name of the site node that is selected or that is a parent of a selected node	
 * @return the name of the site that is selected, or that possesses an account, email box, or email that is selected
 */
	public String getSelectedSite() {
		int length = ddm.getPathLength();
		if (length == 3)
			return ddm.getSelection();
		else if (length > 3 && length <= 6)
			return (ddm.getNthAncestor(length - 3));
		else
			return null;
	}
	
/**
 * Returns the name of the account node that is selected or that is a parent of a selected node	
 * @return the name of the account that is selected, or that possesses an email box or email that is selected
 */
	public String getSelectedAccount() {
		int length = ddm.getPathLength();
		if (length == 4)
			return ddm.getSelection();
		else if (length > 4 && length <= 6)
			return (ddm.getNthAncestor(length - 4));
		else
			return null;
	}
	
/**
 * Returns the name of the box node that is selected or that is a parent of a selected node	
 * @return the name of the email box that is selected or that possesses an email that is selected
 */
	public String getSelectedBox() {
		int length = ddm.getPathLength();
		if (length == 5)
			return ddm.getSelection();
		else if (length > 5 && length <= 6)
			return (ddm.getNthAncestor(length - 5));
		else
			return null;
	}
	
/**
 * Returns the name of the email title that is selected	
 * @return the email title that is selected
 */
	public String getSelectedTitle() {
		if (ddm.getPathLength() == 6)
			return ddm.getSelection();
		else
			return null;
	}
	
/**
 * Renders the email form with the contents of an email
 * @param sender the sender address of the email
 * @param recipient the recipient address of the email
 * @param title the title of the email
 * @param message the email message
 */
	public void readEmail(String sender, String recipient, String title, String message) {
		eb.readEmailForm(sender, recipient, title, message);
	}
	
/**
 * Return whether the form for composing emails is visible
 * @return true if the compose form is visible
 */
	public boolean isComposeFormVisible() {
		return eb.isComposeFormVisible();
	}
	
/**
 * Return whether the form for reading emails is visible
 * @return true if the read-email form is visible
 */
	public boolean isReadFormVisible() {
		return eb.isReadFormVisible();
	}
	
/**
 * Delete an email from the dropdown menu
 */
	public void deleteEmail() {
		ddm.deleteEmail();
	}
	
}
