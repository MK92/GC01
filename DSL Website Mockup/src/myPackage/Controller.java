package myPackage;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;

public class Controller {
	// Mandatory compliance to ensure layout is fully defined
	public static boolean RIGHT_TO_LEFT = false;

	//Set minimum heights for the window (page width and a suitable accompanying minimum height)
	public static final int windowWidth = 400;
	private static final int windowHeight = 20;
	private static final int headerHeight = 160;
	private static final int footerHeight = 150;


	/**
	 * :: This is from the Oracle tutorial on BorderLayout :: -Matti
	 * 
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 * @throws IOException 
	 */

	public static void setBasicLayout(Container body) throws IOException {
		// This method creates the JPanels for the header, body and footer, calls other methods to fill these panels
		// and finally populates the body panels with the newly created Panels.
		
		JPanel headerPanel = new JPanel();
		JPanel bodyPanel = new JPanel();
		JPanel footerPanel = new JPanel();

		/** These methods to set up the contents of the header, body and footer panels are
		 * separated into another class for clarity.
		 */
		
		fillPanel.fillHeader(headerPanel);
		fillPanel.fillBody(bodyPanel);
		fillPanel.fillFooter(footerPanel);

		bodyPanel.setPreferredSize(new Dimension(windowWidth,headerHeight));
				
		body.add(headerPanel, BorderLayout.PAGE_START);
		body.add(bodyPanel, BorderLayout.CENTER);
		body.add(footerPanel, BorderLayout.PAGE_END);
	}

	private static void createAndShowGUI() throws IOException {
		//This method creates the GUI and sets up the basic layout (header, body, footer)
		//and makes the window as a whole scrollable.

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

		// The contents of the individual panels are set up in the following function:
		setBasicLayout (body);

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
				try {
					createAndShowGUI();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}