package item;

public class Armor extends Item{
private int def;
private boolean is_bought;
	public Armor(String name, int buy_gold, int sell_gold, int grade, int def) {
		super(name, buy_gold, sell_gold, grade);
		// TODO Auto-generated constructor stub
		this.def = def;
		this.is_bought = false;
	}
	
	public int getDef() {
		return this.def;
	}
	
	public boolean getIs_bought() {
		return this.is_bought;
	}
	
	public void setIs_bought(boolean is_bought) {
		this.is_bought = is_bought;
	}

}
