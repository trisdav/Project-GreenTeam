import java.sql.Timestamp;
/**
 * The email class is immutable
 * @author Lydia McGovern
 *
 */
public class Email {
	private String title;
	private String message;
	private String senderAddress;
	private String recipientAddress;
	private Timestamp sentTime;
	private String titleWithTimestamp;
	
/**
 * Constructor class for the email
 * @param title the title of the email
 * @param message the email message
 * @param sender the sender address
 * @param recipient the recipient address
 */
	Email(String title, String message, String sender, String recipient) {
		sentTime = new Timestamp(System.currentTimeMillis());
// If there is no title, replace it with the timestamp
		if (title == null) {
			this.title = sentTime.toString();
			this.titleWithTimestamp = " " + sentTime.toString();
		} else {
			this.title = title;
			this.titleWithTimestamp = title + " " + sentTime;
		}
		this.message = message;
		this.senderAddress = sender;
		this.recipientAddress = recipient;
	}

/**
 * Return the email title
 * @return the email title
 */
	public String getTitle() {
		return title;
	}
	
/**
 * Return the title concatenated with the timestamp
 * @return the title concatenated with the timestamp
 */
	public String getTitleWithTimestamp() {
		return titleWithTimestamp;
	}
	
/**
 * Return the email message
 * @return the email message
 */
	public String getMessage() {
		return message;
	}
	
/**
 * Return the sender address	
 * @return the sender address
 */
	public String getSenderAddress() {
		return senderAddress;
	}
	
/**
 * Return the recipient address	
 * @return the recipient address
 */
	public String getRecipientAddress() {
		return recipientAddress;
	}
	
/**
 * Return the time the email was sent
 * @return the sent time
 */
	public Timestamp getSentTime() {
		return sentTime;
	}
}
