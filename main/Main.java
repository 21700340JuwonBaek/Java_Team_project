package main;
import grade.*;
import gui.RpgGui;
import character.*;
import java.io.*;
import java.util.Scanner;
public class Main {
   public static Me userMe;
   
   public static void Save(Me me) //Save Method.
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
   }
   
   public static Me Load(Me me)// Load Method
   {
		ObjectInputStream inputStream = null;
		try {inputStream = new ObjectInputStream(new FileInputStream("My.records"));}
		catch(IOException e) {System.out.println("No File!!");}
		
		try {me = (Me)inputStream.readObject();
			inputStream.close();
		}
		
		catch(Exception e) {System.out.println("Error3"); System.exit(0);}
		
		return me;
   }
   
   public static void main (String[] args) {
      
      Me me = new Me("이름",10,1,500,1,100,100);
      //이름/공격력/방어력/소지골드/크리티컬/체력/마나 입니다
      if(me.getGrade() == 1) {
      Freshman first = new Freshman("Introductory Engineering","Python","Handong Insung GyeoYook","Introductory Physics");
      while(true) {
       //  RpgGui gui = new RpgGui();
         //gui.showMainWindow();
		System.out.println(me.getHp());
		System.out.println(me.getGold());
		System.out.println(me.getMp());
		System.out.println(me.get_clear_major_require());
		System.out.println(me.getName());
		System.out.println("메뉴를 선택해주세요!\\n1.던전으로 가기.\\n2.저장하기\\n3.불러오기");
		Scanner sc = new Scanner(System.in);
		
		int select = sc.nextInt();
		if(select == 1) Freshman.GoToDungeon(me);
		
		else if (select == 2) {
			Main.Save(me);
		}
		
		else if (select == 3) {
			me = Main.Load(me);
		}
		
		
		}//while
		
		
		}//if
	
	
	
	}//main
		
	}//class


