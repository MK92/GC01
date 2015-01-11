/*
 * This is the complementing fillPanel class which handles the actual content of the different panels in the app,
 * as well as their functionality (mouse events for hovering over links, updating pages etc.)
 */
package myPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class fillPanel {
	public static final int windowWidth = 600;
	public static final int linkHeight = 20;
	public static final int headerHeight = 160;
	public static final int bodyHeight = 400;
	public static final int footerHeight = 80;
	public static final int windowHeight = headerHeight+bodyHeight+footerHeight;

	public static final Color DSL_Dark = Color.decode("#35615B");


	/**
	 * @wbp.parser.entryPoint
	 */

	public static void fillHeader(JPanel panel) {
		panel.setBackground(DSL_Dark);

		//Set up header
		panel.setPreferredSize(new Dimension(windowWidth, headerHeight));
		panel.setLayout(new BorderLayout());

		// Add DSL logo
		ImageIcon logoIcon = new ImageIcon("images/logo.png");
		JLabel logo = new JLabel();
		logo.setIcon(logoIcon);
		panel.add(logo, BorderLayout.WEST);

		//Separate panel for the login fields (just to deal with Layouts etc.)
		JPanel loginFields = new JPanel();

		JTextField usernameField = new JTextField("");
		usernameField.setPreferredSize(new Dimension(80,20));

		JPasswordField passwordField = new JPasswordField("");
		passwordField.setPreferredSize(new Dimension(80,20));

		loginFields.add(usernameField);
		loginFields.add(passwordField);

		//		Add login button (note that this is a JLabel, not a JButton)
		ImageIcon loginIcon = new ImageIcon("images/loginicon.png");
		JLabel loginButton = new JLabel();
		loginButton.setIcon(loginIcon);
		loginButton.setName("login"); // Necessary (for now at least) for links using getName()
		loginFields.add(loginButton);
		loginFields.setBackground(DSL_Dark);

		panel.add(loginFields,BorderLayout.EAST);
		panel.setBackground(DSL_Dark);

		class loginSubmitter implements MouseListener {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				InputStream inputStream = null;
				try {
					inputStream = new FileInputStream("userdata/" + usernameField.getText() + ".json");
				} catch (FileNotFoundException e) {
					System.err.println("Invalid user: " + usernameField.getText());
				}

				Reader reader = new InputStreamReader(inputStream);
				Gson gson = new GsonBuilder().create();
				User p = gson.fromJson(reader, User.class);

				if (p.toString().equals(passwordField.getText())) {
					System.out.println("Login success, username: " + usernameField.getText() + ".");
				} else {
					System.err.println("Login failed: Wrong password for user" +usernameField.getText() + ".");
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) { }

			@Override
			public void mouseExited(MouseEvent e) { }

			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }
		} //loginSubmitter end

		loginButton.addMouseListener(new loginSubmitter());

	}

	public static void fillBody(JPanel panel) throws IOException {
		//Set up main body of the page.
		panel.setLayout(new BorderLayout());

		JTextPane bodyContent = new JTextPane();

		
		class pageUpdater implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Get the source of the event (label)
				JLabel tempLabel = (JLabel) arg0.getSource();
				
				// read file corresponding to label name
				File input = new File("html/"	+ tempLabel.getName() +	".html");
				
				Document doc = null;
				try {
					doc = Jsoup.parse(input, "UTF-8", "");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("JSoup failed to parse");
				}
				
				Elements htmlBody = doc.select("div#body");
				String stringBody = htmlBody.outerHtml(); 

				bodyContent.setText(stringBody);
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
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}	
		}

		//Create navPanel to allow multiple elements (BorderLayout only allows a single element)
		JPanel navPanel = new JPanel();
		int numberOfLinks = 5;
		int linkWidth = (windowWidth/numberOfLinks) - 5;

		JLabel home = new JLabel("Home", SwingConstants.CENTER);
		home.setPreferredSize(new Dimension(linkWidth,linkHeight));
		home.addMouseListener(hoverListener);
		home.addMouseListener(new pageUpdater());
		home.setName("home"); //setName necessary for getName() used in the MouseListener. Clumsy but this is the simplest solution I could find.
		navPanel.add(home);

		JLabel about = new JLabel("About", SwingConstants.CENTER);
		about.setPreferredSize(new Dimension(linkWidth,linkHeight));
		about.addMouseListener(hoverListener);
		about.addMouseListener(new pageUpdater());
		about.setName("about");
		navPanel.add(about);


		JLabel services = new JLabel("Services", SwingConstants.CENTER);
		services.setPreferredSize(new Dimension(linkWidth,linkHeight));
		services.addMouseListener(hoverListener);
		services.addMouseListener(new pageUpdater());
		services.setName("services");
		navPanel.add(services);

		JLabel risk = new JLabel("Risk Tool", SwingConstants.CENTER);
		risk.setPreferredSize(new Dimension(linkWidth,linkHeight));
		risk.addMouseListener(hoverListener);
		risk.addMouseListener(new pageUpdater());
		risk.setName("risk");
		navPanel.add(risk);

		

		JLabel contact = new JLabel("Contact Us", SwingConstants.CENTER);
		contact.setPreferredSize(new Dimension(linkWidth,linkHeight));
		contact.addMouseListener(hoverListener);
		contact.addMouseListener(new pageUpdater());
		contact.setName("contact");
		navPanel.add(contact);

		// Add navPanel to the BorderLayout (of the main body in this case, not the entire frame).
		panel.add(navPanel, BorderLayout.PAGE_START);

		// This section reads the main body and puts it in a JTextPane
		File input = new File("html/home.html");
		Document doc = Jsoup.parse(input, "UTF-8", "");
		
		//String title = doc.title();

		Elements htmlBody = doc.select("div#body");
		String stringBody = htmlBody.outerHtml(); 

		bodyContent.setName("bodyContent");
		bodyContent.setContentType("text/html");
		bodyContent.setText(stringBody);
		bodyContent.setMinimumSize(new Dimension(windowWidth,600));
		panel.add(bodyContent, BorderLayout.CENTER);

	}


	public static void fillFooter(JPanel panel) {
		//Set up footer.
		panel.setBackground(DSL_Dark);
		panel.setPreferredSize(new Dimension(windowWidth, footerHeight));

		//Add labels (links on actual site)
		JLabel label = new JLabel("Careers");
		label.addMouseListener(hoverListener);
		label.setName("careers");
		panel.add(label);

		label = new JLabel("Legal Stuff");
		label.addMouseListener(hoverListener);
		label.setName("legal");
		panel.add(label);

		label = new JLabel("Partners");
		label.addMouseListener(hoverListener);
		label.setName("partners");
		panel.add(label);

		label = new JLabel("Site Map");
		label.addMouseListener(hoverListener);
		label.setName("sitemap");
		panel.add(label);

	}



	/*
	 * The MouseListener hoverListener (for now) just reads the name of the link.
	 * Methods that need to be written are@
	 * -one to update the page (mousePressed for the links)
	 * -one to change text colour (mouseEntered)
	 * -one to reset text colour (mouseExited)
	 */
	static MouseListener hoverListener = new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) { }

		@Override
		public void mouseEntered(MouseEvent e) {
			// Set up a dummy label to get info on the source of the event
			JLabel tempLabel = (JLabel) e.getSource();
			// Read the text on the dummy label to get event name 'pageName' which refers to
			// the page to be shown
			tempLabel.setForeground(Color.WHITE);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// Set up a dummy label to get info on the source of the event
			JLabel tempLabel = (JLabel) e.getSource();
			tempLabel.setForeground(Color.BLACK);

		}
		@Override
		public void mouseClicked(MouseEvent e) {}
	};

}
