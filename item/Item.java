package item;
import java.io.Serializable;


public class Item implements Serializable{
	private String name;
	private int buy_gold;
	private int sell_gold;
	private int grade;
	
	public Item(String name, int buy_gold,int sell_gold, int grade) {
		this.name = name;
		this.buy_gold = buy_gold;
		this.sell_gold = sell_gold;
		this.grade = grade;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBuyGold() {
		return this.buy_gold;
	}
	
	public int getSellGold() {
		return this.sell_gold;
	}
	
	public int getGrade() {
		return this.grade;
	}
}