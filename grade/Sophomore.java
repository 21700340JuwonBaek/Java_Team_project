package grade;

import java.util.Scanner;

import character.Me;
import character.Monster;
import inventory.Inventory;

public class Sophomore extends Freshman {
	public final static Monster[] MR2 = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MR2[0] = new Monster("이진탐색", 4, 1, 5, 1, 40);
		MR2[1] = new Monster("중간고사", 6, 1, 5, 1, 60);
		MR2[2] = new Monster("기말고사", 6, 1, 5, 1, 60);
		for(int i = 0; i < MR2.length; i++) {
			MR2[i].setMaxHp(MR2[i].getHp());
		}
	}

	public final static Monster[] ER2 = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ER2[0] = new Monster("Essay", 3, 1, 5, 1, 40);
		ER2[1] = new Monster("Midterm exam", 5, 1, 5, 1, 50);
		ER2[2] = new Monster("Final exam", 5, 1, 5, 1, 50);
		for(int i = 0; i < MR2.length; i++) {
			ER2[i].setMaxHp(ER2[i].getHp());
		}
	}

	public final static Monster[] MS2 = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MS2[0] = new Monster("LMS 강의", 5, 1, 5, 1, 40);
		MS2[1] = new Monster("Lab problems", 7, 1, 5, 1, 60);
		MS2[2] = new Monster("Team project", 7, 1, 5, 1, 60);
		for(int i = 0; i < MR2.length; i++) {
			MS2[i].setMaxHp(MS2[i].getHp());
		}
	}

	public final static Monster[] ES2 = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ES2[0] = new Monster("LMS 강의", 4, 1, 5, 1, 40);
		ES2[1] = new Monster("중간고사", 6, 1, 5, 1, 50);
		ES2[2] = new Monster("기말고사", 6, 1, 5, 1, 50);
		for(int i = 0; i < MR2.length; i++) {
			ES2[i].setMaxHp(ES2[i].getHp());
		}
	}

	public Sophomore(String major1, String major2, String education1, String eucation2) {
		super(major1, major2, education1, eucation2);
		skill[3].setOpen(true);
	}

	public static void GoToDungeon(Me me, Inventory invent) {
		for(int i = 0; i < MR2.length;i++) {			
			MR2[i].setHp(MR2[i].getMaxHp());
			ER2[i].setHp(ER2[i].getMaxHp());
			MS2[i].setHp(MS2[i].getMaxHp());
			ES2[i].setHp(ES2[i].getMaxHp());

		}
	
			Scanner sc = new Scanner(System.in);
			if(me.get_clear_major_require()==false)System.out.println("던전 선택\n1." + Major_require.getName());
			else System.out.println("던전 선택\n1." + Major_require.getName()+"(Clear!)");
			
			if(me.get_clear_education_require()==false)System.out.println("2." + Education_require.getName());
			else System.out.println("2." + Education_require.getName()+"(Clear!)");
			
			if(me.get_clear_major_select()==false) System.out.println("3." + Major_select.getName());
			else System.out.println("3." + Major_select.getName()+"(Clear!)");
			
			if(me.get_clear_education_select()==false)System.out.println("4." + Education_select.getName());
			else System.out.println("4." + Education_select.getName()+"(Clear!)");
			System.out.println("5. 뒤로가기");
			int select = sc.nextInt();
			if (select == 1) {
				if(me.get_clear_major_require()== true) return;
				Major_require.fight(me, skill, MR2, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}
			else if (select == 2) {
				if(me.get_clear_education_require()== true) return;
				Education_require.fight(me, skill, ER2, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}
			else if (select == 3) {
				if(me.get_clear_major_select()== true) return;
				Major_select.fight(me, skill, MS2, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}
			else if (select == 4) {
				if(me.get_clear_education_select()== true) return;
				Education_select.fight(me, skill, ES2, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}else if (select == 5) {
				return;
			}
		
	}
public static void Major_r(Me me,Inventory invent) {
	Major_require.fight(me, skill, MR, invent);
}
public static void Education_r(Me me,Inventory invent) {
	Education_require.fight(me, skill, ER, invent);
}
public static void Major_s(Me me,Inventory invent) {
	Major_select.fight(me, skill, MS, invent);
}
public static void Education_s(Me me,Inventory invent) {
	Education_select.fight(me, skill, ES, invent);
}

	
	
}