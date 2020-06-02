package dungeon;

import character.Me;
import java.util.Scanner;
import character.Monster;
import inventory.Inventory;
import skill.Skill;

public class Education_select extends Dungeon {

	public Education_select(String name) {
		super(name);
	}

	public static void fight(Me me, Skill mySkill[], Monster monsters[], Inventory invent) {
		Scanner sc = new Scanner(System.in);
		// Print Dungeon name and Monsters
		System.out.println("Enter the dungeon");
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
			int i;
			for( i = 0 ; i < mySkill.length; i++) {
				if(mySkill[i].getOpen()==false) break;
				
				System.out.println(i+". "+mySkill[i].getName() + " 공격력 : 기본 데미지("+me.getAtk()+")"+"+" + mySkill[i].getDamage()+ " 필요 지식량: " + mySkill[i].getMana() + ")");
			}
			System.out.println(i+". 포션사용하기");
			System.out.println("스킬을 선택해주세요!");
			int select_skill = sc.nextInt();
			if(select_skill == i) {
				System.out.println("1. HP 포션 (소지한 포션 :" + invent.HpPotion.getNumber() +")");
				System.out.println("2. MP 포션 (소지한 포션 :" + invent.MpPotion.getNumber() +")");
				int Select_potion = sc.nextInt();
				if(Select_potion ==1) { Inventory.useHpPotion(me, invent.HpPotion); continue;}
				if(Select_potion ==2) { Inventory.useMpPotion(me, invent.MpPotion); continue;}

			}
			if(mySkill[select_skill].getRange()>monsters.length) {
				for( i = 0; i < monsters.length;i++)
				Me.Attack(mySkill[select_skill], monsters[i], me);
			}
			
			else {
			for( i = 0; i < mySkill[select_skill].getRange();i++) {
				System.out.println("공격할 몬스터를 선택해주세요!");
				int select = sc.nextInt();
			Me.Attack(mySkill[select_skill], monsters[select], me);
			}
			}

			// Clear condition
			
			for (i = 0; i < monsters.length; i++) {
				if (monsters[i].getHp() > 0)
					break;
			}
			if (i == monsters.length) {
				System.out.println("Dungeon Clear!");
				System.out.println();
				me.set_clear_education_require(true);
				return;
			}
			
			// Be attacked by monsters
			System.out.println();
			for (int j = 0; j < monsters.length; j++) {
				if (monsters[j].getHp() > 0) {
					System.out.println(monsters[j].getName() + j + " 에게 공격받았다!.");
					System.out.println(me.getDef() - monsters[j].getAtk());
					Monster.Attack(me, monsters[j]);
				}
			}
		}
	}
}