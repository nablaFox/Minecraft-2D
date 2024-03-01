package data.blocks.solids;

import data.blocks.AbstractBlock;

public abstract class AbstractSolidBlock extends AbstractBlock {
	AbstractSolidBlock(String blockname, char content) {
		super(blockname, content, false, false);
	}
}
