package uk.ac.aber.dcs.odj.concordance;

/**
 * <p>Minimal Linked List implementation that allows you to plug in your
 * own custom Node objects, as long as the Nodes are based on my
 * {@link CustomNode} interface.</p>
 * <p>Behaves similarly to Java's default {@link LinkedList} class, but with less
 * methods.</p>
 * <p>Uses Generics, and elements in list must extend {@link CustomNode} class.</p>
 * <p>For my CS assignment, I only need to be able to add to the list and iterate
 * through all the elements in a serial manner - I don't need to be able to
 * remove or get specific elements in the middle of the list, so I've left
 * getAt, remove(index), add(index) etc. methods out of this implementation to
 * save myself time.</p>
 * @author Owain Jones <odj@aber.ac.uk>
 *
 */
public class LittleLinkedList<T extends CustomNode> {
	private T head;
	private T tail;
	private int size;
	
	/**
	 * Creates a new Little Linked List with a size of 0 and no head node.
	 * (getHead and getTail methods will return null)
	 */
	public LittleLinkedList() {
		this.size = 0;
	}

	/**
	 * Creates a new Little Linked List and adds a head node
	 * @param first The node to add which will become the head of the list.
	 */
	public LittleLinkedList(T first) {
		this.add(first);
	}
	
	/**
	 * Appends a node to the end of the list, increasing the list's size by 1.
	 * If node is identical to another element in the list, don't add to the list -
	 * return false to indicate we haven't.
	 * @param node The {@link CustomNode} object to append to the end of list
	 * @return true if node was added, false if the node couldn't be added
	 */
	public boolean add(T node) {
		if(this.size == 0) {
			this.head = node;
			this.tail = node;
		} else if(this.size == 1) {
			if(node.identical(this.tail)) return false;
			this.head.next(node);
			this.tail = node;
		} else {
			if(node.identical(this.tail)) return false;
			this.tail.next(node);
			this.tail = node;
		}
		this.size++;
		return true;
	}

	/**
	 * Empties the list.
	 */
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * 
	 * @return current size of the list
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Gets the head of the list.
	 * @return {@link CustomNode} or {@code null} if there's no head node yet.
	 */
	public T getHead() {
		return this.head;
	}
	
}
