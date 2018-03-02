import javax.swing.JFrame;

public class EmailBlockTester {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		EmailBlock block = new EmailBlock();

		frame.setTitle("Email View");
		frame.add(block);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//block.hideComponents();
		//block.showComponents();
	}
}

