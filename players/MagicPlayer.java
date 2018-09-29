package players;

public abstract class MagicPlayer extends Player {
	private int mana;

	public MagicPlayer(String n, int h, int bd, int m) {
		super(n, h, bd);
		this.mana = m;
	}
	
	public MagicPlayer() {
		super();
		this.mana = 0;
	}
	
	public int getMana() {
		return mana;
	}
	
	public void setMana(int mana) {
		this.mana = mana;
	}
}
