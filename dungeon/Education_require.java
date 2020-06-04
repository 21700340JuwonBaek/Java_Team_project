package dungeon;

import character.Me;
import inventory.Inventory;
import character.Monster;
import skill.Skill;
import windowbuilder.HandongDungeons;
import windowbuilder.Info;

import java.util.Scanner;

public class Education_require extends Dungeon {

	private static int getMoney = 0;

	public Education_require(String name) {
		super(name);
	}

	public static void fight(Me me, Skill mySkill[], Monster monsters[], Inventory invent) {

		int i, j = 0;

		HandongDungeons dungeon = new HandongDungeons(invent);
		dungeon.showPlayer(me);
		dungeon.showBG(3);
		dungeon.playBGM();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dungeon");
		String monsterMsg = "<html>";
		for (i = 0; i < monsters.length; i++) {
			String msg = "야생의" + monsters[i].getName() + " 몬스터가 나타났다!";
			System.out.println(msg);
			monsterMsg += msg + "<br/>";
		}
		monsterMsg += "</html>";
		HandongDungeons.showMonsters(monsters);
		dungeon.showMonsterImage(monsters, me.getGrade());
		HandongDungeons.updateMonsters(monsters);
		HandongDungeons.updateMe(me);
		HandongDungeons.showMessage(monsterMsg);

		// Battle
		while (me.getHp() > 0) {

			// Print my status
			System.out.println();
			System.out.println("[My status]");
			System.out.println("HP :" + me.getHp());
			System.out.println("MP :" + me.getMp());
			System.out.println("돈 " + me.getGold());
			System.out.println();
			HandongDungeons.updateMe(me);

			// Print monsters status
			System.out.println("[Monsters status]");
			for (i = 0; i < monsters.length; i++) {
				if (monsters[i].getHp() < 0) {
					System.out.println(i + " " + monsters[i].getName() + ": 0");
					continue;
				}
				System.out.println(i + " " + monsters[i].getName() + " : " + monsters[i].getHp());
			}
			HandongDungeons.updateMonsters(monsters);

			// Print skill window
			System.out.println();
			for (i = 0; i < mySkill.length; i++) {
				if (mySkill[i].getOpen() == false)
					continue;

				System.out.println(i + ". " + mySkill[i].getName() + " 공격력 : 기본 데미지(" + me.getAtk() + ")" + "+"
						+ mySkill[i].getDamage() + " 필요 지식량: " + mySkill[i].getMana() + ")");
			}
			System.out.println(i + ". 포션사용하기");
			System.out.println("스킬을 선택해주세요!");
			int select_skill = HandongDungeons.chooseSkill(mySkill);
			if (select_skill == mySkill.length) {
				System.out.println("1. HP 포션 (소지한 포션 :" + invent.HpPotion.getNumber() + ")");
				System.out.println("2. MP 포션 (소지한 포션 :" + invent.MpPotion.getNumber() + ")");

				int Select_potion = HandongDungeons.choosePotion(invent);
				if (Select_potion == 1) {
					Inventory.useHpPotion(me, invent.HpPotion);
					continue;
				}
				if (Select_potion == 2) {
					Inventory.useMpPotion(me, invent.MpPotion);
					continue;
				}

			}
			int remember_mana = mySkill[select_skill].getMana();
			System.out.println("Original mana: "+remember_mana);
			if (mySkill[select_skill].getRange() > monsters.length) {
				for (i = 0; i < monsters.length; i++) {
					if(mySkill[select_skill].getMana()> me.getMp()) break;
					Me.Attack(mySkill[select_skill], monsters[i], me);
					mySkill[select_skill].setMana(0);
				}

				mySkill[select_skill].setMana(remember_mana);
			} else {
				for (i = 0; i < mySkill[select_skill].getRange(); i++) {
					System.out.println("공격할 몬스터를 선택해주세요!");

					int select = HandongDungeons.chooseMonster(monsters);
					Me.Attack(mySkill[select_skill], monsters[select], me);
					mySkill[select_skill].setMana(0);
				}
				mySkill[select_skill].setMana(remember_mana);

			}
			System.out.println();

			// Clear condition
			for (; j < monsters.length; j++) {
				if (monsters[j].getHp() > 0)
					break;
			}
			if (j == monsters.length) {

				System.out.println("Dungeon Clear!");
				System.out.println();
				String clearMsg = "과목을 클리어 했습니다!";
				for(int k = 0; k<monsters.length;k++) {
					me.setGold(me.getGold()+monsters[k].getGold());
				}
				/////////////////////////////////////////////////////
				System.out.println("골드를 획득했습니다! +");
				//////////////////////////////////////////////////////

				HandongDungeons.showMessage(clearMsg);
				me.set_clear_education_require(true);
				break;
			}

			// Be attacked by monsters
			String monsterAtkMsg = "<html>";
			for (i = 0; i < monsters.length; i++) {
				if (monsters[i].getHp() > 0) {
					System.out.println(monsters[i].getName() + j + " 에게 공격받았다!.");
					Monster.Attack(me, monsters[i]);
					monsterAtkMsg += monsters[j].getName() + j + " 에게 공격받았다!<br/>";
				}
			}
			monsterAtkMsg += "</html>";
			HandongDungeons.showMessage(monsterAtkMsg);
		}
		
		dungeon.stopBGM();
		dungeon.frame.setVisible(false);
		Info.updateInfo();
	}
}