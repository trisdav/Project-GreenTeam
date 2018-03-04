
public class Main {
	public static void main(String args[]) {

		View gui = new View();		
		SimpleEmailSystem ses = new SimpleEmailSystem();
		Controller ctrlr = new Controller(gui, ses);
		gui.run(ctrlr);
//		Controller ctrlr = new Controller();
	}
}
