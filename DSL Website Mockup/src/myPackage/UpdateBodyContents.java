package myPackage;

public class UpdateBodyContents {
	/* This class contains things relevant to changing pages on the 'website'
	 * At the moment this would be the methods changeText() and refreshWindow() to update the 
	 * page contents and refresh the Swing app window, respectively.
	 */
	
	public static void changeText(String pageName) {
		System.out.println("'" + pageName + "' is pageName.");
    	
		/* Here we need code to set the text of the JTextPane in the body of the page.
		 * In practice this will refer to the path 'html/*pageName*.html' as follows:
		 * _relevant panel_.setText("html/" + pageName + ".html");
		 */
	}
	
	public static void refreshWindow() {
		/* Code to redraw the Swing window.
		* I'm not sure if this is actually necessary but if it is, the method should probably live here.
		* An alternative to redrawing would be deleting the existing JTextPane and re-adding it?
		*/
	}

}
