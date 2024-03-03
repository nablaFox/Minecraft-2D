package data.blocks;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class NullBlock extends AbstractBlock implements SmeltableBlock {
	public NullBlock() {
		super("null", ' ', false, false);
		this.pickable = false;
	}

	@Override
	public Block smelt() {
		return new NullBlock();
	}
}
