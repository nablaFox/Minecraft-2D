package visual.gui;

import data.BlockFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ButtonListPane extends VBox {
	MapPane map; // TODO: temp

	Button pick_block_btn;
	Button smelt_btn;
	Button move_to_furnace_btn;
	Button move_to_inventory_button;

	public ButtonListPane(MapPane map) {
		super();

		this.map = map;
		create_test_button();
		create_pick_up_btn();
		create_smelt_btn();
		create_move_to_furnace_btn();
		create_move_to_inventory_button();
	}

	private void create_test_button() {
		Button test_button = new Button("Test");

		test_button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				BlockPane block = (BlockPane) MapPane.get_element_at(map, 0, 0);
				block.change_block(new BlockFactory().sand_block());
				block.init();
			}
		});

		getChildren().add(test_button);
	}

	private void create_pick_up_btn() {
		HBox section = new HBox();

		section.getChildren().addAll(new TextField(), new TextField());

		pick_block_btn = new Button("Pick Block");

		pick_block_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			}
		});

		getChildren().add(section);
	}

	private void create_smelt_btn() {
		smelt_btn = new Button("Smelt");
		smelt_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});

		getChildren().add(smelt_btn);
	}

	private void create_move_to_furnace_btn() {
		HBox section = new HBox();

		section.getChildren().add(new TextField());

		move_to_furnace_btn = new Button("Move to Furnace");
		move_to_furnace_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});

		getChildren().add(section);
	}

	private void create_move_to_inventory_button() {
		move_to_inventory_button = new Button("Move to Inventory");
		move_to_inventory_button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});

		getChildren().add(move_to_inventory_button);
	}

}
