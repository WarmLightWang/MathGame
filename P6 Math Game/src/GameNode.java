import java.util.Random;

/**
 * This class creates nodes in a linked list. Each node has two fields: 1.
 * primitive type integer number to store value; 2. GameNode type object next to
 * store the reference of next node. The class has following methods and
 * functions in turn:
 * 
 * @constructor GameNode: creates a new node and randomly assign a integer
 *              between 1-9 to the number field.
 * @method getNumber: Accessor for the number field. Return the number of this
 *         node.
 * @method getNext: Accessor for the next field. Return the reference of the
 *         next node.
 * @method setNext: Mutator for the next field. Set next field to next node
 * @method applyOperator: Calculating and changing the number and next fields
 */
public class GameNode {

	private int number; // the number held within this node
	private GameNode next; // the next GameNode in the list, or null for the last node

	/**
	 * This constructor creates a new node and randomly assign a integer between 1-9
	 * to the number field.
	 * 
	 * @param rng: random number generator
	 */
	public GameNode(Random rng) {
		this.number = rng.nextInt(9) + 1;
	} // initializes number to random 1-9 value, and next to null

	/**
	 * Accessor for the number field. Return the number of this node
	 * 
	 * @return this.number: value stored in this node
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Accessor for the next field. Return the reference of the next node
	 * 
	 * @return this.next: the next node following the current one in the linked list
	 */
	public GameNode getNext() {
		return this.next;
	}

	/**
	 * Mutator for the next field. Set next field to next node
	 * 
	 * @param next: a node object that is going to be assigned to this.next field
	 */
	public void setNext(GameNode next) {
		this.next = next;
	}

	/**
	 * Calling on this method changes the number and next fields. The new number for
	 * this node is calculated by applying the provided operator to this node's
	 * number (the first operand), and the next node's number (the second operand).
	 * The new next reference for this node should be copied from the next reference
	 * of the following node in the list so that the following node is effectively
	 * removed from the list.
	 * 
	 * @param operator: a provided operator that is going to be used to calculate
	 *                  the node's number
	 */
	public void applyOperator(GameOperator operator) {
		this.number = operator.apply(this.number, this.next.getNumber()); // apply the operator
		this.next = this.next.getNext(); // set the next field to the next node's next field, since
		// the next object has no pointer pointing to it, the next node is deleted from the list
	}
}
