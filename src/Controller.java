import javax.swing.JOptionPane;

/**
 * 
 * @author Lydia McGovern
 *
 */
public class Controller {
	private View GUI;
	private SimpleEmailSystem ses;
	
/**
 * Construct a controller for the MVC Simple Email System model
 * @param v the View object, or GUI
 * @param m the Model, Simple Email System
 */
	Controller(View v, SimpleEmailSystem m) {
		GUI = v;
		ses = m;
	}

/**
 * The main control of the Simple Email System lies in this operation
 * @param action the command from the GUI to be processed
 */
	public void assumeControl(String action) {
		switch (action) {
		case "ADD_USER":
			String newUsername = JOptionPane.showInputDialog("Enter the username: ");
			GUI.addUser(newUsername);
			break;
		case "DELETE_USER":
			if (GUI.getSelection() != null && GUI.getPathLength() == 2) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + GUI.getSelection() + "?",
		    		"Confirm Delete", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
					break;
				}
				else {
					GUI.deleteUser();
				}
		    }
			break;
		case "ADD_ACCOUNT":
			if (GUI.getSelection() != null && GUI.getPathLength() == 3) {
				String newAccountName = JOptionPane.showInputDialog("Enter the account name: ");
				GUI.addAccount(newAccountName);
			}
			break;
		case "DELETE_ACCOUNT":
			if (GUI.getSelection() != null && GUI.getPathLength() == 4) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + GUI.getSelection() + "?",
		    		"Confirm Delete", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
					break;
				}
				else {
					GUI.deleteAccount();
				}
			}
			break;
		case "COMPOSE":
			GUI.showEmailView();
			String emailComposer = GUI.getSelection();
			GUI.setComposer(emailComposer);
			break;
		case "SEND":
			String emailTitle = GUI.getEmailTitle();
			String emailRecipient = GUI.getEmailRecipient();
			String emailSender = GUI.getComposer();
			GUI.addEmail(emailRecipient, emailTitle, 0);
			GUI.addEmail(emailSender, emailTitle, 1);
			GUI.hideEmailView();
			break;
		case "REPLY":
			break;
		case "TRASH":
			break;
		default:
			break;
		}
	}
}
