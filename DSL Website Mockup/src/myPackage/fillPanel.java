package myPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fillPanel {
	
	//The MouseListener ml (for now) just prints out the label.
	static MouseListener ml = new MouseListener() {
		        @Override
		        public void mouseReleased(MouseEvent e) {}
		        
		        @Override
		        public void mousePressed(MouseEvent e) {
		        	JLabel tempLabel = (JLabel) e.getSource();
	                System.out.println(tempLabel.getText());
		        }

		        @Override
		        public void mouseExited(MouseEvent e) {}
		        @Override
		        public void mouseEntered(MouseEvent e) {}
		        @Override
		        public void mouseClicked(MouseEvent e) {}
		    };
	
	private static final int windowWidth = 400;
	private static final int windowHeight = 20;
	private static final int headerHeight = 200;
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
	
	public static void fillBody(JPanel panel) throws IOException {

		panel.setLayout(new BorderLayout());
	
		//Create subPanel to allow multiple elements (clumsy in BorderLayout)
		JPanel subPanel = new JPanel();
		
		JLabel home = new JLabel("Home");
		home.setPreferredSize(new Dimension((windowWidth/5),20));
		home.addMouseListener(ml);
		subPanel.add(home);
		
		JLabel about = new JLabel("About");
		about.setPreferredSize(new Dimension((windowWidth/5),20));
		subPanel.add(about);
		about.addMouseListener(ml);
		
		JLabel services = new JLabel("Services");
		services.setPreferredSize(new Dimension((windowWidth/5),20));
		services.addMouseListener(ml);
		subPanel.add(services);
		
		JLabel risk = new JLabel("Risk");
		risk.setPreferredSize(new Dimension((windowWidth/5),20));
		risk.addMouseListener(ml);
		subPanel.add(risk);
		
		JLabel contact = new JLabel("Contact Us");
		contact.setPreferredSize(new Dimension((windowWidth/5),20));
		contact.addMouseListener(ml);
		subPanel.add(contact);
		
		//Add subPanel to the BorderLayout (of the main body in this case, not the entire frame).
	    panel.add(subPanel, BorderLayout.PAGE_START);
		
		
		
		
		
//		panel.add(button2, BorderLayout.PAGE_START);
		
		
		
		//This section reads the main body and puts it in a JTextPane
		File input = new File("html/index.html");
		Document doc = Jsoup.parse(input, "UTF-8", "");
		
		Elements htmlBody = doc.select("div#body");

		String stringBody = htmlBody.outerHtml(); 
		
		JTextPane bodyContent = new JTextPane();
		bodyContent.setContentType("text/html");
		bodyContent.setText(stringBody);
		bodyContent.setMinimumSize(new Dimension(windowWidth,400));
		panel.add(bodyContent, BorderLayout.CENTER);

	}
	
	public static void fillFooter(JPanel panel) {
		System.out.println("Hello");
		
		panel.setBackground(Color.decode("#bb0000"));

//		JButton button = new JButton("Footer");
//		button.setPreferredSize(new Dimension(windowWidth,footerHeight));
//		panel.add(button);
		
		JLabel label = new JLabel("Careers");
		label.addMouseListener(ml);
		panel.add(label);
		label = new JLabel("Legal Stuff");
		label.addMouseListener(ml);
		panel.add(label);
		label = new JLabel("Partners");
		label.addMouseListener(ml);
		panel.add(label);
		label = new JLabel("Site Map");
		label.addMouseListener(ml);
		panel.add(label);
				
//		JButton startButton = new JButton("START");
//		startButton.setSize(50,70);

//		startButton.addActionListener(new ButtonListener());
//		panel.add(startButton);
//		JButton otherButton = new JButton("Button number two");
//		otherButton.addActionListener(new ButtonListener());
//		panel.add(otherButton);
		
		
		
//		JButton button = new JButton("Contact Us");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(button.getText());
//			}
//		});
//		panel.add(button);
//		
//		JButton button1 = new JButton("Careers");
//		button1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(button1.getText());
//			}
//		});
//		panel.add(button1);
	}
	
}
