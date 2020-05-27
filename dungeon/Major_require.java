package dungeon;

import character.*;
import skill.Skill;

public class Major_require extends Dungeon {

	public Major_require(String name) {
		super(name);
	}
	
	private int grade = 1;

	public void fight(Me me, Skill mySkill[]) {
		
		System.out.println("Enter the dungeon. : Introductory Engineering");

		Monster[] monsters = new Monster[3];
		monsters[0] = new Monster("보고서", 10, 1, 5, 1, 30);
		monsters[1] = new Monster("Line tracer", 10, 1, 5, 1, 30);
		monsters[2] = new Monster("Wrestling robot", 10, 1, 5, 1, 30);
		
		System.out.println("야생의"+ monsters[0].getName() +" 몬스터가 나타났다!");
		System.out.println("야생의"+ monsters[1].getName() +" 몬스터가 나타났다!");
		System.out.println("야생의"+ monsters[2].getName() +" 몬스터가 나타났다!");
		
		// Battle
		while ((monsters[0].getHp() > 0 || monsters[1].getHp() > 0 || monsters[2].getHp() > 0) && me.getHp() > 0) {

			System.out.println();
			System.out.println("[My status]");
			System.out.println("HP :" + me.getHp());
			System.out.println("MP :" + me.getMp());
			System.out.println();
			
			// Monster status
			System.out.println("[Monsters status]");
			for (int i = 0; i < monsters.length; i++) {
				System.out.println(i + " " + monsters[i].getName() + " Hp : " + monsters[i].getHp());
			}
			
			System.out.println();
			me.Attack(mySkill, monsters, me);
			System.out.println();
			
			// Clear condition
			int i;
			for (i = 0; i < monsters.length; i++) {
				if (monsters[i].getHp() > 0)
					break;
			}
			if (i == monsters.length) {
				System.out.println("Dungeon Clear!");
				System.out.println();
				return;
			}
			
			// Be attacked by monsters
			for (int j = 0; j < 3; j++) {
				if (monsters[j].getHp() > 0) {
					System.out.println(monsters[j].getName() + j + " 에게 공격받았다!." + (me.getDef() - monsters[j].getAtk()));
					monsters[j].Attack(me, monsters[j]);
				}
			}
			if (me.getHp() > 0) {
				me.set_clear_major_require(true);
			}
		}
	}
}