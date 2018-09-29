import java.util.Scanner;
// make Arcade's methods static?
public class Arcade {
		
	public static int guessTheNumber(Scanner scan) { // will return a deficit to be subtracted from a number's full potential
		System.out.println("Guess a random number between 1 and 15, inclusive. You will have three tries");
		System.out.println("The difference between your final guess and the random number will be subtracted off your full potential");
		System.out.println("You will be given a hint after each try~");
		int secretNumber = (int) (Math.floor(Math.random() * 15)) + 1;
		//System.out.println(secretNumber);
		int guess = 0;
		for(int i = 1; i <= 3; i++) {
			System.out.print("Enter guess #" + i + ": ");
			guess = UI.takeNumericInput(scan, 1, 15);
			if(guess == secretNumber) {
				System.out.println("Congratulations! You've guessed the number!");
				return 0;
			} else {
				System.out.println("You guessed too " + (guess > secretNumber ? "high" : "low"));
			}
		}
		System.out.println("Your final guess is " + guess + " and the real number is " + secretNumber + ". Better luck next time!");
		return Math.abs(guess - secretNumber);
	}
	
}
