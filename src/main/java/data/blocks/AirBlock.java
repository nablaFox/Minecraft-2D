package data.blocks;

public class AirBlock extends AbstractBlock {
	public AirBlock() {
		super("Air", '.', false, true);
		this.pickable = false;
	}
}
