import java.awt.*;

import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.tree.*;

/**
 * 
 * @author Lydia McGovern and Tristan Davis
 */
public class DropDownMenu extends JPanel {
	private JTree menuTree;
	private TreeModel menuModel;
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Users");
	private View GUI;
	private String composer;
	private DefaultMutableTreeNode tempNode;

/**
 * Constructor for the dropdown menu without dimensions
 * @param v the View object that contains this panel
 */
	DropDownMenu(View v)
	{
		menuModel = new DefaultTreeModel(root);
		menuTree = new JTree(menuModel);
		menuTree.setEditable(true);
		this.add(menuTree);
		GUI = v;
		composer = null;
		tempNode = null;
		testSet();
	}
	
/**
 * Constructor for the dropdown menu with specified dimensions
 * @param v the View object that contains this panel
 * @param d the dimensions of this panel
 */
	DropDownMenu(View v, Dimension d)
	{
		menuModel = new DefaultTreeModel(root);
		menuTree = new JTree(menuModel);
		menuTree.setPreferredSize(d);
		this.add(menuTree);
		GUI = v;
		composer = null;
		tempNode = null;
		testSet();
	}
	
	public void addUser(String userName)
	{
		DefaultMutableTreeNode newUserNode = new DefaultMutableTreeNode(userName);
		DefaultMutableTreeNode localNode = new DefaultMutableTreeNode("Local");
		DefaultMutableTreeNode remoteNode = new DefaultMutableTreeNode("Remote");
		newUserNode.add(localNode);
		newUserNode.add(remoteNode);
		root.add(newUserNode);
		((DefaultTreeModel) menuModel).reload(root);
	}
	
/**
 * Add an account to a user's site
 * @param accountName the name of the account to be added
 */
	public void addAccount(String accountName) {
// Only add the account if the selected node is a site
    	DefaultMutableTreeNode siteNode = (DefaultMutableTreeNode) menuTree.getLastSelectedPathComponent();
    	if(siteNode != null && getPathLength() == 3) {
// Create an account node with three mail boxes
    		DefaultMutableTreeNode newAccountNode = new DefaultMutableTreeNode(accountName);
    		DefaultMutableTreeNode inbox = new DefaultMutableTreeNode("Inbox");
    		DefaultMutableTreeNode sent = new DefaultMutableTreeNode("Sent");
    		DefaultMutableTreeNode trash = new DefaultMutableTreeNode("Trash");
    		newAccountNode.add(inbox);
    		newAccountNode.add(sent);
    		newAccountNode.add(trash);
// Add the account node to the site node and reload the tree
    		siteNode.add(newAccountNode);
    		((DefaultTreeModel) menuModel).reload(siteNode);
    	}		
	}
	
/**
 * Adds an email node to a mailbox node
 * @param account the account to receive the email
 * @param title the title of the email
 * @param mailboxNumber 0 for inbox, 1 for sent, 2 for trash
 */
	public void addEmail(String account, String title, int mailboxNumber) {
		DefaultMutableTreeNode newEmailNode = new DefaultMutableTreeNode(title);
		findAccountNode(account);
		if (tempNode != null) {
			TreeNode mailboxNode = ((TreeNode) tempNode).getChildAt(mailboxNumber);
			((DefaultMutableTreeNode) mailboxNode).add(newEmailNode);
			((DefaultTreeModel) menuModel).reload(mailboxNode);
		}
		tempNode = null;
	}

	private void findAccountNode(String name) {
// Set up the path from the root
		TreeNode rootNode = (TreeNode) root;
		TreePath path = new TreePath(rootNode);
		TreeNode parentNode = null;
// Iterate through the users
		for (int i = 0; i < rootNode.getChildCount(); i++) {
			TreeNode userNode = rootNode.getChildAt(i);
			System.out.println((String) ((DefaultMutableTreeNode)userNode).getUserObject());
// Iterate through the sites
				for (int j = 0; j < 2; j++) {
					TreeNode siteNode = userNode.getChildAt(j);
// Iterate through the accounts
					System.out.println("Number of Accounts: " + siteNode.getChildCount());
					for (int k = 0; k < siteNode.getChildCount(); k++) {
						TreeNode accountNode = siteNode.getChildAt(k);
// If the account name matches the argument name, set as the account name node
						System.out.println(((String) ((DefaultMutableTreeNode)accountNode).getUserObject()));
						if (((String) ((DefaultMutableTreeNode)accountNode).getUserObject()).equals(name)) {
							parentNode = accountNode;
						}
						if (parentNode != null)
							break;
					}
					if (parentNode != null)
						break;
				}
				if (parentNode != null)
					break;
			}
		if (parentNode != null)
			tempNode = (DefaultMutableTreeNode) parentNode;
	}
/**
 * Deletes a User from the Dropdown menu
 */
	public void deleteUser() {
// Call deleteNode if the selected node is a user
		if (getPathLength() == 2)
			deleteNode();
	}
	
/**
 * Deletes an account from the dropdown menu
 */
	public void deleteAccount() {
// Call deleteNode if the selected node is an account
		if (getPathLength() == 4)
			deleteNode();
	}
/**
 * Deletes an email from the dropdown menu	
 */
	public void deleteEmail() {
// Call deleteNode if the selected node is an email
		if (getPathLength() == 6)
			deleteNode();
	}
	
/**
 * This function will get the string representation of the currently selected node
 * in the jtree.
 * @return Returns a string that is the selected node.
 */
	public String getSelection()
	{	
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) menuTree.getLastSelectedPathComponent();		
		if (node != null) {		
			return ((String) node.getUserObject());
		}
		else
			return null;
	}

/**
 * Deletes a node from the tree
 */
	private void deleteNode() {
		DefaultTreeModel model = (DefaultTreeModel) (menuTree.getModel());
		TreePath[] paths = menuTree.getSelectionPaths();
		for (TreePath path : paths) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
			if (node.getParent() != null)
				model.removeNodeFromParent(node);
		}
	}
	
/**
 * Returns the path length of the selected node
 * @return the path length of the selected node
 */
	public int getPathLength() {
		if (menuTree.getSelectionPath().getPath() != null)
			return menuTree.getSelectionPath().getPath().length;
		else
			return 0;
	}
	
/**
 * Initialize some users with accounts for testing purposes
 */
	public void testSet() {
// Create 4 test users
		addUser("John");
		addUser("George");
		addUser("Paul");
		addUser("Ringo");
// Create an account for one of the users		
		DefaultMutableTreeNode localLennon = new DefaultMutableTreeNode("lennon.local");
		DefaultMutableTreeNode lennonInbox = new DefaultMutableTreeNode("Inbox");
		DefaultMutableTreeNode lennonSent = new DefaultMutableTreeNode("Sent");
		DefaultMutableTreeNode lennonTrash = new DefaultMutableTreeNode("Trash");
		localLennon.add(lennonInbox);
		localLennon.add(lennonSent);
		localLennon.add(lennonTrash);
		TreeNode johnNode = root.getChildAt(0);
		johnNode = johnNode.getChildAt(0);
		((DefaultMutableTreeNode) johnNode).add(localLennon);	
// Create an account for one of the users		
		DefaultMutableTreeNode remoteStarr = new DefaultMutableTreeNode("starr.remote");
		DefaultMutableTreeNode starrInbox = new DefaultMutableTreeNode("Inbox");
		DefaultMutableTreeNode starrSent = new DefaultMutableTreeNode("Sent");
		DefaultMutableTreeNode starrTrash = new DefaultMutableTreeNode("Trash");
		remoteStarr.add(starrInbox);
		remoteStarr.add(starrSent);
		remoteStarr.add(starrTrash);
		TreeNode ringoNode = root.getChildAt(3);
		ringoNode = ringoNode.getChildAt(1);
		((DefaultMutableTreeNode) ringoNode).add(remoteStarr);
	}

/**
 * set the composer of the email
 * @param emailComposer the composer of the email
 */
	public void setComposer(String emailComposer) {
		composer = emailComposer;
	}
	
/**
 * Return the email composer
 * @return the composer of the email
 */
	public String getComposer() {
		return composer;
	}
}
