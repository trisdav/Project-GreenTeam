/**
 * Skeleton class for GUI.java
 * This is a mock-up at the moment.
 * @author Tristan Davis
 *
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class GUI {
	JTree tree;
	DefaultTreeModel treeModel;
	
	public static void main(String args[]) {
		GUI frame = new GUI();
		frame.createFrame();
	}
	
	public void createFrame() {
		//Create the frame
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(650, 650);
		
		//Create a panel
		JPanel treePanel = new JPanel();
		Dimension treePanelDimension = new Dimension(200,615);
		//Create and populate a JTree
		createTree();
		//Set tree size
		tree.setPreferredSize(treePanelDimension);
		
		//Add the JTree to the tree panel
		treePanel.add(tree);
		mainFrame.add(treePanel, BorderLayout.WEST);
		
		//Create a button panel.
		JPanel buttonPanel = new JPanel();
		//Create dimensions for the button panel
		Dimension buttonPanelDimension = new Dimension(200,400);
		buttonPanel.setPreferredSize(buttonPanelDimension);
		//Create buttons
		JButton addButton = new JButton("Add");
		JButton deleteButton = new JButton("Delete");
		
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		mainFrame.add(buttonPanel, BorderLayout.CENTER);
		
		
		mainFrame.setVisible(true);
		
		
	}
	
	public void createTree() {
		//The following nodes are for demonstration.
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Users"); //Root
		DefaultMutableTreeNode userJohn = new DefaultMutableTreeNode("John"); //A user
		//User John's account
		DefaultMutableTreeNode local = new DefaultMutableTreeNode("Local");
		DefaultMutableTreeNode remote = new DefaultMutableTreeNode("Remote");

		DefaultMutableTreeNode localJohn = new DefaultMutableTreeNode("John.local");
		DefaultMutableTreeNode remoteJohn = new DefaultMutableTreeNode("John.remote");
		DefaultMutableTreeNode inboxLocal = new DefaultMutableTreeNode("inbox");
		DefaultMutableTreeNode sentLocal = new DefaultMutableTreeNode("sent");
		DefaultMutableTreeNode trashLocal = new DefaultMutableTreeNode("trash");
		DefaultMutableTreeNode anEmail1 = new DefaultMutableTreeNode("Email1");
		DefaultMutableTreeNode anEmail2 = new DefaultMutableTreeNode("Email1");
		DefaultMutableTreeNode anEmail3 = new DefaultMutableTreeNode("Email1");

		
		//Build tree model
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		treeModel.insertNodeInto(userJohn, root, 0);
		userJohn.add(local);
		userJohn.add(remote);
		remote.add(remoteJohn);
		local.add(localJohn);
		localJohn.add(inboxLocal);
		localJohn.add(sentLocal);
		localJohn.add(trashLocal);
		inboxLocal.add(anEmail1);
		sentLocal.add(anEmail2);
		trashLocal.add(anEmail3);
	}
}
