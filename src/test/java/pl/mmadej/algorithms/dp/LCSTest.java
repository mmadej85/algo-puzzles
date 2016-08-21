package pl.mmadej.algorithms.dp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LCSTest {
	private LCS lcs = new LCS();

	@Test
	public void largestCommonSequenceWithManyLetters() {
		assertThat(lcs.apply("ABCBDAB", "BDCABA"), is(equalTo("BCBA")));
	}

	@Test
	public void noLargestCommonSequenceWhenDifferentLettersOnBothStrings() {
		assertThat(lcs.apply("ABCBDAB", "GHJGHHJI"), is(equalTo("")));
	}

	@Test
	public void noLargestCommonSequenceWhenOneStringIsEmpty() {
		assertThat(lcs.apply("", "ABCD"), is(equalTo("")));
	}

	@Test
	public void largestCommonSequenceWithOnlyOneLetter(){
		assertThat(lcs.apply("CDAE", "RAKL"), is(equalTo("A")));
	}
}