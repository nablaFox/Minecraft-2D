package visual;

import data.BlockFactory;
import data.blocks.NullBlock;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class Furnace {
	SmeltableBlock furnace_input;
	Block furnace_output;
	BlockFactory bf;

	public Furnace(BlockFactory bf) {
		this.bf = bf;
		this.furnace_input = this.bf.null_block();
		this.furnace_output = furnace_input.smelt();
	}

	public void display_on_out() {
		System.out.println("|| "
				+ this.furnace_input.display()
				+ " --> "
				+ this.furnace_output.display()
				+ " ||");
	}

	public void move_into_furnace(int row, int col, Map map) {
		if (!map.is_smeltable(row, col)) {
			System.out.println("Selection is not smeltable!");
			return;
		}

		this.furnace_input = map.get_smeltable(row, col);
		this.furnace_output = this.furnace_input.smelt();
	}

	public void smelt() {
		if (this.furnace_input instanceof NullBlock)
			return;

		System.out.println(
				"Smelting " + this.furnace_input.toString()
						+ " into " + this.furnace_output.toString());
		furnace_output = furnace_input.smelt();
		furnace_input = bf.null_block();
	}

	public void set_input(SmeltableBlock block) {
		furnace_input = block;
	}
}
