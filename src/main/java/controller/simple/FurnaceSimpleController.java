package controller.simple;

import view.gui.FurnacePane;
import view.gui.clickable.ClickableInternalBlockPane;
import data.model.Furnace;

public class FurnaceSimpleController implements SimpleController {
	Furnace furnace;
	FurnacePane furnace_pane;
	MainSimpleController controller;

	public FurnaceSimpleController(
			Furnace furnace,
			FurnacePane furnace_pane,
			MainSimpleController controller) {
		this.furnace = furnace;
		this.furnace_pane = furnace_pane;
		this.controller = controller;

		redraw();
	}

	public void redraw() {
		furnace_pane.getChildren().clear();
		furnace_pane.add_text();
		furnace_pane.getChildren().add(
				new ClickableInternalBlockPane(
						furnace.get_input(), controller));
		furnace_pane.add_arrow();
		furnace_pane.getChildren().add(
				new ClickableInternalBlockPane(
						furnace.get_output(), controller));
	}
}
