package view.gui;

import data.BlockFactory;
import data.blocks.interfaces.Block;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import utils.MapCoordinates;

public class MapPane extends GridPane {
	public MapPane() {
		super();
		initialize_air();
	}

	public void initialize_air() {
		for (int i = 0; i < MapCoordinates.DIMENSION_ROWS; i++) {
			for (int j = 0; j < MapCoordinates.DIMENSION_COLUMNS; j++) {
				super.add(
						new BlockPane(new BlockFactory().default_block()),
						j, i);
			}
		}
	}

	public BlockPane get_block_at_coord(MapCoordinates coords) {
		if (!coords.is_inbound())
			return null;

		return (BlockPane) MapPane.get_element_at(
				this,
				coords.get_row(),
				coords.get_col());
	}

	public void set_cell(MapCoordinates coords, Block block) {
		if (!coords.is_inbound())
			return;

		BlockPane to_replace = get_block_at_coord(coords);

		if (to_replace == null)
			super.add(new BlockPane(block), coords.get_col(), coords.get_row());
		else
			to_replace.change_block(block);
	}

	public static Node get_element_at(GridPane gp, int i, int j) {
		for (Node x : gp.getChildren()) {
			if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
				return x;
			}
		}
		return null;
	}
}
