/*
 * 스크린샷을 찍으려면 Screenshot.captureScreen(프레임)을 한다.
 */

package windowbuilder;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import character.Me;


public class Screenshot {
	// Component로 frame을 보낼 것
	public static void captureScreen(Component cmp, Me me) {
		Rectangle rect = cmp.getBounds();
		 
	    try {
	        String fileName = scrFilenameNumbering(me);
	        BufferedImage scr = 
	        		new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_ARGB);
	        cmp.paint(scr.getGraphics());

	        ImageIO.write(scr, "png", new File(fileName));
	    } catch (Exception ex) {
	    	JOptionPane.showMessageDialog(null, "스크린샷 오류", "오류", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private static String scrFilenameNumbering(Me me) {
		int num = 0;
		String filename = "img/scr" + me.getGrade() + ".png";
		
		return filename;
	}
}
