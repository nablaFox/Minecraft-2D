package data.blocks;

import data.blocks.interfaces.SmeltableBlock;
import data.blocks.interfaces.Block;
import data.blocks.solids.GlassBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
	public SandBlock() {
		super("Sand", 'S', true, false);
		this.destroyable_with_torch = true;
	}

	public Block smelt() {
		return new GlassBlock();
	}
}
