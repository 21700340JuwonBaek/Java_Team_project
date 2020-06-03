package windowbuilder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import character.Me;
import character.Monster;
import inventory.Inventory;
import skill.Skill;

public class HandongDungeons implements ActionListener {
	// GUI components
	public JFrame frame;
	public static JPanel msgP = new JPanel();
	public static JPanel choiceP = new JPanel();
	public static JLabel monster1L = new JLabel("");
	public static JLabel monster1NameL = new JLabel("Monster name");
	public static JLabel monster1HpL = new JLabel("HP: ??");
	public static JLabel monster2L = new JLabel("");
	public static JLabel monster2HpL = new JLabel("HP: ??");
	public static JLabel monster2NameL = new JLabel("Monster name");
	public static JLabel monster3L = new JLabel("");
	public static JLabel monster3HpL = new JLabel("HP: ??");
	public static JLabel monster3NameL = new JLabel("Monster name");
	public static JLabel monster4HpL = new JLabel("HP: ??");
	public static JLabel monster4NameL = new JLabel("Monster name");
	public static JLabel monster4L = new JLabel("");
	public static JLabel monster5L = new JLabel("");
	public static JLabel playerL = new JLabel("");
	public static JLabel playerHpL = new JLabel("HP: ??");
	public static JLabel playerMpL = new JLabel("MP: ??");
	public static JLabel monster5HpL = new JLabel("HP: ??");
	public static JLabel monster5NameL = new JLabel("Monster name");
	public static JLabel bgL = new JLabel("");
	public static JButton msgPBtn = new JButton("계속");
	public static JLabel msgPLbl = new JLabel("");
	public static JButton choice1Btn = new JButton("1");
	public static JButton choice2Btn = new JButton("2");
	public static JButton choice3Btn = new JButton("3");
	public static JButton choice4Btn = new JButton("4");
	public static JButton choice5Btn = new JButton("5");
	public static JButton choicePotionBtn = new JButton("<html>포션<br/>사용</html>");
	public static JTextArea instructionTArea = new JTextArea();
	private static int choice;
	private static Inventory inv;
	
	// BGM
	private static Clip clip;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HandongDungeons window = new HandongDungeons(inv);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Major_require.fight(GetCharacter.me, Freshman.skill, Freshman.MR, inv);
	}

	/**
	 * Create the application.
	 */
	public HandongDungeons(Inventory inInv) {
		initialize();
		inv = inInv;
		choiceP.setVisible(false);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                stopBGM();
            }
        });
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		monster5L.setBounds(467, 53, 87, 117);
		
		frame.getContentPane().add(monster5L);
		monster4L.setBounds(366, 53, 87, 117);
		
		frame.getContentPane().add(monster4L);
		msgP.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		msgP.setBackground(Color.WHITE);
		
		msgP.setBounds(0, 361, 584, 100);
		frame.getContentPane().add(msgP);
		msgP.setLayout(null);
		msgPBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				synchronized (msgPBtn) {
			    	msgPBtn.notify();
				}
			}
		});
		msgPBtn.setForeground(Color.BLACK);
		
		msgPBtn.setBounds(445, 26, 97, 50);
		msgP.add(msgPBtn);
		
		msgPLbl.setBackground(Color.WHITE);
		msgPLbl.setBounds(12, 10, 386, 80);
		msgP.add(msgPLbl);
		
		choiceP.setVisible(false);
		choiceP.setBounds(307, 226, 277, 235);
		choiceP.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		choiceP.setBackground(Color.WHITE);
		frame.getContentPane().add(choiceP);
		choiceP.setLayout(null);
		choice1Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				synchronized (msgPBtn) {
			    	msgPBtn.notify();
				}
			}
		});
		
		choice1Btn.addActionListener(this);
		choice1Btn.setBounds(82, 10, 187, 35);
		choiceP.add(choice1Btn);
		choice2Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				synchronized (msgPBtn) {
			    	msgPBtn.notify();
				}
			}
		});
		
		choice2Btn.addActionListener(this);
		choice2Btn.setFont(new Font("굴림", Font.PLAIN, 11));
		choice2Btn.setBounds(82, 55, 187, 35);
		choiceP.add(choice2Btn);
		choice3Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				synchronized (msgPBtn) {
			    	msgPBtn.notify();
				}
			}
		});
		
		choice3Btn.addActionListener(this);
		choice3Btn.setBounds(82, 100, 187, 35);
		choiceP.add(choice3Btn);
		choice4Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				synchronized (msgPBtn) {
			    	msgPBtn.notify();
				}
			}
		});
		
		choice4Btn.addActionListener(this);
		choice4Btn.setBounds(82, 145, 187, 35);
		
		choiceP.add(choice4Btn);
		choice5Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				synchronized (msgPBtn) {
			    	msgPBtn.notify();
				}
			}
		});
		
		choice5Btn.addActionListener(this);
		choice5Btn.setBounds(82, 190, 187, 35);
		choiceP.add(choice5Btn);
		
		choicePotionBtn.addActionListener(this);
		choicePotionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				synchronized (msgPBtn) {
			    	msgPBtn.notify();
				}
			}
		});
		choicePotionBtn.setBounds(11, 9, 66, 49);
		
		choiceP.add(choicePotionBtn);
		
		
		monster1L.setBounds(71, 53, 87, 117);
		frame.getContentPane().add(monster1L);
		monster1NameL.setOpaque(true);
		monster1NameL.setBackground(Color.WHITE);
		
		monster1NameL.setBounds(71, 180, 87, 15);
		frame.getContentPane().add(monster1NameL);
		monster1HpL.setOpaque(true);
		monster1HpL.setBackground(Color.WHITE);
		monster1HpL.setFont(new Font("굴림", Font.PLAIN, 14));
		
		monster1HpL.setBounds(71, 28, 87, 18);
		frame.getContentPane().add(monster1HpL);
		monster2L.setBounds(170, 53, 87, 117);
		
		frame.getContentPane().add(monster2L);
		monster2HpL.setOpaque(true);
		monster2HpL.setBackground(Color.WHITE);
		monster2HpL.setFont(new Font("굴림", Font.PLAIN, 14));
		
		monster2HpL.setBounds(168, 28, 89, 18);
		frame.getContentPane().add(monster2HpL);
		monster2NameL.setOpaque(true);
		monster2NameL.setBackground(Color.WHITE);
		
		monster2NameL.setBounds(168, 180, 89, 15);
		frame.getContentPane().add(monster2NameL);
		
		monster3L.setBounds(267, 53, 87, 117);		
		frame.getContentPane().add(monster3L);
		monster3HpL.setOpaque(true);
		monster3HpL.setBackground(Color.WHITE);
		monster3HpL.setFont(new Font("굴림", Font.PLAIN, 14));
		
		monster3HpL.setBounds(267, 28, 89, 18);
		frame.getContentPane().add(monster3HpL);
		monster3NameL.setOpaque(true);
		monster3NameL.setBackground(Color.WHITE);
		
		monster3NameL.setBounds(267, 180, 89, 15);
		frame.getContentPane().add(monster3NameL);
		monster4HpL.setOpaque(true);
		monster4HpL.setBackground(Color.WHITE);
		monster4HpL.setFont(new Font("굴림", Font.PLAIN, 14));
		
		monster4HpL.setBounds(368, 28, 87, 18);
		frame.getContentPane().add(monster4HpL);
		monster4NameL.setOpaque(true);
		monster4NameL.setBackground(Color.WHITE);
		
		monster4NameL.setBounds(368, 180, 87, 15);
		frame.getContentPane().add(monster4NameL);
		
		
		playerL.setBounds(154, 259, 130, 150);
		frame.getContentPane().add(playerL);
		playerHpL.setBackground(Color.WHITE);
		
		playerHpL.setFont(new Font("굴림", Font.PLAIN, 18));
		playerHpL.setBounds(51, 284, 80, 18);
		frame.getContentPane().add(playerHpL);
		playerMpL.setBackground(Color.WHITE);
		
		playerMpL.setFont(new Font("굴림", Font.PLAIN, 18));
		playerMpL.setBounds(51, 308, 80, 18);
		frame.getContentPane().add(playerMpL);
		monster5HpL.setOpaque(true);
		monster5HpL.setBackground(Color.WHITE);
		monster5HpL.setFont(new Font("굴림", Font.PLAIN, 14));
		
		monster5HpL.setBounds(467, 28, 87, 18);
		frame.getContentPane().add(monster5HpL);
		monster5NameL.setOpaque(true);
		monster5NameL.setBackground(Color.WHITE);
		
		monster5NameL.setBounds(467, 180, 87, 15);
		frame.getContentPane().add(monster5NameL);
		
		
		instructionTArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		instructionTArea.setText("안내");
		instructionTArea.setLineWrap(true);
		instructionTArea.setBounds(12, 365, 134, 67);
		frame.getContentPane().add(instructionTArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(39, 282, 96, 48);
		frame.getContentPane().add(panel);
		
		bgL.setBounds(0, 0, 584, 461);
		frame.getContentPane().add(bgL);
	}

	// 줄바꿈 하려면 html 태그된 스트링 주세요 (<html>....<br/>....</html>)
	public static void showMessage(String msg) {
		msgP.setVisible(true);
		msgPLbl.setText(msg);
		synchronized(msgPBtn) {
			try {
				msgPBtn.wait();
			} 
			catch (Exception e) {
				System.out.println("interrupt");
			}
		}
		msgP.setVisible(false);
	}
	
	public static void showMonsters(Monster[] list) {
		// visible은 디자인에서 건드리면 안 됩니다
		monster1L.setVisible(false);
		monster1NameL.setVisible(false);
		monster1HpL.setVisible(false);
		monster2L.setVisible(false);
		monster2NameL.setVisible(false);
		monster2HpL.setVisible(false);
		monster3L.setVisible(false);
		monster3NameL.setVisible(false);
		monster3HpL.setVisible(false);
		monster4L.setVisible(false);
		monster4NameL.setVisible(false);
		monster4HpL.setVisible(false);
		monster5L.setVisible(false);
		monster5NameL.setVisible(false);
		monster5HpL.setVisible(false);
		
		for (int i = 0; i < list.length; i++) {
			if (i == 0) {
				monster1L.setVisible(true);
				monster1NameL.setVisible(true);
				monster1HpL.setVisible(true);
			}
			else if (i == 1) {
				monster2L.setVisible(true);
				monster2NameL.setVisible(true);
				monster2HpL.setVisible(true);
			}
			else if (i == 2) {
				monster3L.setVisible(true);
				monster3NameL.setVisible(true);
				monster3HpL.setVisible(true);
			}
			else if (i == 3) {
				monster4L.setVisible(true);
				monster4NameL.setVisible(true);
				monster4HpL.setVisible(true);
			}
			else {
				monster5L.setVisible(true);
				monster5NameL.setVisible(true);
				monster5HpL.setVisible(true);
			}
		}
	}
	
	public void showMonsterImage(Monster[] list, int myGrade) {
		String filename = new String();
		
		if (myGrade == 1) {
			filename = "/res/img/monster_1.png";
		}
		else if (myGrade == 2) {
			filename = "/res/img/monster_2.png";
		}
		else if (myGrade == 3) {
			filename = "/res/img/monster_3.png";
		}
		else {
			filename = "/res/img/monster_4.png";
		}
		
		try {
			BufferedImage imgMonster = ImageIO.read(this.getClass().getResource(filename));
			ImageIcon icon = new ImageIcon(imgMonster);
			for (int i = 0; i < list.length; i++) {
				if (i == 0) {
					monster1L.setIcon(icon);
				}
				else if (i == 1) {
					monster2L.setIcon(icon);
				}
				else if (i == 2) {
					monster3L.setIcon(icon);
				}
				else if (i == 3) {
					monster4L.setIcon(icon);
				}
				else {
					monster5L.setIcon(icon);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "몬스터 이미지 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// **** 할 일 ****
	public static void updateMonsters(Monster[] list) {
		Object[][] monsterComponents = new Object[list.length][3];
		for (int i = 0; i < list.length; i++) {
			if (i == 0) {
				monsterComponents[i][0] = monster1L;
				monsterComponents[i][1] = monster1NameL;
				monsterComponents[i][2] = monster1HpL;
			}
			else if (i == 1) {
				monsterComponents[i][0] = monster2L;
				monsterComponents[i][1] = monster2NameL;
				monsterComponents[i][2] = monster2HpL;
			}
			else if (i == 2) {
				monsterComponents[i][0] = monster3L;
				monsterComponents[i][1] = monster3NameL;
				monsterComponents[i][2] = monster3HpL;
			}
			else if (i == 3) {
				monsterComponents[i][0] = monster4L;
				monsterComponents[i][1] = monster4NameL;
				monsterComponents[i][2] = monster4HpL;
			}
			else {
				monsterComponents[i][0] = monster5L;
				monsterComponents[i][1] = monster5NameL;
				monsterComponents[i][2] = monster5HpL;
			}
		}
		
		// monsterP (image)
		for (int i = 0; i < list.length; i++) {
			// 몬스터 이미지 바꿔야 하나?
			//((JPanel)monsterComponents[i][0]).setVisible(true);
		}
		
		// monsterNameL (name)
		for (int i = 0; i < list.length; i++) {
			((JLabel)monsterComponents[i][1]).setText(list[i].getName());
			//((JLabel)monsterComponents[i][1]).setVisible(true);
		}
		
		// monsterHpL (hp)
		for (int i = 0; i < list.length; i++) {
			((JLabel)monsterComponents[i][2]).setText(hpToString(list[i]));
			//((JLabel)monsterComponents[i][2]).setVisible(true);
		}
	}
	
	public static void updateMe(Me m) {
		playerHpL.setText(hpToString(m));
		playerMpL.setText(mpToString(m));
	}
		
	private static String hpToString(character.Character c) {
		String returnStr;
		int hp = c.getHp();
		if (hp <= 0 && c instanceof Monster) {
			returnStr = "<html><B>해치웠다</B></html>";
		}
		else {
			returnStr = "HP: " + Integer.toString(hp);
		}
		return returnStr;
	}
	
	private static String mpToString (Me m) {
		int mp = m.getMp();
		return "MP: " + Integer.toString(mp);
	}
	
	public static int chooseSkill(Skill[] list) {
		choiceP.setVisible(true);
		instructionTArea.setVisible(true);
		showChoiceButtons(list);
		instructionTArea.setText("스킬을 선택해주세요!");
		choice1Btn.setText("검색하기");
		choice2Btn.setText("우주의 기원을 담아 기도하기...");
		choice3Btn.setText("선배님 도와주세요...!");
		choice4Btn.setText("논문찾아보기");
		choice5Btn.setText("교수님께 메일보내보기");
		
		synchronized(msgPBtn) {
			try {
				msgPBtn.wait();
			} 
			catch (Exception e) {
				System.out.println("interrupt");
			}
		}
		choiceP.setVisible(false);
		instructionTArea.setVisible(false);
		return choice;
	}
	
	public static int chooseMonster(Monster[] list) {
		choiceP.setVisible(true);
		instructionTArea.setVisible(true);
		showChoiceButtons(list);
		instructionTArea.setText("공격할 몬스터를 선택해주세요!");
		choice1Btn.setText("몬스터1");
		choice2Btn.setText("몬스터2");
		choice3Btn.setText("몬스터3");
		choice4Btn.setText("몬스터4");
		choice5Btn.setText("몬스터5");
		
		synchronized(msgPBtn) {
			try {
				msgPBtn.wait();
			} 
			catch (Exception e) {
				System.out.println("interrupt");
			}
		}
		choiceP.setVisible(false);
		instructionTArea.setVisible(false);
		return choice;
	}
	
	public static int choosePotion(Inventory inv) {
		int hpNum = inv.HpPotion.getNumber();
		int mpNum = inv.MpPotion.getNumber();
		
		choiceP.setVisible(true);
		instructionTArea.setVisible(true);
		showChoiceButtons(new Object[] {inv.HpPotion, inv.MpPotion});
		instructionTArea.setText("사용할 포션을 선택해주세요! 한 개씩 사용합니다.");
		choice1Btn.setText("HP포션: " + hpNum + " 개 소지");
		choice2Btn.setText("MP포션: " + mpNum + " 개 소지");
		
		synchronized(msgPBtn) {
			try {
				msgPBtn.wait();
			} 
			catch (Exception e) {
				System.out.println("interrupt");
			}
		}
		choiceP.setVisible(false);
		instructionTArea.setVisible(false);
		return choice + 1;
		
	}
		
	public static void showChoiceButtons(Object[] list) {
		choice1Btn.setVisible(false);
		choice2Btn.setVisible(false);
		choice3Btn.setVisible(false);
		choice4Btn.setVisible(false);
		choice5Btn.setVisible(false);
		choicePotionBtn.setVisible(false);
		
		if (list instanceof Skill[]) {
			choicePotionBtn.setVisible(true);
		}
		for (int i = 0; i < list.length; i++) {
			if (i == 0) {
				choice1Btn.setVisible(true);
				if (list instanceof Skill[] && !((Skill)list[i]).getOpen()) {
					choice1Btn.setVisible(false);
				}
			}
			else if (i == 1) {
				choice2Btn.setVisible(true);
				if (list instanceof Skill[] && !((Skill)list[i]).getOpen()) {
					choice2Btn.setVisible(false);
				}
			}
			else if (i == 2) {
				choice3Btn.setVisible(true);
				if (list instanceof Skill[] && !((Skill)list[i]).getOpen()) {
					choice3Btn.setVisible(false);
				}
			}
			else if (i == 3) {
				choice4Btn.setVisible(true);
				if (list instanceof Skill[] && !((Skill)list[i]).getOpen()) {
					choice4Btn.setVisible(false);
				}
			}
			else if (i == 4){
				choice5Btn.setVisible(true);
				if (list instanceof Skill[] && !((Skill)list[i]).getOpen()) {
					choice5Btn.setVisible(false);
				}
			}
		}
	}
	
	// 선택 액션
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(choicePotionBtn)){
			choice = 5;
		}
		else if (e.getSource().equals(choice1Btn)) {
			choice = 0;
		}
		else if (e.getSource().equals(choice2Btn)) {
			choice = 1;
		}
		else if (e.getSource().equals(choice3Btn)) {
			choice = 2;
		}
		else if (e.getSource().equals(choice4Btn)) {
			choice = 3;
		}
		else if (e.getSource().equals(choice5Btn)){
			choice = 4;
		}
	}

	public void showPlayer(Me me) {
		String filename = new String();
		
		if (me.getGrade() == 1) {
			filename = "/res/img/player_1.png";
		}
		else if (me.getGrade() == 2) {
			filename = "/res/img/player_2.png";
		}
		else if (me.getGrade() == 3) {
			filename = "/res/img/player_3.png";
		}
		else {
			filename = "/res/img/player_4.png";
		}
		
		BufferedImage imgPlayer;
		try {
			imgPlayer = ImageIO.read(this.getClass().getResource(filename));
			ImageIcon icon = new ImageIcon(imgPlayer);
			playerL.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "배경 이미지 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void playBGM() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/res/aud/dungeon_bgm.wav"));
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception e) {
	    	JOptionPane.showMessageDialog(null, "BGM 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public static void stopBGM() {
		clip.stop();
	}
	
	public void showBG(int dungeonType) {
		String filename = new String();
		
		if (dungeonType == 1) {
			filename = "/res/img/bg_mr.jpg";
		}
		else if (dungeonType == 2) {
			filename = "/res/img/bg_ms.jpg";
		}
		else if (dungeonType == 3) {
			filename = "/res/img/bg_er.jpg";
		}
		else {
			filename = "/res/img/bg_es.jpg";
		}
		
		BufferedImage imgBg;
		try {
			imgBg = ImageIO.read(this.getClass().getResource(filename));
			ImageIcon icon = new ImageIcon(imgBg);
			bgL.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "배경 이미지 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}
}