package application.ex09_tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Dieses Beispiel veranschaulicht wie eine Tabelle funktioniert. Es wird
 * gezeigt, wie Werte hinzugefügt, geändert und gelöscht werden Grundsätzlich
 * muss man immer eine Klasse beim Erzeugen angeben. Objekte dieser Klasse
 * werden dann in den Tabellenzeilen abgebildet
 */
public class Ex09_TableView extends Application {
	// Hier werden die Daten der Tabelle gespeichert. Wenn in dieser Liste etwas
	// geändert wird, dann wird es auch in der Tabellenansicht geändert (Observable
	// = Beobachtbar, d.h. die Tabellenansicht "beobachtet" diese Liste auf
	// Änderungen und stellt diese dar
	ObservableList<Person> persons = FXCollections.observableArrayList();

	TextField tFirstName;
	TextField tLastName;
	TextField tAge;
	// Das ist die ganze Tabelle
	TableView<Person> table;

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();
		table = new TableView<>();

		// Die 2 Typen stellen folgendes dar: Person: Abbild auf die Klasse Person; Dort
		// auf einen String-Wert
		TableColumn<Person, String> firstNameCol = new TableColumn<>("Vorname");
		// Auf welches Attribut in der Klasse Person wird abgebildet: Hier auf firstName
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		firstNameCol.setPrefWidth(300); // Breite der Spalte

		TableColumn<Person, String> lastNameCol = new TableColumn<>("Nachname");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		lastNameCol.setPrefWidth(300);

		TableColumn<Person, Integer> ageCol = new TableColumn<>("Alter");
		ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
		ageCol.setPrefWidth(300);
		// Stelle alle diese Spalten in die Tabelle
		table.getColumns().addAll(firstNameCol, lastNameCol, ageCol);

		// Zu Testzwecken: Gib diese Person in die Tabelle
		Person p = new Person("Georgi", "Facello", 45);
		persons.add(p);
		// Verknüpfe die Liste persons mit der Tabellenansicht
		table.setItems(persons);

		root.setCenter(table);

		HBox top = new HBox();
		Button bAdd = new Button("hinzufügen");
		bAdd.setOnAction((ActionEvent e) -> {
			String firstName = tFirstName.getText();
			String lastName = tLastName.getText();
			String age = tAge.getText();
			Person p2 = new Person(firstName, lastName, Integer.parseInt(age));
			persons.add(p2); // Schreibe die Daten der Textfelder in die Tabelle
		});

		Button bRemove = new Button("löschen");
		bRemove.setOnAction((ActionEvent e) -> {
			int line = table.getSelectionModel().getSelectedIndex(); // Hole den Index der ausgewählten Zeile
			persons.remove(line); // Loesche die aktuelle Zeile
		});

		Button bChange = new Button("ändern");
		bChange.setOnAction((ActionEvent e) -> {
			String firstName = tFirstName.getText();
			String lastName = tLastName.getText();
			String age = tAge.getText();
			Person p2 = new Person(firstName, lastName, Integer.parseInt(age));
			int line = table.getSelectionModel().getSelectedIndex(); // Hole den Index der ausgewählten Zeile
			persons.set(line, p2); // Ueberschreibe die Daten in der aktuellen Zeile
		});

		tFirstName = new TextField("Georgi");
		tLastName = new TextField("Facello");
		tAge = new TextField("45");

		top.getChildren().addAll(bAdd, bRemove, bChange, tFirstName, tLastName, tAge);
		root.setTop(top);

		Scene scene = new Scene(root, 800, 400);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
