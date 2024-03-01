package data.blocks;

import data.blocks.interfaces.Block;

public abstract class AbstractBlock implements Block {
	protected String blockname;
	protected char content;
	protected boolean falls_with_gravity;
	protected boolean fall_through;

	public AbstractBlock(
			String blockname,
			char content,
			boolean falls_with_gravity,
			boolean fall_through) {
		this.blockname = blockname;
		this.content = content;
		this.falls_with_gravity = falls_with_gravity;
		this.fall_through = fall_through;
	}

	public char display() {
		return this.content;
	}

	public boolean it_falls_with_gravity() {
		return this.falls_with_gravity;
	}

	public boolean it_falls_through() {
		return this.fall_through;
	}

	@Override
	public String toString() {
		return this.blockname + " [" + this.content + "]";
	}
}
