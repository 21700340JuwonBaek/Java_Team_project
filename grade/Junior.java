package grade;

import java.util.Scanner;

import character.Me;
import character.Monster;
import inventory.Inventory;

public class Junior extends Sophomore {

	public final static Monster[] MR3 = new Monster[4];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MR3[0] = new Monster("3학년전필코딩과제", 4, 1, 5, 1, 40);
		MR3[1] = new Monster("3학년전필중간고사", 5, 1, 5, 1, 45);
		MR3[2] = new Monster("3학년전필기말고사", 5, 1, 5, 1, 60);
		MR3[3] = new Monster("3학년교필기말고사", 5, 1, 5, 1, 60);
		
		for(int i = 0; i < MR3.length; i++) {
			MR3[i].setMaxHp(MR3[i].getHp());
		}
	}

	public final static Monster[] ER3 = new Monster[4];
	{
		// Skill name, Attack point, Target, ManaSpent, Open
		ER3[0] = new Monster("3학년교필 서평", 3, 1, 5, 1, 40);
		ER3[1] = new Monster("3학년교필 보고서", 5, 1, 5, 1, 45);
		ER3[2] = new Monster("3학년교필기말고사", 5, 1, 5, 1, 50);
		ER3[3] = new Monster("3학년교필기말고사", 5, 1, 5, 1, 50);
		for(int i = 0; i < MR3.length; i++) {
			ER3[i].setMaxHp(ER3[i].getHp());
		}
	}

	public final static Monster[] MS3 = new Monster[4];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MS3[0] = new Monster("3학년전선코딩과제", 4, 1, 5, 1, 30);
		MS3[1] = new Monster("3학년전선중간고사", 5, 1, 5, 1, 40);
		MS3[2] = new Monster("3학년전선기말고사", 5, 1, 5, 1, 60);
		MS3[3] = new Monster("3학년교필기말고사", 5, 1, 5, 1, 60);
		for(int i = 0; i < MR3.length; i++) {
			MS3[i].setMaxHp(MS3[i].getHp());
		}
	}

	public final static Monster[] ES3 = new Monster[4];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ES3[0] = new Monster("3학년교선서평", 3, 1, 5, 1, 30);
		ES3[1] = new Monster("3학년교션중간고사", 5, 1, 5, 1, 40);
		ES3[2] = new Monster("3학년교선기말고사", 5, 1, 5, 1, 50);
		ES3[3] = new Monster("3학년교필기말고사", 5, 1, 5, 1, 50);
		for(int i = 0; i < MR3.length; i++) {
			ES3[i].setMaxHp(ES3[i].getHp());
		}
	}

	public Junior(String major1, String major2, String education1, String eucation2) {
		super(major1, major2, education1, eucation2);
		skill[4].setOpen(true);
	}

	public static void GoToDungeon(Me me, Inventory invent) {
		for(int i = 0; i < MR3.length;i++) {			
			MR3[i].setHp(MR3[i].getMaxHp());
			ER3[i].setHp(ER3[i].getMaxHp());
			MS3[i].setHp(MS3[i].getMaxHp());
			ES3[i].setHp(ES3[i].getMaxHp());

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
				Major_require.fight(me, skill, MR3, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}
			else if (select == 2) {
				if(me.get_clear_education_require()== true) return;
				Education_require.fight(me, skill, ER3, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());

			}
			else if (select == 3) {
				if(me.get_clear_major_select()== true) return;
				Major_select.fight(me, skill, MS3, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}
			else if (select == 4) {
				if(me.get_clear_education_select()== true) return;
				Education_select.fight(me, skill, ES3, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}else if (select == 5) {
				return;
			}
		
	}
}