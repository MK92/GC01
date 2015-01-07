package myPackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * Customisable basic listener for a JLabel
 * Specifics need to be added/customised for different purposes.
*/


class LabelListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Label clicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("Label hover: TRUE");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println("Label hover: FALSE");
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}