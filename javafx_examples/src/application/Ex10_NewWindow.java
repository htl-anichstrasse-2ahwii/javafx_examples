package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Dieses Beispiel zeigt wie man vom Hauptfenster aus ein zweites Fenster aufmachen kann
 *
 */
public class Ex10_NewWindow extends Application {

	@Override
	public void start(final Stage primaryStage) {
		Button button = new Button();
		button.setText("Neues Fenster öffnen");
		button.setOnAction((ActionEvent e) -> {
			Label secondLabel = new Label("Die Beschriftung des neuen Fensters");
			StackPane secondaryLayout = new StackPane();
			secondaryLayout.getChildren().add(secondLabel);

			Scene secondScene = new Scene(secondaryLayout, 230, 100);

			// Erzeuge ein neues Fenster
			Stage newWindow = new Stage();
			newWindow.setTitle("Die zweite 'Stage'");
			newWindow.setScene(secondScene);

			// Wo soll das Fenster aufgehen: Relativ zum Hauptfenster + (200,100)
			newWindow.setX(primaryStage.getX() + 200);
			newWindow.setY(primaryStage.getY() + 100);

			newWindow.show();

		});

		//Hier alles wie gehabt
		StackPane root = new StackPane();
		root.getChildren().add(button);
		Scene scene = new Scene(root, 450, 250);

		primaryStage.setTitle("Das Hauptfenster");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
