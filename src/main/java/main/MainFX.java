package main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

// MVC pattern
import data.model.MainModel;
import view.gui.MainGui;
import controller.simple.MainSimpleController;

public class MainFX extends Application {
	@Override
	public void start(Stage primaryStage) {
		MainSimpleController controller = new MainSimpleController(new MainModel());
		MainGui layout = controller.get_main_gui();

		Scene scene = new Scene(layout);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
