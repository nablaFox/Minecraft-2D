package controller.textual;

import data.model.MainModel;
import utils.MapCoordinates;
import view.textual.FurnacePrinter;
import view.textual.InventoryPrinter;
import view.textual.MainPrinter;
import view.textual.MapPrinter;

public class MainTextController extends AbstractTextController {
	MainModel main_model;

	FurnaceTextController furnace_controller;
	InventoryTextController inventory_controller;
	MapTextController map_controller;

	public MainTextController(boolean random) {
		super();

		this.main_model = new MainModel(random);
		this.printer = new MainPrinter();
		this.furnace_controller = new FurnaceTextController(main_model.get_furnace());
		this.inventory_controller = new InventoryTextController(main_model.get_inventory());
		this.map_controller = new MapTextController(main_model.get_map());
	}

	public void update_printer() {
		furnace_controller.update_printer();
		inventory_controller.update_printer();
		map_controller.update_printer();
		((MainPrinter) printer).update(
				(MapPrinter) map_controller.get_printer(),
				(InventoryPrinter) inventory_controller.get_printer(),
				(FurnacePrinter) furnace_controller.get_printer());
	}

	public void smelt() {
		main_model.smelt();
	}

	public void move_into_furnace_from_inventory(int index) {
		main_model.move_into_furnace_from_inventory(index);
	}

	public void move_into_inventory_from_furnace() {
		main_model.move_into_inventory_from_furnace();
	}

	public void change_cell_to_test(MapCoordinates coords) {
		main_model.change_cell_to_test(coords);
	}

	public void pick_up_block(MapCoordinates coords) {
		main_model.pick_up_block(coords);
	}
}
