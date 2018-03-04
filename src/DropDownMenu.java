import java.awt.*;

import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.tree.*;

/**
 * 
 * @author Tristan Davis
 * edited by Lydia McGovern
 */
public class DropDownMenu extends JPanel {
	private JTree theTree;
	private TreeModel theModel;
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Users");
	private View gui;
	private String composer;
	private DefaultMutableTreeNode tempComposerNode;
	private DefaultMutableTreeNode tempRecipientNode;
	
/**
 * Constructor for the dropdown menu without dimensions
 * @param v the View object that contains this panel
 */
	DropDownMenu(View v)
	{
		theModel = new DefaultTreeModel(root);
//		theModel.addTreeModelListener(new TreeModelListener);
		theTree = new JTree(theModel);
		theTree.setEditable(true);
		this.add(theTree);
		gui = v;
		composer = null;
		tempComposerNode = null;
		tempRecipientNode = null;
		testSet();
	}
	
/**
 * Constructor for the dropdown menu with specified dimensions
 * @param v the View object that contains this panel
 * @param d the dimensions of this panel
 */
	DropDownMenu(View v, Dimension d)
	{
		theModel = new DefaultTreeModel(root);
		theTree = new JTree(theModel);
		theTree.setPreferredSize(d);
		this.add(theTree);
		gui = v;
		composer = null;
		tempComposerNode = null;
		tempRecipientNode = null;
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
		((DefaultTreeModel) theModel).reload(root);

	}
	
/**
 * Add an account to a user's site
 * @param accountName the name of the account to be added
 */
	public void addAccount(String accountName) {
// Only add the account if the selected node is a site
    	DefaultMutableTreeNode siteNode = (DefaultMutableTreeNode) theTree.getLastSelectedPathComponent();

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
    		((DefaultTreeModel) theModel).reload(siteNode);
    	}		
	}
	
/**
 * Adds an email node to a mailbox node
 * @param user
 * @param account
 * @param title
 * @param mailboxNumber 0 for inbox, 1 for sent, 2 for trash
 */
	public void addEmail(/*String user,*/String account, String title, int mailboxNumber) {
		System.out.println("addEmail has been called");	
		DefaultMutableTreeNode newEmailNode = new DefaultMutableTreeNode(title);
		findTreeNode(account);
		if (tempComposerNode != null) {
//		if (tempComposerNode != null) {
//			TreeNode accountNode = (TreeNode) getTreePath(account);
			System.out.println("Number of mailboxes: " + tempComposerNode);//accountNode.getChildCount());
		TreeNode mailboxNode = ((TreeNode) tempComposerNode).getChildAt(mailboxNumber);//accountNode).getChildAt(mailboxNumber);
			((DefaultMutableTreeNode) mailboxNode).add(newEmailNode);
			((DefaultTreeModel) theModel).reload(mailboxNode);
//			TreeNode mailboxNode = tempComposerNode.getChildAt(mailboxNumber);
//			((DefaultMutableTreeNode) mailboxNode).add(newEmailNode);
//			((DefaultTreeModel) theModel).reload(mailboxNode);
		}	
	}

//	private DefaultMutableTreeNode getTreePath(String name) {
	private void findTreeNode(String name) {
		System.out.println("GetTreePath has been called");
// Set up the path from the root
		TreeNode rootNode = (TreeNode) root;
		TreePath path = new TreePath(rootNode);
		TreeNode parentNode = null;
// Iterate through the users
		System.out.println("Number of users: " + rootNode.getChildCount());
		for (int i = 0; i < rootNode.getChildCount(); i++) {
			TreeNode userNode = rootNode.getChildAt(i);
			System.out.println((String) ((DefaultMutableTreeNode)userNode).getUserObject());
// If the username doesn't match the argument, iterate through the sites
			if (((String) ((DefaultMutableTreeNode)userNode).getUserObject()) != name) {
//				TreeNode localSiteNode = userNode.getChildAt(0);
// Iterate through the sites
				for (int j = 0; j < 2; j++) {
					TreeNode siteNode = userNode.getChildAt(j);
// Iterate through the accounts
					System.out.println("Number of Accounts: " + siteNode.getChildCount());
					for (int k = 0; k < siteNode.getChildCount(); k++) {
						System.out.println("Searching through the accounts");
						TreeNode accountNode = siteNode.getChildAt(k);
// If the account name matches the argument name, set as the account name node
						if (((String) ((DefaultMutableTreeNode)accountNode).getUserObject()) == name) {
//							path = path.pathByAddingChild(accountNode);
							parentNode = accountNode;
							break;
						}
					}	
				}
			}
// If the username matches the argument name, set it as the parent node
			else {
				System.out.println("First else has been triggered");
//				path = path.pathByAddingChild(userNode);
				parentNode = userNode.getChildAt(i);
			}
		}
//		return (DefaultMutableTreeNode) parentNode;
		tempComposerNode = (DefaultMutableTreeNode) parentNode;
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
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) theTree.getLastSelectedPathComponent();		
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
		DefaultTreeModel model = (DefaultTreeModel) (theTree.getModel());
		TreePath[] paths = theTree.getSelectionPaths();
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
		if (theTree.getSelectionPath().getPath() != null)
			return theTree.getSelectionPath().getPath().length;
		else
			return 0;
	}
	
/**
 * Initialize some users with accounts for testing purposes
 */
	public void testSet() {
		addUser("John Lennon");
		addUser("George Harrison");
		addUser("Paul McCartney");
		addUser("Ringo Starr");
		
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
	
	public void setComposer(String emailComposer) {
		composer = emailComposer;
	}
	
	public String getComposer() {
		return composer;
	}
	
	public void setTempComposerNode() {
		tempComposerNode = (DefaultMutableTreeNode) theTree.getLastSelectedPathComponent();
	}
	
	public void setTempRecipientNode(String recipient) {
//		String recipient = eb.getRecipient();
	}
}
