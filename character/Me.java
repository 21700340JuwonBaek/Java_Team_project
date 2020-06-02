package character;
import skill.Skill;
import windowbuilder.HandongMRC;

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
	
	public Me(String name) {
		super.setName(name);
		super.setAtk(10);
		super.setDef(1);
		super.setGold(500);
		super.setCri(1);
		super.setHp(100);
		super.setMp(100); 
		this.clear_major_require = false;
		this.clear_major_select = false;
		this.clear_education_select = false;
		this.clear_education_require = false;
	
	}
	
	
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
	
	public static void Attack(Skill a,Monster monsters, Me me) {
		Scanner sc = new Scanner(System.in);
		
		if(a.getMana()>me.getMp())return;
		int damage = me.getAtk()+a.getDamage() - monsters.getDef();
		int mp = a.getMana();
		int gold = 0;
		gold = monsters.getGold();
		if(me.getAtk() -  monsters.getDef()<0) damage = 0;
		if(Critical()==true) {
			System.out.println("Critical!!");
			monsters.setHp( monsters.getHp()-(damage*2));
		}else monsters.setHp( monsters.getHp()-damage);
		 me.setMp(me.getMp()-mp);
		 if(monsters.getHp()<0) me.setGold(me.getGold()+gold);
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