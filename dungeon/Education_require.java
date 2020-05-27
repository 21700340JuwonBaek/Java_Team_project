package dungeon;

import character.Me;
import character.Monster;
import skill.Skill;

public class Education_require extends Dungeon {

	public Education_require(String name) {
		super(name);
	}

	public void fight(Me me, Skill mySkill[]) {

		System.out.println("Enter the dungeon : Handong Insung GyeoYook");

		Monster[] monsters = new Monster[5];
		monsters[0] = new Monster("한인교 소감문", 3, 1, 5, 1, 10);
		monsters[1] = new Monster("한인교 소감문", 3, 1, 5, 1, 10);
		monsters[2] = new Monster("한인교 소감문", 3, 1, 5, 1, 10);
		monsters[3] = new Monster("한인교 소감문", 3, 1, 5, 1, 10);
		monsters[4] = new Monster("한인교 소감문", 3, 1, 5, 1, 10);

		for (int i = 0; i < monsters.length; i++) {
			System.out.println("야생의 " + i + " " + monsters[0].getName() + " 몬스터가 나타났다!");
		}

		while (me.getHp() > 0) {

			System.out.println();
			System.out.println("[My status]");
			System.out.println("HP :" + me.getHp());
			System.out.println("MP :" + me.getMp());
			System.out.println();

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

			System.out.println();
			for (int j = 0; j < monsters.length; j++) {
				if (monsters[j].getHp() > 0) {
					System.out.println(monsters[j].getName() + j + " 에게 공격받았다!.");
					System.out.println(me.getDef() - monsters[j].getAtk());
					monsters[j].Attack(me, monsters[j]);
				}
			}
			if (me.getHp() > 0) {
				me.set_clear_education_require(true);
			}
		}
	}
}