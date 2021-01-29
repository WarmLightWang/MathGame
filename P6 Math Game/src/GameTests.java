import java.util.Random;

/**
 * The class GameTests is used to test the functions of Math Game. This class
 * has multiple test methods, each test focuses on a specific method, on a
 * specific field, or on a specific potential bug. If problem occurs, an error
 * message will be printed out. If no problem is found, it will only display a
 * single message stating all tests have passed.
 */
public class GameTests {
	
	static Random rng = new Random();

	/**
	 * This test creates a new node and check if the randomly generated number is
	 * between 1 and 9] Should return true.
	 * 
	 * @return boolean test passed
	 */
	public static boolean testGameNode1() {
		GameNode testNode = new GameNode(rng);
		if (testNode.getNumber() >= 1 && testNode.getNumber() <= 9) {
			return true;
		}
		return false;
	}

	/**
	 * This test creates two nodes and set the first node's next reference to the
	 * second node Then check if the first node's next field refer to the next node
	 * by comparing their reference Should return true.
	 * 
	 * @return boolean test passed
	 */
	public static boolean testGameNode2() {
		GameNode testNode = new GameNode(rng);
		GameNode next = new GameNode(rng);
		testNode.setNext(next);
		if (testNode.getNext() == next) {
			return true;
		}
		return false;
	}

	/**
	 * This test creates a empty list and add two elements, then use toString method
	 * to test if the add method work correctly Should return true.
	 * 
	 * @return boolean test passed
	 */
	public static boolean testGameList1() {
		GameList testList = new GameList();
		GameNode next1 = new GameNode(rng);
		testList.addNode(next1);
		GameNode next2 = new GameNode(rng);
		testList.addNode(next2);
		// print out the content of the list to check if it work well
		System.out.println(testList.toString());
		return true;
	}

	/**
	 * This test creates a empty list and add one element, then use contains method
	 * to test if the contains method work correctly Should return true.
	 * 
	 * @return boolean test passed
	 */
	public static boolean testGameList2() {
		GameList testList = new GameList();
		GameNode next = new GameNode(rng);
		int number = next.getNumber();
		testList.addNode(next);
		// only if the list contains the specific number but not the number+1, do the
		// test passed
		if (testList.contains(number) && !testList.contains(number + 1))
			return true;
		return false;
	}

	/**
	 * Testing main. Runs each test and prints which (if any) failed. If no problem
	 * occurs, print a single line showing "All tests passed!".
	 */
	public static void main(String[] args) {
		int fails = 0;
		if (!testGameNode1()) {
			System.out.println("testGameNode1 failed");
			fails++;
		}
		if (!testGameNode2()) {
			System.out.println("testGameNode2 failed");
			fails++;
		}
		if (!testGameList1()) {
			System.out.println("testGameList1 failed");
			fails++;
		}
		if (!testGameList2()) {
			System.out.println("testGameList2 failed");
			fails++;
		}
		// If no problem occurs, print a single line showing "All tests passed!".
		if (fails == 0)
			System.out.println("All tests passed!");
	}
}
