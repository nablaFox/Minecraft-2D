package data;

import java.util.Random;

import data.blocks.*;
import data.blocks.interfaces.Block;

public class BlockFactory {
	private static final int RAND_UPPERBOUND = 5;

	public BlockFactory() {
	}

	public Block random_block() {
		Random rand = new Random();
		int seed = rand.nextInt(RAND_UPPERBOUND);

		switch (seed) {
			case 0:
				return new SandBlock();
			case 1:
				return new WaterBlock();
			case 2:
				return new AirBlock();
			default:
				return this.null_block();
		}
	}

	public SandBlock sand_block() {
		return new SandBlock();
	}

	public WaterBlock water_block() {
		return new WaterBlock();
	}

	public AirBlock default_block() {
		return new AirBlock();
	}

	public Block test_block() {
		return new SandBlock();
	}

	public NullBlock null_block() {
		return new NullBlock();
	}
}
