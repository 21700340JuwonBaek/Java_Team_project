package fgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import character.Me;
import grade.Freshman;

public class Handong1 implements ActionListener{
	static JFrame f2;
	JPanel p2;
	int c_size = HandongStart.c_size;
	int l_size = HandongStart.l_size;
	ImageIcon icon;
	//JScrollPane scrollPane;
	BufferedImage img;

	
	@SuppressWarnings("serial")
	public Handong1() {
		
		icon = new ImageIcon("/Users/ryumi/Desktop/HGU_front.jpg");
		Image im1 = icon.getImage();
		Image rim1 = im1.getScaledInstance(c_size, l_size, Image.SCALE_SMOOTH);
		icon = new ImageIcon(rim1);
		f2 = new JFrame();
		JPanel p1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		p2 = new JPanel();
		f2.setSize(c_size, l_size);
		f2.setResizable(false);//창의 크기를 변경하지 못하게
		p2.setBackground(Color.white);
		f2.setTitle("Handong RPG Game");
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setLayout(null);
		p1.setLayout(null);
		p2.setLayout(null);
		
		p1.setBounds(0,0,c_size,l_size);
		p2.setBounds(160,350,160,150);
		JButton b1 = new JButton("Having class");
		JButton b2 = new JButton("Inventory");
		JButton b3 = new JButton("Item store");
		b1.setBounds(10,340,100,50);
		b2.setBounds(10,400,100,50);
		b3.setBounds(10,460,100,50);
		
		JLabel l1 = new JLabel("Character Info.");
		JLabel c_name= new JLabel("Name : "+GetCharacter.me.getName());
		JLabel c_hp = new JLabel("HP : "+GetCharacter.me.getHp());
		JLabel c_attack = new JLabel("Attck : "+GetCharacter.me.getAtk());
		JLabel c_gold = new JLabel("Gold : "+GetCharacter.me.getGold());
		l1.setBounds(0,0,100,30);
		c_name.setBounds(0,30,100,25);
		c_hp.setBounds(0,60,100,25);
		c_attack.setBounds(0,90,100,25);
		c_gold.setBounds(0,120,100,25);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p2.add(l1);
		p2.add(c_name);
		p2.add(c_hp);
		p2.add(c_attack);
		p2.add(c_gold);
	   // f2.setContentPane(p1);
		f2.add(p2);
		f2.add(p1);
		f2.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Having class") {
			//new Select();
		}
		if(e.getActionCommand() == "Inventory") {
			
		}
		if(e.getActionCommand() == "Item store") {
			
		}
	}
	
}
