package data;

import java.util.Random;

public class BlockFactory {
	private static final int RAND_UPPERBOUND = 5;

	public BlockFactory() {
	}

	public Block random_block() {
		Random rand = new Random();
		int seed = rand.nextInt(RAND_UPPERBOUND);
		return new Block(seed);
	}

	public Block default_block() {
		return new Block();
	}

	public Block test_block() {
		return new Block('A');
	}
}
