package pl.mmadej.algorithms.lists;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedListTest {

	private LinkedList<Integer> linkedList;

	@Before
	public void before() {
		linkedList = new LinkedList<>();
	}

	@Test
	public void shouldPrintFromHeadToTail() {
		linkedList.addAll(4, 5, 1, 8, 9);

		assertThat(linkedList.toString(), is(equalTo("[4,5,1,8,9]")));
	}

	@Test
	public void shouldSortTheListUsingMergeSort() {
		linkedList.addAll(4, 5, 1, 8, 9, -6, -8);

		linkedList.mergeSort();

		assertThat(linkedList.toString(), is(equalTo("[-8,-6,1,4,5,8,9]")));
	}

	@Test
	public void shouldNotFailWhenSortingEmptyList() {
		linkedList.mergeSort();

		assertThat(linkedList.toString(), is(equalTo("[]")));
	}

	@Test
	public void shouldSortListWithOneElement() {
		linkedList.add(-12);

		assertThat(linkedList.toString(), is(equalTo("[-12]")));
	}
}