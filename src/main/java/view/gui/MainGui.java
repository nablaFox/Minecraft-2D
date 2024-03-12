package view.gui;

import controller.simple.MainSimpleController;
import javafx.scene.layout.BorderPane;
import view.gui.handlers.BlockPaneClickHandlerFactory;

public class MainGui extends BorderPane {
	public MainGui(MainSimpleController controller) {
		super();

		setCenter(
				new MapPane(new BlockPaneClickHandlerFactory(controller)));
		setLeft(new ButtonListPane(controller));
		setBottom(new InventoryPane());
		setRight(new FurnacePane());
	}

	public MapPane get_map_pane() {
		return (MapPane) getCenter();
	}

	public FurnacePane get_furnace_pane() {
		return (FurnacePane) getRight();
	}

	public InventoryPane get_inventory_pane() {
		return (InventoryPane) getBottom();
	}
}
