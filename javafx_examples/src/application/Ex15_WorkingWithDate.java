package application;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Ein einfaches Beispiel, dass den Umgang mit Datumswerten zeigt. Die Beispiele
 * gehen ein wenig über JavaFX hinaus und zeigen auch, wie der Umgang mit Datum
 * und Uhrzeit in Java funktioniert. Wesentliche Rolle spielt hier die Klasse
 * LocalDate. Hier eine gute Beschreibung dazu:
 * http://openbook.rheinwerk-verlag.de/java8/05_009.html#u5.10 Will man mit
 * Uhrzeiten arbeiten, kann http://jfxtras.org/ helfen
 *
 */
public class Ex15_WorkingWithDate extends Application {
	TextArea center;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		HBox top = new HBox();
		DatePicker date = new DatePicker();
		date.setValue(LocalDate.of(2020, 5, 7)); // Setze als Startdatum den 7. Mai. LocalDate.now() setzt den heutigen
													// Tag

		center = new TextArea("Hier kommen die Datums und Uhrzeitbeispiele hin\n");
		root.setCenter(center);

		Button select = new Button("auslesen");
		select.setOnAction((ActionEvent e) -> {
			LocalDate ld = date.getValue();
			// Wichtig für das Arbeiten mit Datenbanken: Konvertierung von LocalDate in
			// java.sql.Date
			java.sql.Date d = Date.valueOf(ld);
			System.out.println(d); //nur damit man sieht dass es auch funktioniert

			LocalDate newLoc = d.toLocalDate();
			date.setValue(newLoc);

			// Will man das Datum in einer bestimmten Form ausgeben, ist die Klasse
			// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
			// praktisch
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy MM dd");
			String dateStr = ld.format(df);
			center.appendText(dateStr + "\n");
			
			

		});
		top.getChildren().addAll(date, select);
		root.setTop(top);

		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
