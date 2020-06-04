package grade;

import java.util.Scanner;

import character.Me;
import character.Monster;
import inventory.Inventory;

public class Senior extends Junior {
	public final static Monster[] MR4 = new Monster[5];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MR4[0] = new Monster("졸업논문1", 5, 1, 5, 1, 50);
		MR4[1] = new Monster("캡스톤", 4, 1, 5, 1, 65);
		MR4[2] = new Monster("팀프로젝트", 3, 1, 5, 1, 50);
		MR4[3] = new Monster("취업준비", 7, 1, 5, 1, 65);
		MR4[4] = new Monster("졸업논문2", 5, 1, 5, 1, 50);
		for(int i = 0; i < MR4.length; i++) {
			MR4[i].setMaxHp(MR4[i].getHp());
		}
	}

	public final static Monster[] ER4 = new Monster[5];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ER4[0] = new Monster("인자기", 1, 1, 5, 1, 10);
		ER4[1] = new Monster("졸업영어", 3, 1, 5, 1, 40);
		ER4[2] = new Monster("서평1", 5, 1, 5, 1, 40);
		ER4[3] = new Monster("레포트", 5, 1, 5, 1, 45);
		ER4[4] = new Monster("서평2", 5, 1, 5, 1, 40);
		for(int i = 0; i < MR4.length; i++) {
			ER4[i].setMaxHp(ER4[i].getHp());
		}
	}

	public final static Monster[] MS4 = new Monster[5];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MS4[0] = new Monster("졸업논문1", 5, 1, 5, 1, 50);
		MS4[1] = new Monster("캡스톤", 7, 1, 5, 1, 60);
		MS4[2] = new Monster("팀프로젝트", 4, 1, 5, 1, 50);
		MS4[3] = new Monster("취업준비", 7, 1, 5, 1, 65);
		MS4[4] = new Monster("졸업논문2", 6, 1, 5, 1, 60);
		for(int i = 0; i < MR4.length; i++) {
			MS4[i].setMaxHp(MS4[i].getHp());
		}
	}

	public final static Monster[] ES4 = new Monster[5];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ES4[0] = new Monster("인자기", 3, 1, 5, 1, 10);
		ES4[1] = new Monster("졸업영어", 5, 1, 5, 1, 40);
		ES4[2] = new Monster("서평1", 5, 1, 5, 1, 40);
		ES4[3] = new Monster("레포트", 5, 1, 5, 1, 50);
		ES4[4] = new Monster("서평2", 5, 1, 5, 1, 40);
		for(int i = 0; i < MR4.length; i++) {
			ES4[i].setMaxHp(ES4[i].getHp());
		}

	}

	public Senior(String major1, String major2, String education1, String eucation2) {
		super(major1, major2, education1, eucation2);
	}

	public static void GoToDungeon(Me me, Inventory invent) {
		for(int i = 0; i < MR4.length;i++) {			
			MR4[i].setHp(MR4[i].getMaxHp());
			ER4[i].setHp(ER4[i].getMaxHp());
			MS4[i].setHp(MS4[i].getMaxHp());
			ES4[i].setHp(ES4[i].getMaxHp());

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
				Major_require.fight(me, skill, MR4, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}
			else if (select == 2) {
				if(me.get_clear_education_require()== true) return;
				Education_require.fight(me, skill, ER4, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}
			else if (select == 3) {
				if(me.get_clear_major_select()== true) return;
				Major_select.fight(me, skill, MS4, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}
			else if (select == 4) {
				if(me.get_clear_education_select()== true) return;
				Education_select.fight(me, skill, ES4, invent);
				me.setHp(me.getMaxHp());
				me.setMp(me.getMaxMp());
			}else if (select == 5) {
				return;
			}
		
	}
public static void Major_r(Me me,Inventory invent) {
	Major_require.fight(me, skill, MR4, invent);
	me.setHp(me.getMaxHp());
	me.setMp(me.getMaxMp());
}
public static void Education_r(Me me,Inventory invent) {
	Education_require.fight(me, skill, ER4, invent);
	me.setHp(me.getMaxHp());
	me.setMp(me.getMaxMp());
}
public static void Major_s(Me me,Inventory invent) {
	Major_select.fight(me, skill, MS4, invent);
	me.setHp(me.getMaxHp());
	me.setMp(me.getMaxMp());
}
public static void Education_s(Me me,Inventory invent) {
	Education_select.fight(me, skill, ES4, invent);
	me.setHp(me.getMaxHp());
	me.setMp(me.getMaxMp());
}

	
	
}