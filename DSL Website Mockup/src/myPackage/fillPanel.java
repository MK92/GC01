package myPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class fillPanel implements MouseListener {
	
	private static final int windowWidth = 400;
	private static final int windowHeight = 20;
	private static final int headerHeight = 160;
	private static final int footerHeight = 150;
	public static final Color DSL_Dark = Color.decode("#bb0000");
	
	public static void fillHeader(JPanel panel) {
panel.setBackground(DSL_Dark);
        
		ImageIcon logoIcon = new ImageIcon("images/logo.png");
		JLabel logo = new JLabel(logoIcon);
		panel.add(logo);
		
		ImageIcon loginIcon = new ImageIcon("images/loginicon.png");
		JButton loginButton = new JButton(loginIcon);
		panel.add(loginButton);
		
	}
	
	public static void fillBody(JPanel panel) {
		JButton button = new JButton("Body");
		button.setPreferredSize(new Dimension(windowWidth,200));
		panel.add(button);
	}
	
	public static void fillFooter(JPanel panel) {
		System.out.println("Hello");
		System.out.println("Hello");
		
		panel.setBackground(Color.decode("#bb0000"));

//		JButton button = new JButton("Footer");
//		button.setPreferredSize(new Dimension(windowWidth,footerHeight));
//		panel.add(button);
		
		JLabel label1 = new JLabel("1");
		JLabel label2 = new JLabel("2");
		JLabel label3 = new JLabel("3");
		JLabel label4 = new JLabel("4");
		
		addListeners.linkListener(label1);

		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
	       System.out.println("MousePressed!");
	    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
