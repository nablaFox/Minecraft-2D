package main;

import javafx.application.Application;

import javafx.scene.Scene;

// TODO: temp
import view.gui.BlockPane;
import view.gui.FurnacePane;
import view.gui.InventoryPane;
import view.gui.MapPane;
import data.model.MainModel;
import view.gui.MainGui;

import java.util.ArrayList;

import controller.simple.MainSimpleController;
import data.BlockFactory;

import javafx.stage.Stage;
import utils.MapCoordinates;

public class MainFX extends Application {
	BlockFactory bf;

	@Override
	public void start(Stage primaryStage) {
		bf = new BlockFactory();

		test_main_gui(primaryStage);
	}

	private void test_main_gui(Stage primaryStage) {
		MainSimpleController controller = new MainSimpleController(new MainModel());
		MainGui layout = controller.get_main_gui();

		Scene scene = new Scene(layout);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void test_furnace_pane(Stage primaryStage) {
		FurnacePane furnace_pane = new FurnacePane();

		Scene scene = new Scene(furnace_pane);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void test_map_pane(Stage primaryStage) {
		MapPane map_pane = new MapPane();

		for (int i = 0; i < MapCoordinates.DIMENSION_ROWS; i++) {
			for (int j = 0; j < MapCoordinates.DIMENSION_COLUMNS; j++) {
				MapCoordinates coords = new MapCoordinates(j, i);
				map_pane.set_cell(coords, bf.random_block());
			}
		}

		Scene scene = new Scene(map_pane);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void test_inventory_pane(Stage primaryStage) {
		InventoryPane inventory_pane = new InventoryPane();
		Scene scene = new Scene(inventory_pane, 300, 250);

		ArrayList<BlockPane> block_panes = new ArrayList<BlockPane>();

		for (int i = 0; i < 10; i++) {
			block_panes.add(new BlockPane(bf.random_block()));
		}

		for (BlockPane bp : block_panes) {
			inventory_pane.add_to_inventory(bp);
		}

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void test_block_pane(Stage primaryStage) {
		BlockFactory bf = new BlockFactory();
		BlockPane block_pane = new BlockPane(bf.raw_iron_block());
		Scene scene = new Scene(block_pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
