package windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import character.Me;
import character.Monster;
import dungeon.Major_require;
import fgame.GetCharacter;
import grade.Freshman;
import inventory.Inventory;
import skill.Skill;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class HandongMRC implements ActionListener {

	private JFrame frame;
	public static JPanel msgP = new JPanel();
	public static JPanel choiceP = new JPanel();
	public static JPanel monster1P = new JPanel();
	public static JLabel monster1NameL = new JLabel("Monster name");
	public static JLabel monster1HpL = new JLabel("HP: ??");
	public static JLabel monster2HpL = new JLabel("HP: ??");
	public static JPanel monster2P = new JPanel();
	public static JLabel monster2NameL = new JLabel("Monster name");
	public static JLabel monster3HpL = new JLabel("HP: ??");
	public static JPanel monster3P = new JPanel();
	public static JLabel monster3NameL = new JLabel("Monster name");
	public static JLabel monster4HpL = new JLabel("HP: ??");
	public static JPanel monster4P = new JPanel();
	public static JLabel monster4NameL = new JLabel("Monster name");
	public static JPanel playerP = new JPanel();
	public static JLabel playerHpL = new JLabel("HP: ??");
	public static JLabel playerMpL = new JLabel("MP: ??");
	public static JLabel monster5HpL = new JLabel("HP: ??");
	public static JPanel monster5P = new JPanel();
	public static JLabel monster5NameL = new JLabel("Monster name");
	public static JLabel bgL = new JLabel("");
	public static JButton msgPBtn = new JButton("계속");
	public static JLabel msgPLbl = new JLabel("");
	public static JButton choice1Btn = new JButton("1");
	public static JButton choice2Btn = new JButton("2");
	public static JButton choice3Btn = new JButton("3");
	public static JButton choice4Btn = new JButton("4");
	public static JButton choice5Btn = new JButton("5");
	public static JTextArea instructionTArea = new JTextArea();
	private static int choice;
	private static Inventory inv;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HandongMRC window = new HandongMRC(inv);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Major_require.fight(GetCharacter.me, Freshman.skill, Freshman.MR, inv);
	}

	/**
	 * Create the application.
	 */
	public HandongMRC(Inventory inInv) {
		initialize();
		choiceP.setVisible(false);
		inv = inInv;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
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
		
		choiceP.setBounds(384, 226, 200, 235);
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
		choice1Btn.setBounds(12, 10, 176, 35);
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
		choice2Btn.setBounds(12, 55, 176, 35);
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
		choice3Btn.setBounds(12, 100, 176, 35);
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
		choice4Btn.setBounds(12, 145, 176, 35);
		
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
		choice5Btn.setBounds(12, 190, 176, 35);
		
		choiceP.add(choice5Btn);
		
		monster1P.setBounds(71, 53, 87, 117);
		frame.getContentPane().add(monster1P);
		
		monster1NameL.setBounds(71, 180, 87, 15);
		frame.getContentPane().add(monster1NameL);
		
		monster1HpL.setBounds(71, 28, 57, 15);
		frame.getContentPane().add(monster1HpL);
		
		monster2HpL.setBounds(168, 28, 57, 15);
		frame.getContentPane().add(monster2HpL);
		
		monster2P.setBounds(170, 53, 87, 117);
		frame.getContentPane().add(monster2P);
		
		monster2NameL.setBounds(168, 180, 89, 15);
		frame.getContentPane().add(monster2NameL);
		
		monster3HpL.setBounds(267, 28, 57, 15);
		frame.getContentPane().add(monster3HpL);
		
		monster3P.setBounds(269, 53, 87, 117);
		frame.getContentPane().add(monster3P);
		
		monster3NameL.setBounds(267, 180, 89, 15);
		frame.getContentPane().add(monster3NameL);
		
		monster4HpL.setBounds(368, 28, 57, 15);
		frame.getContentPane().add(monster4HpL);
		
		monster4P.setBounds(368, 53, 87, 117);
		frame.getContentPane().add(monster4P);
		
		monster4NameL.setBounds(368, 180, 87, 15);
		frame.getContentPane().add(monster4NameL);
		
		playerP.setBounds(208, 249, 125, 159);
		frame.getContentPane().add(playerP);
		
		playerHpL.setFont(new Font("굴림", Font.PLAIN, 18));
		playerHpL.setBounds(71, 284, 125, 18);
		frame.getContentPane().add(playerHpL);
		
		playerMpL.setFont(new Font("굴림", Font.PLAIN, 18));
		playerMpL.setBounds(71, 312, 125, 18);
		frame.getContentPane().add(playerMpL);
		
		monster5HpL.setBounds(467, 28, 57, 15);
		frame.getContentPane().add(monster5HpL);
		
		monster5P.setBounds(467, 53, 87, 117);
		frame.getContentPane().add(monster5P);
		
		monster5NameL.setBounds(467, 180, 87, 15);
		frame.getContentPane().add(monster5NameL);
		
		
		instructionTArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		instructionTArea.setText("안내");
		instructionTArea.setLineWrap(true);
		instructionTArea.setBounds(12, 365, 184, 67);
		frame.getContentPane().add(instructionTArea);
		
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
		monster1P.setVisible(false);
		monster1NameL.setVisible(false);
		monster1HpL.setVisible(false);
		monster2P.setVisible(false);
		monster2NameL.setVisible(false);
		monster2HpL.setVisible(false);
		monster3P.setVisible(false);
		monster3NameL.setVisible(false);
		monster3HpL.setVisible(false);
		monster4P.setVisible(false);
		monster4NameL.setVisible(false);
		monster4HpL.setVisible(false);
		monster5P.setVisible(false);
		monster5NameL.setVisible(false);
		monster5HpL.setVisible(false);
		for (int i = 0; i < list.length; i++) {
			if (i == 0) {
				monster1P.setVisible(true);
				monster1NameL.setVisible(true);
				monster1HpL.setVisible(true);
			}
			else if (i == 1) {
				monster2P.setVisible(true);
				monster2NameL.setVisible(true);
				monster2HpL.setVisible(true);
			}
			else if (i == 2) {
				monster3P.setVisible(true);
				monster3NameL.setVisible(true);
				monster3HpL.setVisible(true);
			}
			else if (i == 3) {
				monster4P.setVisible(true);
				monster4NameL.setVisible(true);
				monster4HpL.setVisible(true);
			}
			else {
				monster5P.setVisible(true);
				monster5NameL.setVisible(true);
				monster5HpL.setVisible(true);
			}
		}
	}
	
	// **** 할 일 ****
	public static void updateMonsters(Monster[] list) {
		Object[][] monsterComponents = new Object[list.length][3];
		for (int i = 0; i < list.length; i++) {
			if (i == 0) {
				monsterComponents[i][0] = monster1P;
				monsterComponents[i][1] = monster1NameL;
				monsterComponents[i][2] = monster1HpL;
			}
			else if (i == 1) {
				monsterComponents[i][0] = monster2P;
				monsterComponents[i][1] = monster2NameL;
				monsterComponents[i][2] = monster2HpL;
			}
			else if (i == 2) {
				monsterComponents[i][0] = monster3P;
				monsterComponents[i][1] = monster3NameL;
				monsterComponents[i][2] = monster3HpL;
			}
			else if (i == 3) {
				monsterComponents[i][0] = monster4P;
				monsterComponents[i][1] = monster4NameL;
				monsterComponents[i][2] = monster4HpL;
			}
			else {
				monsterComponents[i][0] = monster5P;
				monsterComponents[i][1] = monster5NameL;
				monsterComponents[i][2] = monster5HpL;
			}
		}
		
		// monsterP (image)
		for (int i = 0; i < list.length; i++) {
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
		
	public static void showChoiceButtons(Object[] list) {
		choice1Btn.setVisible(false);
		choice2Btn.setVisible(false);
		choice3Btn.setVisible(false);
		choice4Btn.setVisible(false);
		choice5Btn.setVisible(false);
		
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
			else {
				choice5Btn.setVisible(true);
				if (list instanceof Skill[] && !((Skill)list[i]).getOpen()) {
					choice5Btn.setVisible(false);
				}
			}
		}
	}
	
	// 선택 액션
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(choice1Btn)) {
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
		else {
			choice = 4;
		}
	}


}
