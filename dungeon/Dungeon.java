package dungeon;

public class Dungeon {
	private String name;
	private int grade = 1;
	
	public Dungeon(String name) {
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return this.grade;
	}
}
