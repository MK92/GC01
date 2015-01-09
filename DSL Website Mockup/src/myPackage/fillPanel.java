package myPackage;

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
		
//		JButton button1 = new JButton("Title1");
//		button1.setPreferredSize(new Dimension((windowWidth/5),20));
//		panel.add(button1);
//		
//		JButton button2 = new JButton ("Title2");
//		panel.add(button2);
		
		File input = new File("html/index.html");
		Document doc = Jsoup.parse(input, "UTF-8", "");
		
		Elements htmlBody = doc.select("div#body");

		String linkOuterH = htmlBody.outerHtml(); 
		    // "<a href="http://example.com"><b>example</b></a>"
		
		JTextPane bodyContent = new JTextPane();
		bodyContent.setContentType("text/html");
		bodyContent.setText(linkOuterH);
		
		panel.add(bodyContent);
		
		
		
	}
	
	public static void fillFooter(JPanel panel) {
		System.out.println("Hello");
		
		panel.setBackground(Color.decode("#bb0000"));

//		JButton button = new JButton("Footer");
//		button.setPreferredSize(new Dimension(windowWidth,footerHeight));
//		panel.add(button);
		
		JLabel label1 = new JLabel("1");
		panel.add(label1);

		label1 = new JLabel("2");
		panel.add(label1);
		label1 = new JLabel("3");
		panel.add(label1);
		JLabel label4 = new JLabel("4");
				
		JButton startButton = new JButton("START");
		startButton.setSize(50,70);

		startButton.addActionListener(new ButtonListener());
		panel.add(startButton);
		JButton otherButton = new JButton("Button number two");
		otherButton.addActionListener(new ButtonListener());
		panel.add(otherButton);
		
		
		panel.add(label1);
		panel.add(label4);
		
		JButton button = new JButton("Contact Us");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(button.getText());
			}
		});
		panel.add(button);
		
		JButton button1 = new JButton("Careers");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(button1.getText());
			}
		});
		panel.add(button1);
	}
	
	class LabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("Hello");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
