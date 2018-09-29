package players;

public abstract class Player {
	
	private String className;
	private String name;
	private int hp;
	private int baseDamage;

	public Player(String n, int h, int bd) {
		this.name = n;
		this.hp = h;
		this.baseDamage = bd;
		className = this.getClass().getSimpleName();
		for(int i = className.length()-1; i >= 1; i--) { // put spaces between each word
			if(Character.isUpperCase(className.charAt(i))) {
				className = className.substring(0, i) + " " + className.substring(i); //ugly reused code; find better way to create className
			}
		}
	}

	public Player() {
		this.name = "";
		this.hp = 0;
		this.baseDamage = 0;
		className = this.getClass().getSimpleName();
		for(int i = className.length()-1; i >= 1; i--) { // put spaces between each word
			if(Character.isUpperCase(className.charAt(i))) {
				className = className.substring(0, i) + " " + className.substring(i);
			}
		}
	}
	
	// getters & setters; setters probably used for dynamic in-game character setup
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getBaseDamage() {
		return baseDamage;
	}
	
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	public String toString() { //print out stats
		return "-----------\n" + name + "'s stats" + "\n-----------\nClass: " + className + "\nHP: " + 
				hp + "\nBase Damage: " + baseDamage + "\n-----------";
	}
}
