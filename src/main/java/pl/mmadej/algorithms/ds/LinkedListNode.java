package pl.mmadej.algorithms.ds;

public class LinkedListNode<T> {
	private LinkedListNode<T> next;
	private T value;

	public LinkedListNode(T value) {
		this.value = value;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public LinkedListNode<T> next() {
		return next;
	}

	public boolean hasNext() {
		return next != null;
	}

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {
		String content = "";
		LinkedListNode<T> node = this;
		while (node != null) {
			content += node.getValue();
			if (node.hasNext()) {
				content += ",";
			}
			node = node.next();
		}
		return "[" + content + "]";
	}

	@SafeVarargs
	public static <E> LinkedListNode<E> listOf(E... elements) {
		if (elements == null || elements.length == 0)
			throw new IllegalArgumentException("Elements arrays cannot be null or empty");
		LinkedListNode<E> head = new LinkedListNode<>(elements[0]);
		LinkedListNode<E> node = head;
		for (int i = 1; i < elements.length; i++) {
			LinkedListNode<E> next = new LinkedListNode<>(elements[i]);
			node.setNext(next);
			node = next;
		}
		return head;
	}
}
