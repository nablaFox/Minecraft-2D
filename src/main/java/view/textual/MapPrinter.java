package view.textual;

import utils.MapCoordinates;
import data.blocks.interfaces.Block;

public class MapPrinter implements TextPrinter {
	private Block[][] content;

	public void update(Block[][] content) {
		this.content = content;
	}

	public void display_on_out() {
		System.out.println("|============|");
		for (int i = 0; i < MapCoordinates.DIMENSION_ROWS; i++) {
			System.out.print("||");
			for (int k = 0; k < MapCoordinates.DIMENSION_COLUMNS; k++)
				System.out.print(content[i][k].display());
			System.out.print("||");
			System.out.println();
		}
		System.out.println("|============|");
	}
}
