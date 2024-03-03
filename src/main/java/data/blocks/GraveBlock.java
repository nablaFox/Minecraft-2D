package data.blocks;

public class GraveBlock extends AbstractBlock {
	public GraveBlock() {
		super("Grave", 'G', true, false);
		this.destroyable_with_torch = true;
	}
}
