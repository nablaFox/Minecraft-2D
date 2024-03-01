package visual;

import data.BlockFactory;

public class MainGui {
	private Furnace furnace;
	private Map map;
	private BlockFactory bf; // we inject this

	public MainGui() {
		this(true);
	}

	public MainGui(boolean random) {
		bf = new BlockFactory();
		map = new Map(bf, random);
		furnace = new Furnace(bf);
	}

	public void display_on_out() {
		map.display_on_out();
		print_separator();
		furnace.display_on_out();
	}

	private static void print_separator() {
		System.out.print("|");
		// TODO: change the hard-coded value with MapCoordinates
		for (int i = 0; i < 10; i++) {
			System.out.print("=");
		}
		System.out.print("|");
		System.out.println();
	}

	public void smelt() {
		furnace.smelt();
	}

	public void change_cell_to_test(int row, int col) {
		map.change_cell_to_test(row, col);
	}

	public void move_into_furnace(int row, int col) {
		furnace.move_into_furnace(row, col, map);
	}
}