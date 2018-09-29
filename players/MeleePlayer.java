package players;

public abstract class MeleePlayer extends Player {
	
	public static final int MeleeHpBoost = 15;
	public static final int MeleeBdBoost = 5;
	
	public MeleePlayer(String n, int h, int bd) {
		super(n, h + MeleeHpBoost, bd + MeleeBdBoost);
	}
	
	public MeleePlayer() {
		super();
	}
}
