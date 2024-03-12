package controller.simple;

import java.util.Iterator;

import view.gui.InventoryPane;
import view.gui.clickable.ClickableAnonBlockPane;
import data.model.Inventory;
import data.blocks.interfaces.Block;

public class InventorySimpleController implements SimpleController {
	Inventory inventory;
	InventoryPane inventory_pane;
	MainSimpleController controller;

	public InventorySimpleController(
			Inventory inventory,
			InventoryPane inventory_pane,
			MainSimpleController controller) {
		this.inventory = inventory;
		this.inventory_pane = inventory_pane;
		this.controller = controller;

		redraw();
	}

	public void redraw() {
		System.out.println("update inventory");

		inventory_pane.getChildren().clear();
		inventory_pane.add_text();
		Iterator<Block> it = inventory.get_iterator();

		int index = 0;
		while (it.hasNext()) {
			Block block = it.next();
			ClickableAnonBlockPane block_pane = new ClickableAnonBlockPane(
					block,
					controller,
					index);
			inventory_pane.getChildren().add(block_pane);
			index++;
		}
	}
}
