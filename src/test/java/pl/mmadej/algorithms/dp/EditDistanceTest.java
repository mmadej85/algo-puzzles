package pl.mmadej.algorithms.dp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class EditDistanceTest {

	private EditDistance editDistance = new EditDistance();


	@Test
	public void findEditDistanceBetweenTwoWords(){
		assertThat(editDistance.apply("Saturday", "Sunday"), is(equalTo(3)));
		assertThat(editDistance.apply("intention", "execution"), is(equalTo(5)));
	}

	@Test
	public void findEditDistanceBetweenSameWords(){
		assertThat(editDistance.apply("Phone", "Phone"), is(equalTo(0)));
	}

	@Test
	public void editDistanceIsCaseSensitive(){
		assertThat(editDistance.apply("paper", "PapEr"), is(equalTo(2)));
	}

	@Test
	public void findEditDistanceBetweenEmptyWordAndNonEmptyWord(){
		assertThat(editDistance.apply("", "button"), is(equalTo(6)));
	}

}