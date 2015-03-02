package T10;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

	// insert inner node class here
	/*----------Node class-------------*/
	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;

		}
	}

	/*----------------------------------*/

	// LinedStack data field;
	private Node<T> topStack;

	public LinkedStack() {
		topStack = null;
	}

	@Override
	public boolean empty() {
		return topStack == null;
	}

	@Override
	public T peek() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			return topStack.data;
		}
	}

	@Override
	public T pop() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			T tmp = topStack.data;
			topStack = topStack.next;
			return tmp;
		}
	}

	@Override
	public T push(T obj) {
		topStack = new Node<T>(obj, topStack);
		return obj;
	}
}
