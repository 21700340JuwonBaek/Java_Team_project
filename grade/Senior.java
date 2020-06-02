package grade;

import java.util.Scanner;

import character.Me;
import character.Monster;
import inventory.Inventory;

public class Senior extends Junior {
	public final static Monster[] ER4 = new Monster[3];
	{
		ER4[0] = new Monster("4학년교필 서평",1,1,5,1,60 );
		ER4[1] = new Monster("4학년교필중간고사",1,1,5,1,60 );
		ER4[2] = new Monster("4학년교필기말고사",1,1,5,1,60 );
		}
		
		
		public final static Monster[]MR4 = new Monster[3];{
		MR4[0] = new Monster("4학년전필코딩과제",1,1,5,1,60 );
		MR4[1] = new Monster("4학년전필중간고사",1,1,5,1,60 );
		MR4[2] = new Monster("4학년전필기말고사",1,1,5,1,60 );
		}
		
		public final static Monster[] ES4 = new Monster[3]; {
			
		ES4[0] = new Monster("4학년교선서평",1,1,5,1,60 );
		ES4[1] = new Monster("4학년교션중간고사",1,1,5,1,60 );
		ES4[2] = new Monster("4학년교선기말고사",1,1,5,1,60 );
		}
		
		public final static Monster[]MS4 = new Monster[3];{
		MS4[0] = new Monster("4학년전선코딩과제",1,1,5,1,60 );
		MS4[1] = new Monster("4학년전선중간고사",1,1,5,1,60 );
		MS4[2] = new Monster("4학년전선기말고사",1,1,5,1,60 );
		}
		
	public Senior(String major1, String major2, String education1, String eucation2) {
		super(major1, major2, education1, eucation2);
	}
public static void GoToDungeon(Me me, Inventory invent){

		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select the Dungeon\n\n1."+Major_require.getName());
		System.out.println("2."+Education_require.getName());
		System.out.println("3."+Major_select.getName());
		System.out.println("4."+Education_select.getName());


		int select = sc.nextInt();
		
		if(select == 1) {
			Major_require.fight(me, skill, MR4, invent);
		}
		if(select == 2) {
			Education_require.fight(me, skill, ER4, invent);
		}
		if(select == 3) {
			Major_select.fight(me, skill, MS4, invent);
		}
		if(select == 4) {
			Education_select.fight(me, skill, ES4, invent);
		}
		
	}
	
	
}