package myPackage;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

public class Controller {
	// Mandatory compliance to ensure layout is fully defined
	public static boolean RIGHT_TO_LEFT = false;

	//Set minimum heights for the window (page width and a suitable accompanying minimum height)
	private static final int windowWidth = 400;
	private static final int windowHeight = 20;
	private static final int headerHeight = 160;
	private static final int footerHeight = 150;
	private static final Color DSL_Dark = Color.decode("#bb0000");

	private static void fillHeader(JPanel panel) {
        panel.setBackground(DSL_Dark);
        
		ImageIcon logoIcon = new ImageIcon("images/logo.png");
		JLabel logo = new JLabel(logoIcon);
		panel.add(logo);
		
		ImageIcon loginIcon = new ImageIcon("images/loginicon.png");
		JButton loginButton = new JButton(loginIcon);
		panel.add(loginButton);		
	}
	
	private static void fillBody(JPanel panel) {
		JButton button = new JButton("Body");
		button.setPreferredSize(new Dimension(windowWidth,200));
		panel.add(button);
	}
	private static void fillFooter (JPanel panel) {
        panel.setBackground(DSL_Dark);

		JButton button = new JButton("Footer");
		button.setPreferredSize(new Dimension(windowWidth,footerHeight));
		panel.add(button);
	}
	
	/**
	 * ::From Oracle tutorial:: -Matti
	 * 
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */

	//Probably going to be obsolete but I don't want to delete this yet!
	public static void setBasicLayout(Container body) {
		// This method creates the JPanels for the header, body and footer, calls other methods to fill these panels
		// and finally populates the body panels with the newly created Panels.
		
		JPanel headerPanel = new JPanel();
		JPanel bodyPanel = new JPanel();
		JPanel footerPanel = new JPanel();

		fillHeader(headerPanel);
		fillBody(bodyPanel);
		fillFooter(footerPanel);
		
		bodyPanel.setPreferredSize(new Dimension(400,headerHeight));
		
		body.add(headerPanel, BorderLayout.PAGE_START);
		body.add(bodyPanel, BorderLayout.CENTER);
		body.add(footerPanel, BorderLayout.PAGE_END);

	}

	private static void createAndShowGUI() {
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
				createAndShowGUI();
			}
		});
	}
}