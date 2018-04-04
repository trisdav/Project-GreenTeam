import java.sql.Timestamp;

/**
 * TrashBox inherits from EmailBox; any email removed from a TrashBox is permanently deleted
 * @author Lydia McGovern
 *
 */
public class TrashBox extends EmailBox {

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
}
