import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the menu for adding and deleting items
 * This class uses the AddUnAPane, which was originally designed as 
 * 		two separate classes for the accounts and menus
 * @author Lydia McGovern
 *
 */
public class UnAMenu {
	private JMenu menu;
	private action a;
// An item (either an account name or a username) that is temporarily
	// stored in the block to be sent to the View
	private String item;
	
/**
 * Constructor class for the menu item; allows for an item to be added and deleted
 * @param the type of menu, either user or account
 */
	UnAMenu(String itemType) {
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
					AddUnAPane accountsPane = new AddUnAPane("account");
					setItem(accountsPane.getItemName());
					a = action.CREATE_ACCOUNT;
					break;
				case "Delete Account":
					a = action.DELETE_ACCOUNT;
					break;
				case "Add User":
					AddUnAPane usersPane = new AddUnAPane("user");
					setItem(usersPane.getItemName());
					a = action.CREATE_USER;
					break;
				case "Delete User":
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
	
/**
 * Sets the action to be performed, either to add or delete an item type (user or account)
 * Currently a private function, which could possibly change
 * @param newAction the action to be performed
 */
	private void setAction(action newAction) {
		a = newAction;
	}
	
/**
 * Sets the item variable to be temporarily stored
 * Currently a private function, which could possibly change
 * @param itemName the particular username or account name to be added
 */
	private void setItem(String itemName) {
		item = itemName;
	}
	
}