package grade;

import java.util.Scanner;

import character.Me;
import character.Monster;
import inventory.Inventory;

public class Junior extends Sophomore{
	
	
		
		public final static Monster[] ER3 = new Monster[3]; {
			
			ER3[0] = new Monster("3학년교필 서평",1,1,5,1,60 );
			ER3[1] = new Monster("3학년교필중간고사",1,1,5,1,60 );
			ER3[2] = new Monster("3학년교필기말고사",1,1,5,1,60 );
			}
			
			
			public final static Monster[]MR3 = new Monster[3];{
			MR3[0] = new Monster("3학년전필코딩과제",1,1,5,1,60 );
			MR3[1] = new Monster("3학년전필중간고사",1,1,5,1,60 );
			MR3[2] = new Monster("3학년전필기말고사",1,1,5,1,60 );
			}
			
			public final static Monster[] ES3 = new Monster[3]; {
				
			ES3[0] = new Monster("3학년교선서평",1,1,5,1,60 );
			ES3[1] = new Monster("3학년교션중간고사",1,1,5,1,60 );
			ES3[2] = new Monster("3학년교선기말고사",1,1,5,1,60 );
			}
			
			public final static Monster[]MS3 = new Monster[3];{
			MS3[0] = new Monster("3학년전선코딩과제",1,1,5,1,60 );
			MS3[1] = new Monster("3학년전선중간고사",1,1,5,1,60 );
			MS3[2] = new Monster("3학년전선기말고사",1,1,5,1,60 );
			}
			

	public Junior(String major1, String major2, String education1, String eucation2) {
		super(major1, major2, education1, eucation2);
		skill[4].setOpen(true);
	}
	
	public static void GoToDungeon(Me me, Inventory invent){

		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select the Dungeon\n\n1."+Major_require.getName());
		System.out.println("2."+Education_require.getName());
		System.out.println("3."+Major_select.getName());
		System.out.println("4."+Education_select.getName());


		int select = sc.nextInt();
		
		if(select == 1) {
			Major_require.fight(me, skill, MR3, invent);
		}
		if(select == 2) {
			Education_require.fight(me, skill, ER3, invent);
		}
		if(select == 3) {
			Major_select.fight(me, skill, MS3, invent);
		}
		if(select == 4) {
			Education_select.fight(me, skill, ES3, invent);
		}
		
	}
	
	
}