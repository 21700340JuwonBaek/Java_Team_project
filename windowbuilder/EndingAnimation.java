package windowbuilder;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class EndingAnimation {

	private JFrame frame;
	private String[] scrArr = {
		"scr1.png",
		"scr2.png",
		"scr3.png",
		"scr4.png"
	};
	private Timer tm;
	private int i = 0;
	
	// BGM
	Clip clip;

	/**
	 * Create the application.
	 */
	public EndingAnimation() {
		initialize();
		tm.restart();
		playBGM();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 701, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel player = new JLabel("");
		player.setBounds(0, 151, 250, 350);
		frame.getContentPane().add(player);
		
		JLabel text = new JLabel("졸업이다.....");
		text.setFont(new Font("궁서", Font.ITALIC, 40));
		text.setBounds(300, 174, 279, 52);
		frame.getContentPane().add(text);
		
		JLabel scrSlideShow = new JLabel("");
		scrSlideShow.setBounds(0, 0, 684, 501);
		frame.getContentPane().add(scrSlideShow);
		
		try {
			BufferedImage imgPlayer = ImageIO.read(this.getClass().getResource("/res/img/user_graduation.png"));
			ImageIcon icon = new ImageIcon(imgPlayer);
			player.setIcon(icon);
			player.setBounds(0, 501-350, 250, 350);
		}
		catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "플레이어 이미지파일 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
		}
		
		tm = new Timer(3000, new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				scrSlideShow.setIcon(new ImageIcon(scrArr[i]));
	            i += 1;
	            if(i >= scrArr.length) {
	                i = 0; 
	            }
	        }
		});
		tm.setInitialDelay(0);
		
		// Stop bgm when closing
		frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                stopBGM();
            }
        });
	}
	
	public void playBGM() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/res/aud/ending_bgm.wav"));
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "BGM 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void stopBGM() {
		clip.stop();
	}
}
