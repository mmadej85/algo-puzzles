package pl.mmadej.algorithms.lists;

class Node<T> {
	private Node<T> next;
	private T value;

	Node(T value) {
		this.value = value;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> next() {
		return next;
	}

	public boolean hasNext() {
		return next != null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}