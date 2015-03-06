package T11;

public interface Queue<T> {
	void clear();

	boolean isEmpty();

	T dequeue();

	void enqueue(T el);

}
