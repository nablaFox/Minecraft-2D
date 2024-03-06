package view.gui;

import controller.simple.MainSimpleController;
import data.BlockFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.MapCoordinates;

public class ButtonListPane extends VBox {
	MainSimpleController controller;

	Button pick_block_btn;
	Button smelt_btn;
	Button move_to_furnace_btn;
	Button move_to_inventory_button;

	TextField pick_block_x;
	TextField pick_block_y;

	public ButtonListPane(MainSimpleController controller) {
		super();

		this.controller = controller;
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
				BlockPane block = (BlockPane) MapPane.get_element_at(
						controller.get_main_gui().get_map_pane(), 0, 0);
				block.change_block(new BlockFactory().sand_block());
			}
		});

		getChildren().add(test_button);
	}

	private void create_pick_up_btn() {
		HBox section = new HBox();

		pick_block_btn = new Button("Pick Block");
		pick_block_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int row = Integer.parseInt(pick_block_x.getText());
				int col = Integer.parseInt(pick_block_y.getText());

				System.out.println("Picking up block at " + row + ", " + col);
				controller.pick_up_block(new MapCoordinates(row, col));
			}
		});

		pick_block_x = new TextField();
		pick_block_y = new TextField();
		section.getChildren().addAll(
				pick_block_x,
				pick_block_y,
				pick_block_btn);

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

		move_to_furnace_btn = new Button("Move to Furnace");
		move_to_furnace_btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});

		section.getChildren().addAll(
				new TextField(), move_to_furnace_btn);
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
