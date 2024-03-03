package data.blocks.utils;

import data.blocks.interfaces.Block;

public class AlphabeticalBlockComparator implements java.util.Comparator<Block> {
	@Override
	public int compare(Block b1, Block b2) {
		return b1.toString().compareTo(b2.toString());
	}
}
