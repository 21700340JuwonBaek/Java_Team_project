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
	
	public void Attack(Me me) {
		if(monsters.getHp()>0) {
			int damage = super.getAtk() - me.getDef();

			if(super.getAtk() - me.getDef()<0) damage = 0;

			me.setHp(me.getHp()-damage);
		}
	}
	
}
