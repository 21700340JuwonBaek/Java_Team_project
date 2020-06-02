package dungeon;

import character.Me;
import java.util.Scanner;
import character.Monster;
import skill.Skill;

public class Major_require extends Dungeon {

	public Major_require(String name) {
		super(name);
	}

	public static void fight(Me me, Skill mySkill[], Monster[] monsters) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dungeon");
		for (int i = 0; i < monsters.length; i++)
			System.out.println("야생의" + monsters[i].getName() + " 몬스터가 나타났다!");

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
				if(monsters[i].getHp() > 0)
					System.out.println(i + " " + monsters[i].getName() + " Hp : " + monsters[i].getHp());
			}
			
			// Print skill window
			System.out.println();
			System.out.println("공격할 몬스터를 선택해주세요!");
			
			int select = sc.nextInt();
			for(int i = 0 ; i < mySkill.length; i++) {
				if(mySkill[i].getOpen()==false) continue;
				
				System.out.println(i+". "+mySkill[i].getName() + " 공격력 : 기본 데미지("+me.getAtk()+")"+"+" + mySkill[i].getDamage()+ " 필요 지식량: " + mySkill[i].getMana() + ")");
			}
			System.out.println("스킬을 선택해주세요!");
			int select_skill = sc.nextInt();
			Me.Attack(mySkill[select_skill], monsters[select], me);

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
				me.set_clear_major_require(true);
				return;
			}

			// Be attacked by monsters
			for (int j = 0; j < monsters.length; j++) {
				if (monsters[j].getHp() > 0) {
					System.out.println(monsters[j].getName() + j + " 에게 공격받았다! " + (me.getDef() - monsters[j].getAtk()));
					Monster.Attack(me, monsters[j]);
				}
			}
		}
	}
}