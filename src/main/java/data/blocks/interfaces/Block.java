package data.blocks.interfaces;

public interface Block extends InventoryBlock {
	char display();

	boolean it_falls_with_gravity();

	boolean it_falls_through();

	boolean is_pickable();

	boolean is_destroyable_with_torch();
}
