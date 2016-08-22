package pl.mmadej.algorithms.dp;

import java.util.function.BiFunction;

import static java.lang.Math.min;

//dynamic programming version of edit distance
public class EditDistance implements BiFunction<String, String, Integer> {
	@Override
	public Integer apply(String s1, String s2) {
		int[][] editDistances = initializeEditDistances(s1.length() + 1, s2.length() + 1);
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					editDistances[i][j] = editDistances[i - 1][j - 1];
				} else {
					int insertCost = editDistances[i][j - 1] + 1; //insert s2[j] after s1[i]
					int deleteCost = editDistances[i - 1][j] + 1; //delete s1[i]
					int substituteCost = editDistances[i - 1][j - 1] + 1; //substitute s1[i] with s2[j]
					editDistances[i][j] = min(min(insertCost, deleteCost), substituteCost);
				}
			}
		}
		return editDistances[s1.length()][s2.length()];
	}

	private int[][] initializeEditDistances(int rows, int columns) {
		int[][] editDistances = new int[rows][];
		for (int i = 0; i < rows; i++) {
			editDistances[i] = new int[columns];
		}
		for (int i = 1; i < rows; i++) { //it takes i deletions to transfer ith-length string to empty string
			editDistances[i][0] = i;
		}
		for (int j = 1; j < columns; j++) { //it takes j inserts to transfer empty string to jth-length string
			editDistances[0][j] = j;
		}
		return editDistances;
	}
}
