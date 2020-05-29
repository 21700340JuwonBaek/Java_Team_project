package item;

public class Potion extends Item{
	private int recovory;
	private int number;
	public Potion(String name, int buy_gold, int sell_gold, int grade, int recovory) {
		super(name, buy_gold, sell_gold, grade);
		this.recovory = recovory;
		this.number = 0;
	}
	
	public int getRecovory() {
		return this.recovory;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

}
