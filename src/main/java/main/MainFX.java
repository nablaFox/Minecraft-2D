package main;

import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

// TODO: temp
import visual.gui.BlockPane;
import visual.gui.InventoryPane;
import visual.gui.MapPane;

import java.util.ArrayList;

import data.BlockFactory;

import javafx.stage.Stage;

public class MainFX extends Application {
	BlockFactory bf;

	@Override
	public void start(Stage primaryStage) {
		bf = new BlockFactory();

		test_map_pane(primaryStage);
	}

	private void test_map_pane(Stage primaryStage) {
		MapPane map_pane = new MapPane();

		Scene scene = new Scene(map_pane, 500, 500);

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
		Scene scene = new Scene(block_pane, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
