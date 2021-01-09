package com.company;

public class Main {

    public static void main(String[] args) {
		int testOne = 3;
		int testTwo = 3;
		int n = 0;
		int[][] test = new int[testOne][testTwo];

		for (int i = 0; i < testOne; i++) {
			for (int j = 0; j < testTwo; j++) {
				n += 1;
				test[i][j] = n;

			}
		}

		Snail snail = new Snail();
		snail.realSnail(test);

    }
}
