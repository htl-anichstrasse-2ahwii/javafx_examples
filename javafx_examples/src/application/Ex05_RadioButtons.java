package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Wenn mehrere Fragen/Eingaben mit RadioButtons auf einer Seite sind, müssen diese immer zu Gruppen zusammengefasst werden
 * Das funktioniert mit sogenannte ToggleGroups
 * Auch wie das Auslesen der Werte (also welcher Radiobutton gedrückt ist) funktioniert wird hier gezeigt 
 * und wie man auf Änderungen eines Buttons reagieren kann
 *
 */
public class Ex05_RadioButtons  extends Application  {
	Label feedback;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			VBox center = new VBox();
			
			RadioButton bA = new RadioButton("A");
			RadioButton bB = new RadioButton("B");
			RadioButton bC = new RadioButton("C");
			bC.setPadding(new Insets(0, 0, 40, 0)); //(top, right, bottom, left) damit ein Abstand zwischen der ersten und zweiten Gruppe ist
			//Erzeuge die Gruppe der Radiobuttons und füge die entsprechenden Buttons hinzu
			//Dann ist immer nur eine Auswahl erlaubt
			ToggleGroup tgA = new ToggleGroup();
			bA.setToggleGroup(tgA);
			bB.setToggleGroup(tgA);
			bC.setToggleGroup(tgA);
			
			RadioButton b1 = new RadioButton("1");
			RadioButton b2 = new RadioButton("2");
			RadioButton b3 = new RadioButton("3");
			
			//Erzeuge die Gruppe der Radiobuttons und füge die entsprechenden Buttons hinzu
			//Dann ist immer nur eine Auswahl erlaubt
			ToggleGroup tg1 = new ToggleGroup();
			b1.setToggleGroup(tg1);
			b2.setToggleGroup(tg1);
			b3.setToggleGroup(tg1);
			b3.setPadding(new Insets(0, 0, 40, 0));
			
			Button check = new Button("check");
			check.setOnAction((ActionEvent e) -> {
				RadioButton tgASel = (RadioButton)tgA.getSelectedToggle();
				RadioButton tg1Sel = (RadioButton)tg1.getSelectedToggle();
				String selections = String.format("%s %s", tgASel.getText(), tg1Sel.getText());
			    feedback.setText(selections);
			});
			center.getChildren().addAll(bA,bB, bC, b1, b2, b3, check);
			root.setCenter(center);
			
			feedback = new Label();
			root.setBottom(feedback);

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
