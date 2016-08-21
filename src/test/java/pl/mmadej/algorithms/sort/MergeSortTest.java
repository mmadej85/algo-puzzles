package pl.mmadej.algorithms.sort;

import org.junit.Before;
import org.junit.Test;
import pl.mmadej.algorithms.ds.LinkedListNode;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static pl.mmadej.algorithms.ds.LinkedListNode.listOf;

public class MergeSortTest {

	private MergeSort<Integer> mergeSort;
	private LinkedListNode<Integer> linkedList;

	@Before
	public void before() {
		mergeSort = new MergeSort<>();
	}


	@Test
	public void shouldSortTheListUsingMergeSort() {
		linkedList = listOf(4, 5, 1, 8, 9, -6, -8);

		linkedList = mergeSort.sort(linkedList);

		assertThat(linkedList.toString(), is(equalTo("[-8,-6,1,4,5,8,9]")));
	}

	@Test
	public void shouldSortListWithOneElement() {
		linkedList = listOf(-12);

		assertThat(linkedList.toString(), is(equalTo("[-12]")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failsWhenNodeIsNull() {
		mergeSort.sort(null);
	}

}