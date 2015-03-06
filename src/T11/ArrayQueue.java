package T11;

public class ArrayQueue<T> implements Queue<T> {
	private int first, last, size;
	private T[] CAPICITY;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int n) {
		size = n;
		CAPICITY = (T[]) new Object[size];
		first = last = -1;
	}

	@Override
	public boolean isEmpty() {
		return first == -1;
	}

	@Override
	public T dequeue() {
		T tmp = CAPICITY[first];
		if (first == last)
			last = first = -1;
		else if (first == size - 1)
			first = 0;
		else
			first++;
		return tmp;
	}

	@Override
	public void enqueue(T el) {
		if (last == size - 1 || last == -1) {
			CAPICITY[0] = el;
			last = 0;
			if (first == -1)
				first = 0;
		} else
			CAPICITY[++last] = el;

	}

}
