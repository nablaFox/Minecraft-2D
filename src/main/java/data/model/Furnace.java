package data.model;

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
		furnace_input = bf.null_block();
		furnace_output = furnace_input.smelt();
	}

	private void reset_furnace() {
		furnace_input = bf.null_block();
		furnace_output = bf.null_block();
	}

	public void setInput(SmeltableBlock smeltable) {
		furnace_input = smeltable;
		furnace_output = smeltable.smelt();
	}

	public Block smelt() {
		if (furnace_input instanceof NullBlock)
			return furnace_input;

		System.out.println(
				"Smelting " + furnace_input.toString()
						+ " into " + furnace_output.toString());

		Block smelted = furnace_output;
		reset_furnace();
		return smelted;
	}

	public SmeltableBlock get_input() {
		SmeltableBlock input = furnace_input;
		reset_furnace();
		return input;
	}

	public SmeltableBlock get_output() {
		return (SmeltableBlock) furnace_output;
	}
}
