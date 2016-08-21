package pl.mmadej.algorithms.sort;

import pl.mmadej.algorithms.ds.LinkedListNode;

public class MergeSort<T extends Comparable<T>> {

	public LinkedListNode<T> sort(LinkedListNode<T> head) {
		if (head == null) throw new IllegalArgumentException("Argument is null");
		return mergeSortRecursively(head);
	}

	private LinkedListNode<T> mergeSortRecursively(LinkedListNode<T> firstNode) {
		if (!firstNode.hasNext()) {
			return firstNode;
		}
		LinkedListNode<T> nodeBeforeMiddleNode = findMiddleNode(firstNode);
		LinkedListNode<T> middleNode = nodeBeforeMiddleNode.next();
		nodeBeforeMiddleNode.setNext(null);

		return mergeList(mergeSortRecursively(firstNode), mergeSortRecursively(middleNode));
	}

	private LinkedListNode<T> mergeList(LinkedListNode<T> nodeFromFirstList, LinkedListNode<T> nodeFromSecondList) {
		LinkedListNode<T> dummyNode = new LinkedListNode<>(null);
		LinkedListNode<T> node = dummyNode;
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

	private void appendIfNotEmpty(LinkedListNode<T> node, LinkedListNode<T> toAppend) {
		while (toAppend != null) {
			node.setNext(toAppend);
			toAppend = toAppend.next();
			node = node.next();
		}
	}

	private LinkedListNode<T> findMiddleNode(LinkedListNode<T> firstNode) {
		LinkedListNode<T> slowNode = firstNode;
		LinkedListNode<T> fastNode = firstNode;
		while (fastNode.hasNext() && fastNode.next().hasNext()) {
			slowNode = slowNode.next();
			fastNode = fastNode.next().next();
		}
		return slowNode;
	}
}
