package pl.mmadej.algorithms.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Project Euler problem 31, Coin Sums:
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * <p>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * <p>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class CoinSums {

    private List<Integer> coinNominals = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200);

    public int numberOfChangeOptions(int targetAmountOfPences) {
        int[] memory = new int[targetAmountOfPences + 1];
        memory[0] = 1;
        coinNominals.forEach(coinNominal -> { //building memory table
            for (int index = coinNominal; index <= targetAmountOfPences; index++) {
                memory[index] += memory[index - coinNominal];
            }
        });

        return memory[targetAmountOfPences];
    }
}
