import javax.swing.JOptionPane;

/**
 * 
 * @author Lydia McGovern
 *
 */
public class Controller {
	private View GUI;
	private Model simpleEmailSystem;
	
/**
 * Construct a controller for the MVC Simple Email System model
 * @param v the View object, or GUI
 * @param m the Model, Simple Email System
 */
	Controller(View v, Model m) {
		GUI = v;
		simpleEmailSystem = m;
	}

/**
 * The main control of the Simple Email System lies in this operation
 * @param action the command from the GUI to be processed
 */
	public void assumeControl(String action) {
		switch (action) {
		case "ADD_USER":
// Prompt the user for the name
			String newUsername = JOptionPane.showInputDialog("Enter the username: ");
// Add the user
			if (newUsername != null && simpleEmailSystem.addUser(newUsername))
				GUI.addUser(newUsername);
			break;
		case "DELETE_USER":
// Ensure a user has been selected
			if (GUI.getSelectedUser() != null && GUI.getPathLength() == 2) {
// Confirm delete
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + GUI.getSelection() + "?",
		    		"Confirm Delete", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
					break;
				}
				else {
// Delete the selected user
					String user = GUI.getSelectedUser();
					if (simpleEmailSystem.deleteUser(user))
						GUI.deleteUser();
				}
		    }
			break;
		case "ADD_ACCOUNT":
// Ensure a site has been selected
			if (GUI.getSelectedSite() != null && GUI.getPathLength() == 3) {
// Prompt the user for the name
				String newAccountName = JOptionPane.showInputDialog("Enter the account name: ");
				newAccountName.trim();
// Ensure an account name has been chosen
				if (newAccountName != null && newAccountName != "") {
					String user = GUI.getSelectedUser();
					String site = GUI.getSelectedSite();
// Add to the simple email system and the GUI
					if (simpleEmailSystem.addAccount(user, site, newAccountName) == true);
						GUI.addAccount(newAccountName);					
				}
			}
			break;
		case "DELETE_ACCOUNT":
// Ensure an account is selected
			if (GUI.getSelectedAccount() != null && GUI.getPathLength() == 4) {
// Confirm delete
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + GUI.getSelection() + "?",
		    		"Confirm Delete", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
					break;
				}
				else {
// Delete the account from the simple email system and the GUI
					String user = GUI.getSelectedUser();
					String site = GUI.getSelectedSite();
					String account = GUI.getSelectedAccount();
					if (simpleEmailSystem.deleteAccount(user, site, account))
						GUI.deleteAccount();
				}
			}
			break;
		case "COMPOSE":
// Ensure an account is clicked on before offering the email form
			if (GUI.getPathLength() == 4) {
				String emailComposer = GUI.getSelectedAccount();				
				GUI.setComposer(emailComposer);			
				GUI.composeEmailView();
			}
			break;
		case "SEND":
// Only send an email if the form is up
			if (GUI.isComposeFormVisible()) {
// Get the email components
				String title = GUI.getEmailTitle();
				String message = GUI.getEmailMessage();
				String recipient = GUI.getEmailRecipient();
				String sender = GUI.getComposer();
// Update the Data Structure with the new email
				if (simpleEmailSystem.sendEmail(title, message, sender, recipient) == true) {
// Update the GUI with the new email
					GUI.addEmail(recipient, title, 0);
					GUI.addEmail(sender, title, 1);
					GUI.hideEmailView();
					GUI.resetEmailForm();
				}
			}
			break;
		case "REPLY":
			break;
		case "TRASH":
			break;
		case "READ_EMAIL":
// Get the components of the email
			String user = GUI.getSelectedUser();
			String site = GUI.getSelectedSite();
			String account = GUI.getSelectedAccount();
			String box = GUI.getSelectedBox();
			String title = GUI.getSelectedTitle();
// Retrieve the email and disassemble
			Email e = simpleEmailSystem.retrieveEmail(user, site, account, box, title);
			String reSender = e.getSenderAddress();
			String reRecipient = e.getRecipientAddress();
			String reTitle = e.getTitle();
			String reMessage = e.getMessage();
// Render the email
			GUI.readEmail(reSender, reRecipient, reTitle, reMessage);			
			break;
		default:
			break;
		}
	}
}
