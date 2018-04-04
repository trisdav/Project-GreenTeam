import java.util.*;
import java.sql.Timestamp;
/**
 * An email box with a list of emails
 * @author Lydia McGovern
 *
 */
public class EmailBox {

	protected ArrayList<Email> emailList;
	
/**
 * Construct an email box
 */
	EmailBox() {
		emailList = new ArrayList<Email>();
	}
	
/**
 * Add an email to the email box
 * @param e the email to be added
 * @return true if the email is added
 */
	public boolean addEmail(Email e) {
		emailList.add(e);
		return true;
	}
	
/**
 * Remove an email from the email box
 * @param time the time the email was sent
 * @return true if the email is found and removed
 */
	public boolean removeEmail(Timestamp time) {
		for (Email e : emailList) {
			if (e.getSentTime() == time) {
				emailList.remove(e);
				return true;
			}
		}
		return false;
	}
	
	public Email retrieveEmail(String title) {
		for (Email e : emailList) {
			if (e.getTitle() == title) 
				return e;
		}
		return null;
	}
	
/**
 * Finds and returns an email by its timestamp
 * @param time the timestamp of the email
 * @return the email
 */
	public Email getEmail(Timestamp time) {
		for (int i = 0; i < emailList.size(); i++) {
			if (emailList.get(i).getSentTime() == time) {
				return emailList.get(i);
			}
		}
		return null;
	}

}
