package myPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
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
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fillPanel {
	
	
	
	private static final int windowWidth = 700;
	private static final int windowHeight = 500; //Minimum, not sure if necessary once everything is finished.
	private static final int headerHeight = 160;
	private static final int footerHeight = 80;
	public static final Color DSL_Dark = Color.decode("#35615B");
	boolean highlighted;
	
	
	public static void fillHeader(JPanel panel) {
		//Set up header
		panel.setBackground(DSL_Dark);
		panel.setPreferredSize(new Dimension(windowWidth, headerHeight));

        // Add DSL logo
		ImageIcon logoIcon = new ImageIcon("images/logo.png");
		JLabel logo = new JLabel();
		logo.setIcon(logoIcon);
		panel.add(logo);
		
		//Add login button (note that this is a JLabel, not a JButton)
		ImageIcon loginIcon = new ImageIcon("images/loginicon.png");
		JLabel loginButton = new JLabel("login");
		loginButton.setIcon(loginIcon);
		loginButton.addMouseListener(ml);
		loginButton.setForeground(Color.white);
		loginButton.setName("login"); // Necessary (for now at least) for links using getName()
		panel.add(loginButton);
	}
	
	public static void fillBody(JPanel panel) throws IOException {
		//Set up main body of the page.
		panel.setLayout(new BorderLayout());
		
		//Create navPanel to allow multiple elements (clumsy in BorderLayout)
		JPanel navPanel = new JPanel();
		int numberOfLinks = 5;
		int linkWidth = (windowWidth/numberOfLinks) - 5;
		
		JLabel home = new JLabel("Home", SwingConstants.CENTER);
		home.setPreferredSize(new Dimension(linkWidth,20));
		home.addMouseListener(ml);
		home.setName("home"); //setName necessary for getName() used in the MouseListener. Clumsy but this is the simplest solution I could find.
		navPanel.add(home);
		
		JLabel about = new JLabel("About", SwingConstants.CENTER);
		about.setPreferredSize(new Dimension(linkWidth,20));
		about.addMouseListener(ml);
		about.setName("about");
		navPanel.add(about);
		
		
		JLabel services = new JLabel("Services", SwingConstants.CENTER);
		services.setPreferredSize(new Dimension(linkWidth,20));
		services.addMouseListener(ml);
		services.setName("services");
		navPanel.add(services);
		
		JLabel risk = new JLabel("Risk Tool", SwingConstants.CENTER);
		risk.setPreferredSize(new Dimension(linkWidth,20));
		risk.addMouseListener(ml);
		risk.setName("risk");
		navPanel.add(risk);
		
		JLabel contact = new JLabel("Contact Us", SwingConstants.CENTER);
		contact.setPreferredSize(new Dimension(linkWidth,20));
		contact.addMouseListener(ml);
		contact.setName("contact");
		navPanel.add(contact);
		
		//Add navPanel to the BorderLayout (of the main body in this case, not the entire frame).
	    panel.add(navPanel, BorderLayout.PAGE_START);
		
	    
		//This section reads the main body and puts it in a JTextPane
		File input = new File("html/Home.html");
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
		//Set up footer.
		panel.setBackground(DSL_Dark);
		panel.setPreferredSize(new Dimension(windowWidth, footerHeight));

		//Add labels (links on actual site)
		JLabel label = new JLabel("Careers");
		label.setForeground(Color.white);
		label.addMouseListener(ml);
		label.setName("careers");
		panel.add(label);
		
		label = new JLabel("Legal Stuff");
		label.addMouseListener(ml);
		label.setName("legal");
		panel.add(label);
		
		label = new JLabel("Partners");
		label.addMouseListener(ml);
		label.setName("partners");
		panel.add(label);
		
		label = new JLabel("Site Map");
		label.addMouseListener(ml);
		label.setName("sitemap");
		panel.add(label);
				
		//Obsolete code, leaving it in for now:
		
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
	
	
	
	/*
	 * The MouseListener ml (for now) just reads the name of the link.
	 * Methods that need to be written are@
	 * -one to update the page (mousePressed for the links)
	 * -one to change text colour (mouseEntered)
	 * -one to reset text colour (mouseExited)
	 */
		static MouseListener ml = new MouseListener() {
			        @Override
			        public void mouseReleased(MouseEvent e) {}
			        
			        @Override
			        public void mousePressed(MouseEvent e) {
			        	// Set up a dummy label to get info on the source of the event
			        	JLabel tempLabel = (JLabel) e.getSource();
			        	
			        	// Read the text on the dummy label to get event name 'pageName' which refers to
			        	// the page to be shown
		                String pageName = tempLabel.getName();
			        	System.out.println("Page name is: " + pageName);
			        	// Call this method to update the contents of the page only (leaving the header and footer as they are)
		                UpdateBodyContents.changeText(pageName);
			        }

			        @Override
			        public void mouseEntered(MouseEvent e) {
			        	// Set up a dummy label to get info on the source of the event
			        	JLabel tempLabel = (JLabel) e.getSource();
			        	// Read the text on the dummy label to get event name 'pageName' which refers to
			        	// the page to be shown
		                String pageName = tempLabel.getName();
		                tempLabel.setForeground(Color.WHITE);
		                mouseOver(pageName);

		                /*
		                 * Code to colour label named 'pageName' a different shade
		                 * This needs a simple if/else statement relating to the initial colour, as 
		                 * some of the links are white text on green while others are black text on
		                 * white
		                 */
			        }
			        
			        @Override
			        public void mouseExited(MouseEvent e) {
			        	// Set up a dummy label to get info on the source of the event
			        	JLabel tempLabel = (JLabel) e.getSource();
			        	// Read the text on the dummy label to get event name 'pageName' which refers to
			        	// the page to be shown
		                String pageName = tempLabel.getName();
		                tempLabel.setForeground(Color.BLACK);
		                mouseLeft(pageName);
		                /*
		                 * A simple method to complement the mouseEntered bit. Code to colour label
		                 * named 'pageName' back to normal
		                 */
		                
			        }
			        
			        @Override
			        public void mouseClicked(MouseEvent e) {}
			    };
			    
				public static void mouseOver(String pageName) {
					System.out.println("Link " + pageName + " highlighted");
				}
				
				public static void mouseLeft(String pageName) {
					System.out.println("Link " + pageName + " reverted");
			}
	
}
