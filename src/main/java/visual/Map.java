package visual;

import java.util.Random;

import utils.MapCoordinates;
import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.AbstractBlock;

public class Map {
	private static final int RANDOM_BLOCKS = 8;

	private Block[][] content;
	private BlockFactory bf;

	public Map(BlockFactory bf) {
		this(bf, true);
	}

	public Map(BlockFactory bf, boolean random) {
		this.bf = bf;

		content = new AbstractBlock[MapCoordinates.DIMENSION_ROWS][MapCoordinates.DIMENSION_COLUMNS];
		bf = new BlockFactory();

		make_default_map(random);
	}

	private void make_default_map(boolean random) {
		for (int i = 0; i < MapCoordinates.DIMENSION_ROWS; i++) {
			for (int j = 0; j < MapCoordinates.DIMENSION_COLUMNS; j++) {
				insert_block_at_coords(
						bf.default_block(),
						new MapCoordinates(i, j),
						false);
			}
		}

		add_sea();

		if (random)
			add_random_blocks();
	}

	private void add_random_blocks() {
		Random rand = new Random();
		for (int i = 0; i < RANDOM_BLOCKS; i++) {
			Block block = bf.sand_block();
			int row = rand.nextInt(MapCoordinates.DIMENSION_ROWS);
			int col = rand.nextInt(MapCoordinates.DIMENSION_COLUMNS);

			insert_block_at_coords(block, new MapCoordinates(row, col), true);
		}
	}

	private void set_block_at_coords(MapCoordinates coords, Block block) {
		content[coords.get_row()][coords.get_col()] = block;
	}

	private void insert_block_at_coords(
			Block block,
			MapCoordinates coords,
			boolean stack) {
		if (!coords.is_inbound())
			return;

		set_block_at_coords(coords, block);

		if (stack)
			move(coords);
	}

	private void move(MapCoordinates coords) {
		int index = coords.get_row();
		int col = coords.get_col();

		while (index < MapCoordinates.DIMENSION_ROWS - 1
				&& content[index][col].it_falls_with_gravity()
				&& content[index + 1][col].it_falls_through()) {
			swap(new MapCoordinates(index, coords.get_col()));
			index++;
		}
	}

	private void swap(MapCoordinates coords) {
		if (!coords.is_inbound())
			return;

		int row = coords.get_row();
		int col = coords.get_col();

		Block tmp = content[row][col];
		content[row][col] = content[row + 1][col];
		content[row + 1][col] = tmp;
	}

	private void add_rows_of_water(int num) {
		if (num >= MapCoordinates.DIMENSION_ROWS)
			return;

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < MapCoordinates.DIMENSION_COLUMNS; j++) {
				insert_block_at_coords(
						bf.water_block(),
						new MapCoordinates(i, j),
						true);
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

	public Block get_block(MapCoordinates coords) {
		return content[coords.get_row()][coords.get_col()];
	}

	public boolean is_smeltable(MapCoordinates coords) {
		return get_block(coords) instanceof SmeltableBlock;
	}

	public SmeltableBlock get_smeltable(MapCoordinates coords) {
		if (!is_smeltable(coords))
			return bf.null_block();

		SmeltableBlock smeltable = (SmeltableBlock) get_block(coords);
		set_block_at_coords(coords, bf.default_block());
		return smeltable;
	}

	public void change_cell_to_test(MapCoordinates coords) {
		if (!coords.is_inbound())
			return;
		insert_block_at_coords(bf.test_block(), coords, true);
	}

	public void display_on_out() {
		System.out.println("|============|");
		for (int i = 0; i < MapCoordinates.DIMENSION_ROWS; i++) {
			System.out.print("||");
			for (int k = 0; k < MapCoordinates.DIMENSION_COLUMNS; k++)
				System.out.print(content[i][k].display());
			System.out.print("||");
			System.out.println();
		}
		System.out.println("|============|");
	}
}
