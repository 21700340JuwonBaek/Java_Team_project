package character;
import skill.Skill;
import java.util.Scanner;
import java.io.Serializable;

public class Me extends Character {
	
	private int Mp;
	private int percent;
	private int score;
	private int grade = 1;
	private boolean clear_major_require;
	private boolean clear_major_select;
	private boolean clear_education_select;
	private boolean clear_education_require;
	
	public Me(String name, int attack, int defense, int gold, int critical, int hp, int mp) {
		super.setName(name);
		super.setAtk(attack);
		super.setDef(defense);
		super.setGold(gold);
		super.setCri(critical);
		super.setHp(hp);
		super.setMp(mp); 
		this.Mp = mp;
		this.clear_major_require = false;
		this.clear_major_select = false;
		this.clear_education_select = false;
		this.clear_education_require = false;
	}
	
	public static String enterName(Me me) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름을 적어주세요. ");
		String name = sc.nextLine();
		
		return name;
	}
	
	public static boolean Critical() { //1부터 100 사이에서 랜덤값이 1~10일 경우 데미지 2배
		int random = (int)(Math.random()*100) + 1;
		
		if(random>0 && random <=10) return true;
		else return false;
	}
	
	public static void Attack(Skill a[],Monster monsters[], Me me) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the skill!!");
		
		for(int i = 0; i < a.length; i++) {
			if(a[i].getOpen()==false)continue;
			System.out.println(i+". "+a[i].getName() + "(범위 : "+a[i].getRange() + " 공격력 : 기본 데미지("+me.getAtk()+")"+"+" + a[i].getDamage() + " 필요 지식량: " + a[i].getMana() + ")");
		}
		int select_skill = sc.nextInt();
		
		if(a[select_skill].getRange()>monsters.length) {
			int mp = a[select_skill].getMana();
			for(int i = 0; i < monsters.length;i++) {
				int damage = me.getAtk()+a[select_skill].getDamage() - monsters[i].getDef();
				int gold = 0;
				if(monsters[i].getHp()>0) {
					gold = monsters[i].getGold();
				}
				if(me.getAtk() -  monsters[i].getDef()<0) damage = 0;
				if(Critical()==true) {
					System.out.println("Critical!!");
					monsters[i].setHp( monsters[i].getHp()-(damage*2));
				}else monsters[i].setHp( monsters[i].getHp()-damage);
				if(monsters[i].getHp()<0) me.setGold(me.getGold()+gold);
			}
			me.setMp(me.getMp()-mp);
		}
		
		else {
		for(int i = 0; i < a[select_skill].getRange();i++) {
			System.out.println("잡을 몬스터를 선택하세요!!");
		int select_monster = sc.nextInt();
		int damage = me.getAtk()+a[select_skill].getDamage() - monsters[select_monster].getDef();
		int mp = a[select_skill].getMana();
		int gold = 0;
		gold = monsters[i].getGold();
		if(me.getAtk() -  monsters[select_monster].getDef()<0) damage = 0;
		if(Critical()==true) {
			System.out.println("Critical!!");
			monsters[i].setHp( monsters[i].getHp()-(damage*2));
		}else monsters[i].setHp( monsters[i].getHp()-damage);
		 me.setMp(me.getMp()-mp);
		 if(monsters[i].getHp()<0) me.setGold(me.getGold()+gold);
		}
		}
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return this.grade;
	}
	
	public void set_clear_major_require(boolean t_f) {
		this.clear_major_require = t_f;
	}
	public boolean get_clear_major_require() {
		return this.clear_major_require;
	}
	public void set_clear_major_select(boolean t_f) {
		this.clear_major_select = t_f;
	}
	public boolean get_clear_major_select() {
		return this.clear_major_select;
	}
	
	public void set_clear_education_select(boolean t_f) {
		this.clear_education_select = t_f;
	}
	public boolean get_clear_education_select() {
		return this.clear_education_select;
	}
	
	public void set_clear_education_require(boolean t_f) {
		this.clear_education_require = t_f;
	}
	public boolean get_clear_education_require() {
		return this.clear_education_require;
	}

}
