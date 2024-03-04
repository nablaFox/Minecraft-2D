package main;

import utils.MapCoordinates;
import visual.textual.MainGui;

import java.util.Scanner;

public class Main {
	private static final int INTERACTIONS = 6;

	public static void main(String[] args) {
		test_gravity();
		// change_at_coords();
		// test_picking();
		// test_single_pickup();
	}

	private static void test_single_pickup() {
		MainGui gui = new MainGui();
		gui.display_on_out();
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < INTERACTIONS; i++) {
			System.out.println("Enter row and then column to pick that block");
			int row = input.nextInt();
			int col = input.nextInt();
			MapCoordinates c = new MapCoordinates(row, col);
			gui.pick_up_block(c);
			gui.display_on_out();
		}

		input.close();
	}

	private static void test_picking() {
		MainGui gui = new MainGui();
		gui.display_on_out();
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < INTERACTIONS; i++) {
			System.out.println("Enter row and then column to pick that block");
			System.out.println("Enter '9' and the item number to move the item to the furnace");
			System.out.println("Enter '99' and then '9' to smelt");
			System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
			System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
			int row = input.nextInt();
			int col = input.nextInt();
			if (row == 9) {
				gui.move_into_furnace_from_inventory(col);
			} else if (row == 99) {
				if (col == 9) {
					gui.smelt();
				} else if (col == 0) {
					gui.toggle_inventory_comparator();
				} else {
					gui.move_into_inventory_from_furnace();
				}
			} else {
				MapCoordinates c = new MapCoordinates(row, col);
				gui.pick_up_block(c);
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
