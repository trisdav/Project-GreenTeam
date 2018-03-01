import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Skeleton class for View.java
 * 
 * @author Tristan Davis
 *
 */


public class View implements ActionListener {
	private Controller control;
	//Create variables for various components of the gui
	private DropDownMenu ddm;
	private ButtonBlock bb;
	View(Controller c) {
		control = c;
		GridLayout layout = new GridLayout();//create the layout
		//Create the frame
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(800, 615);
		mainFrame.setLayout(layout);
		//Create a preferred dimension for ddm
		Dimension ddmDim = new Dimension( 200,550 );
		ddm = new DropDownMenu(ddmDim);
		bb = new ButtonBlock(this);
		mainFrame.add(ddm);
		mainFrame.add(bb);
		mainFrame.setVisible(true);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		
	}
	
}
