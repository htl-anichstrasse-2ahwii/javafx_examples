package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ein Beispiel wie man auf Tastendruck reagiert, hier im Fall eines Textfeldes,
 * dass auf Aenderungen des Textes reagiert.
 *
 */
public class Ex18_KeyEvents_TextArea extends Application {

	TextArea feedback;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			VBox bottom = new VBox();
			
			Label l = new Label("Feedback:");
			TextArea feedback = new TextArea();
			bottom.getChildren().addAll(l, feedback);
			root.setBottom(bottom);

			TextArea center = new TextArea();
			center.setOnKeyPressed(e -> {
				KeyCode k = e.getCode(); // Der KeyCode der gedrueckten Taste
				String c = e.getText(); // Das gedrueckte Zeichen
				feedback.appendText("Taste gedrueckt:" + k + " " + c + "\n");
			});
			
			center.setOnKeyReleased(e -> {
				KeyCode k = e.getCode(); // Der KeyCode der gedrueckten Taste
				String c = e.getText(); // Das gedrueckte Zeichen
				feedback.appendText("Taste losgelassen:" + k + " " + c + "\n");
			});
			
			center.setOnKeyTyped(e -> {
				String c = e.getCharacter(); // Das gedrueckte Zeichen
				feedback.appendText("Taste eingegeben:"  + c + "\n");
			});
			root.setCenter(center);
			Scene scene = new Scene(root, 800, 600);

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
