/*
 * 이게 구조적으로 좋은지 생각해보기
 */

package gui;
import java.awt.*;
import javax.swing.*;
import main.Main;
import java.awt.event.*;

public class RpgGui extends JFrame {
	static JFrame f;
	static JPanel meInfoP;
	static JPanel mainP;
	static JPanel dungeonP;
	
	
	// Default constructor
	public RpgGui () {	
		f = new JFrame("Handong RPG");
	}
	
	public void showMainWindow() {
		makeMainP();
		makeMeInfoP();
		makeDungeonP();
		
		f.add(mainP);
		f.setSize(500, 500);
		f.setVisible(true);
	}
	
	public void makeMainP() {
		mainP = new JPanel();
		JLabel l1 = new JLabel("Handong RPG");
		JLabel l2 = new JLabel("Main menu");
		JButton meInfoButton = new JButton("Character Information");
		meInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.getContentPane().removeAll();
				f.getContentPane().add(meInfoP);
				f.revalidate();
				f.repaint();
			}
		});
		JButton dungeonButton = new JButton("Go to a dungeon");
		meInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ***** 占쏙옙 占쏙옙 *****
			}
		});
		
		mainP.add(l1);
		mainP.add(l2);
		mainP.add(meInfoButton);
	}
	
	public void makeMeInfoP() {
		meInfoP = new JPanel();
		JLabel l = new JLabel("User information:");
		JLabel lName = new JLabel("Name: " + Main.userMe.getName());
		JLabel lAttack = new JLabel("Atk: " + Integer.toString(Main.userMe.getAtk()));
		JLabel lDef = new JLabel("Def: " + Integer.toString(Main.userMe.getDef()));
		JLabel lGold = new JLabel("Gold: " + Integer.toString(Main.userMe.getGold()));
		JLabel lCri = new JLabel("Cri: " + Integer.toString(Main.userMe.getCri()));
		JLabel lHp = new JLabel("Hp: " + Integer.toString(Main.userMe.getHp()));
		JButton mainButton = new JButton("Main menu");
		mainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.getContentPane().removeAll();
				f.getContentPane().add(mainP);
				f.revalidate();
				f.repaint();
			}
		});
		
		meInfoP.add(l);
		meInfoP.add(lName);
		meInfoP.add(lAttack);
		meInfoP.add(lDef);
		meInfoP.add(lGold);
		meInfoP.add(lCri);
		meInfoP.add(lHp);
		meInfoP.add(mainButton);
	}
	
	public void makeDungeonP() {
		// ***** 할 일 *****
	}
}
