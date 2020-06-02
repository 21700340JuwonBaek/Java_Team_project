package grade;

import java.util.Scanner;

import character.Me;
import character.Monster;
import inventory.Inventory;

public class Sophomore extends Freshman {
	public final static Monster[] ER2 = new Monster[3];
	{ER2[0] = new Monster("2학년교필 서평",1,1,5,1,60 );
	ER2[1] = new Monster("2학년교필중간고사",1,1,5,1,60 );
	ER2[2] = new Monster("2학년교필기말고사",1,1,5,1,60 );
	}
	
	
	public final static Monster[]MR2 = new Monster[3];{
	MR2[0] = new Monster("2학년전필코딩과제",1,1,5,1,60 );
	MR2[1] = new Monster("2학년전필중간고사",1,1,5,1,60 );
	MR2[2] = new Monster("2학년전필기말고사",1,1,5,1,60 );
	}
	
	public final static Monster[] ES2 = new Monster[3]; {
		
	ES2[0] = new Monster("2학년교선서평",1,1,5,1,60 );
	ES2[1] = new Monster("2학년교션중간고사",1,1,5,1,60 );
	ES2[2] = new Monster("2학년교선기말고사",1,1,5,1,60 );
	}
	
	public final static Monster[]MS2 = new Monster[3];{
	MS2[0] = new Monster("2학년전선코딩과제",1,1,5,1,60 );
	MS2[1] = new Monster("2학년전선중간고사",1,1,5,1,60 );
	MS2[2] = new Monster("2학년전선기말고사",1,1,5,1,60 );
	}
	
	public Sophomore(String major1, String major2, String education1, String eucation2) {
		super(major1, major2, education1, eucation2);
		skill[3].setOpen(true);
	}
	
public static void GoToDungeon(Me me, Inventory invent){

		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select the Dungeon\n\n1."+Major_require.getName());
		System.out.println("2."+Education_require.getName());
		System.out.println("3."+Major_select.getName());
		System.out.println("4."+Education_select.getName());


		int select = sc.nextInt();
		
		if(select == 1) {
			Major_require.fight(me, skill, MR2, invent);
		}
		if(select == 2) {
			Education_require.fight(me, skill, ER2, invent);
		}
		if(select == 3) {
			Major_select.fight(me, skill, MS2, invent);
		}
		if(select == 4) {
			Education_select.fight(me, skill, ES2, invent);
		}
		
	}
	
	
}
