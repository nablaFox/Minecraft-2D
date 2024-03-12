package view.gui.handlers;

import controller.simple.MainSimpleController;
import utils.MapCoordinates;

public class BlockPaneClickHandlerFactory {
	MainSimpleController controller;

	public BlockPaneClickHandlerFactory(MainSimpleController controller) {
		this.controller = controller;
	}

	public BlockPanePickUpClickHandler create_pick_up_handler(MapCoordinates coords) {
		return new BlockPanePickUpClickHandler(controller, coords);
	}
}
