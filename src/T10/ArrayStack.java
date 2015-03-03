package T10;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private int top; // Reference to the top element.
	private T[] arr;

	/**
	 * creates a stack with initial size
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		arr = (T[]) new Object[DEFAULT_CAPACITY];
		top = -1; // stack is empty;
	}

	@Override
	public boolean empty() {
		return top == -1;
	}

	@Override
	public T peek() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			return arr[top];
		}

	}

	@Override
	public T pop() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			T tmp = arr[top];
			arr[top] = null;
			top--;
			return tmp;

		}
	}

	@Override
	public T push(T obj) {
		if (top == DEFAULT_CAPACITY - 1) {
			System.out.println("Stack is Full!");
		} else {
			top++;
			arr[top] = obj;
		}
		return obj;
	}

}
