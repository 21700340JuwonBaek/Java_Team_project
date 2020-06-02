package item;
import java.io.Serializable;

public class Potion extends Item implements Serializable{
	private int recovory;
	private int number;//포션의 개수.
	public Potion(String name, int buy_gold, int sell_gold, int grade, int recovory, int number) {
		super(name, buy_gold, sell_gold, grade);
		this.recovory = recovory;
		this.number = number;
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