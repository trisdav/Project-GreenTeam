/*
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
*/
/**
 * This class is a JPanel with two text fields for an email title and recipient
 * and with a text pane for an actual email itself 
 * @author Alex Barr
 *
/*public class EmailBlock extends JPanel{
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
*/
/**
 * Gets the title
 * @return the title 
 */
/*	public String getTitle() {
		return titleField.getText();
	}
	
	/**
	 * Gets the recipient
	 * @return the recipient
	 */
/*	public String getRecipient() {
		return recipientField.getText();
	}
	
/**
 * Gets the sender	
 * @return the sender
 */
/*	public String getSender() {
		return senderField.getText();
	}
	
	/**
	 * Gets the text of the email
	 * @return the email text
	 */
/*	public String getEmailText() {
		return emailPane.getText();
	}
	
	/**
	 * Hides the two text fields and the text pane
	 */
/*	public void hideComponents() {
		titleField.setVisible(false);
		recipientField.setVisible(false);
		senderField.setVisible(false);
		emailPane.setVisible(false);
	}
	
	/**
	 * Shows the two text fields and the text pane and does nothing if they 
	 * aren't hidden in the first place 
	 */
/*	public void showComponents() {
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
/*	public void resetEmailForm() {
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
/*	public void readEmailForm(String sender, String recipient, String title, String message) {
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
/*	public boolean isComposeFormVisible() {
		return (titleField.isVisible() && recipientField.isVisible() && emailPane.isVisible() && senderField.isVisible() == false);
	}
	
/**
 * Returns whether the read-email form is visible
 * @return true if the read-email form is visible
 */
/*	public boolean isReadFormVisible() {
		return (titleField.isVisible() && recipientField.isVisible() && emailPane.isVisible() && senderField.isVisible());
	}

} */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * This class is a JPanel with three text fields for an email title, recipient,
 * and sender and with a text area for an actual email itself
 * 
 * @author Alex Barr
 */
public class EmailBlock extends JPanel
{
    private static final int WIDTH = 570;
    private static final int HEIGHT = 495;
    private JTextField titleField;
    private JTextField recipientField;
    private JTextField senderField;
    private JLabel titleLabel;
    private JLabel toLabel;
    private JLabel fromLabel;
    private JTextArea emailArea;
    private JScrollPane scrollPane;

    EmailBlock()
    {
	this.setLayout(new GridBagLayout());

	this.addComponents();

	this.resetEmailForm();
	this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    /**
     * Gets the title
     * 
     * @return the title
     */
    public String getTitle()
    {
	return titleField.getText();
    }

    /**
     * Gets the recipient
     * 
     * @return the recipient
     */
    public String getRecipient()
    {
	return recipientField.getText();
    }

    /**
     * Gets the sender
     * 
     * @return the sender
     */
    public String getSender()
    {
	return senderField.getText();
    }

    /**
     * Gets the text of the email
     * 
     * @return the email text
     */
    public String getEmailText()
    {
	return emailArea.getText();
    }

    /**
     * Hides the components of the EmailBlock
     */
    public void hideComponents()
    {
	for (Component c : this.getComponents())
	    c.setVisible(false);
    }

    /**
     * Shows the components of the EmailBlock aren't hidden in the first place
     */
    public void showComponents()
    {
	for (Component c : this.getComponents())
	    c.setVisible(true);
    }

    /**
     * Adds an AWT component to this JPanel with a GridBagLayout
     * 
     * @param component
     * @param x
     * @param y
     * @param width
     * @param height
     * @param align
     * @param weightx
     * @param weighty
     */
    private void addItem(Component component, int x, int y, int width,
	    int height, int align, double weightx, double weighty)
    {
	GridBagConstraints c = new GridBagConstraints();
	c.gridx = x;
	c.gridy = y;
	c.gridwidth = width;
	c.gridheight = height;
	c.weightx = weightx;
	c.weighty = weighty;
	c.anchor = align;
	c.fill = GridBagConstraints.HORIZONTAL;
	this.add(component, c);
    }

    /**
     * Shows the components except for the from label and sender text field
     */
    public void composeEmailForm()
    {
	this.removeComponents();
	this.addComponents();
	fromLabel.setVisible(false);
	senderField.setVisible(false);
    }

    public void replyEmailForm(String title, String origComposer)
    {
	this.removeComponents();
	this.addComponents();
	fromLabel.setVisible(false);
	senderField.setVisible(false);
	titleField.setText(title);
	recipientField.setText(origComposer);
    }

    /**
     * Resets the email form with default field labels
     */
    public void resetEmailForm()
    {
	titleField.setText("title");
	recipientField.setText("recipient");
	senderField.setText("sender");
	emailArea.setText("email");
    }

    /**
     * Fills out the email form with an email's contents
     * 
     * @param sender the email address of the sender
     * @param recipient the address of the recipient
     * @param title the title of the email
     * @param message the email message
     */
    public void readEmailForm(String sender, String recipient, String title,
	    String message)
    {
	this.removeComponents();
	this.addComponents();
	this.showComponents();
	titleField.setText(title);
	recipientField.setText(recipient);
	senderField.setText(sender);
	emailArea.setText(message);
	this.setReadOnly();
	this.updateUI();
    }

    /**
     * Returns whether the compose-email form is visible
     * 
     * @return true if the compose-email form is visible
     */
    public boolean isComposeFormVisible()
    {
	return (titleField.isVisible() && recipientField.isVisible()
		&& emailArea.isVisible() && !senderField.isVisible());
    }

    /**
     * Returns whether the read-email form is visible
     * 
     * @return true if the read-email form is visible
     */
    public boolean isReadFormVisible()
    {
	return (titleField.isVisible() && recipientField.isVisible()
		&& emailArea.isVisible() && senderField.isVisible());
    }

    /**
     * Sets the fields and area to be read-only and removes their borders
     */
    private void setReadOnly()
    {
	titleField.setEditable(false);
	recipientField.setEditable(false);
	senderField.setEditable(false);
	emailArea.setEditable(false);

	titleField.setBorder(BorderFactory.createEmptyBorder());
	recipientField.setBorder(BorderFactory.createEmptyBorder());
	senderField.setBorder(BorderFactory.createEmptyBorder());
	emailArea.setBorder(BorderFactory.createEmptyBorder());
    }

    /**
     * Removes every component in this JPanel
     */
    private void removeComponents()
    {
	for (Component c : this.getComponents())
	    this.remove(c);
    }

    /**
     * Adds the components to the JPanel
     */
    private void addComponents()
    {
	titleLabel = new JLabel("Title: ");
	this.addItem(titleLabel, 0, 0, 1, 1,
		GridBagConstraints.FIRST_LINE_START, 0.05, 0.0);

	titleField = new JTextField("Title");
	titleField.setBorder(BorderFactory.createLineBorder(Color.gray));
	this.addItem(titleField, 1, 0, 1, 1,
		GridBagConstraints.FIRST_LINE_START, 1.0, 0.0);

	toLabel = new JLabel("To: ");
	this.addItem(toLabel, 0, 1, 1, 1, GridBagConstraints.FIRST_LINE_START,
		0.05, 0.0);

	recipientField = new JTextField("Recipient");
	recipientField.setBorder(BorderFactory.createLineBorder(Color.gray));
	this.addItem(recipientField, 1, 1, 1, 1,
		GridBagConstraints.FIRST_LINE_START, 1.0, 0.0);

	fromLabel = new JLabel("From: ");
	this.addItem(fromLabel, 0, 2, 1, 1, GridBagConstraints.FIRST_LINE_START,
		0.05, 0.0);

	senderField = new JTextField("Sender");
	senderField.setBorder(BorderFactory.createLineBorder(Color.gray));
	this.addItem(senderField, 1, 2, 1, 1,
		GridBagConstraints.FIRST_LINE_START, 1.0, 0.0);

	emailArea = new JTextArea();
	emailArea.setBorder(BorderFactory.createLineBorder(Color.gray));
	emailArea.setLineWrap(true);
	emailArea.setWrapStyleWord(true);
	GridBagConstraints c = new GridBagConstraints();
	c.gridx = 0;
	c.gridy = 3;
	c.gridwidth = 2;
	c.weighty = 1.0;
	c.anchor = GridBagConstraints.FIRST_LINE_START;
	c.fill = GridBagConstraints.BOTH;

	scrollPane = new JScrollPane(emailArea);
	scrollPane.setPreferredSize(new Dimension(WIDTH,
		(int) scrollPane.getPreferredSize().getHeight()));
	this.add(scrollPane, c);
    }

}
