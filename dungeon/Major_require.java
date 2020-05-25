package dungeon;
import character.*;
import skill.Skill;

public class Major_require extends Dungeon {
	
	public Major_require(String name) {
		super(name);
	}

	private String name;
	private int grade = 1;

	public void fight(Me me,Skill mySkill[]) {
		Monster[] monsters = new Monster[3];
		monsters[0] = new Monster("C프로그래밍 퀴즈",10,1,5,1,30);
		monsters[1] = new Monster("C프로그래밍 퀴즈",10,1,5,1,30);
		monsters[2] = new Monster("C프로그래밍 퀴즈",10,1,5,1,30);
		
		
		while((monsters[0].getHp()>0||monsters[1].getHp()>0||monsters[2].getHp()>0)&&me.getHp()>0) {
			System.out.println("내 체력 :"+me.getHp());
			for(int i = 0 ; i < monsters.length; i++) {
			System.out.println(i+" "+monsters[i].getNmae()+" : "+ monsters[i].getHp());
			}
			me.Attack(mySkill,monsters);
			monsters[0].Attack(me);
			monsters[1].Attack(me);
			monsters[2].Attack(me);
		}
		if(me.getHp()>0) {
			me.set_clear_major_require(true);
		}
		
	}
}