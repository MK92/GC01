package myPackage;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

public class Controller {
	public static boolean RIGHT_TO_LEFT = false;
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
	
	public static void addComponentsToPane(Container pane) {
        
		//Ensuring the correct layout is used
		//Slightly irrelevant for a static project such as this one.
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }
        
        //Set left-to-right orientation (avoiding magic numbers)
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        //Header (including nav bar)
        //Should include some functionality (mouseListeners, login fields)
        JButton button = new JButton("Button 1 (PAGE_START)");
        pane.add(button, BorderLayout.PAGE_START);
         
        //Main body of the page
        //This is the one that should be updated, the rest fairly static
        button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(200, 100));
        pane.add(button, BorderLayout.CENTER);
         
        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, BorderLayout.LINE_START);
                 
        button = new JButton("5 (LINE_END)");
        pane.add(button, BorderLayout.LINE_END);
        
        //Footer (static as hell - only a bit of mouseListeners)
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, BorderLayout.PAGE_END);
    }
	
    private static void createAndShowGUI() {
    	//Create and set up the window.
        JFrame frame = new JFrame("BorderLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        //Use the content pane's default BorderLayout. No need for
        //setLayout(new BorderLayout());
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