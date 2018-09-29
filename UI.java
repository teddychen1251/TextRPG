import java.util.Scanner;
import players.*;

public class UI {
	public static final String[] characterClasses = { "Knight", "Karate Master" };
	public static final String[] menuActions = { "Complete next quest", "View stats", "Exit/save game" };
	
	public static void displayWelcomeMessage() {
		System.out.println("Welcome, traveler, to the DUNGEON");
	}
	/*
	private static int takeNumericInput(Scanner scan) {
		int inputToNum = 0;
		boolean inputIsNotValid = true;
		while (inputIsNotValid) {
			try {
				inputIsNotValid = false;
				inputToNum = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.print("Please enter a valid number:");
				inputIsNotValid = true;
			}
		}
		return inputToNum;
	}
	*/
	public static int takeNumericInput(Scanner scan, int lowerBoundInclusive, int upperBoundInclusive) {
		int input = 0;
		boolean inputIsNotValid = true;
		while (inputIsNotValid) {
			try {
				inputIsNotValid = false;
				input = Integer.parseInt(scan.nextLine()); //nextInt() doesn't work b/c of Strings as endless tokens I think
				if(input > upperBoundInclusive || input < lowerBoundInclusive) throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				System.out.print("Please enter a valid number: "); //be wary of this print with no newline
				inputIsNotValid = true;
			}
		}
		return input;
	}

	public static int chooseCharacterClass(Scanner scan) { //have info for the different classes
		System.out.println("Please choose a class for your character");
		System.out.println("Choose from the following classes:");
		for (int i = 1; i <= characterClasses.length; i++) {
			System.out.println(i + ". " + characterClasses[i - 1]);
		}
		System.out.print("Enter the number corresponding to the class of your choice: ");
		int choice = takeNumericInput(scan, 1, characterClasses.length);
		return choice;
	}
	//setUpCharacter takes in choice and sets up the character's class
	public static Player setUpCharacter(Scanner scan, int choice) {
		String className = characterClasses[choice-1];
		System.out.println("You have chosen to become a " + className);
		System.out.println("Please enter a name for you character: ");
		String name = scan.nextLine();
		System.out.println("Your hp and base damage will now be generated");
		int hp = (int) (Math.floor(Math.random() * 15) + 75);
		int baseDamage = (int) (Math.floor(Math.random() * 5) + 10);
		System.out.println("Your randomly generated hp is " + hp + " and your randomly generated base damage is " + baseDamage);
		System.out.println("Now for your specialized " + className + " skills");
		switch(choice-1) {
		case 0:
			System.out.println(className + "s get " + Knight.MeleeHpBoost + " extra hp and " + Knight.MeleeBdBoost + " extra base damage");
			System.out.println("A " + className + "'s Sword Skill requires precision. You will play a game to ascertain this skill.");
			int deficit = Arcade.guessTheNumber(scan);
			int swordSkill = 7 - deficit;
			if(swordSkill <= 0) swordSkill = 1;
			System.out.println("Your Sword Skill is " + swordSkill);
			Player knight = new Knight(name, hp, baseDamage, swordSkill);
			System.out.println(knight);
			return knight;
		case 1:
			System.out.println(className + "s get " + KarateMaster.MeleeHpBoost+ " extra hp and " + (KarateMaster.MeleeBdBoost + KarateMaster.KarateBdBoost) + " extra base damage");
			Player karateMaster = new KarateMaster(name, hp, baseDamage);
			System.out.println(karateMaster);
			return karateMaster;
		default:
			break;
		}
		return null;
	}
	
	public static void displayMenu() {
		for(int i = 0; i < menuActions.length; i++) {
			System.out.println((i + 1) + ". " + menuActions[i]);
		}
	}

	public static void chooseNextActionFromMenu(Scanner scan, Player player) {
		System.out.println("What would you like to do?");
		displayMenu();
		System.out.print("> ");
		switch(takeNumericInput(scan, 1, menuActions.length)) {
		case 1:
			System.out.println("Questing in progress...");
			break;
		case 2:
			System.out.println(player);
			break;
		case 3:
			System.out.println("saved stats...");
			return;
		default:
			break;
		}
		chooseNextActionFromMenu(scan, player);
	}

}
