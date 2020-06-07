package windowbuilder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class Intro {

	private JFrame frmHguRpg;
	public static JLabel bgL = new JLabel("");
	public static JPanel msgP = new JPanel();
	public static JButton nextBtn = new JButton("계속");
	public static JLabel msgL = new JLabel("");
	public static JLabel playerL = new JLabel("");
	
	// BGM
	private static Clip clip;

	/**
	 * Launch the application.
	 */
	public static void run() {
		new Thread() {
			@Override
			public void run() {
				Intro window = new Intro();
				window.frmHguRpg.setVisible(true);
				
				startIntro();
				window.frmHguRpg.setVisible(false);
			}
		}.start();
	}

	/**
	 * Create the application.
	 */
	public Intro() {
		initialize();
		setBg();
		showPlayer();
		playBGM();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHguRpg = new JFrame();
		frmHguRpg.setTitle("HGU RPG 인트로");
		frmHguRpg.setVisible(true);
		frmHguRpg.setBounds(100, 100, 688, 419);
		frmHguRpg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHguRpg.getContentPane().setLayout(null);
		
		
		msgP.setLayout(null);
		msgP.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		msgP.setBackground(Color.WHITE);
		msgP.setBounds(0, 260, 672, 120);
		frmHguRpg.getContentPane().add(msgP);
		
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				synchronized (nextBtn) {
					nextBtn.notify();
				}
			}
		});
		nextBtn.setForeground(Color.BLACK);
		nextBtn.setBounds(544, 34, 97, 50);
		msgP.add(nextBtn);
		msgL.setFont(new Font("굴림", Font.PLAIN, 15));
		
		
		msgL.setBackground(Color.WHITE);
		msgL.setBounds(12, 10, 465, 100);
		msgP.add(msgL);
		
		
		playerL.setBounds(228, 89, 210, 210);
		frmHguRpg.getContentPane().add(playerL);
		
		
		bgL.setBounds(0, 0, 672, 380);
		frmHguRpg.getContentPane().add(bgL);
		
		
	}
	
	// 줄바꿈 하려면 html 태그된 스트링 주세요 (<html>....<br/>....</html>)
	public static void showMessage(String msg) {
		if (!msg.equals("<html></html>")) {
			msgP.setVisible(true);
			msgL.setText(msg);
			synchronized(nextBtn) {
				try {
					nextBtn.wait();
				} 
				catch (Exception e) {
					System.out.println("interrupt");
				}
			}
			msgP.setVisible(false);
		}
	}
	
	public static void startIntro() {
		String[] introMsg = {
			"당신은 고등학교를 갓 졸업하고 한동대학교에 입학한<br/>스무살 반짝이는 새내기입니다.",
			"전산을 전공할 계획을 가지고 입학한 당신은<br/>Why not change the world 할<br/>큰 꿈을 가지고 있습니다.",
			"\"God's University\" 한동대학교에 오신 당신에게<br/>4년 과정동안 겪어야 할 많은 어려움이 준비되어 있습니다.",
			"잘 극복해 졸업하는 것이 목표입니다.",
			"게임에서는 매 학년마다<br/>(1)전공필수 (2)전공선택 (3)교양필수 (4)교양선택<br/>4 가지 과목을 듣게 됩니다.",
			"강의마다 여러 고난이 주어질 것이기 때문에<br/>좌절하지 않고 잘 극복해야 합니다.",
			"다음 학년으로 올라가기 위해서 네 과목을 모두 클리어해야 합니다.<br/>4학년이 되어 모든 과목을 클리어하면 졸업을 하게 됩니다.",
			"과목을 클리어할 때마다 골드를 얻어 아이템을 살 수 있습니다.<br/>아이템을 잘 활용하길 바랍니다.",
			"설명은 여기까지 하겠습니다. 공부 열심히 하세요!"
		};
		for (String msg : introMsg) {
			showMessage("<html>" + msg + "</html>");
		}
		clip.stop();
	}
	
	private void setBg() {
		try {
			BufferedImage imgBg = ImageIO.read(this.getClass().getResource("/res/img/bg_intro.jpg"));
			ImageIcon icon = new ImageIcon(imgBg);
			bgL.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "배경이미지 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void showPlayer() {
		try {
			BufferedImage imgBg = ImageIO.read(this.getClass().getResource("/res/img/intro_player.png"));
			ImageIcon icon = new ImageIcon(imgBg);
			playerL.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "플레이어 이미지 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void playBGM() {
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/res/aud/intro_bgm.wav"));
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "BGM 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
