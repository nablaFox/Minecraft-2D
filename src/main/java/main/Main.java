package main;

import visual.Map;

import java.util.Scanner;

public class Main {
	private static final int INTERACTIONS = 6;
	private static Map map;

	public static void main(String[] args) {
		test_gravity();
	}

	private static void test_gravity() {
		map = new Map(false);
		map.display_on_out();

		Scanner input = new Scanner(System.in);

		for (int i = 0; i < INTERACTIONS; i++) {
			System.out.println("Col: ");
			int col = input.nextInt();

			System.out.println("Dropping a new block in the col: " + col);
			map.change_chell_to_test(0, col);

			map.display_on_out();
		}

		input.close();
	}
}
