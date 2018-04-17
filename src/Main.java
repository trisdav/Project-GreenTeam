/**
 * Run the Simple Email System
 *
 */
public class Main {
	public static void main(String args[]) {

		View gui = new View();		
		Model simpleEmailSystem = new Model();
		Controller ctrlr = new Controller(gui, simpleEmailSystem);
		gui.run(ctrlr);
	}
}
