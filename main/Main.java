package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import character.Me;
import inventory.Inventory;
import item.Armor;
import item.Potion;
import item.Weapon;
import windowbuilder.EndingAnimation;
import windowbuilder.EnterName;
import windowbuilder.Info;
import windowbuilder.ItemInventory;
import windowbuilder.ShopGui;
import windowbuilder.StartGame;

public class Main {
	public static Me userMe;
	public static Potion hp;
	public static Potion mp;
	public static Weapon Ipad;
	public static Weapon Macbook;
	public static Weapon TA;
	public static Armor Hood;
	public static Weapon Note;

	Inventory invent = new Inventory(Ipad, Macbook, Note, TA, Hood, hp, mp);

	public static void Save(Me me, Inventory inventory, Weapon Ipad, Weapon Macbook, Weapon Note, Weapon TA, Armor Hood) // Save
																															// Method.
	{
		ObjectOutputStream outputStream = null;
		FileOutputStream f_stream = null;
		ObjectOutputStream outputStream1 = null;
		FileOutputStream f1_stream = null;
		String fileName1 = "Inventory.records";
		String fileName = "My.records";
		System.out.println(me);
		try {
			f_stream = new FileOutputStream(fileName);
			outputStream = new ObjectOutputStream(f_stream);
		} catch (IOException e) {
			System.out.println("Error0");
			System.exit(0);
		}

		try {
			outputStream.writeObject(me);
			f_stream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error1");
		}
		System.out.println(inventory);
		try {
			f1_stream = new FileOutputStream(fileName1);
			outputStream1 = new ObjectOutputStream(f1_stream);
		} catch (IOException e) {
			System.out.println("Error00");
			System.exit(0);
		}
		try {
			outputStream1.writeObject(inventory);
			f1_stream.close();
			outputStream1.close();
		} catch (IOException e) {
			System.out.println("Error2");
		}
	}

	public static Me LoadMe() {
		ObjectInputStream inputStream = null;
		Me me = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream("My.records"));
		} catch (IOException e) {
			System.out.println("No File!!");
		}

		try {
			me = (Me) inputStream.readObject();
			inputStream.close();
		}

		catch (Exception e) {
			System.out.println("Error3");
		}

		return me;
	}

	public static Inventory LoadInventory() {
		ObjectInputStream inputStream = null;
		Inventory inventory = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream("Inventory.records"));
		} catch (IOException e) {
			System.out.println("No File!!");
		}

		try {
			inventory = (Inventory) inputStream.readObject();
			inputStream.close();
		}

		catch (Exception e) {
			System.out.println("Error3");
			System.exit(0);
		}

		return inventory;
	}

	public Main(String name) {
		Me me = new Me(name, 5, 1, 500, 1, 100, 100, 100, 100);
		setting(me);
	}

	public void setting(Me me) {
		// 이름/공격력/방어력/소지골드/크리티컬/체력/마나/최대체력/최대마나 입니다
		this.hp = new Potion("HP Potion", 10, 10, 0, 100, 1);
		this.mp = new Potion("Mp Potion", 10, 10, 0, 100, 1);
		this.Ipad = new Weapon("Ipad", 100, 100, 1, 5, 10);
		this.Macbook = new Weapon("Macbook", 100, 100, 1, 7, 10);
		this.Note = new Weapon("Note", 100, 100, 1, 10, 10);
		this.TA = new Weapon("TA", 100, 100, 1, 10, 12);
		this.Hood = new Armor("Sanaegi Hood", 100, 100, 1, 5, 10);

		Inventory invent = new Inventory(Ipad, Macbook, Note, TA, Hood, hp, mp);
		getStart(me, invent, 1);
	}

	public static void selSave(Me me, Inventory invent) {
		invent.setInventory(invent.getWeapon1(), invent.getWeapon2(), Note, TA, invent.getArmor1(), hp, mp);
		Save(me, invent, Ipad, Macbook, Note, TA, Hood);
		JOptionPane.showMessageDialog(null, "저장되었습니다.");
	}

	public static void selLoad() {
		Me me = Main.LoadMe();
		Inventory invent = Main.LoadInventory();
		Ipad = invent.getWeapon1();
		Macbook = invent.getWeapon2();
		Note = invent.getWeapon3();
		Hood = invent.getArmor1();
		TA = invent.getWeapon4();
		hp = invent.getHpPotion();
		mp = invent.getMpPotion();
		getStart(me, invent, 2);
	}

	public static void selShop(Me me, Inventory invent) {
		ShopGui.run(me, invent, hp, mp, Ipad, Macbook, Note, TA, Hood);
		Info.quitFrame();
	}

	public static void selInventory(Me me, Inventory invent) {
		ItemInventory.run(me, invent, hp, mp, Ipad, Macbook, Note, TA, Hood);
		Info.quitFrame();
	}

	public static void clearCondition(Me me, Inventory invent) {
		if (me.get_clear_education_require() == true && me.get_clear_education_select() == true
				&& me.get_clear_major_require() == true && me.get_clear_major_select() == true) {
			if (me.getGrade() == 4) {
				// 졸업
				JOptionPane.showMessageDialog(null, "4년 과정을 모두 마치셨습니다. 축하합니다!", "알림", JOptionPane.INFORMATION_MESSAGE);
				new EndingAnimation();
				return;
			}
			me.setGrade(me.getGrade() + 1);
			me.setMaxHp(me.getMaxHp() + 50);
			me.setMaxMp(me.getMaxMp() + 30);
			me.setAtk(me.getAtk() + 5);
			me.setDef(me.getDef() + 1);
			me.setCri(me.getCri() + 4);
			me.setHp(me.getHp() + 50);
			me.setMp(me.getMp() + 50);
			me.set_clear_education_require(false);
			me.set_clear_education_select(false);
			me.set_clear_major_require(false);
			me.set_clear_major_select(false);
			String nextGradeStr = me.getGrade() + "학년으로 올라갑니다!(Level up)";
			JOptionPane.showMessageDialog(null, nextGradeStr, "알림", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(me.getGrade() + "학년으로 올라갑니다!(Level up)");

		}

	}

	public static void getStart(Me me, Inventory invent, int a) {
		String str;
		str = "<html>";
		str = "<html>";
		str += "Name : " + me.getName() + "<br/>";
		str += "HP : " + me.getHp() + "<br/>";
		str += "MP : " + me.getMp() + "<br/>";
		str += "Gold : " + me.getGold() + "<br/>";
		str += "Grade : " + me.getGrade() + "<br/>";

		Info inf = new Info(me, str, invent);
		inf.run(me, str, invent);
		if (a == 1) {
			EnterName.quitFrame();
			StartGame.quitFrame();
		}
	}
}
