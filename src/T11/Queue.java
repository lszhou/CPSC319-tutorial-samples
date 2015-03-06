package T11;

public interface Queue<T> {

	boolean isEmpty();

	T dequeue();

	void enqueue(T el);

}
