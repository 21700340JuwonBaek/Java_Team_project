package inventory;
import item.*;
import character.Me;

public class Inventory {
	
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
	
	public static void sellWeapon(Me me, Weapon weapon) {
		me.setGold(me.getGold()+weapon.getSellGold());
		weapon.setIs_bought(false);
	}
	
	public static void sellArmor(Me me, Armor armor) {
		me.setGold(me.getGold()+armor.getSellGold());
		armor.setIs_bought(false);
	}
	
	public static void sellPotion(Me me, Potion potion) {
		me.setGold(me.getGold()+potion.getSellGold());
		potion.setNumber(potion.getNumber()-1);
	}
	

}
