package grade;

import skill.Skill;
import dungeon.*;
import inventory.Inventory;

import java.util.Scanner;
import character.Me;
import character.Monster;

public class Freshman {

	public static Skill[] skill = new Skill[5];
	{
		// Skill name, Attack point, Target, ManaSpent, Open
		skill[0] = new Skill("검색하기", 5, 1, 3, true);
		skill[1] = new Skill("우주의 기원을 담아 기도하기...", 5, 4, 10, true);
		skill[2] = new Skill("선배님 도와주세요...!", 10, 1, 10, true);
		skill[3] = new Skill("논문찾아보기", 20, 1, 15, false);
		skill[4] = new Skill("교수님께 메일보내보기", 30, 1, 20, false);
	}

	public final static Monster[] MR = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MR[0] = new Monster("라인 트레이서", 3, 1, 5, 1, 30);
		MR[1] = new Monster("공설입 중간고사", 5, 1, 5, 1, 50);
		MR[2] = new Monster("공설입 기말고사", 5, 1, 5, 1, 50);
	}

	public final static Monster[] ER = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ER[0] = new Monster("한인교 보고서", 3, 1, 5, 1, 30);
		ER[1] = new Monster("한인교 보고서", 3, 1, 5, 1, 30);
		ER[2] = new Monster("한인교 보고서", 3, 1, 5, 1, 30);
	}

	public final static Monster[] MS = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MS[0] = new Monster("코딩과제", 3, 1, 5, 1, 30);
		MS[1] = new Monster("파이썬 중간고사", 5, 1, 5, 1, 50);
		MS[2] = new Monster("파이썬 기말고사", 5, 1, 5, 1, 50);
	}

	public final static Monster[] ES = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ES[0] = new Monster("F=ma", 3, 1, 5, 1, 20);
		ES[1] = new Monster("상대성 이론", 5, 1, 5, 1, 40);
		ES[2] = new Monster("베르누이 법칙", 5, 1, 5, 1, 40);
	}

	protected static Education_require Education_require;
	protected static Major_require Major_require;
	protected static Education_select Education_select;
	protected static Major_select Major_select;

	// 만약 학년별로 각 던전을 상속받는 클래스가 나온다면, 생성자에 int형 변수 파라미터를 추가해서.... if문으로 해야할 것 같다.
	public Freshman(String major1, String major2, String education1, String education2) {
		Freshman.Education_require = new Education_require(education1);
		Freshman.Major_require = new Major_require(major1);
		Freshman.Education_select = new Education_select(education2);
		Freshman.Major_select = new Major_select(major2);
	}

	public static void GoToDungeon(Me me, Inventory invent) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("던전 선택\n1." + Major_require.getName());
			System.out.println("2." + Education_require.getName());
			System.out.println("3." + Major_select.getName());
			System.out.println("4." + Education_select.getName());
			System.out.println("5. 뒤로가기");
			int select = sc.nextInt();

			if (select == 1) {
				Major_require.fight(me, skill, MR, invent);
			}
			else if (select == 2) {
				Education_require.fight(me, skill, ER, invent);
			}
			else if (select == 3) {
				Major_select.fight(me, skill, MS, invent);
			}
			else if (select == 4) {
				Education_select.fight(me, skill, ES, invent);
			}
			else if (select == 5) {
				break;
			}
		}
	}
}