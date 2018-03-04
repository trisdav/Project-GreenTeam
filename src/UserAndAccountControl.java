import javax.swing.*;
/**
 * This is the functional block that allows users and accounts to be added and deleted
 * @author Lydia McGovern
 *
 */
public class UserAndAccountControl extends JPanel {
// The Menu variables
	private JMenuBar menu;
	private JMenu usersMenu;
	private JMenu accountsMenu;
	private JMenuItem addUser;
	private JMenuItem deleteUser;
	private JMenuItem addAccount;
	private JMenuItem deleteAccount;
	
/**
 * Constructor class to create the menu
 * @param v the View object, or GUI, that contains this class
 */
	UserAndAccountControl(View v) {
// Initialize a menu bar with two menus
		menu = new JMenuBar();	
		usersMenu = new JMenu("Users");
		accountsMenu = new JMenu("Accounts");
// Initialize the four menu items and add action listeners to them
		addUser = new JMenuItem("Add User");
		deleteUser = new JMenuItem("Delete User");
		addAccount = new JMenuItem("Add Account");
		deleteAccount = new JMenuItem("Delete Account");
		addUser.addActionListener(v);
		deleteUser.addActionListener(v);
		addAccount.addActionListener(v);
		deleteAccount.addActionListener(v);
// Add the menu items to the appropriate menus
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