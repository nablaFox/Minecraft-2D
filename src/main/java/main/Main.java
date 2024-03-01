package main;

import utils.MapCoordinates;
import visual.MainGui;

import java.util.Scanner;

public class Main {
	private static final int INTERACTIONS = 6;

	public static void main(String[] args) {
		// test_gravity();
		// change_at_coords();
		test_smelting();
	}

	private static void test_smelting() {
		MainGui gui = new MainGui();
		gui.display_on_out();

		Scanner input = new Scanner(System.in);

		for (int i = 0; i < INTERACTIONS; i++) {
			System.out.println("Enter row and column, (9, 9) to smelt");
			int row = input.nextInt();
			int col = input.nextInt();

			if (row == 9 && col == 9) {
				gui.smelt();
			} else {
				gui.move_into_furnace(new MapCoordinates(row, col));
			}

			gui.display_on_out();
		}

		input.close();
	}

	private static void test_gravity() {
		MainGui gui = new MainGui();
		gui.display_on_out();

		Scanner input = new Scanner(System.in);

		for (int i = 0; i < INTERACTIONS; i++) {
			System.out.println("Col: ");
			int col = input.nextInt();

			System.out.println("Dropping a new block in the col: " + col);
			gui.change_cell_to_test(new MapCoordinates(0, col));

			gui.display_on_out();
		}

		input.close();
	}

	private static void change_at_coords() {
		MainGui gui = new MainGui();
		gui.display_on_out();

		Scanner input = new Scanner(System.in);

		for (int i = 0; i < INTERACTIONS; i++) {
			System.out.println("Row: ");
			int row = input.nextInt();

			System.out.println("Col: ");
			int col = input.nextInt();

			System.out.println("Changing the block at row: " + row + " and col: " + col);
			gui.change_cell_to_test(new MapCoordinates(row, col));

			gui.display_on_out();
		}

		input.close();
	}
}
