/*
 * GC01 Coursework 2014-2015
 * Team 3 - Swing mockup of DSL Risk website
 * 
 * @authors Yueyang Chen, Hao Dong, Matti Konsala
 * @version final
 * 	
 * 
 * This Swing app is a high-fidelity mockup of a website to aid the web-design process.
 * The project is completed as part of coursework for COMPGC01 - Introductoru Programming for
 * the Financial Computing Master's at UCL
 */

package myPackage;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;


public class Controller {
	// Compliance to ensure layout is fully defined
	public static boolean RIGHT_TO_LEFT = false;

	//Set minimum heights for the window (page width and a suitable accompanying minimum height)
	public static final int windowWidth = 400;
	public static final int headerHeight = 160;
	public static final int bodyHeight = 400;
	public static final int footerHeight = 80;
	public static final int windowHeight = headerHeight+bodyHeight+footerHeight;

	/**
	 * Sets the basic layout.
	 *
	 * @param wrapper The full page (header + body + footer)
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void setBasicLayout(Container wrapper) throws IOException {
		// This method creates the JPanels for the header, body and footer, calls other methods to fill these panels
		// and finally populates the body panels with the newly created Panels.
		
		JPanel headerPanel = new JPanel();
		JPanel bodyPanel = new JPanel();
		JPanel footerPanel = new JPanel();

		/* These methods to set up the contents of the header, body and footer panels are
		 * separated into another class for clarity.
		 */
		
		fillPanel.fillHeader(headerPanel);
		fillPanel.fillBody(bodyPanel);
		fillPanel.fillFooter(footerPanel);
		
		bodyPanel.setPreferredSize(new Dimension(windowWidth,400));
				
		wrapper.add(headerPanel, BorderLayout.PAGE_START);
		wrapper.add(bodyPanel, BorderLayout.CENTER);
		wrapper.add(footerPanel, BorderLayout.PAGE_END);
		
//		System.out.println(bodyPanel.getComponentCount());
//		System.out.println(bodyPanel.getComponent(1).getName());
		
	}
	

	/**
	 * Creates the JFrame, and sets up the body and JScrollPane to allow a scrollable BorderLayout for the window
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	
	public static void createAndShowGUI() throws IOException {
		//This method creates the GUI and sets up the basic layout (header, body, footer)
		//and makes the window as a whole scrollable.

		//Create and set up the window.
		JFrame frame = new JFrame("BorderLayoutDemo");
		frame.setMinimumSize(new Dimension(windowWidth,windowHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel wrapper = new JPanel();
		// Set Layout to BorderLayout (as it is not standard for a JPanel)
		wrapper.setLayout(new BorderLayout());

		// Set left-to-right orientation
		if (RIGHT_TO_LEFT) {
			wrapper.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}

		// The contents of the individual panels are set up in the following function:
		setBasicLayout(wrapper);

		// Set up scrollpane features
		JScrollPane jsp = new JScrollPane(wrapper);
		frame.add(jsp);
		
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * The main method.
	 */
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("Something went wrong in creating the GUI");
				}
			}
		});
	}
}