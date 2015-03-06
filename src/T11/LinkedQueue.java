package T11;

public class LinkedQueue<T> implements Queue<T> {

	private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

	@Override
	public void clear() {
		list.clear();

	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public T dequeue() {
		return list.removeFirst();
	}

	@Override
	public void enqueue(T el) {
		list.addLast(el);

	}

}
