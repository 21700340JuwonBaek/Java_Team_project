package skill;

public class Skill {
	private String name;
	private int damage;
	private int range;
	private int mana;
	private boolean open = false;
	
	public Skill() {
		this.name = "nothin";
		this.damage = 0;
		this.range = 0;
		this.mana = 0;
	}
	
	public Skill(String name, int damage, int range, int mana, boolean open) {
		this.name = name;
		this.damage = damage;
		this.range = range;
		this.mana = mana;
		this.open = open;
	}
	
	public void setSkill(String name, int damage, int range, int mana, boolean open) {
		this.name = name;
		this.damage = damage;
		this.range = range;
		this.mana = mana;
		this.open = open;
	}
	
	public Skill(boolean open) {
		this.open = open;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getRange() {
		return this.range;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	public boolean getOpen() {
		return this.open;
	}
}
