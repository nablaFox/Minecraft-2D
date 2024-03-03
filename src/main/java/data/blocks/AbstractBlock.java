package data.blocks;

import data.blocks.interfaces.Block;

public abstract class AbstractBlock implements Block {
	protected String blockname;
	protected char content;
	protected boolean falls_with_gravity;
	protected boolean fall_through;
	protected boolean pickable;
	protected boolean destroyable_with_torch;

	public AbstractBlock(
			String blockname,
			char content,
			boolean falls_with_gravity,
			boolean fall_through) {
		this.blockname = blockname;
		this.content = content;
		this.falls_with_gravity = falls_with_gravity;
		this.fall_through = fall_through;
		this.pickable = true;
		this.destroyable_with_torch = false;
	}

	public char display() {
		return content;
	}

	public boolean it_falls_with_gravity() {
		return falls_with_gravity;
	}

	public boolean it_falls_through() {
		return fall_through;
	}

	public boolean is_pickable() {
		return pickable;
	}

	public boolean is_destroyable_with_torch() {
		return destroyable_with_torch;
	}

	public String display_in_inventory() {
		return "[" + content + "]";
	}

	@Override
	public String toString() {
		return blockname + " [" + content + "]";
	}
}
