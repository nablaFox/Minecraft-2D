package visual;

import utils.BlockErrorException;
import utils.MapCoordinates;
import data.BlockFactory;
import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;

public class MainGui {
	private Furnace furnace;
	private Map map;
	private BlockFactory bf;
	private Inventory inventory;

	public MainGui() {
		this(true);
	}

	public MainGui(boolean random) {
		bf = new BlockFactory();
		map = new Map(bf, random);
		furnace = new Furnace(bf);
		inventory = new Inventory();
	}

	public void display_on_out() {
		map.display_on_out();
		System.out.println();
		inventory.display_on_out();
		System.out.println();
		furnace.display_on_out();
	}

	public void smelt() {
		Block block = furnace.smelt();
		inventory.add_block(block);
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
			SmeltableBlock smeltable = inventory.get_smeltable(index);
			furnace.setInput(smeltable);
		} catch (BlockErrorException e) {
			System.out.println("Not smeltable");
		}
	}

	public void toggle_inventory_comparator() {
		inventory.toggle_comparator();
	}

	// TODO: remove this
	public void change_cell_to_test(MapCoordinates coords) {
		map.change_cell_to_test(coords);
	}
}
