import java.awt.Dimension;

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
	DropDownMenu(Dimension d)
	{
		theModel = new DefaultTreeModel(root);
		theTree = new JTree(theModel);
		theTree.setPreferredSize(d);
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
    	DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(accountName);
	    DefaultMutableTreeNode node = (DefaultMutableTreeNode) theTree.getLastSelectedPathComponent();

    	if(node != null)
    	{
    		if(location == "local")
    		{
    			node = node.getFirstLeaf();
    			node.add(newNode);
    	    	theTree.updateUI(); //Notify UI that a change has happened in the tree.
    		}
    		else if(location == "remote")
    		{
    			node = node.getLastLeaf();
    			node.add(newNode);	
    	    	theTree.updateUI(); //Notify UI that a change has happened in the tree.
    		}
    		else
    		{
    			//Unknown location
    		}
    	}
    	else
    	{
    		//Node is null
    	}
		
	}
	
	public void addEmail(String user, String account, String email)
	{
		//find user
		//find account
		//add email
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
	/**
	 * This function will get the string representation of the currently selected node
	 * in the jtree.
	 * @return Returns a string that is the selected node.
	 */
	public String getSelection()
	{
	    DefaultMutableTreeNode node = (DefaultMutableTreeNode) theTree.getLastSelectedPathComponent();
		return ((String) node.getUserObject());
	}

}
