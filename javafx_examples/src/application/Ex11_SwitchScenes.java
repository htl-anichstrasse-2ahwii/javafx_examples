package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Dieses Beispiel soll zeigen wie man den kompletten Inhalt des Fensters ändern kann.
 * Das kann für unterschiedliche Ansichten bzw. unterschiedliche Abfragen verwendet werden
 */
public class Ex11_SwitchScenes extends Application{
	private Scene firstScene;
	private Scene secondScene;
	
	private Scene buildFirstScene(Stage primaryStage)
	{
		StackPane root = new StackPane();
		Button button = new Button();
		button.setText("Umschalten zur 2. Darstellung");
		button.setOnAction((ActionEvent e) -> {
			primaryStage.setTitle("Die 2. Darstellung");
			primaryStage.setScene(secondScene);
		});
		root.getChildren().add(button);
		return new Scene(root, 450, 250);
	}
	
	private Scene buildsecondScene(Stage primaryStage)
	{
		StackPane root = new StackPane();
		Button button = new Button();
		button.setText("Umschalten zur 1. Darstellung");
		button.setOnAction((ActionEvent e) -> {
			primaryStage.setTitle("Die 1. Darstellung");
			primaryStage.setScene(firstScene);
		});
		root.getChildren().add(button);
		return new Scene(root, 450, 250);
	}
	
	@Override
	public void start(Stage primaryStage) {
		firstScene = buildFirstScene(primaryStage);
		secondScene = buildsecondScene(primaryStage);
		primaryStage.setTitle("Die 1. Darstellung");
		primaryStage.setScene(firstScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
