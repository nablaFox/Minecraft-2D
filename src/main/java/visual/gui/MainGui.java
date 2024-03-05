package visual.gui;

import javafx.scene.layout.BorderPane;

public class MainGui extends BorderPane {

	public MainGui() {
		super();

		MapPane map = new MapPane(); // TODO: temp
		setCenter(map);
		setLeft(new ButtonListPane(map));
		setRight(new FurnacePane());
	}

}
