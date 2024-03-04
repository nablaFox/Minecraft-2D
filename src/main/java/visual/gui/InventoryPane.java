package visual.gui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class InventoryPane extends HBox {
	private Text text;
	private HBox inventory;

	public InventoryPane() {
		super();
		add_text();
		add_inventory();
	}

	private void add_inventory() {
		inventory = new HBox();
		getChildren().add(inventory);
	}

	public void add_to_inventory(BlockPane bp) {
		inventory.getChildren().add(bp);
	}

	public void add_text() {
		text = new Text("Inventory: ");
		StackPane sp = new StackPane();
		Rectangle bg = new Rectangle(BlockPane.DIM_SQUARE, BlockPane.DIM_SQUARE);

		bg.setFill(Color.TRANSPARENT);
		bg.setStroke(Color.TRANSPARENT);

		sp.getChildren().addAll(bg, text);
		getChildren().add(sp);
	}
}
