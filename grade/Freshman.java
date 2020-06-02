package grade;
import skill.Skill;
import dungeon.*;
import inventory.Inventory;

import java.util.Scanner;
import character.Me;
import character.Monster;

public class Freshman {
	
	public static Skill[] skill = new Skill[5];{
	skill[0] = new Skill("검색하기",5,1,3,true);//Skill name, Damage, Target, ManaSpent, Open
	skill[1] = new Skill("우주의 기원을 담아 기도하기...",5,4,10,true);
	skill[2] = new Skill("선배님 도와주세요...!",10,1,10,true);
	skill[3] = new Skill("논문찾아보기",20,1,15,false);
	skill[4] = new Skill("교수님께 메일보내보기",30,1,20,false);

	}
	
	public final static Monster[] ER = new Monster[3]; {
	
	ER[0] = new Monster("1학년교필 서평",1,1,5,1,60 );
	ER[1] = new Monster("1학년교필중간고사",1,1,5,1,60 );
	ER[2] = new Monster("1학년교필기말고사",1,1,5,1,60 );
	}
	
	
	public final static Monster[]MR = new Monster[3];{
	MR[0] = new Monster("1학년전필코딩과제",1,1,5,1,60 );
	MR[1] = new Monster("1학년전필중간고사",1,1,5,1,60 );
	MR[2] = new Monster("1학년전필기말고사",1,1,5,1,60 );
	}
	
	public final static Monster[] ES = new Monster[3]; {
		
	ES[0] = new Monster("1학년교선서평",1,1,5,1,60 );
	ES[1] = new Monster("1학년교션중간고사",1,1,5,1,60 );
	ES[2] = new Monster("1학년교선기말고사",1,1,5,1,60 );
	}
	
	public final static Monster[]MS = new Monster[3];{
	MS[0] = new Monster("1학년전선코딩과제",1,1,5,1,60 );
	MS[1] = new Monster("1학년전선중간고사",1,1,5,1,60 );
	MS[2] = new Monster("1학년전선기말고사",1,1,5,1,60 );
	}
	
	
	protected static Education_require  Education_require;
	protected static Major_require Major_require;
	protected static Education_select Education_select;
	protected static Major_select Major_select;
	//만약 학년별로 각 던전을 상속받는 클래스가 나온다면, 생성자에 int형 변수 파라미터를 추가해서.... if문으로 해야할 것 같다. 
	public Freshman(String major1, String major2 , String education1, String education2) {
		this.Education_require = new Education_require(education1);
		this.Major_require = new Major_require(major1);
		this.Education_select = new Education_select(education2);
		this.Major_select = new Major_select(major2);
		
	}
	public static void GoToDungeon(Me me,Inventory invent){

		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select the Dungeon\n\n1."+Major_require.getName());
		System.out.println("2."+Education_require.getName());
		System.out.println("3."+Major_select.getName());
		System.out.println("4."+Education_select.getName());


		int select = sc.nextInt();
		
		if(select == 1) {
			Major_require.fight(me, skill, MR, invent);
		}
		if(select == 2) {
			Education_require.fight(me, skill, ER, invent);
		}
		if(select == 3) {
			Major_select.fight(me, skill, MS, invent);
		}
		if(select == 4) {
			Education_select.fight(me, skill, ES, invent);
		}
		
	}
	
	
	

}