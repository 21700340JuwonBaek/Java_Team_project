package dungeon;

public class Dungeon {
	protected String name;
	protected int grade = 1;
	
	public Dungeon(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return this.grade;
	}
}
