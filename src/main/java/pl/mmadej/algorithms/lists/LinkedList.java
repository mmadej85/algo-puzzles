package pl.mmadej.algorithms.lists;

public class LinkedList<T extends Comparable<T>> {
	private Node<T> head = null;

	public void add(T value) {
		Node<T> newNode = new Node<>(value);

		if (head == null) {
			head = newNode;
			return;
		}
		Node<T> node = head;
		while (node.hasNext()) {
			node = node.next();
		}
		node.setNext(newNode);
	}

	@SafeVarargs
	public final void addAll(T... values) {
		for (T value : values) add(value);
	}

	public void mergeSort() {
		if (head == null) return;
		head = mergeSortRecursively(head);
	}

	private Node<T> mergeSortRecursively(Node<T> firstNode) {
		if (!firstNode.hasNext()) {
			return firstNode;
		}
		Node<T> nodeBeforeMiddleNode = findMiddleNode(firstNode);
		Node<T> middleNode = nodeBeforeMiddleNode.next();
		nodeBeforeMiddleNode.setNext(null);

		return mergeList(mergeSortRecursively(firstNode), mergeSortRecursively(middleNode));
	}

	private Node<T> mergeList(Node<T> nodeFromFirstList, Node<T> nodeFromSecondList) {
		Node<T> dummyNode = new Node<>(null);
		Node<T> node = dummyNode;
		while (nodeFromFirstList != null && nodeFromSecondList != null) {
			if (nodeFromFirstList.getValue().compareTo(nodeFromSecondList.getValue()) <= -1) {
				node.setNext(nodeFromFirstList);
				nodeFromFirstList = nodeFromFirstList.next();
			} else {
				node.setNext(nodeFromSecondList);
				nodeFromSecondList = nodeFromSecondList.next();
			}
			node = node.next();
		}
		appendIfNotEmpty(node, nodeFromFirstList);
		appendIfNotEmpty(node, nodeFromSecondList);
		return dummyNode.next();
	}

	private void appendIfNotEmpty(Node<T> node, Node<T> toAppend) {
		while (toAppend != null) {
			node.setNext(toAppend);
			toAppend = toAppend.next();
			node = node.next();
		}
	}

	private Node<T> findMiddleNode(Node<T> firstNode) {
		Node<T> slowNode = firstNode;
		Node<T> fastNode = firstNode;
		while (fastNode.hasNext()&& fastNode.next().hasNext()) {
			slowNode = slowNode.next();
			fastNode = fastNode.next().next();
		}
		return slowNode;
	}

	@Override
	public String toString() {
		String content = "";
		Node<T> node = head;
		while (node != null) {
			content += node.getValue();
			if (node.hasNext()) {
				content += ",";
			}
			node = node.next();
		}
		return "[" + content + "]";
	}
}

