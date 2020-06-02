package shop;

import java.util.Scanner;
import character.Me;
import inventory.Inventory;
import shop.shop;
import item.*;
import item.Potion;

public class shop {
	
	public static void buy(Me me, Potion hp, Potion mp, Weapon Ipad, Weapon Macbook, Weapon Note, Weapon TA, Armor Hood) {
		Scanner sc = new Scanner(System.in);
		int item = 0;
		int kind = 0;
		
		do {
			System.out.print("어떤 종류의 아이템을 보시겠습니까? ");
			System.out.println("0. 나가기");
			System.out.println("1. 포션");
			System.out.println("2. 장비");
			kind = sc.nextInt();
			
			if(kind==1) {
				System.out.println("구매하려는 아이템을 골라주세요! ");
				System.out.println("0. 취소\n1. HP 포션: 체력을 최대로 회복시켜준다.(10 골드)\n2. MP 포션: 마나를 최대로 회복시켜준다.(10 골드)");
				item = sc.nextInt();
				
				if(item == 1) {
					System.out.println("HP 포션을 구매하였습니다! 10골드 차감.");
					me.setGold(me.getGold()-10);
					hp.setNumber(hp.getNumber()+1);
				}else if(item==2) {
					System.out.println("MP 포션을 구매하였습니다! 10골드 차감.");
					me.setGold(me.getGold()-10);
					mp.setNumber(mp.getNumber()+1);
				}else System.out.println("그럼 다른 아이템을 구매 하실건가요?");
			}else if(kind==2) {
				System.out.println("구매하려는 아이템을 골라주세요! ");
				System.out.println("0. 취소\n1. 아이패드: 공격력 5 증가(20골드)\n2. 새내기 후드티: 방어력 5 증가(20골드)\n3. 맥북: 공격력 7 증가(30골드)\n4. 선배의 필기노트: 공격력 10 증가(50골드)\n5. TA 세션: 공격력 12 증가(60골드)");
				item = sc.nextInt();
				
				if(item == 0) {
					System.out.println("그럼 다른 아이템을 구매 하실건가요?");
				}else if(item==1) {
					System.out.println("아이패드를 구매하였습니다. 공격력 +5 ");
					me.setGold(me.getGold()-20);
					Ipad.setIs_bought(true);
				}else if(item==2) {
					System.out.println("새내기 후드티를 구매하였습니다. 방어력 +5 ");
					me.setGold(me.getGold()-20);
					Hood.setIs_bought(true);
				}else if(item==3) {
					System.out.println("맥북을 구매하였습니다. 공격력 +7 ");
					me.setGold(me.getGold()-30);
					Macbook.setIs_bought(true);
				}else if(item==4) {
					System.out.println("선배의 필기노트를 구매하였습니다. 공격력 +10 ");
					me.setGold(me.getGold()-50);
					Note.setIs_bought(true);
				}else if(item==5) {
					System.out.println("TA 세션을 들었습니다. 공격력 +12 ");
					me.setGold(me.getGold()-60);
					TA.setIs_bought(true);
				}
			}
		}while(kind!=0);
		
		System.out.println("안녕히가세요!");	
	
	}
}
