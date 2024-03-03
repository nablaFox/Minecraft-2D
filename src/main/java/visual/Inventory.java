package visual;

import data.blocks.interfaces.Block;
import data.blocks.interfaces.SmeltableBlock;
import data.blocks.utils.AlphabeticalBlockComparator;
import data.blocks.utils.BlockComparator;
import utils.BlockErrorException;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
	private ArrayList<Block> blocks;
	private Comparator<Block> comparator;

	public Inventory() {
		blocks = new ArrayList<Block>();
		comparator = new BlockComparator();
	}

	private void sort_inventory() {
		blocks.sort(comparator);
	}

	private boolean has_index(int index) {
		return index >= 0 && index < blocks.size();
	}

	public void add_block(Block block) {
		blocks.add(block);
		sort_inventory();
	}

	// TODO: create a custom exception for this
	public Block get_block(int index) throws IndexOutOfBoundsException {
		if (!has_index(index))
			throw new IndexOutOfBoundsException();

		return blocks.remove(index);
	}

	private boolean is_smeltable(int index) throws IndexOutOfBoundsException {
		if (!has_index(index))
			throw new IndexOutOfBoundsException();

		return blocks.get(index) instanceof SmeltableBlock;
	}

	public SmeltableBlock get_smeltable(int index) throws BlockErrorException {
		if (!is_smeltable(index))
			throw new BlockErrorException();

		return (SmeltableBlock) blocks.remove(index);
	}

	public void display_on_out() {
		Iterator<Block> iterator = blocks.iterator();

		while (iterator.hasNext())
			System.out.println(iterator.next().display_in_inventory());
	}

	public void toggle_comparator() {
		comparator = comparator instanceof BlockComparator ? new AlphabeticalBlockComparator() : new BlockComparator();
	}
}
