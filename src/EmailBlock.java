
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
	private JTextPane emailPane;
	
	EmailBlock() { 
		Dimension blockSize = new Dimension(570, 250);
		Dimension fieldSize;
		titleField = new JTextField();
		recipientField = new JTextField();
		emailPane = new JTextPane();
		fieldSize = new Dimension((int) blockSize.getWidth(), 
				(int) titleField.getPreferredSize().getHeight());
		
		//Configure emailBlock
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(blockSize);
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Configure titleField
		titleField.setText("title");
		titleField.setMinimumSize(fieldSize);
		titleField.setMaximumSize(fieldSize);
		titleField.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Confifure recipientField
		recipientField.setText("recipient");
		recipientField.setMinimumSize(fieldSize);
		recipientField.setMaximumSize(fieldSize);
		recipientField.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Configure emailPane
		emailPane.setText("email");
		emailPane.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Add fields and pane
		this.add(titleField, BorderLayout.NORTH);
		this.add(recipientField, BorderLayout.CENTER);
		this.add(emailPane, BorderLayout.CENTER);
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
		emailPane.setVisible(false);
	}
	
	/**
	 * Shows the two text fields and the text pane and does nothing if they 
	 * aren't hidden in the first place 
	 */
	public void showComponents() {
		titleField.setVisible(true);
		recipientField.setVisible(true);
		emailPane.setVisible(true);
	}

}
