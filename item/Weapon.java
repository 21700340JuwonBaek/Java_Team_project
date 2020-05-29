package item;

public class Weapon extends Item {
	private int atk;
	private int cri;
	private boolean is_bought;

	
	public Weapon(String name, int buy_gold, int sell_gold, int grade, int atk, int cri) {
		super(name, buy_gold, sell_gold, grade);
		this.atk = atk;
		this.cri = cri;
	}

	public int getAtk() {
		return this.atk;
	}
	
	public int getCri() {
		return this.cri;
	}
	
	public boolean getIs_bought() {
		return this.is_bought;
	}
	
	public void setIs_bought(boolean is_bought) {
		this.is_bought = is_bought;
	}

	
}
