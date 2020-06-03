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
	public	Armor armor2;
	public	Armor armor3;
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
	
	
	public  Inventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Armor armor1, Armor armor2, Armor armor3, Potion HpPotion, Potion MpPotion) {
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.weapon4 = weapon4;
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
	//���옣�맂 �뙆�씪�쓣 遺덈윭�솕�쓣 �븣�뿉 instatnceVariable�뿉 媛믪씠 ���옣�릺�뼱 �엳�쓣�뀒�땲,
	//get�븿�닔瑜� �넻�빐�꽌 parameter�뱾�뿉寃� ���옣�맂 媛믪쓣 �븷�떦�븯�젮�뒗 �쓽�룄. �옒 �맆�윴吏��뒗 紐⑤Ⅴ寃좊떎. 
	
	public void  setInventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Armor armor1, Potion HpPotion, Potion MpPotion) {
		this.weapon1 = weapon1;
		this.weapon2 = weapon2;
		this.weapon3 = weapon3;
		this.weapon4 = weapon4;
		this.armor2 = armor1;
		this.HpPotion = HpPotion;
		this.MpPotion = MpPotion;
	}
	
	public void getInventory(Weapon weapon1, Weapon weapon2, Weapon weapon3, Weapon weapon4, Armor armor1, Armor armor2, Armor armor3, Potion HpPotion, Potion MpPotion) {
		weapon1 = this.weapon1;
		weapon2 = this.weapon2;
		weapon3 = this.weapon3;
		weapon4 = this.weapon4;
		armor1 = this.armor1;
		armor2 = this.armor2;
		armor3 = this.armor3;
		HpPotion = this.HpPotion;
		MpPotion = this.MpPotion;
	}
	
	public Weapon getWeapon4() {
		return this.weapon4;
	}
	
	public void setWeapon1(Weapon weapon1) {
		this.weapon1 = weapon1;
	}
	//�븘�씠�뀥�쓣 �뙋留ㅽ븯嫄곕굹 援щℓ�뻽�쓣 �븣 �샊�� �븘�씠�뀥�쓣 �궗�슜�뻽�쓣 �븣�뿉 set�븿�닔瑜� �궗�슜�븳�떎. 
	
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
		me.setHp(me.getHp()+potion.getRecovory());
		potion.setNumber(potion.getNumber()-1);
		return;
		}
	}
	
	

}
