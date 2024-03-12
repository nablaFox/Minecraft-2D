package view.gui.clickable;

import controller.simple.MainSimpleController;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import view.gui.BlockPane;

public class ClickableInternalBlockPane extends BlockPane {
	public ClickableInternalBlockPane(
			Block block,
			MainSimpleController controller) {
		super(block);

		EventHandler<MouseEvent> event = block instanceof SmeltableBlock ? new SmeltBlockHandler(controller)
				: new MoveToInventoryHandler(controller);

		setOnMouseClicked(event);
	}

	class SmeltBlockHandler implements EventHandler<MouseEvent> {
		private MainSimpleController controller;

		public SmeltBlockHandler(MainSimpleController controller) {
			this.controller = controller;
		}

		@Override
		public void handle(MouseEvent event) {
			controller.smelt();
		}
	}

	class MoveToInventoryHandler implements EventHandler<MouseEvent> {
		private MainSimpleController controller;

		public MoveToInventoryHandler(MainSimpleController controller) {
			this.controller = controller;
		}

		@Override
		public void handle(MouseEvent event) {
			controller.move_into_inventory_from_furnace();
		}
	}
}
