package grade;
import skill.Skill;
import dungeon.*;

import java.util.Scanner;
import character.Me;

public class Freshman {
	
	public static Skill[] skill = new Skill[5];{
	skill[0] = new Skill("Searching",5,1,3,true);//Skill name, Damage, Target, ManaSpent, Open
	skill[1] = new Skill("Praying",5,4,10,true);
	skill[2] = new Skill("Ask",10,1,10,true);
	skill[3] = new Skill(false);
	skill[4] = new Skill(false);

	}
	
	private static Education_require  Education_require;
	private static Major_require Major_require;
	
	public Freshman(String major1, String major2 , String education1, String eucation2) {
		this.Education_require = new Education_require(education1);
		this.Major_require = new Major_require(major1);
	}
	public static void GoToDungeon(Me me){

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select the Dungeon\n\n1."+Major_require.getName());
		System.out.println("2."+Education_require.getName());

		int select = sc.nextInt();
		
		if(select == 1) {
			System.out.println(me.get_clear_major_require());
			Major_require.fight(me, skill);
			System.out.println(me.get_clear_major_require());
		}
		if(select == 2) {
			Education_require.fight(me, skill);
		}
		
	}
	
	
	

}
