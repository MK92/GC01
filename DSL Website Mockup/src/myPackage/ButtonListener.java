package myPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Customisable basic listener for a JButton
 * Specifics need to be added/customised for different purposes.
*/


public class ButtonListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("ButtonClicked");
	}
	
	
}