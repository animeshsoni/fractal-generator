package code;

import gui.UI;

/**
 * @author Animesh
 *
 */
public class Driver {

	/**
	 * This method instantiates an instance of UI and then calls the initialize
	 * method on it to run the program.
	 */
	public static void main(String[] args) {
		UI run = new UI();
		run.initialize();
	}
}
