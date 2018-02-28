import javax.swing.*;
/**
 * This is the functional block that allows users and accounts to be added and deleted
 * @author Lydia McGovern
 *
 */
public class UserAndAccountControl {
	private JPanel block;
	
	UserAndAccountControl() {
		block = new JPanel();
		JMenuBar menu = new JMenuBar();
		
		UserAndAccountControlMenu usersMenu = new UserAndAccountControlMenu("User");
		UserAndAccountControlMenu accountsMenu = new UserAndAccountControlMenu("Account");
		
		menu.add(usersMenu.getMenu());
		menu.add(accountsMenu.getMenu());
		block.add(menu);
	}
	
	public JPanel getUserAndAccountControl() {
		return block;
	}
}
