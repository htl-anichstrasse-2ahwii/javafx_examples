package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Möchte man keinen Layoutmanager wie BorderPane usw. verwenden, kann man die Steuerelemente auch absolut positionieren.
 * Ist eigentlich nicht empfohlen, weil die Buttons nicht reagieren, wenn man die Größe des Fensters ändert und es auf Auflösungen
 * keine Rücksicht nimmt
 */
public class EX06_AbsolutePositioning extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Button b1 = new Button("Ein Button");
			b1.setLayoutX(40);
			b1.setLayoutY(100);
			root.getChildren().add(b1);

			Button b2 = new Button("Ein weiterer Button");
			b2.setLayoutX(70);
			b2.setLayoutY(200);
			root.getChildren().add(b2);
			
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
