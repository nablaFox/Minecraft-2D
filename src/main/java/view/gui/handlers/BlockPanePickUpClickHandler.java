package view.gui.handlers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import controller.simple.MainSimpleController;
import utils.MapCoordinates;

public class BlockPanePickUpClickHandler implements EventHandler<MouseEvent> {
	private MainSimpleController controller;
	private MapCoordinates coords;

	public BlockPanePickUpClickHandler(
			MainSimpleController controller,
			MapCoordinates coords) {
		this.controller = controller;
		this.coords = coords;
	}

	public void handle(MouseEvent event) {
		controller.pick_up_block(coords);
	}
}
