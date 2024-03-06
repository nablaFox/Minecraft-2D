package view.textual;

public class MainPrinter implements TextPrinter {
	MapPrinter map;
	InventoryPrinter inventory;
	FurnacePrinter furnace;

	public void update(
			MapPrinter map,
			InventoryPrinter inventory,
			FurnacePrinter furnace) {
		this.map = map;
		this.inventory = inventory;
		this.furnace = furnace;
	}

	public void display_on_out() {
		map.display_on_out();
		System.out.println();
		inventory.display_on_out();
		System.out.println();
		furnace.display_on_out();
	}
}
