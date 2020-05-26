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
	
	public void Attack(Skill a[],Monster monsters[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the skill!!");
		
		for(int i = 0; i < a.length; i++) {
			if(a[i].getOpen()==false)continue;
			System.out.println(i+". "+a[i].getName() + "(범위 : "+a[i].getRange() + " 공격력 : 기본 데미지("+super.getAtk()+")"+"+" + a[i].getDamage() + " 필요 지식량: " + a[i].getMana() + ")");
		}
		int select_skill = sc.nextInt();
		
		if(a[select_skill].getRange()>monsters.length) {
			int mp = a[select_skill].getMana();
			for(int i = 0; i < monsters.length;i++) {
				int damage = super.getAtk()+a[select_skill].getDamage() - monsters[i].getDef();
				int gold = 0;
				if(monsters[i].getHp()>0) {
					gold = monsters[i].getGodl();
				}
				if(super.getAtk() -  monsters[i].getDef()<0) damage = 0;
				 monsters[i].setHp( monsters[i].getHp()-damage);
				if(monsters[i].getHp()<0) me.setGold(me.getGodl()+gold);
			}
			me.setMp(me.getMp()-mp);
		}
		
		else {
		for(int i = 0; i < a[select_skill].getRange();i++) {
			System.out.println("잡을 몬스터를 선택하세요!!");
		int select_monster = sc.nextInt();
		int damage = super.getAtk()+a[select_skill].getDamage() - monsters[select_monster].getDef();
		int mp = a[select_skill].getMana();
		int gold = 0;
		gold = monsters[i].getGodl();
		if(super.getAtk() -  monsters[select_monster].getDef()<0) damage = 0;
		 monsters[select_monster].setHp( monsters[select_monster].getHp()-damage);
		 me.setMp(me.getMp()-mp);
		 if(monsters[i].getHp()<0) me.setGold(me.getGodl()+gold);
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
