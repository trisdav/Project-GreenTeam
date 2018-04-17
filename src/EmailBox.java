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
				if (e.getTitleWithTimestamp() != null) {
					String emailTitle = e.getTitleWithTimestamp();
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
 * @param titleWithTimestamp the title of the email concatenated with the time the email was sent
 * @return the email being searched for
 */
	public Email retrieveEmail(String titleWithTimestamp) {
		if (emailList.isEmpty())
			return null;
		for (Email e : emailList) {
			String emailTitle = e.getTitleWithTimestamp(); //e.getTitle() + " " + e.getSentTime();
			if (emailTitle.equals(titleWithTimestamp)) 
				return e;
		}
		return null;
	}
}
