import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is a functional block that contains 4 buttons, "Send", "Reply", "Compose", and "Trash"
 * @author Tristan Davis and Lydia McGovern
 *
 */
public class ButtonBlock extends JPanel {

/**
 * Constructs a ButtonBlock object with 4 buttons
 * @param the View object, or GUI, that contains this class
 */
	ButtonBlock(View v) {
// Create four buttons
		JButton compose = new JButton("Compose");
		JButton send = new JButton("Send");
		JButton reply = new JButton("Reply");
		JButton trash = new JButton("Trash");

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

}
