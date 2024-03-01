package data;

// Question: why don't initialize the variables directly with the defaults?
// Answer: because in this way we cannot have the isDefault() method

// Note: the default blocks does not falls with gravity and they do not stack

public class Block {
	private char content;
	private boolean falls_with_gravity;
	private boolean fall_through; // stackable

	private static final char DEFAULT_CONTENT = '.';
	private static final boolean DEFAULT_FALLS_WITH_GRAVITY = true;

	public Block(int seed) {
		super(); // call Block()

		this.falls_with_gravity = true;
		switch (seed) {
			case 0:
				content = 'X';
				break;
			case 1:
				content = '+';
				break;
			case 2:
				content = 'o';
				break;
			default:
				content = Block.DEFAULT_CONTENT;
				this.falls_with_gravity = false;
		}

		this.set_fall_trhough();
	}

	public Block(char content) {
		super();
		this.content = content;
		this.falls_with_gravity = true;
		this.set_fall_trhough();
	}

	public Block() {
		this.content = Block.DEFAULT_CONTENT;
		this.falls_with_gravity = Block.DEFAULT_FALLS_WITH_GRAVITY;
		this.set_fall_trhough();
	}

	private void set_fall_trhough() {
		this.fall_through = this.isDefault();
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

	public boolean isDefault() {
		return this.content == DEFAULT_CONTENT;
	}
}
