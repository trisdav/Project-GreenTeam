import javax.swing.*;
/**
 * This is the functional block that allows users and accounts to be added and deleted
 * @author Lydia McGovern
 *
 */
public class UserAndAccountControl extends JPanel {
	
/**
 * Constructor class to create the menu
 * @param v the View object, or GUI, that contains this class
 */
	UserAndAccountControl(View v) {
// Create a menu bar with two menus
		JMenuBar menu = new JMenuBar();	
		JMenu usersMenu = new JMenu("Users");
		JMenu accountsMenu = new JMenu("Accounts");
// Create four menu items and add action listeners to them
		JMenuItem addUser = new JMenuItem("Add User");
		JMenuItem deleteUser = new JMenuItem("Delete User");
		JMenuItem addAccount = new JMenuItem("Add Account");
		JMenuItem deleteAccount = new JMenuItem("Delete Account");
		addUser.addActionListener(v);
		deleteUser.addActionListener(v);
		addAccount.addActionListener(v);
		deleteAccount.addActionListener(v);
//add the menu items to the appropriate menus
		usersMenu.add(addUser);
		usersMenu.add(deleteUser);
		accountsMenu.add(addAccount);
		accountsMenu.add(deleteAccount);		
// Add the menus to the menu bar
		menu.add(usersMenu);
		menu.add(accountsMenu);
// Add the menu bar to this panel
		this.add(menu);
	}
}