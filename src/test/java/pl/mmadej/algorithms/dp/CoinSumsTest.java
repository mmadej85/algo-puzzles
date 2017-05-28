package pl.mmadej.algorithms.dp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CoinSumsTest {

    private CoinSums coinSums = new CoinSums();

    @Test
    public void shouldCorrectlyCalculatedAllNumberOfChangeOptions() {
        assertThat(coinSums.numberOfChangeOptions(1), is(equalTo(1)));
        assertThat(coinSums.numberOfChangeOptions(2), is(equalTo(2)));
        assertThat(coinSums.numberOfChangeOptions(5), is(equalTo(4)));
        assertThat(coinSums.numberOfChangeOptions(10), is(equalTo(11)));
        assertThat(coinSums.numberOfChangeOptions(200), is(equalTo(73682)));
    }

}