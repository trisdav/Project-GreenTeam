import javax.swing.JOptionPane;
/**
 * A box for creating an item (either an account or user)
 * @author Lydia McGovern
 *
 */
public class AddUnAPane {
	private String itemName; // The username or account name
	
/**
 * Construct an option pane that collects the name of the new user or account
 * @param itemType either account or user
 */
	AddUnAPane(String itemType) {
		String message = "Enter your " + itemType + " name";
		itemName = JOptionPane.showInputDialog(message);
	}
	
/**
 * Returns the new username or account name
 * @return the new username or acccount name
 */
	public String getItemName() {
		return itemName;
	}
}