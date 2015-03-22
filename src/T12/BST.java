package T12;

import java.util.ArrayDeque;

/*This class is a generic type implementation of Binary Search Tree which
 * implements self-defined BST interface (BSTInterface.java). 
 * 
 * It is implemented by a private inner node class. In order to support
 * the binary search property, we require the data stored in each node is
 * comparable. Specially, BST class is of generic type T which is an ADT (class)
 * extends Comparable interface. Since all java basic ADTs (integer, String, etc) 
 * have implemented the compareTo() method, therefore for these data, this BST
 * could be used directly. For general object data (for example, self-defined 
 * student object), it should implements compareTo() method in advance, namely
 * it should implement comparable interface in advance. 
 *  
 * For more information of comparable interface, please refer to
 * "http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html"
 * */

public class BST<T extends Comparable<T>> implements BSTInterface<T> {

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

		/**
		 * recursive depth-first PreOrder traversal
		 */
		public void DFS_PreOrder_Display() {

			System.out.print(this.data + " ");

			if (this.left != null) {
				this.left.DFS_PreOrder_Display();
			}

			if (this.right != null) {
				this.right.DFS_PreOrder_Display();
			}
		}

		/**
		 * recursive depth-first InOrder traversal
		 */
		public void DFS_InOrder_Display() {

			if (this.left != null) {
				this.left.DFS_InOrder_Display();
			}

			System.out.print(this.data + " ");

			if (this.right != null) {
				this.right.DFS_InOrder_Display();
			}
		}

		/**
		 * recursive depth-first PostOrder traversal
		 */
		public void DFS_PostOrder_Display() {

			if (this.left != null) {
				this.left.DFS_PostOrder_Display();
			}

			if (this.right != null) {
				this.right.DFS_PostOrder_Display();
			}

			System.out.print(this.data + " ");
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
	/**
	 * Search the given data in the BST;
	 * @param toSearch the given data
	 */
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
	/**
	 * Delete the data toDelete, considering the fllowing cases:
	 *  - is not in BST
	 *  - is a leaf (no children)
	 *  - has one child
	 *  - has two children
	 */
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
	
	/**
	 * Get the smallest node data is the left subtree.
	 * @param p current node I am in.
	 * @return biggest data in the left subtree
	 */
	private T retrieveData(Node<T> p) {
		while (p.right != null)
			p = p.right;

		return p.data;
	}

	public void DFS_PreOrder_Display() {
		this.root.DFS_PreOrder_Display();
		System.out.println();
	}

	public void DFS_InOrder_Display() {
		this.root.DFS_InOrder_Display();
		System.out.println();
	}

	public void DFS_PostOrder_Display() {
		this.root.DFS_PostOrder_Display();
		System.out.println();
	}
	
	/**
	 * non-recursive Breadth-first traversal using stack;
	 */
	public void BFS_LevelOder_Display() {
		
		if (root == null) {
			System.out.println("empty tree");
			return;
		}
		
		ArrayDeque<Node<T>> queue = new ArrayDeque<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node<T> node = queue.remove();
			System.out.print(node.data + " ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		System.out.print(" ");
	}

	/*-----------------------BST Test-----------------------*/
	public static void main(String[] args) {
		int[] arrTest = { 1, 4, 2, 3, 6, 5 };
		BST<Integer> tree = new BST<>();

		for (int i = 0; i < arrTest.length; i++) {
			tree.insert(arrTest[i]);
		}
		System.out.println("Display all data via PreOrder traversal");
		tree.DFS_PreOrder_Display();

		System.out.println("Display all data via InOrder traversal");
		tree.DFS_InOrder_Display();

		System.out.println("Display all data via PostOrder traversal");
		tree.DFS_PostOrder_Display();
		
		System.out.println("Display all data via LevelOrder traversal");
		tree.BFS_LevelOder_Display();

	}

}
