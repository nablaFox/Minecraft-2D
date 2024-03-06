package controller.textual;

import view.textual.InventoryPrinter;
import data.model.Inventory;

public class InventoryTextController extends AbstractTextController {
	Inventory inventory;

	public InventoryTextController(Inventory inventory) {
		super();
		this.printer = new InventoryPrinter();
		this.inventory = inventory;
	}

	public void update_printer() {
		((InventoryPrinter) printer).update(inventory.get_iterator());
	}
}
