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
	

	

}
