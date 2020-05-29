package inventory;
import item.*;
import character.Me;

public class Inventory {
	
	private Weapon weapon1;
	private	Weapon weapon2;
	private	Weapon weapon3;
	private	Armor armor1;
	private	Armor armor2;
	private	Armor armor3;
	private	Potion HpPotion;
	private	Potion MpPotion;
	
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
	
	
	
	public static void detatchArmor(Me me, Armor armor) {
		me.setMaxHp(me.getMaxHp()-armor.getHp());
		me.setDef(me.getDef()-armor.getDef());
	}
	
	public static void detatchWeapon(Me me, Weapon weapon) {
		me.setCri(me.getCri()-weapon.getCri());
		me.setAtk(me.getAtk()-weapon.getAtk());
	}
	
	public static void applyAromor(Me me, Armor armor) {
		me.setMaxHp(me.getMaxHp()+armor.getHp());
		me.setDef(me.getDef()+armor.getDef());
		
	}
	
	public static void applyWeapon(Me me, Weapon weapon) {
		me.setCri(me.getCri()-weapon.getCri());
		me.setAtk(me.getAtk()-weapon.getAtk());
	}
	
	public static void useHpPotion(Me me, Potion potion) {
		if(potion.getNumber()==0) return;
		me.setHp(me.getHp()+potion.getRecovory());
		potion.setNumber(potion.getNumber()-1);
	}
	
	public static void useMpPotion(Me me, Potion potion) {
		if(potion.getNumber()==0) return;
		me.setHp(me.getMp()+potion.getRecovory());
		potion.setNumber(potion.getNumber()-1);
	}
	
	

}
