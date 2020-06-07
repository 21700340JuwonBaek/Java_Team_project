package windowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import character.Me;
import inventory.Inventory;
import item.Armor;
import item.Potion;
import item.Weapon;
import main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;

public class ItemInventory extends JFrame {

	private JPanel contentPane;
	ImageIcon icon,icon2,x;
	ImageIcon [] icons = new ImageIcon[5];
	static ItemInventory frame;
	JLabel imghp,imgmp,imgipad,imghood,imgmacbook,imgnote,imgta;
	/**
	 * Launch the application.
	 */
	
			public static void run(Me me,Inventory invent,Potion hp, Potion mp, Weapon Ipad, Weapon Macbook, Weapon Note, Weapon TA, Armor Hood) {
				try {
					frame = new ItemInventory(me, invent,hp,mp,Ipad,Macbook,Note,TA,Hood);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public ItemInventory(Me me,Inventory invent,Potion hp, Potion mp, Weapon Ipad, Weapon Macbook, Weapon Note, Weapon TA, Armor Hood) {
		Info.quitFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BufferedImage hpPotion = null;
		BufferedImage mpPotion = null;
		BufferedImage xicon = null;
		BufferedImage [] items = new BufferedImage[5];
		try {
			xicon = ImageIO.read(this.getClass().getResource("/res/img/x.png"));
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
		//HP MP Potions
		Image X = xicon.getScaledInstance(88, 78, Image.SCALE_SMOOTH);
		Image imgHP = hpPotion.getScaledInstance(88, 78, Image.SCALE_SMOOTH);
		Image imgMP = mpPotion.getScaledInstance(88, 78, Image.SCALE_SMOOTH);
		icon = new ImageIcon(imgHP);
		icon2 = new ImageIcon(imgMP);
		x = new ImageIcon(X);
		
		//Weapon, armors
		Image [] imgs = new Image[5];
		for(int i=0;i<5;i++) {
			imgs[i] = items[i].getScaledInstance(88, 78, Image.SCALE_SMOOTH);
			icons[i] = new ImageIcon(imgs[i]);
		}
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(0, 0, 61, -221);
		contentPane.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(5, 5, 440, 268);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item list");
		lblNewLabel.setBounds(190, 6, 61, 16);
		panel.add(lblNewLabel);
		
		imghp = new JLabel(icon);
		imghp.setBounds(14, 43, 88, 78);
		panel.add(imghp);
		
		imgmp = new JLabel(icon2);
		imgmp.setBounds(114, 43, 88, 78);
		panel.add(imgmp);
		
		imgmacbook = new JLabel(icons[1]);
		imgmacbook.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(invent.weapon2.getIs_bought() == true) {
					int result= JOptionPane.showConfirmDialog(null, "아이템을 판매하시겠습니까?","종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == 0){
							me.setGold(me.getGold() + invent.weapon2.getSellGold());
							Inventory.detatchWeapon(me,Macbook);
							imgmacbook.setIcon(x);
							invent.weapon2.setIs_bought(false);
						}
				}
			}
		});
		imgmacbook.setBounds(24, 161, 88, 78);
		panel.add(imgmacbook);
		
		imgnote = new JLabel(icons[2]);
		imgnote.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(invent.weapon3.getIs_bought() == true) {
				int result= JOptionPane.showConfirmDialog(null, "아이템을 판매하시겠습니까?","종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(result == 0){
						me.setGold(me.getGold() + invent.weapon3.getSellGold());
						Inventory.detatchWeapon(me,Note);
						imgnote.setIcon(x);
						invent.weapon3.setIs_bought(false);
					}
				}
			}
		});
		imgnote.setBounds(114, 161, 88, 78);
		panel.add(imgnote);
		
		imgta = new JLabel(icons[3]);
		imgta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(invent.weapon4.getIs_bought() == true) {
					int result= JOptionPane.showConfirmDialog(null,"아이템을 판매하시겠습니까?","종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == 0){
						me.setGold(me.getGold() + invent.weapon4.getSellGold());
							Inventory.detatchWeapon(me,TA);
							imgta.setIcon(x);
							invent.weapon4.setIs_bought(false);
						}
					}
			}
		});
		imgta.setBounds(214, 161, 88, 78);
		panel.add(imgta);
		
		imgipad = new JLabel(icons[0]);
		imgipad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(invent.weapon1.getIs_bought() == true) {
					int result= JOptionPane.showConfirmDialog(null, "아이템을 판매하시겠습니까?","종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == 0){
							me.setGold(me.getGold() + invent.weapon1.getSellGold());
							Inventory.detatchWeapon(me,Ipad);
							imgipad.setIcon(x);
							invent.weapon1.setIs_bought(false);
						}
					}
			}
			
		});
		imgipad.setBounds(324, 43, 88, 78);
		panel.add(imgipad);
		
		JLabel imghood = new JLabel(icons[4]);
		imghood.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(invent.armor1.getIs_bought() == true) {
					int result= JOptionPane.showConfirmDialog(null, "아이템을 판매하시겠습니까?","종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == 0){
							me.setGold(me.getGold() + invent.armor1.getSellGold());
							Inventory.detatchArmor(me,Hood);
							imghood.setIcon(x);
							invent.armor1.setIs_bought(false);
						}
					}
			}
		});
		imghood.setBounds(218, 43, 88, 78);
		panel.add(imghood);
		
		JLabel hpL = new JLabel("HP potion x"+hp.getNumber());
		hpL.setBounds(14, 133, 88, 16);
		panel.add(hpL);
		
		JLabel mpL = new JLabel("HP potion x"+mp.getNumber());
		mpL.setBounds(114, 133, 88, 16);
		panel.add(mpL);
		
		JLabel hoodL = new JLabel("Hood");
		hoodL.setBounds(240, 133, 34, 16);
		panel.add(hoodL);
		
		JLabel mbL = new JLabel("MACBOOK");
		mbL.setBounds(31, 246, 81, 16);
		panel.add(mbL);
		
		JLabel noteL = new JLabel("Note");
		noteL.setBounds(141, 246, 34, 16);
		panel.add(noteL);
		
		JLabel taL = new JLabel("TA session");
		taL.setBounds(231, 246, 75, 16);
		panel.add(taL);
		
		JLabel ipadL = new JLabel("Ipad");
		ipadL.setBounds(349, 133, 34, 16);
		panel.add(ipadL);
		
		JButton btnNewButton = new JButton("뒤로가기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Main.getStart(me, invent, 2);
				Info.updateInfo();
				quitFrame();
			}
		});
		btnNewButton.setBounds(0, 1, 68, 29);
		panel.add(btnNewButton);
		
		if(!invent.weapon1.getIs_bought()) {
			imgipad.setIcon(x);
		}if(!invent.armor1.getIs_bought()) {
			imghood.setIcon(x);
		}if(!invent.weapon2.getIs_bought()) {
			imgmacbook.setIcon(x);
		}if(!invent.weapon3.getIs_bought()) {
			imgnote.setIcon(x);
		}if(!invent.weapon4.getIs_bought()) {
			imgta.setIcon(x);
		}	

				
				
	}
	public static void quitFrame() {
		frame.setVisible(false);
	}
}
