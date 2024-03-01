package visual;

import java.util.Random;

import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.AbstractBlock;

public class Map {
	private static final int DIMENSION_COLUMNS = 10;
	private static final int DIMENSION_ROWS = 5;
	private static final int RANDOM_BLOCKS = 8;

	private Block[][] content;
	private BlockFactory bf;

	public Map(BlockFactory bf) {
		this(bf, true);
	}

	public Map(BlockFactory bf, boolean random) {
		this.bf = bf;

		content = new AbstractBlock[DIMENSION_ROWS][DIMENSION_COLUMNS];
		bf = new BlockFactory();

		make_default_map(random);
	}

	private void make_default_map(boolean random) {
		for (int i = 0; i < DIMENSION_ROWS; i++) {
			for (int j = 0; j < DIMENSION_COLUMNS; j++) {
				insert_block_at_coords(bf.default_block(), i, j, false);
			}
		}

		this.add_sea();

		if (random)
			add_random_blocks();
	}

	private void add_random_blocks() {
		Random rand = new Random();
		for (int i = 0; i < RANDOM_BLOCKS; i++) {
			Block block = bf.sand_block();
			int row = rand.nextInt(DIMENSION_ROWS);
			int col = rand.nextInt(DIMENSION_COLUMNS);

			insert_block_at_coords(block, row, col, true);
		}
	}

	private void insert_block_at_coords(
			Block block,
			int row,
			int col,
			boolean stack) {
		this.content[row][col] = block;

		if (!stack)
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

	private void add_rows_of_water(int num) {
		if (num >= DIMENSION_ROWS)
			return;

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < DIMENSION_COLUMNS; j++) {
				insert_block_at_coords(bf.water_block(), i, j, true);
			}
		}
	}

	public void add_river() {
		add_rows_of_water(1);
	}

	public void add_sea() {
		add_river();
		add_river();
	}

	public boolean is_smeltable(int row, int col) {
		return content[row][col] instanceof SmeltableBlock;
	}

	public SmeltableBlock get_smeltable(int row, int col) {
		if (!is_smeltable(row, col))
			return bf.null_block();

		content[row][col] = bf.default_block();
		return (SmeltableBlock) content[row][col];
	}

	public void change_cell_to_test(int row, int col) {
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
