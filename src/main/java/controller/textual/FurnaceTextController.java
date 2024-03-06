package controller.textual;

import view.textual.FurnacePrinter;
import data.model.Furnace;

public class FurnaceTextController extends AbstractTextController {
	Furnace furnace;

	public FurnaceTextController(Furnace furnace) {
		super();
		this.printer = new FurnacePrinter();
		this.furnace = furnace;
	}

	public void update_printer() {
		((FurnacePrinter) printer).update(
				furnace.get_input(),
				furnace.get_output());
	}
}
