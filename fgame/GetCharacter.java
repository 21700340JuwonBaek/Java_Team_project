package fgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import character.Me;

public class GetCharacter implements ActionListener {
	 public static JFrame f1;
	JPanel p1;
	public static Me me;
	JLabel j1;
	JTextField t1;
	JButton b1;
	 public static String name;

	public GetCharacter(){
		
		f1 = new JFrame();
		JPanel p1 = new JPanel();
		f1.setSize(320,200); 
		f1.setResizable(false);//창의 크기를 변경하지 못하게
		p1.setBackground(Color.white);
		f1.setTitle("User Setting");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	f1.setLayout(null);
		p1.setLayout(null);
	
		j1 = new JLabel("Enter character name : ");
		t1 = new JTextField();
		b1 = new JButton("Enter");
		j1.setBounds(10,50,160,10);
		t1.setBounds(160,45,150,20);
		b1.setBounds(130,100,50,40);
		
		b1.addActionListener(this);
		
		p1.add(j1);
		p1.add(t1);
		p1.add(b1);
		f1.add(p1);
		f1.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Enter") {
			name = t1.getText();
			//new Handong1();
			//HandongStart.f1.setVisible(false);
			//f1.setVisible(false);
		}
	}
}
