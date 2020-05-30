package dungeon;

import character.Me;
import character.Monster;
import skill.Skill;

public class Education_require extends Dungeon {

	public Education_require(String name) {
		super(name);
	}

	public static void fight(Me me, Skill mySkill[], Monster monsters[]) {

		// Print Dungeon name and Monsters
		System.out.println("Enter the dungeon : (Dungeon name)");
		for (int i = 0; i < monsters.length; i++)
			System.out.println("야생의 " + i + " " + monsters[i].getName() + " 몬스터가 나타났다!");
		
		// Battle
		while (me.getHp() > 0) {
			
			// Print my status
			System.out.println();
			System.out.println("[My status]");
			System.out.println("HP :" + me.getHp());
			System.out.println("MP :" + me.getMp());
			System.out.println();
			
			// Print monsters status
			System.out.println("[Monsters status]");
			for (int i = 0; i < monsters.length; i++) {
				if (monsters[i].getHp() < 0) {
					System.out.println(i + " " + monsters[i].getName() + ": 0");
					continue;
				}
				System.out.println(i + " " + monsters[i].getName() + " : " + monsters[i].getHp());
			}
			System.out.println();
			me.Attack(mySkill, monsters, me);

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
			System.out.println();
			for (int j = 0; j < monsters.length; j++) {
				if (monsters[j].getHp() > 0) {
					System.out.println(monsters[j].getName() + j + " 에게 공격받았다!.");
					System.out.println(me.getDef() - monsters[j].getAtk());
					monsters[j].Attack(me, monsters[j]);
				}
			}
		}
		if (me.getHp() > 0) {
			me.set_clear_education_require(true);
		}
	}
}