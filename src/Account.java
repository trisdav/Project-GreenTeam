import java.sql.Timestamp;

/**
 * An email Account with an email address and three email boxes
 * @author Lydia McGovern
 *
 */
public class Account {
	private String address;
	private EmailBox inbox;
	private EmailBox sent;
	private EmailBox trash;
	
/**
 * Construct an email account
 * @param address the account address
 */
	Account(String address) {
		this.address = address;
		inbox = new EmailBox();
		sent = new EmailBox();
		trash = new EmailBox();
	}
	
/**
 * Add an email to one of the accounts
 * @param e the email to be sent
 * @param the email box to place the email into; 0 for inbox, 1 for sent, 2 for trash
 * @return true if the email is added
 */
	public boolean addEmail(Email e, int box) {
		if (box == 0)
			return (inbox.addEmail(e));
		else if (box == 1)
			return (sent.addEmail(e));
		else if (box == 2)
			return (trash.addEmail(e));
		else		
			return false;
	}
	
/**
 * Finds and removes an email from one of the accounts
 * @param time the timeStamp of the email to be deleted
 * @param the email box to remove the email from; 0 for inbox, 1 for sent, 2 for trash
 * @return true if the email is removed
 */
	public boolean removeEmail(String box, String title) {
// If the email is in the inbox or sent box, move the email to the trash box before deleting
// Else if the email is in the trash box, permanently delete
		if (box.equals("inbox")) {
			if (trash.addEmail(inbox.getEmail(title)))
				return (inbox.removeEmail(title));
			else
				return false;
		} else if (box.equals("sent")) {
			if (trash.addEmail(inbox.getEmail(title)))
				return (sent.removeEmail(title));
			else
				return false;
		} else if (box.equals("trash")) {
			return (trash.removeEmail(title));
		} else		
			return false;
	}
	
	public Email retrieveEmail(String box, String title) {
		if (box == "inbox")
			return inbox.retrieveEmail(title);
		else if (box == "sent")
			return sent.retrieveEmail(title);
		else if (box == "trash")
			return trash.retrieveEmail(title);
		else
			return null;
	}
	
/**
 * Return the email address
 * @return the email address
 */
	public String getAddress() {
		return address;
	}
	
}
