package controller.simple;

import view.gui.BlockPane;
import view.gui.InventoryPane;
import data.model.Inventory;

public class InventorySimpleController implements SimpleController {
	Inventory inventory;
	InventoryPane inventory_pane;
	MainSimpleController controller;

	public InventorySimpleController(
			Inventory inventory,
			InventoryPane inventory_pane) {
		this.inventory = inventory;
		this.inventory_pane = inventory_pane;

		redraw();
	}

	public void redraw() {
		System.out.println("update inventory");

		for (int i = 0; i < inventory.get_size(); i++) {
			inventory_pane.getChildren().add(
					new BlockPane(inventory.get_block(i)));
		}
	}
}
