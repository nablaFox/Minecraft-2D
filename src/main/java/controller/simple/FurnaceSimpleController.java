package controller.simple;

import view.gui.BlockPane;
import view.gui.FurnacePane;
import data.model.Furnace;

public class FurnaceSimpleController implements SimpleController {
	Furnace furnace;
	FurnacePane furnace_pane;

	public FurnaceSimpleController(Furnace furnace, FurnacePane furnace_pane) {
		this.furnace = furnace;
		this.furnace_pane = furnace_pane;
		redraw();
	}

	public void redraw() {
		furnace_pane.getChildren().clear();
		furnace_pane.add_text();
		furnace_pane.getChildren().add(
				new BlockPane(furnace.get_input()));
		furnace_pane.add_arrow();
		furnace_pane.getChildren().add(
				new BlockPane(furnace.get_output()));
	}

}
