package myPackage;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class Controller {
	// Mandatory compliance to ensure layout is fully defined
	public static boolean RIGHT_TO_LEFT = false;

	//Set minimum heights for the window (page width and a suitable accompanying minimum height)
	private static final int windowWidth = 10;
	private static final int windowHeight = 20;
	private static final int headerHeight = 200;
	private static final int footerHeight = 150;

	/**
	 * ::From Oracle tutorial:: -Matti
	 * 
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */

	public static void setBasicLayout(Container pane) {

	}

	private static void createAndShowGUI() {



		//Create and set up the window.
		JFrame frame = new JFrame("BorderLayoutDemo");
		frame.setMinimumSize(new Dimension(windowWidth,windowHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel body = new JPanel();
		// Set Layout to BorderLayout (as it is not standard for a JPanel)
		body.setLayout(new BorderLayout());
		
		//Set left-to-right orientation (avoiding magic numbers)
		if (RIGHT_TO_LEFT) {
			body.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}
		
		int x = 200;

		JButton button = new JButton("Header button");
		button.setPreferredSize(new Dimension(x,x));
		body.add(button, BorderLayout.PAGE_START);

		button = new JButton("Button 3 (LINE_START)");
		button.setPreferredSize(new Dimension(x,x));
		body.add(button, BorderLayout.LINE_START);

		button = new JButton("Button 2 (CENTER)");
		button.setPreferredSize(new Dimension(x,x));
		body.add(button, BorderLayout.CENTER);

		button = new JButton("5 (LINE_END)");
		button.setPreferredSize(new Dimension(x,x));
		body.add(button, BorderLayout.LINE_END);

		button = new JButton("Long-Named Button 4 (PAGE_END)");
		button.setPreferredSize(new Dimension(x,x));
		body.add(button, BorderLayout.PAGE_END);

		//Set up scrollpane features
		JScrollPane jsp = new JScrollPane(body);
		frame.add(jsp);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}