package view.textual;

import java.util.Iterator;
import data.blocks.interfaces.Block;

public class InventoryPrinter implements TextPrinter {
	private Iterator<Block> iterator;
	// TODO: add comparator

	public void display_on_out() {
		while (iterator.hasNext())
			System.out.println(iterator.next().display_in_inventory());
	}

	public void update(Iterator<Block> iterator) {
		this.iterator = iterator;
	}
}
