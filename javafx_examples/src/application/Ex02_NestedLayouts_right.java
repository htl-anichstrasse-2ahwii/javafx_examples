package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex02_NestedLayouts_right extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			VBox right = new VBox();
			
			VBox right1 = new VBox();
			Label b1 = new Label("A");
			Label b2 = new Label("B");
			Label b3 = new Label("C");
			right1.getChildren().addAll(b1, b2, b3);
			right1.setPrefHeight(140);
			right1.setMinHeight(140);
			
			VBox right2 = new VBox();
			Label r1 = new Label("rot");
			Label r2 = new Label("grün");
			Label r3 = new Label("blau");
			right2.getChildren().addAll(r1, r2, r3);
			
			right.getChildren().addAll(right1, right2);
			root.setRight(right);

			GridPane center = new GridPane();
			// Die Elemente können natürlich auch dynamisch erzeugt werden
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					String bStr = String.format("(%d %d)", i, j); // funktioniert wie printf
					Button b = new Button(bStr);
					center.add(b, i, j); // stelle den Button an die Stelle i,j
				}
			}
			root.setCenter(center);

			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
