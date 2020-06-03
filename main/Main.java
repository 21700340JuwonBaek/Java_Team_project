package main;
import grade.*;
import gui.RpgGui;
import character.*;
import fgame.GetCharacter;
import fgame.HandongStart;

import java.io.*;
import java.util.Scanner;
import inventory.Inventory;
import shop.shop;
import windowbuilder.EnterName;
import windowbuilder.Info;
import windowbuilder.StartGame;
import windowbuilder.selectDungeon;
import item.*;
public class Main {
   public static Me userMe;
   public static Potion hp;
   public static Potion mp;
   public static Weapon Ipad;
   public static Weapon Macbook;
   public static Weapon TA;
   public static Armor Hood;
   public static Weapon Note;
   
  Inventory invent = new Inventory(Ipad,Macbook,Note,TA,Hood,hp,mp);
   

	public static void Save(Me me, Inventory inventory, Weapon Ipad, Weapon Macbook, Weapon Note, Weapon TA, Armor Hood) // Save Method.
	{
		ObjectOutputStream outputStream = null;
		String fileName = "My.records";
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		} catch (IOException e) {
			System.out.println("Error0");
			System.exit(0);
		}

		try {
			outputStream.writeObject(me);
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error1");
		}

		ObjectOutputStream outputStream1 = null;
		String fileName1 = "Inventory";
		try {
			outputStream1 = new ObjectOutputStream(new FileOutputStream(fileName1));
		} catch (IOException e) {
			System.out.println("Error0");
			System.exit(0);
		}

		try {
			outputStream1.writeObject(inventory);
			outputStream1.close();
		} catch (IOException e) {
			System.out.println("Error2");
		}
		
		ObjectOutputStream outputStream2 = null;
		String fileName2 = "Weapon";
		try {
			outputStream2 = new ObjectOutputStream(new FileOutputStream(fileName2));
		} catch (IOException e) {
			System.out.println("Error3");
			System.exit(0);
		}

		try {
			outputStream2.writeObject(Ipad);
			outputStream2.writeObject(Macbook);
			outputStream2.writeObject(Note);
			outputStream2.writeObject(TA);
			outputStream2.close();
		} catch (IOException e) {
			System.out.println("Error4");
		}
		
		ObjectOutputStream outputStream3 = null;
		String fileName3 = "Armor";
		try {
			outputStream3 = new ObjectOutputStream(new FileOutputStream(fileName3));
		} catch (IOException e) {
			System.out.println("Error3");
			System.exit(0);
		}

		try {
			outputStream3.writeObject(Hood);
			outputStream3.close();
		} catch (IOException e) {
			System.out.println("Error4");
		}
		
	}

	public static Me LoadMe()// Load Method
	{
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
			inputStream = new ObjectInputStream(new FileInputStream("Inventory"));
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
	
	public static Weapon LoadWeapon() {
		ObjectInputStream inputStream = null;
		Weapon weapon = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream("Weapon"));
		} catch (IOException e) {
			System.out.println("No File!!");
		}

		try {
			weapon = (Weapon) inputStream.readObject();
			inputStream.close();
		}

		catch (Exception e) {
			System.out.println("Error3");
			System.exit(0);
		}

		return weapon;
	}
	
	public static Armor LoadArmor() {
		ObjectInputStream inputStream = null;
		Armor armor = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream("Armor"));
		} catch (IOException e) {
			System.out.println("No File!!");
		}

		try {
			armor = (Armor) inputStream.readObject();
			inputStream.close();
		}

		catch (Exception e) {
			System.out.println("Error3");
			System.exit(0);
		}

		return armor;
	}
   public Main(String name) {
	   //Inventory inventory = new Inventory
	   Me me = new Me(name,10,1,500,1,100,100,100,100);
	   setting(me);
   }
   public void setting(Me me) {
	   //이름/공격력/방어력/소지골드/크리티컬/체력/마나/최대체력/최대마나 입니다
	   this.hp = new Potion("HP Potion", 10, 10, 0, 100, 1);
		this.mp = new Potion("Mp Potion", 10, 10, 0, 100, 1);
		this.Ipad = new Weapon("Ipad", 100, 100, 1, 5, 10);
		this.Macbook = new Weapon("Macbook", 100, 100, 1, 7, 10);
		this.Note = new Weapon("Note", 100, 100, 1, 10, 10);
		this.TA = new Weapon("TA", 100, 100, 1, 10, 12);
		this.Hood = new Armor("Sanaegi Hood", 100, 100, 1, 5, 10);

		Inventory invent = new Inventory(Ipad, Macbook, Note, TA, Hood, hp, mp);

	  //System.out.print(me.getName());
	
	  invent.applyWeapon(me, Ipad);
	  
	  getStart(me,invent);
   }
   public static void selSave(Me me, Inventory invent) {
	   invent.setInventory(Ipad, Macbook, Note, TA, Hood, hp, mp);
	   Save(me, invent, Ipad, Macbook, Note, TA, Hood);
   }
   
  public static void selLoad(Me me,Inventory invent) {
	  	me = Main.LoadMe();
		invent = Main.LoadInventory();
		Ipad = Main.LoadWeapon();
		Macbook = Main.LoadWeapon();
		Note = Main.LoadWeapon();
		TA = Main.LoadWeapon();
		Hood = Main.LoadArmor();
		invent.getInventory(Ipad, Macbook, Note, TA, Hood, hp, mp);
  }
  public static void selShop(Me me,Inventory invent) {
	  shop.buy(me, hp, mp, Ipad, Macbook, Note, TA, Hood);
  }
  public static void clearCondition(Me me, Inventory invent) {
	  if (me.get_clear_education_require() == true && me.get_clear_education_select() == true
				&& me.get_clear_major_require() == true && me.get_clear_major_select() == true) {
		  if(me.getGrade() == 4) {
			  //졸업
			  return;
		  }
			me.setGrade(me.getGrade() + 1);
			me.setMaxHp(me.getMaxHp()+50);
			me.setMaxMp(me.getMaxMp()+30);
			me.setAtk(me.getAtk()+5);
			me.setDef(me.getDef()+1);
			me.setCri(me.getCri()+4);
			me.setHp(me.getHp()+50);
			me.setMp(me.getMp()+50);
			me.set_clear_education_require(false);
			me.set_clear_education_select(false);
			me.set_clear_major_require(false);
			me.set_clear_major_select(false);
			System.out.println(me.getGrade()+"학년으로 올라갑니다!(Level up)");
		}
  }
   public void getStart(Me me,Inventory invent) {
	   		String str;
		     // while(true) {
		    	str = "<html>";
		    	str += "Name : "+me.getName()+"<br/>";
				//System.out.println(me.getHp());
				str += "HP : "+me.getHp()+"<br/>";
				//System.out.println(me.getGold());
				str += "Gold : "+me.getGold()+"<br/>";
				//System.out.println(me.getMp());
				str += "MP : "+me.getMp()+"<br/>";
				//System.out.println(me.get_clear_major_require());
				str += "Clear Major Require : "+me.get_clear_major_require()+"<br/>";
				
				Info inf = new Info(me,str,invent);
				inf.run(me,str,invent);
				EnterName.quitFrame();
				StartGame.quitFrame();
				
      		//}
      	}
      }