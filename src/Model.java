import java.util.*;
/**
 * The simple email system model
 * @author Lydia McGovern
 *
 */
public class Model {
	private ArrayList<EmailUser> userList;
	
/**
 * Constructor for the model
 */
	Model() {
		userList = new ArrayList<EmailUser>();
	}
	
/**
 * Add a user to the email system if the username isn't taken
 * @param username the new username
 * @return true if the user was successfully added
 */
	public boolean addUser(String username) {
		boolean isAvailable = true;
		for (EmailUser u : userList) {
			if (u.getName().equals(username)) {
				isAvailable = false;
				break;
			}
		}
		if (isAvailable) {
			userList.add(new EmailUser(username));
		}
		return isAvailable;
	}
	
/**
 * Deletes a user from the email system if it exists
 * @param username the username of the user to be deleted
 * @return true if the delete was successful
 */
	public boolean deleteUser(String username) {
		boolean isValidUser = false;
		for (EmailUser u : userList) {
			if (u.getName().equals(username)) {
				isValidUser = true;
				userList.remove(u);
				break;
			}
		}
		return isValidUser;
	}	
	
/**
 * Adds an account to a user's local or remote site if the account name isn't already taken
 * @param user the user who owns the new account
 * @param site "local" or "remote" site the account is to be added to
 * @param account the new account name
 * @return
 */
	public boolean addAccount(String user, String site, String account) {
		boolean isAvailable = true;
		for (EmailUser u : userList) {
			if (u.getName().equals(user)) {
				isAvailable = false;
				break;
			}
		}
		if (isAvailable) {
			for (EmailUser u : userList) {
				if (!(u.getName().equals(user)))
					continue;
				else {
					if (site.equals("local"))
						u.addLocalAccount(account);
					else
						u.addRemoteAccount(account);
					break;
				}
			}
		}
		return isAvailable;
	}

/**
 * Delete an account from the email system if it exists	
 * @param user the name of the user whose account is being deleted
 * @param site the site, "local" or "remote" the account is being deleted from
 * @param account the email address of the account to be deleted
 * @return
 */
	public boolean deleteAccount(String user, String site, String account) {
		boolean isDeleted = false;
// Find the appropriate user
		for (EmailUser u : userList) {
// Delete the account from the appropriate site
			if (u.getName().equals(user)) {
				if (site.equals("local")) {
					u.deleteLocalAccount(account);
					isDeleted = true;
				}
				else if (site.equals("remote")) {
					u.deleteRemoteAccount(account);
					isDeleted = true;
				}
				break;				
			}
		}
		return isDeleted;
	}
	
/**
 * Send an email to the inbox of a recipient, then place the email in the sent box of the sender
 * @param title the email's title
 * @param message the email message
 * @param sender the sender address
 * @param recipient the recipient address
 * @return true if the the email was successfully sent
 */
	public boolean sendEmail(String title, String message, String sender, String recipient) {
		Email e = new Email(title, message, sender, recipient);
		boolean sent = false;
		
// Send the email to the recipient's inbox
// Check all users
		for (EmailUser r : userList) {
// Check each local site
			for (Account a : r.localSite) {
// Send the email if the account is found, and update sent flag
				if (a.getAddress().equals(recipient)) {
					a.addEmail(e, 0);
					sent = true;
					break;
				}				
			}
// Repeat for remote site if the account wasn't local
			if (!sent) {
				for (Account a : r.remoteSite) {
					if (a.getAddress().equals(recipient)) {
						a.addEmail(e, 0);
						sent = true;
						break;
					}
				}
			}
// If the account was found and the email was sent, place the email into the sender's sent box
			if (sent) {
				boolean sent2 = false;
				for (EmailUser s : userList) {
// Check each local site
					for (Account a : s.localSite) {
// Send the email if the account is found, and update sent flag
						if (a.getAddress().equals(sender)) {
							a.addEmail(e, 1);
							sent2 = true;
							break;
						}				
					}
// Repeat for remote site if the account wasn't local
					if (!sent2) {
						for (Account a : s.remoteSite) {
							if (a.getAddress().equals(sender)) {
								a.addEmail(e, 0);
								sent2 = true;
								break;
							}
						}
					}
// Don't check the other users for the sender's address
					if (sent2)
						break;			
		}				
// Don't check the other users for the recipient's address				
				break;
			}
		}
// Verify whether the email was sent		
		return sent;
	}
	
/**
 * Return an email from the email system
 * @param user the name of the user who possesses the email
 * @param site the name of the site that possesses the email
 * @param account the name of the account that possesses the email
 * @param box the name of the box that possesses the email
 * @param title the title of the email
 * @return the selected email
 */
	public Email retrieveEmail(String user, String site, String account, String box, String title) {
		for (EmailUser u : userList) {
			if (u.getName() == user) {
				return u.retrieveEmail(site, account, box, title);
			}
		}
		return null;
	}
}
