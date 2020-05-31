package item;
import java.io.Serializable;


public class Armor extends Item implements Serializable{
private int def;
private int hp;
private boolean is_bought;//이 방어구를 가지고 있는지 아닌지를 판별해주는 변
	public Armor(String name, int buy_gold, int sell_gold, int grade, int def, int hp) {
		super(name, buy_gold, sell_gold, grade);
		this.def = def;
		this.hp = hp;
		this.is_bought = false;
	}
	
	public int getDef() {
		return this.def;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public boolean getIs_bought() {
		return this.is_bought;
	}
	
	public void setIs_bought(boolean is_bought) {
		this.is_bought = is_bought;
	}

}
