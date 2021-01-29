/**
 * This class creates a linked list using nodes. Each list has only one field:
 * the reference to the first node. In fact, this list are composed of many node
 * objects and many list methods. The list itself does not have any storage to
 * store data, the data are stored in nodes The class has following methods and
 * functions in turn:
 * 
 * @constructor GameList: Creates a new linked list by starting with an empty
 *              list
 * @method addNode: Adds the new node to the end of this list
 * @method contains: Checks if the list contains a node with the specified
 *         number
 * @method toString: Returns the content of the list in a string
 * @method applyOperatorToNumber: if the list contains a node with the specified
 *         number, it will call the applyOperator method in that node to do the
 *         operation.
 */
public class GameList {

	private GameNode list; // reference to the first GameNode in this list

	/**
	 * Constructor. Creates a new linked list by starting with an empty list This
	 * constructor creates a new node and randomly assign a integer between 1-9 to
	 * the number field.
	 */
	public GameList() {

	}

	/**
	 * Adds the new node to the end of this list
	 * 
	 * @param newNode: a new node that is going to be added to the end of the list
	 */
	public void addNode(GameNode newNode) {
		GameNode now = list; // We begin with the first element of the list (which is the first node)
		if (now == null) {
			list = newNode;
			return;
		} // if the list is empty(in other words, the list field is null), we assign the
			// newNode to it and end the method by return
		while (now.getNext() != null)
			now = now.getNext();
		now.setNext(newNode);
	} // if the list is not empty, we go through the list by calling getNext method of
		// current node until the getNext returns null, which means the current node is
		// the last one. We then assign the newNode to the current node(which is the
		// last one)'s next field by calling the setNext method

	/**
	 * Only returns true when this list contains a node with the specified number
	 * 
	 * @return return true if the list contains a node with the specified number,
	 *         false otherwise
	 */
	public boolean contains(int number) {
		GameNode now = list;
		while (now != null) {
			if (now.getNumber() == number)
				return true;
			now = now.getNext();
		} // we go through the list by calling getNext method of current node until the
			// current node is null, which means the list ends. Once we find the specific
			// number, we end the method by returning true, marking that the list contains
			// that specific number, otherwise false
		return false;
	}

	/**
	 * Override the toString method in Object class Returns a string with each
	 * number in the list separated by " -> "s, and ending with " -> END"
	 * 
	 * @return a string with each number in the list separated by " -> "s, and
	 *         ending with " -> END"
	 */
	@Override
	public String toString() {
		GameNode now = list;
		String res = new String();
		while (now != null) {
			res = res.concat(now.getNumber() + " -> ");
			now = now.getNext();
		} // we go through the list by calling getNext method of current node until the
			// current node is null, which means the list is ended. Each loop we concatenate
			// the new number and the pointer mark "->" to the final String

		res = res.concat("END"); // At the end of the String, we concatenate an "END" mark
		return res;
	}

	/**
	 * This method scans through this list searching for the first occurrence of a
	 * node with the specified number. After finding a node with that number, it
	 * calls the applyOperator method on that GameNode, passing along the specified
	 * operator object reference. We will be sure to never call this method when the
	 * first occurrence of specified number either does not exist or is the last
	 * element in the list, so that we can avoid the Exception being thrown.
	 * 
	 * @param number:   a node with this number to be found and implemented the
	 *                  operation
	 * @param operator: a provided operator that is going to be used to calculate
	 *                  the node's number
	 */
	public void applyOperatorToNumber(int number, GameOperator operator) {
		GameNode now = list;
		// we run the following loop to find the precise location of the first node with
		// that number
		while (now != null) {
			if (now.getNumber() == number) {
				now.applyOperator(operator);
				break;
			}
			now = now.getNext();
		}
	}
}
