package pl.mmadej.algorithms.ds;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static pl.mmadej.algorithms.ds.LinkedListNode.listOf;

public class LinkedListNodeTest {

	private LinkedListNode<Integer> linkedListNode;

	@Test
	public void shouldPrintFromHeadToTail() {
		linkedListNode = listOf(4, 5, 1, 8, 9);

		assertThat(linkedListNode.toString(), is(equalTo("[4,5,1,8,9]")));
	}


	@Test
	public void shouldPrintListWithOneElement() {
		linkedListNode = listOf(-12);

		assertThat(linkedListNode.toString(), is(equalTo("[-12]")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailToConstructListFromNull(){
		listOf(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailToConstrultListFromEmptyArray(){
		listOf();
	}

}