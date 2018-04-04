
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

/**
 * This class is a JPanel with two text fields for an email title and recipient
 * and with a text pane for an actual email itself 
 * @author Alex Barr
 */
public class EmailBlock extends JPanel{
	private JTextField titleField;
	private JTextField recipientField;
	private JTextField senderField;
	private JTextPane emailPane;
	private View GUI;
	
	EmailBlock(View v) { 
		GUI = v;
		Dimension blockSize = new Dimension(570, 250);
		Dimension fieldSize;
		titleField = new JTextField();
		recipientField = new JTextField();
		senderField = new JTextField();
		emailPane = new JTextPane();
		fieldSize = new Dimension((int) blockSize.getWidth(), 
				(int) titleField.getPreferredSize().getHeight());
		
		//Configure emailBlock
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(blockSize);
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Configure titleField
		titleField.setMinimumSize(fieldSize);
		titleField.setMaximumSize(fieldSize);
		titleField.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Configure recipientField
		recipientField.setMinimumSize(fieldSize);
		recipientField.setMaximumSize(fieldSize);
		recipientField.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Configure senderField
		senderField.setMinimumSize(fieldSize);
		senderField.setMaximumSize(fieldSize);
		senderField.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Configure emailPane
		emailPane.setBorder(BorderFactory.createLineBorder(Color.gray));
		resetEmailForm();
		
		//Add fields and pane
		this.add(titleField, BorderLayout.NORTH);
		this.add(recipientField, BorderLayout.CENTER);
		this.add(senderField, BorderLayout.CENTER);
		this.add(emailPane, BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the title
	 * @return the title 
	 */
	public String getTitle() {
		return titleField.getText();
	}
	
	/**
	 * Gets the recipient
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipientField.getText();
	}
	
/**
 * Gets the sender	
 * @return the sender
 */
	public String getSender() {
		return senderField.getText();
	}
	
	/**
	 * Gets the text of the email
	 * @return the email text
	 */
	public String getEmailText() {
		return emailPane.getText();
	}
	
	/**
	 * Hides the two text fields and the text pane
	 */
	public void hideComponents() {
		titleField.setVisible(false);
		recipientField.setVisible(false);
		senderField.setVisible(false);
		emailPane.setVisible(false);
	}
	
	/**
	 * Shows the two text fields and the text pane and does nothing if they 
	 * aren't hidden in the first place 
	 */
	public void showComponents() {
		titleField.setVisible(true);
		recipientField.setVisible(true);
		senderField.setVisible(true);
		emailPane.setVisible(true);
	}
	
	public void composeEmailForm() {
		showComponents();
		senderField.setVisible(false);
	}
	
/**
 * Resets the email form with default field labels
 */
	public void resetEmailForm() {
		titleField.setText("title");
		recipientField.setText("recipient");
		senderField.setText("sender");
		emailPane.setText("email");
	}
	
/**
 * Fills out the email form with an email's contents
 * @param sender the email address of the sender
 * @param recipient the address of the recipient
 * @param title the title of the email
 * @param message the email message
 */
	public void readEmailForm(String sender, String recipient, String title, String message) {
		showComponents();
		titleField.setText(title);
		recipientField.setText(recipient);
		senderField.setText(sender);
		emailPane.setText(message);
	}
	
/**
 * Returns whether the compose-email form is visible
 * @return true if the compose-email form is visible
 */
	public boolean isComposeFormVisible() {
		return (titleField.isVisible() && recipientField.isVisible() && emailPane.isVisible());
	}
	
/**
 * Returns whether the read-email form is visible
 * @return true if the read-email form is visible
 */
	public boolean isReadFormVisible() {
		return (isComposeFormVisible() && senderField.isVisible());
	}

}
