/**
 * Skeleton class for GUI.java
 * This is a mock-up at the moment.
 * @author Tristan Davis
 *
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTextArea;

public class GUI{
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
		mainFrame.setSize(800, 615);
		
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
		// use BorderLayout(int hgap, int vgap)
		//Create a button panel.
		JPanel buttonPanel = new JPanel();
		//Create dimensions for the button panel
		Dimension buttonPanelDimension = new Dimension(50,50);
		buttonPanel.setPreferredSize(buttonPanelDimension);
		//Create buttons
		JButton addButton = new JButton("Compose");
		JButton deleteButton = new JButton("Trash");
		JButton sendButton = new JButton("Send");
		JButton replyButton = new JButton("Reply");
		
		//Add buttons to frame
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(sendButton);
		buttonPanel.add(replyButton);
	
		//Create JText panel
		JPanel textPanel = new JPanel();
		textPanel.setVisible(true);
		//Create JTEXT
		JTextArea emailText = new JTextArea();
		textPanel.add(emailText);
		//textPanel.insets();
		Dimension TextPanelDimensions = new Dimension(500,500);
		emailText.setPreferredSize(TextPanelDimensions);
		emailText.setMinimumSize(TextPanelDimensions);
		emailText.setMaximumSize(TextPanelDimensions);
		//mainFrame.add(textPanel, BorderLayout.CENTER);
		
		//Create a JPanel for the center.
		JPanel centralPane = new JPanel();
		BoxLayout centerLayout = new BoxLayout(centralPane, BoxLayout.PAGE_AXIS);
		centralPane.setLayout(centerLayout);
		centralPane.add(buttonPanel);
		centralPane.add(emailText, Box.createGlue());
		Dimension centralPaneDimension = new Dimension(600,600);
		centralPane.add(Box.createRigidArea(centralPaneDimension));

		//Add central pane to main frame
		centralPane.setPreferredSize(centralPaneDimension);
		mainFrame.add(centralPane, BorderLayout.CENTER);
		mainFrame.setTitle("Simple Email System");
		Border emptyBorder = new EmptyBorder(10,10,10,10);
		centralPane.setBorder(emptyBorder);
		
		//Create JMenu bar
		JMenuBar menuBar = new JMenuBar();
		//Create menu buttons
		JMenu users = new JMenu("Users");
		JMenu accounts = new JMenu("Accounts");
		users.add(new JMenuItem("Add User"));
		users.add(new JMenuItem("Delete User"));
		accounts.add(new JMenuItem("Add Account"));
		accounts.add(new JMenuItem("Delete Account"));
		menuBar.add(users);
		menuBar.add(accounts);
		mainFrame.setJMenuBar(menuBar);
		mainFrame.pack();
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
