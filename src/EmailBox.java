import java.util.ArrayList;
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
 * @param title the title of the email concatenated with the time the email was sent
 * @return true if the email is found and removed
 */
	public boolean removeEmail(String title) {
		if (title == null)
			return false;
		if (!emailList.isEmpty()) {
			for (Email e : emailList) {
				if (e.getTitle() != null && e.getSentTime() != null) {
					String emailTitle = e.getTitle() + " " + e.getSentTime();
					if (emailTitle.equals(title)) {
						emailList.remove(e);
						return true;
					}
				}
			}
		}
		return false;
	}
	
/**
 * Retrieve an email from the emailbox
 * @param title the title of the email concatenated with the time the email was sent
 * @return the email being searched for
 */
	public Email retrieveEmail(String title) {
		if (emailList.isEmpty())
			return null;
		for (Email e : emailList) {
			String emailTitle = e.getTitle() + " " + e.getSentTime();
			if (emailTitle.equals(title)) 
				return e;
		}
		return null;
	}
}
