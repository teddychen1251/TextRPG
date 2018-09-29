package players;

public class KarateMaster extends MeleePlayer {
	
	public static final int KarateBdBoost = 10;
	
	public KarateMaster(String n, int h, int bd) {
		super(n, h, bd + KarateBdBoost);
	}
	
	public KarateMaster() {
		super();
	}
	
}
