package T12;

public class BST<T extends Comparable<T>> implements BSTInterface<T>{

	@SuppressWarnings("hiding")
	private class Node<T> {
		private T data;
		private Node<T> left, right;

		public Node(T data, Node<T> l, Node<T> r) {
			left = l;
			right = r;
			this.data = data;
		}

		public Node(T data) {
			this(data, null, null);
		}

		public void printNode() {  //InOrder Traversal
			if (this.left != null) {
				this.left.printNode();
			}
			System.out.print(this.data + " ");
			if (this.right != null) {
				this.right.printNode();
			}
		}
	}

	private Node<T> root;

	/**
	 * Construct an empty BST; 
	 */
	public BST() {
		root = null;
	}

	@Override
	public void insert(T toInsert) {
		root = insert(root, toInsert);
	}

	private Node<T> insert(Node<T> p, T toInsert) {
		if (p == null)
			return new Node<T>(toInsert);

		if (toInsert.compareTo(p.data) == 0)
			return p;

		if (toInsert.compareTo(p.data) < 0)
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);

		return p;
	}

	@Override
	public boolean search(T toSearch) {
		return search(root, toSearch);
	}

	private boolean search(Node<T> p, T toSearch) {
		if (p == null)
			return false;
		else if (toSearch.compareTo(p.data) == 0)
			return true;
		else if (toSearch.compareTo(p.data) < 0)
			return search(p.left, toSearch);
		else
			return search(p.right, toSearch);
	}
	
	@Override
	public void delete(T toDelete) {
		root = delete(root, toDelete);
	}

	private Node<T> delete(Node<T> p, T toDelete) {
		if (p == null)
			throw new RuntimeException("cannot delete.");
		else if (toDelete.compareTo(p.data) < 0)
			p.left = delete(p.left, toDelete);
		else if (toDelete.compareTo(p.data) > 0)
			p.right = delete(p.right, toDelete);
		else {
			if (p.left == null)
				return p.right;
			else if (p.right == null)
				return p.left;
			else {
				p.data = retrieveData(p.left);
				p.left = delete(p.left, p.data);
			}
		}
		return p;
	}

	private T retrieveData(Node<T> p) {
		while (p.right != null)
			p = p.right;

		return p.data;
	}

	public void display() {
		this.root.printNode();
	}

	/*-----------------------BST Test-----------------------*/
	public static void main(String[] args) {
		int[] arrTest = {1, 4, 2, 3, 6, 5};
		BST<Integer> tree = new BST<>();

		for (int i = 0; i < arrTest.length; i++) {
			tree.insert(arrTest[i]);
		}

		tree.display();

	}

}
