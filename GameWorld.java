import java.util.Scanner;
import players.*;

public class GameWorld {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UI.displayWelcomeMessage();
		Player player = UI.setUpCharacter(scan, UI.chooseCharacterClass(scan));
		UI.chooseNextActionFromMenu(scan, player);
		scan.close();
	}

}
//don't need to worry about dynamically casting character because I'll have if statements anyway when doing special actions
//this goes to show I should plan ahead what my game is gonna do before I do stuff