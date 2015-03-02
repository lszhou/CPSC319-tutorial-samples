/*Following package name should be changed to your own package name*/
package T07;

/*The following self-defined single linked list class implements the following operations:
 - addFirst
 - addLast
 - insertAfter
 - remove
 - display
 */
public class SingleLinkedList<AnyType> {

	/*******************************************************
	 * 
	 * The (Inner) Node class
	 * 
	 ********************************************************/
	private static class Node<AnyType> {
		private AnyType data;
		private Node<AnyType> next;

		/* Constructor with one argument. */
		/*
		 * public Node(AnyType data) { this.data = data; this.next = null; }
		 */
		
		/* Constructor with two arguments. */
		public Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}
	}

	/* ******************************************************** */

	//SinglelinkedList data field
	private Node<AnyType> head;

	/* Constructs an empty list. */
	public SingleLinkedList() {
		head = null;
	}

	public void addFirst(AnyType item) {
		head = new Node<AnyType>(item, head);
	}

	public void addLast(AnyType item) {
		if (head == null)
			addFirst(item);
		else {
			Node<AnyType> tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;

			tmp.next = new Node<AnyType>(item, null);
		}
	}

	public void insertAfter(AnyType key, AnyType toInsert) {
		Node<AnyType> tmp = head;

		while (tmp != null && !tmp.data.equals(key))
			tmp = tmp.next;

		if (tmp != null)
			tmp.next = new Node<AnyType>(toInsert, tmp.next);
	}

	public void remove(AnyType key) {
		if (head == null)
			throw new RuntimeException("cannot delete");

		if (head.data.equals(key)) {
			head = head.next;
			return;
		}

		Node<AnyType> cur = head;
		Node<AnyType> prev = null;

		while (cur != null && !cur.data.equals(key)) {
			prev = cur;
			cur = cur.next;
		}

		if (cur == null)
			throw new RuntimeException("cannot delete");

		// delete cur node
		prev.next = cur.next;
	}

	public void display() {
		Node tmp = head;
		while (tmp != null) {
			System.out.printf("-->" + tmp.data);
			tmp = tmp.next;
		}
		System.out.println();
	}

}
