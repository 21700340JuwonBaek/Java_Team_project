package fgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import grade.*;
import windowbuilder.HandongDungeons;

public class Select implements ActionListener{
		JFrame f4;
		JPanel p1;
	
	public Select(){
		
		f4 = new JFrame();
		JPanel p1 = new JPanel();
		f4.setSize(320,320); 
		f4.setResizable(false);//창의 크기를 변경하지 못하게
		p1.setBackground(Color.white);
		f4.setTitle("Select class");
		f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	f1.setLayout(null);
		p1.setLayout(null);
		
		
		JButton b1 = new JButton("Education Require");
		JButton b2 = new JButton("Major Require");
//		JButton b3 = new JButton("Education Select");
//		JButton b4 = new JButton("Major Select");
		
		b1.setBounds(10,10,300,80);
		b2.setBounds(10,90,300,80);
		//b3.setBounds(((c_size-150)/2),460,150,80);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		//b3.addActionListener(this);
		
		p1.add(b1);
		p1.add(b2);
		//p1.add(b3);
		f4.add(p1);
		f4.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Education Require") {
			new HandongERClass();
			f4.setVisible(false);
			Handong1.f2.setVisible(false);
		}
		else if(e.getActionCommand() == "Major Require") {
			// new HandongMRClass();
			new HandongDungeons(null);
			f4.setVisible(false);
			Handong1.f2.setVisible(false);
		}
	}
}
