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
	
	public Me(String name, int attack, int defense, int gold, int critical, int hp, int mp) {
		super.setName(name);
		super.setAtk(attack);
		super.setDef(defense);
		super.setGold(gold);
		super.setCri(critical);
		super.setHp(hp);
		this.Mp = mp;
		this.clear_major_require = false;
	}
	
	public void Attack(Skill a[],Monster monsters[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the skill!!");
		
		for(int i = 0; i < a.length; i++) {
			if(a[i].getOpen()==false)continue;
			System.out.println(i+". "+a[i].getName() + "(���� : "+a[i].getRange() + " ���ݷ� : �⺻ ������("+super.getAtk()+")"+"+" + a[i].getDamage() + ")");
		}
		int select_skill = sc.nextInt();
		
		if(a[select_skill].getRange()>monsters.length) {
			for(int i = 0; i < monsters.length;i++) {
				int damage = super.getAtk()+a[select_skill].getDamage() - monsters[i].getDef();
				if(super.getAtk() -  monsters[i].getDef()<0) damage = 0;
				 monsters[i].setHp( monsters[i].getHp()-damage);
			}
		}
		
		else {
		for(int i = 0; i < a[select_skill].getRange();i++) {
			System.out.println("���� ���͸� �����ϼ���!!");
		int select_monster = sc.nextInt();
		int damage = super.getAtk()+a[select_skill].getDamage() - monsters[select_monster].getDef();
		if(super.getAtk() -  monsters[select_monster].getDef()<0) damage = 0;
		 monsters[select_monster].setHp( monsters[select_monster].getHp()-damage);
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

}
