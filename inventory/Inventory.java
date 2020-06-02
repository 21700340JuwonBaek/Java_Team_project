package inventory;
import item.*;
import character.Me;
import java.io.Serializable;

public class Inventory implements Serializable {
	
	private Weapon weapon1;
	private	Weapon weapon2;
	private	Weapon weapon3;
	private	Weapon weapon4;
	private	Armor armor1;
	private	Armor armor2;
	private	Armor armor3;
	public	Potion HpPotion;
	public	Potion MpPotion;
	
	public  Inventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Armor armor1, Potion HpPotion, Potion MpPotion) {
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.weapon4 = weapon4;
		this.armor2 = armor1;
		this.HpPotion = HpPotion;
		this.MpPotion = MpPotion;
	}
	
	
	public  Inventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Armor armor1, Armor armor2, Armor armor3, Potion HpPotion, Potion MpPotion) {
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.armor1 = armor1;
		this.armor2 = armor2;
		this.armor3 = armor3;
		this.HpPotion = HpPotion;
		this.MpPotion = MpPotion;
	}
	
	public void getInventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Armor armor1, Potion HpPotion, Potion MpPotion) {
		weapon1 = this.weapon1;
		weapon2 = this.weapon2;
		weapon3 = this.weapon3;
		weapon4 = this.weapon4;
		armor1 = this.armor1;
		HpPotion = this.HpPotion;
		MpPotion = this.MpPotion;
	}
	//저장된 파일을 불러왔을 때에 instatnceVariable에 값이 저장되어 있을테니,
	//get함수를 통해서 parameter들에게 저장된 값을 할당하려는 의도. 잘 될런지는 모르겠다. 
	
	public void  setInventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Armor armor1, Potion HpPotion, Potion MpPotion) {
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.weapon4 = weapon4;
		this.armor2 = armor1;
		this.HpPotion = HpPotion;
		this.MpPotion = MpPotion;
	}
	
	public void getInventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Armor armor1, Armor armor2, Armor armor3, Potion HpPotion, Potion MpPotion) {
		weapon1 = this.weapon1;
		weapon2 = this.weapon2;
		weapon3 = this.weapon3;
		armor1 = this.armor1;
		armor2 = this.armor2;
		armor3 = this.armor3;
		HpPotion = this.HpPotion;
		MpPotion = this.MpPotion;
	}
	
	public void setWeapon1(Weapon weapon1) {
		this.weapon1 = weapon1;
	}
	//아이템을 판매하거나 구매했을 때 혹은 아이템을 사용했을 때에 set함수를 사용한다. 
	
	public void setWeapon2(Weapon weapon2) {
		this.weapon1 = weapon1;
	}
	
	public void setWeapon3(Weapon weapon3) {
		this.weapon1 = weapon1;
	}
	
	public void setArmor1(Armor armor) {
		this.armor1 = armor;
	}
	
	public void setArmor2(Armor armor) {
		this.armor2 = armor;
	}
	
	public void setArmor3(Armor armor) {
		this.armor3 = armor;
	}
	
	public void setHpPotion(Potion HpPotion) {
		this.HpPotion = HpPotion;
	}
	
	public void setMpPotion(Potion MpPotion) {
		this.MpPotion = MpPotion;
	}
	
	
	public static void detatchArmor(Me me, Armor armor) {
		me.setMaxHp(me.getMaxHp()-armor.getHp());
		me.setDef(me.getDef()-armor.getDef());
	}
	
	public static void detatchWeapon(Me me, Weapon weapon) {
		me.setCri(me.getCri()-weapon.getCri());
		me.setAtk(me.getAtk()-weapon.getAtk());
	}
	
	public static void applyAromor(Me me, Armor armor) {
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
		me.setHp(me.getHp()+potion.getRecovory());
		potion.setNumber(potion.getNumber()-1);
		return;
		}
	}
	
	

}