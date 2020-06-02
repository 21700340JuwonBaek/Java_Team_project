package character;

public class Monster extends Character {
	public Monster(String name, int attack, int defense, int gold, int critical, int hp) {
		super.setName(name);
		super.setAtk(attack);
		super.setDef(defense);
		super.setGold(gold);
		super.setCri(critical);
		super.setHp(hp);
	}
	
	public static boolean Critical() {
		int random = (int)(Math.random()*100) + 1;
		
		if(random>0 && random <=10) return true;
		else return false;
	}
	
	public static void Attack(Me me, Monster monsters) {
		if(monsters.getHp()>0) {
			int damage = monsters.getAtk() - me.getDef();
			
			if(monsters.getAtk() - me.getDef()<0) damage = 0;
			
			if(Critical()==true) {
				System.out.println("Critical!!");
				me.setHp(me.getHp()-(damage*2));
			}else {
				me.setHp(me.getHp()-damage);
			}
		}
	}
	
}
