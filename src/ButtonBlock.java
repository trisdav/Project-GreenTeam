import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Lydia McGovern
 *
 */
public class ButtonBlock {
	private JPanel block;
	private JButton compose;
	private JButton send;
	private JButton reply;
	private JButton trash;
	private action a;

/**
 * Constructs a ButtonBlock object with 4 buttons
 * TO DO: Fix notify so that the action is redirected to GUI
 */
	public ButtonBlock() {
		block = new JPanel();
		compose = new JButton("Compose");
		send = new JButton("Send");
		reply = new JButton("Reply");
		trash = new JButton("Trash");
		a = null;
	    
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action tempAction;
				switch (e.getActionCommand()) {
				case "Compose":
					tempAction = action.COMPOSE;
					break;
				case "Send":
					tempAction = action.SEND;
					break;
				case "Reply":
					tempAction = action.REPLY;
					break;
				case "Trash":
					tempAction = action.TRASH;
				default:
					tempAction = null;
					break;
				}
				
				setAction(tempAction);
// Notify the GUI of the action, then reset a to null				
				notify();
				a = null;
			}
		};
		
		compose.addActionListener(listener);
		send.addActionListener(listener);
		reply.addActionListener(listener);
		trash.addActionListener(listener);
		
		
	    block.add(compose);
	    block.add(send);
	    block.add(reply);
	    block.add(trash);
	}
	
	public JPanel getButtonBlock() {
		return block;
	}
	
	private void setAction(action newAction) {
		a = newAction;
	}
}
