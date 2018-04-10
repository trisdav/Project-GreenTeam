import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is a functional block that contains 4 buttons, "Send", "Reply", "Compose", and "Trash"
 * @author Tristan Davis
 *
 */
public class ButtonBlock extends JPanel {
	private JButton compose;
	private JButton send;
	private JButton reply;
	private JButton trash;
/**
 * Constructs a ButtonBlock object with 4 buttons
 * @param the View object, or GUI, that contains this class
 */
	ButtonBlock(View v) {
// Initialize the four buttons
		compose = new JButton("Compose");
		send = new JButton("Send");
		reply = new JButton("Reply");
		trash = new JButton("Trash");

// Add action listeners to the buttons
		compose.addActionListener(v);
		send.addActionListener(v);
		reply.addActionListener(v);
		trash.addActionListener(v);
		
// Add the buttons to this panel
	    this.add(compose, BorderLayout.NORTH);
	    this.add(send, BorderLayout.NORTH);
	    this.add(reply, BorderLayout.NORTH);
	    this.add(trash, BorderLayout.NORTH);
	}
	
/**
 * Set the Compose button to be visible or invisible
 * @param i 0 for invisible, or 1 for visible
 */
	public void setComposeVisibility(int i) {
		if (i == 0)
			compose.setVisible(false);
		if (i == 1)
			compose.setVisible(true);
	}
	
/**
 * Set the Send button to be visible or invisible
 * @param i 0 for invisible, or 1 for visible
 */
	public void setSendVisibility(int i) {
		if (i == 0)
			send.setVisible(false);
		if (i ==1)
			send.setVisible(true);		
	}

/**
 * Set the Reply button to be visible or invisible
 * @param i 0 for invisible, or 1 for visible
 */
	public void setReplyVisibility(int i) {
		if (i == 0)
			reply.setVisible(false);
		if (i == 1)
			reply.setVisible(true);
	}
	
/**
 * Set the Trash button to be visible or invisible
 * @param i 0 for invisible, or 1 for visible
 */
	public void setTrashVisibility(int i) {
		if (i == 0)
			trash.setVisible(false);
		if (i == 1)
			trash.setVisible(true);
	}
}
