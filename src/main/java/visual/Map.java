package visual;

import data.Block;
import data.BlockFactory;

// Note: move a block only if it is random 
// because if it is random it falls with gravity

public class Map {
	private static final int DIMENSION_COLUMNS = 10; // final = const
	private static final int DIMENSION_ROWS = 5;

	private Block[][] content;
	private BlockFactory bf;

	public Map() {
		// this() stands for the constructor
		this(true);
	}

	public Map(boolean random) {
		content = new Block[DIMENSION_ROWS][DIMENSION_COLUMNS];
		bf = new BlockFactory();

		for (int i = 0; i < DIMENSION_ROWS; i++) {
			for (int j = 0; j < DIMENSION_COLUMNS; j++) {
				Block block = null;

				block = random ? bf.random_block() : bf.default_block();

				insert_block_at_coords(block, i, j, random);
			}
		}
	}

	private void insert_block_at_coords(
			Block block,
			int row,
			int col,
			boolean random) {
		this.content[row][col] = block;

		if (!random)
			return;

		this.move(row, col);
	}

	private void move(int row, int col) {
		int index = row;

		while (index < DIMENSION_ROWS - 1
				&& this.content[index][col].it_falls_with_gravity()
				&& this.content[index + 1][col].it_falls_through()) {
			this.swap(index, col);
			index++;
		}
	}

	private void swap(int row, int col) {
		Block tmp = this.content[row][col];
		this.content[row][col] = this.content[row + 1][col];
		this.content[row + 1][col] = tmp;
	}

	public void change_chell_to_test(int row, int col) {
		if (row >= DIMENSION_ROWS || col >= DIMENSION_COLUMNS)
			return;

		this.insert_block_at_coords(bf.test_block(), row, col, true);
	}

	public void display_on_out() {
		System.out.println("|============|");
		for (int i = 0; i < DIMENSION_ROWS; i++) {
			System.out.print("||");
			for (int k = 0; k < DIMENSION_COLUMNS; k++)
				System.out.print(this.content[i][k].display());
			System.out.print("||");
			System.out.println();
		}
		System.out.println("|============|");
	}
}
