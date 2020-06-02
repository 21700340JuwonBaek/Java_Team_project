package grade;

import java.util.Scanner;

import character.Me;
import character.Monster;
import inventory.Inventory;

public class Sophomore extends Freshman {

	public final static Monster[] MR2 = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MR2[0] = new Monster("이진탐색", 4, 1, 5, 1, 40);
		MR2[1] = new Monster("중간고사", 6, 1, 5, 1, 60);
		MR2[2] = new Monster("기말고사", 6, 1, 5, 1, 60);
	}

	public final static Monster[] ER2 = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ER2[0] = new Monster("Essay", 3, 1, 5, 1, 40);
		ER2[1] = new Monster("Midterm exam", 5, 1, 5, 1, 50);
		ER2[2] = new Monster("Final exam", 5, 1, 5, 1, 50);
	}

	public final static Monster[] MS2 = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		MS2[0] = new Monster("LMS 강의", 5, 1, 5, 1, 40);
		MS2[1] = new Monster("Lab problems", 7, 1, 5, 1, 60);
		MS2[2] = new Monster("Team project", 7, 1, 5, 1, 60);
	}

	public final static Monster[] ES2 = new Monster[3];
	{
		// Name, Attack point, Defense point, gold, critical, Hp
		ES2[0] = new Monster("LMS 강의", 4, 1, 5, 1, 40);
		ES2[1] = new Monster("중간고사", 6, 1, 5, 1, 50);
		ES2[2] = new Monster("기말고사", 6, 1, 5, 1, 50);
	}

	public Sophomore(String major1, String major2, String education1, String eucation2) {
		super(major1, major2, education1, eucation2);
		skill[3].setOpen(true);
	}

	public static void GoToDungeon(Me me, Inventory invent) {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Select the Dungeon\n\n1." + Major_require.getName());
			System.out.println("2." + Education_require.getName());
			System.out.println("3." + Major_select.getName());
			System.out.println("4." + Education_select.getName());

			int select = sc.nextInt();

			if (select == 1) {
				Major_require.fight(me, skill, MR2, invent);
			} else if (select == 2) {
				Education_require.fight(me, skill, ER2, invent);
			} else if (select == 3) {
				Major_select.fight(me, skill, MS2, invent);
			} else if (select == 4) {
				Education_select.fight(me, skill, ES2, invent);
			} else if (select == 5) {
				break;
			}
		}
	}
}