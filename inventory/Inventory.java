package inventory;
import item.*;
import character.Me;
import java.io.Serializable;

public class Inventory implements Serializable {
	
	public Weapon weapon1;
	public	Weapon weapon2;
	public	Weapon weapon3;
	public	Weapon weapon4;
	public	Armor armor1;
	public	Potion HpPotion;
	public	Potion MpPotion;
	
	public  Inventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Armor armor1, Potion HpPotion, Potion MpPotion) {
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.weapon4 = weapon4;
		this.armor1 = armor1;
		this.HpPotion = HpPotion;
		this.MpPotion = MpPotion;
	}
	
	
	
	//저장된 파일을 불러왔을 때에 instatnceVariable에 값이 저장되어 있을테니,
	//get함수를 통해서 parameter들에게 저장된 값을 할당하려는 의도. 잘 될런지는 모르겠다. 
	
	public void  setInventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Armor armor1, Potion HpPotion, Potion MpPotion) {
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.weapon4 = weapon4;
		this.armor1 = armor1;
		this.HpPotion = HpPotion;
		this.MpPotion = MpPotion;
	}
	
	
	public void setWeapon1(Weapon weapon1) {
		this.weapon1 = weapon1;
	}
	//아이템을 판매하거나 구매했을 때 혹은 아이템을 사용했을 때에 set함수를 사용한다. 
	
	public void setWeapon2(Weapon weapon2) {
		this.weapon2 = weapon2;
	}
	
	public void setWeapon3(Weapon weapon3) {
		this.weapon3 = weapon3;
	}
	
	public void setWeapon4(Weapon weapon4) {
		this.weapon4 = weapon4;
	}
	
	
	public void setArmor1(Armor armor) {
		this.armor1 = armor;
	}
	
	public void setHpPotion(Potion HpPotion) {
		this.HpPotion = HpPotion;
	}
	
	public void setMpPotion(Potion MpPotion) {
		this.MpPotion = MpPotion;
	}
	
	public Weapon getWeapon1() {
		return this.weapon1;
	}
	
	public Weapon getWeapon2() {
		return this.weapon2;
	}	
	
	public Weapon getWeapon3() {
		return this.weapon3;
	}
	
	public Weapon getWeapon4() {
		return this.weapon4;
	}
	
	public Armor getArmor1() {
		return this.armor1;
	}
	
	public Potion getHpPotion() {
		return this.HpPotion;
	}
	
	public Potion getMpPotion() {
		return this.MpPotion;
	}
	
	public static void detatchArmor(Me me, Armor armor) {
		me.setMaxHp(me.getMaxHp()-armor.getHp());
		me.setDef(me.getDef()-armor.getDef());
	}
	
	public static void detatchWeapon(Me me, Weapon weapon) {
		me.setCri(me.getCri()-weapon.getCri());
		me.setAtk(me.getAtk()-weapon.getAtk());
	}
	
	public static void applyArmor(Me me, Armor armor) {
		if(armor.getIs_bought() == false) { return;}
		me.setMaxHp(me.getMaxHp()+armor.getHp());
		me.setDef(me.getDef()+armor.getDef());
		
	}
	
	public static void applyWeapon(Me me, Weapon weapon) {
		if(weapon.getIs_bought() == false) { return;}
		me.setCri(me.getCri()+weapon.getCri());
		me.setAtk(me.getAtk()+weapon.getAtk());
	}
	
	public static void useHpPotion(Me me, Potion potion) {
		if(potion.getNumber()==0) return;
		if(me.getHp()+potion.getRecovory()>me.getMaxHp()) {
			me.setHp(me.getMaxHp());
			potion.setNumber(potion.getNumber()-1);
			return;
		}
		else {
		me.setHp(me.getHp()+potion.getRecovory());
		potion.setNumber(potion.getNumber()-1);
		return;
		}
	}
	
	public static void useMpPotion(Me me, Potion potion) {
		if(potion.getNumber()==0) return;
		if(me.getMp()+potion.getRecovory()>me.getMaxMp()) {
			me.setMp(me.getMaxMp());
			potion.setNumber(potion.getNumber()-1);
			return;
		}
		else {
		me.setMp(me.getMp()+potion.getRecovory());
		potion.setNumber(potion.getNumber()-1);
		return;
		}
	}
	
	

}
