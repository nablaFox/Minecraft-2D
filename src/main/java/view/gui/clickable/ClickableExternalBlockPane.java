package view.gui.clickable;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import data.blocks.interfaces.Block;
import view.gui.BlockPane;

public class ClickableExternalBlockPane extends BlockPane {
	public ClickableExternalBlockPane(
			Block block,
			EventHandler<MouseEvent> event) {

		super(block);
		this.setOnMouseClicked(event);
	}
}
