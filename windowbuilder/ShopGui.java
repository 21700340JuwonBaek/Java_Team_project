package windowbuilder;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import character.Me;
import inventory.Inventory;
import item.Armor;
import item.Potion;
import item.Weapon;
import main.Main;

public class ShopGui extends JFrame {

	private JPanel contentPane;
	public static JPanel panel, panel_1, panel_2, panel_3, panel_4;
	ImageIcon icon, icon2;
	ImageIcon[] icons = new ImageIcon[5];
	int check;
	String inform = "<html>";
	JLabel lblNewLabel_8;
	BufferedImage back;
	JLabel bgL;
	static ShopGui frame;

	/**
	 * Launch the application.
	 */
	public static void run(Me me, Inventory invent, Potion hp, Potion mp, Weapon Ipad, Weapon Macbook, Weapon Note,
			Weapon TA, Armor Hood) {
		try {
			frame = new ShopGui(me, invent, hp, mp, Ipad, Macbook, Note, TA, Hood);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public ShopGui(Me me, Inventory invent, Potion hp, Potion mp, Weapon Ipad, Weapon Macbook, Weapon Note, Weapon TA,
			Armor Hood) {
		Info.quitFrame();
		setTitle("Item Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		BufferedImage hpPotion = null;
		BufferedImage mpPotion = null;
		BufferedImage[] items = new BufferedImage[5];
		try {
			hpPotion = ImageIO.read(this.getClass().getResource("/res/img/HPpotion.png"));
			mpPotion = ImageIO.read(this.getClass().getResource("/res/img/mpPotion.png"));
			items[0] = ImageIO.read(this.getClass().getResource("/res/img/ipad.png"));
			items[1] = ImageIO.read(this.getClass().getResource("/res/img/MacBook.png"));
			items[2] = ImageIO.read(this.getClass().getResource("/res/img/Note.png"));
			items[3] = ImageIO.read(this.getClass().getResource("/res/img/TA.png"));
			items[4] = ImageIO.read(this.getClass().getResource("/res/img/Hood.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("error! Didn't get picture!");
		}
		// HP MP Potions
		Image imgHP = hpPotion.getScaledInstance(88, 78, Image.SCALE_SMOOTH);
		Image imgMP = mpPotion.getScaledInstance(88, 78, Image.SCALE_SMOOTH);
		icon = new ImageIcon(imgHP);
		icon2 = new ImageIcon(imgMP);

		// Weapon, armors
		Image[] imgs = new Image[5];
		for (int i = 0; i < 5; i++) {
			imgs[i] = items[i].getScaledInstance(88, 78, Image.SCALE_SMOOTH);
			icons[i] = new ImageIcon(imgs[i]);
		}

		try {
			back = ImageIO.read(this.getClass().getResource("/res/img/store.jpg"));
			// icon = new ImageIcon("/Users/ryumi/Desktop/classroom.jpeg");
			// Image back= icon.getImage();
			Image rim1 = back.getScaledInstance(450, 300, Image.SCALE_SMOOTH);
			// icon = new ImageIcon(rim1);
			ImageIcon icon = new ImageIcon(rim1);
			bgL = new JLabel(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "배경 이미지 읽기 오류", "오류", JOptionPane.ERROR_MESSAGE);
		}
		bgL.setBounds(0, 0, 450, 300);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(222, 151, 223, 122);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Information");
		lblNewLabel.setBounds(74, 6, 79, 16);
		panel.add(lblNewLabel);

		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(6, 34, 211, 82);
		panel.add(lblNewLabel_8);
		inform = settingInform(me, hp, mp, inform);
		lblNewLabel_8.setText(inform);

		panel_3 = new JPanel();
		panel_3.setForeground(new Color(255, 0, 0, 0));
		panel_3.setBackground(new Color(255, 0, 0, 0));
		panel_3.setBounds(10, 146, 207, 127);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton_4 = new JButton("나가기");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMessage("");
				inform = settingInform(me, hp, mp, inform);
				lblNewLabel_8.setText(inform);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(41, 67, 117, 29);
		panel_3.add(btnNewButton_4);

		panel_4 = new JPanel();
		panel_4.setBounds(10, 146, 207, 127);
		contentPane.add(panel_4);
		panel_4.setBackground(new Color(255, 0, 0, 0));
		panel_4.setLayout(null);

		JButton btnNewButton = new JButton("나가기");
		btnNewButton.setBounds(37, 87, 119, 29);
		panel_4.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("포션구매");
		btnNewButton_2.setBounds(37, 25, 119, 29);
		panel_4.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("장비구매");
		btnNewButton_1.setBounds(37, 56, 119, 29);
		panel_4.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMessage("");
				buyInvent();
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showMessage("");
				buyPotion();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				shopBye(me, invent);
			}
		});

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 5, 444, 137);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton button_1 = new JButton(icons[0]);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyIpad(me, Ipad, invent);
			}
		});
		button_1.setBounds(18, 6, 76, 72);
		panel_1.add(button_1);

		JButton button_2 = new JButton(icons[4]);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyHood(me, Hood, invent);
			}
		});
		button_2.setBounds(106, 6, 76, 72);
		panel_1.add(button_2);

		JButton button_3 = new JButton(icons[1]);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyMacbook(me, Macbook, invent);
			}
		});
		button_3.setBounds(194, 6, 76, 72);
		panel_1.add(button_3);

		JButton button_4 = new JButton(icons[2]);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyNote(me, Note, invent);
			}
		});
		button_4.setBounds(282, 6, 76, 72);
		panel_1.add(button_4);

		JButton button_5 = new JButton(icons[3]);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyTA(me, TA, invent);
			}
		});
		button_5.setBounds(362, 6, 76, 72);
		panel_1.add(button_5);

		JLabel lblNewLabel_3 = new JLabel("아이패드");
		lblNewLabel_3.setBounds(33, 90, 61, 16);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("새내기 후드티");
		lblNewLabel_4.setBounds(106, 90, 76, 16);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("맥북");
		lblNewLabel_5.setBounds(220, 90, 30, 16);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("선배의 필기노트");
		lblNewLabel_6.setBounds(282, 84, 86, 28);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("TA 세션");
		lblNewLabel_7.setBounds(384, 90, 43, 16);
		panel_1.add(lblNewLabel_7);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 427, 130);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_5 = new JButton(icon);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyHpPotion(me, hp, invent);
			}
		});
		btnNewButton_5.setBounds(79, 6, 88, 78);
		panel_2.add(btnNewButton_5);

		JButton button = new JButton(icon2);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				buyMpPotion(me, mp, invent);
			}
		});
		button.setBounds(239, 6, 88, 78);
		panel_2.add(button);

		JLabel lblNewLabel_1 = new JLabel("HP 포션");
		lblNewLabel_1.setBounds(89, 96, 61, 16);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("MP 포션");
		lblNewLabel_2.setBounds(249, 96, 61, 16);
		panel_2.add(lblNewLabel_2);

		getContentPane().add(bgL);

		panel_3.setVisible(false);
		panel_2.setVisible(false);
		panel_1.setVisible(false);

	}

	public int buyInvent() {
		panel_3.setVisible(true);
		panel_1.setVisible(true);
		panel_4.setVisible(false);

		return 2;
	}

	public int buyPotion() {
		panel_3.setVisible(true);
		panel_2.setVisible(true);
		panel_4.setVisible(false);

		return 1;
	}

	public int shopBye(Me me, Inventory invent) {
		Main.getStart(me, invent, 2);
		quitFrame();
		return 0;
	}

	public int buyHpPotion(Me me, Potion hp, Inventory invent) {
		// System.out.println(inform);
		me.setGold(me.getGold() - hp.getBuyGold());
		check = goldCheck(me, hp.getBuyGold());
		if (check != 1) {
			inform += "HP 포션을 구매하였습니다!<br/>10골드 차감.<br/>Gold : " + me.getGold();
			hp.setNumber(hp.getNumber() + 1);
			invent.setHpPotion(hp);
			showMessage(inform);
		}
		return 1;
	}

	public int buyMpPotion(Me me, Potion mp, Inventory invent) {
		// showMessage(inform);
		me.setGold(me.getGold() - mp.getBuyGold());
		check = goldCheck(me, mp.getBuyGold());
		if (check != 1) {
			inform += "MP 포션을 구매하였습니다!<br/>10골드 차감.<br/>Gold : " + me.getGold();
			mp.setNumber(mp.getNumber() + 1);
			invent.setMpPotion(mp);
			showMessage(inform);
		}
		return 1;
	}

	public int buyIpad(Me me, Weapon Ipad, Inventory invent) {
		// showMessage(inform);
		check = goldCheck(me, invent.weapon1.getBuyGold());
		if ((check != 1) && (!invent.weapon1.getIs_bought())) {
			me.setGold(me.getGold() - invent.weapon1.getBuyGold());
			inform += "아이패드를 구매하였습니다.<br/>공격력 +5.<br/>Gold : " + me.getGold();
			invent.weapon1.setIs_bought(true);
			invent.setWeapon1(Ipad);
			invent.applyWeapon(me, Ipad);
			showMessage(inform);
		} else if (invent.weapon1.getIs_bought() == true) {
			showAlert();
		}
		return 1;
	}

	public int buyHood(Me me, Armor Hood, Inventory invent) {
		// showMessage(inform);
		check = goldCheck(me, invent.armor2.getBuyGold());
		if ((check != 1) && (!invent.armor2.getIs_bought())) {
			me.setGold(me.getGold() - invent.armor2.getBuyGold());
			inform += "새내기 후드티를 구매하였습니다.<br/>방어력 +5.<br/>Gold : " + me.getGold();
			invent.armor2.setIs_bought(true);
			invent.setArmor1(Hood);
			invent.applyArmor(me, Hood);
			showMessage(inform);
		} else if (invent.armor2.getIs_bought() == true) {
			showAlert();
		}
		return 1;
	}

	public int buyMacbook(Me me, Weapon Macbook, Inventory invent) {
		// showMessage(inform);
		check = goldCheck(me, invent.weapon2.getBuyGold());
		if ((check != 1) && (!invent.weapon2.getIs_bought())) {
			me.setGold(me.getGold() - invent.weapon2.getBuyGold());
			inform += "맥북을 구매하였습니다.<br/>공격력 +7.<br/>Gold : " + me.getGold();
			invent.setWeapon2(Macbook);
			invent.weapon2.setIs_bought(true);
			invent.applyWeapon(me, Macbook);
			showMessage(inform);
		} else if (invent.weapon2.getIs_bought() == true) {
			showAlert();
		}
		return 1;
	}

	public int buyNote(Me me, Weapon Note, Inventory invent) {
		// showMessage(inform);
		check = goldCheck(me, invent.weapon3.getBuyGold());
		if ((check != 1) && (!invent.weapon3.getIs_bought())) {
			me.setGold(me.getGold() - invent.weapon3.getBuyGold());
			inform += "선배의 필기노트를 구매하였습니다.<br/>공격력 +10.<br/>Gold : " + me.getGold();
			invent.weapon3.setIs_bought(true);
			invent.setWeapon3(Note);
			invent.applyWeapon(me, Note);
			showMessage(inform);
		} else if (invent.weapon3.getIs_bought() == true) {
			showAlert();
		}
		return 1;
	}

	public int buyTA(Me me, Weapon TA, Inventory invent) {
		// showMessage(inform);
		check = goldCheck(me, 60);
		if ((check != 1) && (!invent.weapon4.getIs_bought())) {
			me.setGold(me.getGold() - invent.weapon4.getBuyGold());
			inform += "TA 세션을 들었습니다.<br/>공격력 +12.<br/>Gold : " + me.getGold();
			invent.weapon4.setIs_bought(true);
			invent.setWeapon4(TA);
			invent.applyWeapon(me, TA);
			showMessage(inform);
		} else if (invent.weapon4.getIs_bought() == true) {
			showAlert();
		}
		return 1;
	}

	public void showAlert() {
		JOptionPane.showMessageDialog(null, "이미 가지고 있는 아이템입니다.");
	}

	public int goldCheck(Me me, int i) {
		if (me.getGold() - i < 0) {
			JOptionPane.showMessageDialog(null, "소지 Gold가 부족합니다!");
			return 1;
		}
		return 0;

	}

	public void showMessage(String mes) {
		lblNewLabel_8.setText(mes);
		inform = "<html>";
	}

	public String settingInform(Me me, Potion hp, Potion mp, String mes) {
		mes += "Attack : " + me.getAtk() + "<br/>Defense : " + me.getDef() + "<br/>HP potion : " + hp.getNumber()
				+ "<br/>MP potion" + mp.getNumber() + "<br/>Gold : " + me.getGold();
		return mes;
	}

	public static void quitFrame() {
		frame.setVisible(false);
	}
}
