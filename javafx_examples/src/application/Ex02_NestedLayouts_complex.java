package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Es sollen hier mehrere Layouts ineinander verschatelt werden (Auch
 * Eventlistener sind schon mit dabei)
 *
 */
public class Ex02_NestedLayouts_complex extends Application implements EventHandler<ActionEvent> {
	TextArea result;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Grundayout
			BorderPane root = new BorderPane();

			// Alle Gruppen von Steuerelementen werden horizontal angeordnet
			HBox center = new HBox();

			// Die erste Gruppe besteht nur aus A, B, B - Buttons
			VBox letters = new VBox(); // Horizontale Anordnung der Steuerelemente
			Button b1 = new Button("A");
			b1.setOnAction(this); // Die handle-Methode am Ende übernimmt die Verarbeitung eines Knopfdrucks
			Button b2 = new Button("B");
			b2.setOnAction(this);
			Button b3 = new Button("C");
			b3.setOnAction(this);

			// top.getChildren().add kann man verwendenn um ein einzelnes Steuerelement
			// hinzuzufügen
			// hier werden gleich alle hinzugefügt:
			letters.getChildren().addAll(b1, b2, b3); // Gebe die A,B,C-Buttons auf das vertikale Layout

			center.getChildren().add(letters); // gib die Buttongruppe in den Centerbereich (da kommen dann noch mehr)

			result = new TextArea();
			result.setWrapText(true);
			center.getChildren().add(result); // Das Textfeld kommt auch in die Mitte (als 2. Element)

			VBox commands = new VBox();
			Button clear = new Button("löschen");
			clear.setOnAction((ActionEvent e) -> { // Das Reagieren des Knopfdrucks passiert gleich hier
				result.setText("");
			});

			Button dbl = new Button("doppelt");
			dbl.setOnAction((ActionEvent e) -> {
				result.setText(result.getText() + result.getText());
			});
			commands.getChildren().addAll(clear, dbl);
			center.getChildren().add(commands);

			root.setCenter(center);

			Scene scene = new Scene(root, 800, 800);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button) event.getSource();
		// Nimm den aktuellen Fensterinhalt und schreibe das was auf den gedrückten
		// Button steht ins Textfeld
		result.setText(result.getText() + b.getText());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
