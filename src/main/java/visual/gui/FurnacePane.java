package visual.gui;

import data.BlockFactory;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FurnacePane extends VBox {
	private BlockPane input;
	private BlockPane output;

	public FurnacePane() {
		super();
		add_text();
		init_input();
		add_arrow();
		init_output();
	}

	private void init_input() {
		input = new BlockPane(new BlockFactory().null_block());
		getChildren().add(input);
	}

	private void init_output() {
		output = new BlockPane(new BlockFactory().null_block());
		getChildren().add(output);
	}

	public void add_text() {
		Text text = new Text("Furnace");
		getChildren().add(text);
	}

	public void add_arrow() {
		Text text = new Text("---->");
		getChildren().add(text);
	}
}
