package data;

import java.util.Random;

import data.blocks.*;
import data.blocks.solids.*;
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
				return sand_block();
			case 1:
				return raw_iron_block();
			case 2:
				return earth_block();
			default:
				return default_block();
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

	public RawIronBlock raw_iron_block() {
		return new RawIronBlock();
	}

	public GlassBlock glass_block() {
		return new GlassBlock();
	}

	public TorchBlock torch_block() {
		return new TorchBlock();
	}

	public EarthBlock earth_block() {
		return new EarthBlock();
	}

	public Block test_block() {
		return new SandBlock();
	}

	public NullBlock null_block() {
		return new NullBlock();
	}
}
