package view.gui.clickable;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import view.gui.BlockPane;
import controller.simple.MainSimpleController;
import data.blocks.interfaces.Block;

// each clicked block will move blocks from inventory to furnace
public class ClickableAnonBlockPane extends BlockPane {
	public ClickableAnonBlockPane(
			Block block,
			MainSimpleController controller,
			int index) {
		super(block);
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				controller.move_into_furnace_from_inventory(index);
			}
		});
	}
}
