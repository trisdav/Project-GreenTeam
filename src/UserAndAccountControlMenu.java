import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the menu for adding and deleting items
 * @author Lydia McGovern
 *
 */
public class UserAndAccountControlMenu {
	private JMenu menu;
	private action a;
// An item (either an account name or a username) that is temporarily
	// stored in the block to be sent to the View for adding or deleting
	private String item;
	
/**
 * Constructor class for the menu item; allows for an item to be added and deleted
 * @param the type of menu, either user or account
 */
	UserAndAccountControlMenu(String itemType) {
// Initialize the variables
		menu = new JMenu(itemType);
		a = null;
		item = null;
		
// Create two menu items to add or delete
		String addMessage = "Add " + itemType;
		String deleteMessage = "Delete " + itemType;
		JMenuItem addItem = new JMenuItem(addMessage);
		JMenuItem deleteItem = new JMenuItem(deleteMessage);
		
// The ActionListener for the menu items
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "Add Account":
					String addAccountMessage = "Enter your account name";
					item = JOptionPane.showInputDialog(addAccountMessage);
					if (item != null) {
						a = action.CREATE_ACCOUNT;
					}
					break;
				case "Delete Account":
					String message = "Are you sure you want to delete this account?";
				    if (JOptionPane.showConfirmDialog(null, message, "Confirm Delete",
				            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				        a = action.DELETE_ACCOUNT;
				    }
					break;
				case "Add User":					
					String addUserMessage = "Enter your username";
					item = JOptionPane.showInputDialog(addUserMessage);
					if (item != null) {
						a = action.CREATE_ACCOUNT;
					}				
					break;
				case "Delete User":
					String deleteUserMessage = "Are you sure you want to delete this user?";
				    if (JOptionPane.showConfirmDialog(null, deleteUserMessage, "Confirm Delete",
				            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				        a = action.DELETE_ACCOUNT;
				    }
					a = action.DELETE_USER;
					break;
				default:
					break;
				}
			}
		};
		
// Add the ActionListener to the menu items and add to the menu
		addItem.addActionListener(listener);
		deleteItem.addActionListener(listener);
		menu.add(addItem);
		menu.add(deleteItem);	
	}
	
/**
 * Returns the Menu
 * @return the menu
 */
	public JMenu getMenu() {
		return menu;
	}
}