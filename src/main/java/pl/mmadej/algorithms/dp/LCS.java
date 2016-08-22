package pl.mmadej.algorithms.dp;

import java.util.function.BiFunction;

//dynamic programming version of longest-common-subsequence
//note - s(0,k) - means substring of sequence s from 0 to k-th index
public class LCS implements BiFunction<String, String, String> {

	public String apply(String s1, String s2) {
		Path[][] lcsPaths = initializeLcsPaths(s1.length(), s2.length());
		findLcs(s1, s2, lcsPaths);
		return resolveLcs(s1, s2, lcsPaths);
	}

	private void findLcs(String s1, String s2, Path[][] lcsPaths) {
		int[][] lcsLengths = initializeLcsLengths(s1.length() + 1, s2.length() + 1);
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //i-th letter of s1 is the same as j-th letter of s2 and is part of LCS for s1(0,i) & s2(0,j)
					lcsLengths[i][j] = lcsLengths[i - 1][j - 1] + 1; //increase lcs length
					lcsPaths[i - 1][j - 1] = Path.GO_WEST_NORTH;
				} else {
					if (lcsLengths[i - 1][j] >= lcsLengths[i][j - 1]) { //LCS for s1(0,i) & s2(0,j) is the same as LCS for s1(0,i-1) & s2(0,j)
						lcsLengths[i][j] = lcsLengths[i - 1][j];
						lcsPaths[i - 1][j - 1] = Path.GO_NORTH;
					} else { //LCS for s1(0,i) & s2(0,j) is the same as LCS for s1(0,i) & s2(0,j-1)
						lcsLengths[i][j] = lcsLengths[i][j - 1];
						lcsPaths[i - 1][j - 1] = Path.GO_WEST;
					}
				}
			}
		}
	}

	private String resolveLcs(String s1, String s2, Path[][] lcsPaths) {
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		String result = "";
		while (i >= 0 && j >= 0) {
			if (lcsPaths[i][j] == Path.GO_WEST_NORTH) {
				result = s1.charAt(i--) + result;
				j--;
			} else if (lcsPaths[i][j] == Path.GO_NORTH) {
				i--;
			} else {
				j--;
			}
		}
		return result;
	}

	private Path[][] initializeLcsPaths(int rows, int columns) {
		Path[][] lcsPaths = new Path[rows][];
		for (int i = 0; i < rows; i++) {
			lcsPaths[i] = new Path[columns];
		}
		return lcsPaths;
	}

	private int[][] initializeLcsLengths(int rows, int columns) {
		int[][] lcsLenghts = new int[rows][];
		for (int i = 0; i < rows; i++) {
			lcsLenghts[i] = new int[columns];
		}
		return lcsLenghts;
	}

	//to reproduce lcs letters in matrix
	private enum Path {
		GO_NORTH,
		GO_WEST,
		GO_WEST_NORTH
	}
}
