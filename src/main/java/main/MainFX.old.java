package main;

// used for "extends Application"
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

// top level container. It's the window of the application
import javafx.stage.Stage;

public class MainFX extends Application {
	@Override
	// we pass the reference to the window we're using
	public void start(Stage primaryStage) {
		Button btn = new Button("Say hello world");

		// we pass a callback to the button
		btn.setOnAction(new EventHandler<ActionEvent>() { // we use a generic and we specify the type of the event
			@Override
			public void handle(ActionEvent event) { // the main callbck is this method
				System.out.println("Hello, JavaFX 17, running on Java 21");
			}
		});

		StackPane root = new StackPane(); // we create a container
		root.getChildren().add(btn);

		Scene scene = new Scene(root, 300, 250); // a scene is a sort of screen

		// we use the reference to the window to set the scene
		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
