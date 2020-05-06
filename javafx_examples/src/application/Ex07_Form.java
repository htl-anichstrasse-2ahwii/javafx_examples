package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Hier soll die Darstellung eines Formulares gezeigt werden. Es wird mittels
 * GridPane erzeugt, in der ersten Spalte steht die Beschriftung, in der zweiten
 * die Eingabefelder für die Daten
 */
public class Ex07_Form extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			GridPane baseForm = new GridPane();
			baseForm.setHgap(10); // Horizontaler Platz zwischen den Zellen
			baseForm.setVgap(10); // Vertikaler Platz zwischen den Zellen

			Label scenetitle = new Label("Welcome");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20)); // Es koennen auch andere Schriftarten für
																			// Labels verwendet werden
			baseForm.add(scenetitle, 0, 0, 2, 1); // Die Beschriftung soll an die Stelle (0,0) kommen, sich über 2
													// Spalten und eine Zeile erstrecken

			Label userName = new Label("User Name");
			baseForm.add(userName, 0, 1);

			TextField userTextField = new TextField();
			baseForm.add(userTextField, 1, 1);

			Label pw = new Label("Password");
			baseForm.add(pw, 0, 2);

			PasswordField pwBox = new PasswordField();
			baseForm.add(pwBox, 1, 2);

			Button save = new Button("Speichern");

			// Positionierung innerhalb einer Zelle: Hier muss man einen kleinen Trick
			// anwenden. In die Zelle eine HBox geben, das zu positionierende Elemente fügt
			// man der HBox hinzu und diese dann an die gewünschte grid-Position
			HBox hbBtn = new HBox();
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(save);
			baseForm.add(hbBtn, 1, 3);

			root.setCenter(baseForm);
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
