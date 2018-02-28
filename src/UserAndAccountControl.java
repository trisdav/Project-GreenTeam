import javax.swing.*;
/**
 * This is the functional block that allows users and accounts to be added and deleted
 * It uses the UnAMenu class, which was originally broken into two separate
 * 		classes for the accounts and menus
 * @author Lydia McGovern
 *
 */
public class UserAndAccountControl {
	private JPanel block;
	
	UserAndAccountControl() {
		block = new JPanel();
		JMenuBar menu = new JMenuBar();
		
		UnAMenu usersMenu = new UnAMenu("User");
		UnAMenu accountsMenu = new UnAMenu("Account");
		
		menu.add(usersMenu.getMenu());
		menu.add(accountsMenu.getMenu());
		block.add(menu);
	}
	
	public JPanel getUserAndAccountControl() {
		return block;
	}
}
