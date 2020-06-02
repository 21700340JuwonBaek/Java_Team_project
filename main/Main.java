package main;
import grade.*;
import gui.RpgGui;
import character.*;
import java.io.*;
import java.util.Scanner;
import inventory.Inventory;
import shop.shop;
import item.*;
public class Main {
   public static Me userMe;
   
   public static void Save(Me me, Inventory inventory) //Save Method.
   {
	   ObjectOutputStream outputStream = null;
		String fileName = "My.records";
		try {outputStream = new ObjectOutputStream(new FileOutputStream(fileName));}
		catch(IOException e) {System.out.println("Error0"); System.exit(0);}

		try {
			outputStream.writeObject(me);
			outputStream.close();
		}
		catch(IOException e) {
			System.out.println("Error1");
		}
		
		   ObjectOutputStream outputStream1 = null;
			String fileName1 = "Inventory";
			try {outputStream1 = new ObjectOutputStream(new FileOutputStream(fileName1));}
			catch(IOException e) {System.out.println("Error0"); System.exit(0);}

			try {
				outputStream1.writeObject(inventory);
				outputStream1.close();
			}
			catch(IOException e) {
				System.out.println("Error2");
			}
   }

   
   public static Me LoadMe()// Load Method
   {
		ObjectInputStream inputStream = null;
		Me me = null;
		try {inputStream = new ObjectInputStream(new FileInputStream("My.records"));}
		catch(IOException e) {System.out.println("No File!!");}
		
		try { me = (Me)inputStream.readObject();
			inputStream.close();
		}
		
		catch(Exception e) {System.out.println("Error3"); System.exit(0);}
		
		return me;
   }
   
   public static Inventory LoadInventory() {
		ObjectInputStream inputStream = null;
		Inventory inventory = null;
		try {inputStream = new ObjectInputStream(new FileInputStream("Inventory"));}
		catch(IOException e) {System.out.println("No File!!");}
		
		try { inventory = (Inventory)inputStream.readObject();
			inputStream.close();
		}
		
		catch(Exception e) {System.out.println("Error3"); System.exit(0);}
	
		
		return inventory;
   }
   
   public static void main (String[] args) {
	   //Inventory inventory = new Inventory
      
      Me me = new Me("이름",10,1,500,1,100,100,100,100);
      //이름/공격력/방어력/소지골드/크리티컬/체력/마나/최대체력/최대마나 입니다
	   Potion hp = new Potion("HP Potion",10,10,0,100,1);
	   Potion mp = new Potion("Mp Potion",10,10,0,100,1);
	   Weapon Ipad = new Weapon("Ipad", 100,100,1,10,10);
	   Weapon Macbook = new Weapon("Macbook", 100,100,1,10,10);
	   Weapon Note = new Weapon("Note", 100,100,1,10,10);
	   Weapon TA = new Weapon("TA", 100,100,1,10,10);
	   Armor Hood = new Armor("Hood", 100,100,1,1,10);
	   
	  Inventory invent = new Inventory(Ipad,Macbook,Note,TA,Hood,hp,mp);

	me.enterName(me); //플레이어의 이름을 받습니다.
	   
	invent.applyWeapon(me, Ipad);
	me.setGrade(4);
		

      while(me.getGrade()<5) {
       //  RpgGui gui = new RpgGui();
         //gui.showMainWindow();
    	  if(me.getGrade() ==1) { Freshman first = new Freshman("Introductory Engineering","Python","Handong Insung GyeoYook","Introductory Physics");}
    	  else if(me.getGrade()==2) {Sophomore second = new Sophomore("Data Structure","Java","ERC","Statistic");}
    	  else if(me.getGrade()==3) {Junior third =new Junior("OS","Gong Pu Gi","EAP","linear Algebra");}
    	  else if(me.getGrade()==4) {Senior fourth =new Senior("Graduation(MAJOR)","Graduation","Graduation(EDUCATION)","Graduation");}

    	  
		Scanner sc = new Scanner(System.in);

		while(me.getGrade()==1) {
			System.out.println("메뉴를 선택해주세요!\\n1.던전으로 가기.\\n2.저장하기\\n3.불러오기\\n4.상점");
			int select = sc.nextInt();
		if(select == 1) {
			Freshman.GoToDungeon(me, invent);
		}
		
		else if (select == 2) {
			invent.setInventory(Ipad,Macbook,Note,TA,Hood,hp,mp);
			Main.Save(me, invent);
		}
		
		else if (select == 3) {
			me = Main.LoadMe();
			invent = Main.LoadInventory();
		}
		
	      	else if (select == 4) {
	      		shop.buy(me, hp, mp, Ipad, Macbook, Note, TA, Hood);
		}//if
		
		if(me.get_clear_education_require() == true && me.get_clear_education_select() 
				== true && me.get_clear_major_require()== true && me.get_clear_major_select()==true) {me.setGrade(me.getGrade()+1);
				me.setMaxHp(150); me.setMaxMp(120); me.setAtk(15); me.setDef(2); me.setCri(5); me.setHp(150); me.setMp(120);
				me.set_clear_education_require(false);me.set_clear_education_select(false);me.set_clear_major_require(false);me.set_clear_major_select(false);}
		
      }//while first grade
		
		
		while(me.getGrade()==2) {
			System.out.println("메뉴를 선택해주세요!\\n1.던전으로 가기.\\n2.저장하기\\n3.불러오기\\n4.상점");
			int select = sc.nextInt();
		if(select == 1) {
			Sophomore.GoToDungeon(me, invent);
		}
		
		else if (select == 2) {
			invent.setInventory(Ipad,Macbook,Note,TA,Hood,hp,mp);
			Main.Save(me, invent);
		}
		
		else if (select == 3) {
			me = Main.LoadMe();
			invent = Main.LoadInventory();
		}
		
	      	else if (select == 4) {
	      		shop.buy(me, hp, mp, Ipad, Macbook, Note, TA, Hood);
		}//if
		
		if(me.get_clear_education_require() == true && me.get_clear_education_select() 
				== true && me.get_clear_major_require()== true && me.get_clear_major_select()==true) {me.setGrade(me.getGrade()+1);
				me.setMaxHp(200); me.setMaxMp(150); me.setAtk(20); me.setDef(3); me.setCri(8); me.setHp(200); me.setMp(150);
				me.set_clear_education_require(false);me.set_clear_education_select(false);me.set_clear_major_require(false);me.set_clear_major_select(false);}
		
      }//while Second grade
	    


		
		while(me.getGrade()==3) {
			System.out.println("메뉴를 선택해주세요!\\n1.던전으로 가기.\\n2.저장하기\\n3.불러오기\\n4.상점");
			int select = sc.nextInt();
		if(select == 1) {
			Junior.GoToDungeon(me, invent);
		  //  new Senior("Graduation","Graduation","Graduation","Graduation");
		//	me.setHp(100);
			//Senior.GoToDungeon(me, invent);
		}
		
		else if (select == 2) {
			invent.setInventory(Ipad,Macbook,Note,TA,Hood,hp,mp);
			Main.Save(me, invent);
		}
		
		else if (select == 3) {
			me = Main.LoadMe();
			invent = Main.LoadInventory();
		}
		
	      	else if (select == 4) {
	      		shop.buy(me, hp, mp, Ipad, Macbook, Note, TA, Hood);
		}//if
		
		if(me.get_clear_education_require() == true && me.get_clear_education_select() 
				== true && me.get_clear_major_require()== true && me.get_clear_major_select()==true) {me.setGrade(me.getGrade()+1);
				me.setMaxHp(250); me.setMaxMp(180); me.setAtk(25); me.setDef(4); me.setCri(12); me.setHp(250); me.setMp(180);
				me.set_clear_education_require(false);me.set_clear_education_select(false);me.set_clear_major_require(false);me.set_clear_major_select(false);}
		
      }//while thrid grade
		
		while(me.getGrade()==4) {
			System.out.println("메뉴를 선택해주세요!\\n1.던전으로 가기.\\n2.저장하기\\n3.불러오기\\n4.상점");
			if(me.get_clear_education_require() == true/*&& me.get_clear_education_select() 
					== true && me.get_clear_major_require()== true && me.get_clear_major_select()==true*/) {me.setGrade(me.getGrade()+1);continue;}
			int select = sc.nextInt();
		if(select == 1) {
			Senior.GoToDungeon(me, invent);
		}
		
		else if (select == 2) {
			invent.setInventory(Ipad,Macbook,Note,TA,Hood,hp,mp);
			Main.Save(me, invent);
		}
		
		else if (select == 3) {
			me = Main.LoadMe();
			invent = Main.LoadInventory();
		}
		
	      	else if (select == 4) {
	      		shop.buy(me, hp, mp, Ipad, Macbook, Note, TA, Hood);
		}//if
		
		if(me.get_clear_education_require() == true/*&& me.get_clear_education_select() 
				== true && me.get_clear_major_require()== true && me.get_clear_major_select()==true*/) {me.setGrade(me.getGrade()+1);}
		
      }//while fourth grade
		
      }//while game
      
		////////////////////////////////////////////////////////////////////////////////////////////////////////
      //엔딩크레딧
	
	
	
	}//main
		
	}//class
