package controller.simple;

import java.util.Collection;

import utils.MapCoordinates;

import java.util.ArrayList;

import view.gui.MainGui;
import data.model.MainModel;

public class MainSimpleController implements SimpleController {
	MainGui main_gui;
	MainModel main_model;
	Collection<SimpleController> controllers;

	public MainSimpleController(MainModel main_model) {
		this.main_model = main_model;
		this.main_gui = new MainGui(this);

		SimpleController map_controller = new MapSimpleController(
				main_model.get_map(), main_gui.get_map_pane());

		SimpleController furnace_controller = new FurnaceSimpleController(
				main_model.get_furnace(), main_gui.get_furnace_pane());

		SimpleController inventory_controller = new InventorySimpleController(
				main_model.get_inventory(), main_gui.get_inventory_pane());

		controllers = new ArrayList<SimpleController>();
		controllers.add(map_controller);
		controllers.add(furnace_controller);
		controllers.add(inventory_controller);
	}

	public void smelt() {
		main_model.smelt();
		redraw();
	}

	public void move_into_furnace_from_inventory(int index) {
		main_model.move_into_furnace_from_inventory(index);
		redraw();
	}

	public void move_into_inventory_from_furnace() {
		main_model.move_into_inventory_from_furnace();
		redraw();
	}

	public void pick_up_block(MapCoordinates coords) {
		main_model.pick_up_block(coords);
		redraw();
	}

	public MainGui get_main_gui() {
		return main_gui;
	}

	public void redraw() {
		for (SimpleController controller : controllers) {
			controller.redraw();
		}
	}
}
