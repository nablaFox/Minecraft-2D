package data.model;

import utils.BlockErrorException;
import utils.MapCoordinates;
import data.BlockFactory;

public class MainModel {
	private Furnace furnace;
	private Map map;
	private BlockFactory bf;
	private Inventory inventory;

	public MainModel() {
		this(true);
	}

	public MainModel(boolean random) {
		bf = new BlockFactory();
		map = new Map(bf, random);
		furnace = new Furnace(bf);
		inventory = new Inventory();
	}

	public void smelt() {
		inventory.add_block(furnace.smelt());
	}

	public void pick_up_block(MapCoordinates coords) {
		try {
			inventory.add_block(map.get_pickable(coords));
		} catch (BlockErrorException e) {
			System.out.println("Not pickable");
		}
	}

	public void move_into_inventory_from_furnace() {
		inventory.add_block(furnace.get_input());
	}

	public void move_into_furnace_from_inventory(int index) {
		try {
			furnace.set_input(inventory.get_smeltable(index));
		} catch (BlockErrorException e) {
			System.out.println("Not smeltable");
		}
	}

	public void toggle_inventory_comparator() {
		inventory.toggle_comparator();
	}

	public Map get_map() {
		return map;
	}

	public Furnace get_furnace() {
		return furnace;
	}

	public Inventory get_inventory() {
		return inventory;
	}

	// TODO: remove this
	public void change_cell_to_test(MapCoordinates coords) {
		map.change_cell_to_test(coords);
	}
}
