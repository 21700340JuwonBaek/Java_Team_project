package dungeon;

import character.Me;
import character.Monster;
import skill.Skill;

public class Education_require extends Dungeon {

	public Education_require(String name) {
		super(name);
	}
	
	public void fight(Me me,Skill mySkill[]) {
		Monster[] monsters = new Monster[5];
		monsters[0] = new Monster("한인교 소감문",3,1,5,1,10);
		monsters[1] = new Monster("한인교 소감문",3,1,5,1,10);
		monsters[2] = new Monster("한인교 소감문",3,1,5,1,10);
		monsters[3] = new Monster("한인교 소감문",3,1,5,1,10);
		monsters[4] = new Monster("한인교 소감문",3,1,5,1,10);

		
		
		while(me.getHp()>0) {
			System.out.println("내 체력 :"+me.getHp());
			for(int i = 0 ; i < monsters.length; i++) {
			System.out.println(i+" "+monsters[i].getNmae()+" : "+ monsters[i].getHp());
			}
			me.Attack(mySkill,monsters);
			int i;
			for(i = 0; i < monsters.length; i++) {
				if(monsters[i].getHp()>0)break;
			}
			if(i == monsters.length) return;
			
			
			monsters[0].Attack(me);
			monsters[1].Attack(me);
			monsters[2].Attack(me);
		}
		
		
	}

}