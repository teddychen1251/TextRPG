import java.util.Scanner;

public class QuestGiver {
	// must complete previous quest to move to next
	private static String[] quests = {"Welcome to the Dungeon", "Gobs of Goblins"};
	private static int questIndex = 0;
	
	public boolean chooseNextAvailableQuest(Scanner scan) {
		System.out.println("Next available quest: " + quests[questIndex]);
		System.out.println("Enter quest? (type yes/no)");
		String answer = scan.nextLine();
		while(!answer.toLowerCase().equals("yes") && !answer.toLowerCase().equals("no")) {
			System.out.print("Please enter a valid answer: ");
			answer = scan.nextLine();
		}
		return answer.equals("yes");
	}
	
	public void enterNextAvailableQuest(Scanner scan) {
		
	}
	
	
}
