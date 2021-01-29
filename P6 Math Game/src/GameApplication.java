import java.util.Random;
import java.util.Scanner;

/**
 * This class creates the application of the math game, it sets up the target
 * goal and the a new GameLists for each run.
 * 
 * @constructor GameApplication: Targets goal number and creates a new linked
 *              list with 7 randomly numbered GameNodes
 * @method main: Driver method responsible for running and implement the game
 */
public class GameApplication {
	
	private static int goal; // target value
	private static GameList list; // linked list, used for value storage
	static Random rng = new Random(); // random number generator

	/**
	 * This constructor targets the goal number between 10 - 99, and it creates a
	 * new GameList with 7 randomly numbered GameNodes at the beginning of each
	 * game. This setup will be presented on each turn.
	 * 
	 */
	public GameApplication() {
		goal = rng.nextInt(90) + 10; // targeting goal number
		list = new GameList();
		for (int i = 1; i <= 7; i++) {
			GameNode next = new GameNode(rng); // creating new GameList with 7 randomly numbered
			list.addNode(next);
		}
	}

	/**
	 * This main method results in an interactive session. On each turn, the driver
	 * method display all of the valid operation characters. The program will end
	 * with a goodbye message as a result if user ever types in the word "quit". The
	 * program will print out a descriptive warning message if the user ever enters
	 * input invalid format.
	 */
	public static void main(String[] args) {
		new GameApplication();
		Scanner scnr = new Scanner(System.in);
		int movesTaken = 0;
		while (!list.contains(goal)) {
			System.out.println("Goal: " + goal + " Moves Taken: " + movesTaken);
			System.out.println("Puzzle: " + list.toString());
			// display all of the valid operation characters
			System.out.print("Number and Operation " + GameOperator.ALL_OPERATORS.toString() + " to Apply: ");

			String cmd = scnr.nextLine(); // read in each entire move entered by the player
			cmd = cmd.trim();
			while (cmd.length() == 0) {
				cmd = scnr.nextLine(); // read in each entire move entered by the player
				cmd = cmd.trim();
			}

			if (cmd.toLowerCase().equals("quit")) { // the program with a goodbye message as a result
				// if the user ever types in "quit"
				System.out.println();
				System.out.println("Goodbye!");
				return;
			}
			System.out.println();

			GameOperator operator = GameOperator.getFromChar(cmd.charAt(cmd.length() - 1));
			if (operator == null) {
				System.out.println("WARNING: Invalid operator!");
				System.out.println();
				continue;
			} // print out a descriptive warning message if the user ever enters input that
			 // does not conform to the format

			int number = 1;
			try {
				number = Integer.parseInt(cmd.substring(0, cmd.length() - 1));
			} catch (NumberFormatException e) {
				System.out.println("WARNING: Invalid number!");
				System.out.println();
				continue;
			} // print out a descriptive warning message if the user ever enters input that
			 // does not conform to the format

			if (list.contains(number)) { // check if the number exist in the list
				String[] numbers = list.toString().split(" -> ");
				int cnt = 0;
				for (int i = 0; i < numbers.length - 2; i++)
					if (Integer.parseInt(numbers[i]) == number)
						cnt++;
				if (cnt > 0) { // check if the number is not the last one in the list
					list.applyOperatorToNumber(number, operator);
					GameNode next = new GameNode(rng);
					list.addNode(next);
					movesTaken++;
				} else { // if the number is the last one, print out the warning message
					System.out.println("WARNING: This is the last number!");
					System.out.println();
				}

			} else { 
				// if the number does not exist, print out the warning message
				System.out.println("WARNING: This number does not exist in the list!");
				System.out.println();
			}
			//scnr.close();
		}
		System.out.println("Congratulations, you won in " + movesTaken + " moves.");
		System.out.println("Soluton: " + list.toString());
	}
}
