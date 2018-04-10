import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

/**
 * 
 * @author Tristan Davis and Lydia McGovern
 */
public class DropDownMenu extends JPanel {
	private JTree menuTree;
	private TreeModel menuModel;
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Users");
	private View GUI;
	private String composer;
	private DefaultMutableTreeNode tempNode;
	
/**
 * Constructor for the dropdown menu with specified dimensions
 * @param v the View object that contains this panel
 * @param d the dimensions of this panel
 */
	DropDownMenu(View v, Dimension d)
	{
		menuModel = new DefaultTreeModel(root);
		menuTree = new JTree(menuModel);
		menuTree.setEditable(false);
//Create a tree selection listener
		menuTree.addTreeSelectionListener(listener);
		JScrollPane scrollPane = new JScrollPane(menuTree);
		scrollPane.setPreferredSize(d);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollPane);
		GUI = v;
		composer = null;
		tempNode = null;
		testSet();
	}
	
/**
 * Add a user to the tree with two sites
 * @param userName the name of the user to be added to the tree
 */
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
		TreeNode parentNode = null;
// Iterate through the users
		for (int i = 0; i < rootNode.getChildCount(); i++) {
			TreeNode userNode = rootNode.getChildAt(i);
// Iterate through the sites
				for (int j = 0; j < 2; j++) {
					TreeNode siteNode = userNode.getChildAt(j);
// Iterate through the accounts
					for (int k = 0; k < siteNode.getChildCount(); k++) {
						TreeNode accountNode = siteNode.getChildAt(k);
// If the account name matches the argument name, set as the account name node
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
 * Return the ancestor of a leaf n generations up 
 * @param n the number of generations up the tree
 * @return the nth ancestor of the leaf
 */
	public String getNthAncestor(int n) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) menuTree.getLastSelectedPathComponent();
// Count up n generations
		for(int i = 0; i < n; i++)
		{
			if(node.getParent() != null)
			{
				node = (DefaultMutableTreeNode) node.getParent();
			}
		}
		return (String) node.getUserObject();
	}
	
/**
 * Returns the path length of the selected node; root = 1, user = 2, site = 3, account = 4, email box = 5, email = 6
 * @return the path length of the selected node
 */
	public int getPathLength() {
//If getSelectionPath is null the function call is essentially null.getPath()
//Also, getPath is not guaranteed to return null if it is an invalid path.
		if(menuTree.getSelectionPath() != null)
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
	//I think there is a more elegant solution for this -T
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
	
/**
 * This will create a selection listener but send its event to GUI.
 * The source is the dropdownmenu.
 * The id of the code is 1.
 * The actionCommand is emailSelected.
 */
	private TreeSelectionListener listener = (new TreeSelectionListener()
			{

				@Override
				public void valueChanged(TreeSelectionEvent e) {
					DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)
	                           menuTree.getLastSelectedPathComponent();
					if(selectedNode != null)
					{
						DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
						if(parentNode != null)
						{
							String key = (String) parentNode.getUserObject();
							if(key == "Inbox" || key == "Sent" || key == "Trash")
							{
								ActionEvent event = new ActionEvent(this, 1, "emailSelected" );
								GUI.actionPerformed(event);
							}
						}
					}
				}
		
			});
	
}