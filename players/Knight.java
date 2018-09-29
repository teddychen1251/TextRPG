package players;

public class Knight extends MeleePlayer {
	
	private int swordSkill;

	public Knight(String n, int h, int bd, int ss) {
		super(n, h, bd);
		this.swordSkill = ss;
	}
	
	public Knight() {
		super();
		this.swordSkill = 0;
	}

	public String toString() {
		return super.toString() + "\nSword Skill: " + swordSkill + "\n-----------";
	}
	
}
