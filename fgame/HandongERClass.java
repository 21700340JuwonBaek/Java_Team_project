package fgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import dungeon.Education_require;
import character.Me;
import character.Monster;
import grade.*;
import skill.Skill;

public class HandongERClass implements ActionListener{
	JFrame f3;
	JPanel p1;
	int c_size = HandongStart.c_size;
	int l_size = HandongStart.l_size;
	ImageIcon icon;
	JLabel clear, fail;
	Font f1;	
	JLabel m[];
	int max;
	Monster [] monsters;
	Skill [] skills;
	
	@SuppressWarnings("serial")
	public HandongERClass() {
		
		icon = new ImageIcon("/Users/ryumi/Desktop/classroom.jpeg");
		Image back= icon.getImage();
		Image rim1 = back.getScaledInstance(c_size, l_size, Image.SCALE_SMOOTH);
		icon = new ImageIcon(rim1);
		f3 = new JFrame();
		p1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, c_size, l_size, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		f3.setSize(c_size, l_size);
		p1.setBackground(Color.white);
		f3.setTitle("Handong RPG Game");
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p1.setLayout(null);
		
		switch(GetCharacter.me.getGrade()) {
		case 1:	
			Freshman d1 = new Freshman("Introductory Engineering","Python","Handong Insung GyeoYook","Introductory Physics");
			max = d1.ER.length;
			monsters = d1.ER;
			skills = d1.skill;
		case 2:
			Sophomore d2 = new Sophomore("Data Structure","Java","ERC","Statistic");
			max = d2.ER.length;
			monsters = d2.ER;
			skills = d2.skill;
		case 3:
			Junior d3 = new Junior("OS","Gong Pu Gi","EAP","linear Algebra");
			max = d3.ER.length;
			monsters = d3.ER;
			skills = d3.skill;
			
		}
		
		
		ImageIcon [] images = new ImageIcon [max];
		for(int i=0;i<max;i++) {
			//몬스터 이미지 불러오기 객체 설정 
			images[i] = new ImageIcon("/Users/ryumi/Desktop/1.png");
			Image im1 = images[i].getImage();
			Image rmi1 = im1.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
			images[i] = new ImageIcon(rmi1);
			
			//객체 받아오기                   
		}   //
		m = new JLabel[max];
		for(int i=0;i<max;i++) {
			m[i] = new JLabel(images[i]);
			m[i].setBounds(30+(i*100),150,80,100);
			p1.add(m[i]);
		}
	
		f1 = new Font("돋움",Font.BOLD,70);
		clear = new JLabel();
		clear.setFont(f1);
		clear.setBounds(60,150,200,80);
		
		JButton b1 = new JButton(skills[0].getName());
		JButton b2 = new JButton(skills[1].getName());
		JButton b3 = new JButton(skills[2].getName());
		JButton b4 = new JButton(skills[3].getName());
		JButton b5 = new JButton(skills[4].getName());
		
		b1.setBounds(10,310,(c_size-10)/2,50);
		b2.setBounds(10,360,(c_size-10)/2,50);
		b3.setBounds(10,410,(c_size-10)/2,50);
		b4.setBounds(10,460,(c_size-10)/2,50);
		b5.setBounds(10,510,(c_size-10)/2,50);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		//p1.add(m1);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(clear);
		f3.add(p1);
		f3.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == skills[0].getName()) {
			//fight(me,skill1);
			//몬스터 체력확인 후 체력이 없으면 clear 띄우기! 
				if(HP_Check(monsters) == 1) {
					clear();
				}
				else if(GetCharacter.me.getHp() < 0) {
					//Monster.Attack(GetCharacter.me, monsters[i]);
				}
				else {
					int i=0;
					while(monsters[i].getHp() == 0) {
						i++;
					}
					//Me.Attack(skills[0], monsters[i], GetCharacter.me);
					while(monsters[i].getHp() == 0) {
						i++;
						if(i == max) {clear();}
					}
					for(int j =i;j<max;j++) {
						Monster.Attack(GetCharacter.me, monsters[i]);
					}
				}
			//본인 체력 확인후 체력이 없으면 fail 띄우기!
		}	
		else if(e.getActionCommand() == skills[1].getName()) {
			//fight(me,skill2);
		}
		else if(e.getActionCommand() == skills[2].getName()) {
			//fight(me,skill3);
		}
		else if(e.getActionCommand() == skills[3].getName()) {
			//fight(me,skill4);
		}
		
	}
	//파라메타로 
	public int HP_Check(Monster a[]) {
		int count = 0;
		//몬스터 및 객체 받고, 받은 객체의 HP가 있으면 return 1
		for(int i=0;i<max;i++) {
			if(a[i].getHp() == 0) count++;
		}
		if(count == max) return 1;
		//없으면 return 0
		else return 0;
	}
	public void clear() {
		clear.setText("Clear");
		f3.setVisible(false);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Handong1.f2.setVisible(true);
	}
	
}

