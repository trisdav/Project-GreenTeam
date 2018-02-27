import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

/**
 * 
 * @author Tristan Davis
 *
 */
public class DropDownMenu extends JPanel {
	JTree theTree;
	TreeModel theModel;
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Users");
	DropDownMenu()
	{
		theModel = new DefaultTreeModel(root);
		theTree = new JTree(theModel);
		this.add(theTree);
	}
	
	public void addUser(String userName)
	{
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(userName);
		DefaultMutableTreeNode localNode = new DefaultMutableTreeNode("Local");
		DefaultMutableTreeNode remoteNode = new DefaultMutableTreeNode("Remote");
		newNode.add(localNode);
		newNode.add(remoteNode);
		root.add(newNode);

	}
	
	public void addAccount(String accountName, String location)
	{
		if(location == "Local")
		{
			
		}
		else if(location == "Remote")
		{
			
		}
		else
		{
			//Unkown locale
		}
		
	}
	
	public void addEmail()
	{
	
	}

	public void deleteUser()
	{
		
	}
	
	public void deleteAccount()
	{
		
	}
	
	public void deleteEmail()
	{
		
	}
}
