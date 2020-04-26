package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Erzeuge eine Liste von String-Werten und speichere diese in einer ListView
 * Weiters soll das Arbeiten mit diesen Listenelementen gezeigt werden
 */
public class Ex04_ListView extends Application implements ChangeListener<String>, EventHandler<ActionEvent> {
	ListView<String> lv;
	ObservableList<String> items;
	Label feedback;
	Button remove;
	Button add;
	Button change;
	TextField text;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			//Die obere Button - Zeile
			HBox top = new HBox();
			remove = new Button ("löschen");
			remove.setOnAction(this);
			add = new Button ("hinzufügen");
			add.setOnAction(this);
			change = new Button("ändern");
			change.setOnAction(this);
			text = new TextField();
			top.getChildren().addAll(remove, add, change, text);
			root.setTop(top);
			
			lv = new ListView<String>();
			/*
			 * Diese Klasse ist notwendig, um Einträge in die Listview zu bekommen. In Java
			 * ist es üblich, dass man die Daten, die gespeichert werden, von ihrer
			 * Darstellung getrennt werden, also ListView = Darstellung; ObservableList =
			 * Daten
			 */
			items = FXCollections.observableArrayList("Eins", "Zwei", "Drei", "Vier");
			lv.setItems(items);
			// Hier wird eine Event listener registiert: das hat zur Folge dass immer wenn
			// die Auswahl in der Liste geändert wird, die Methode changed aufgerufen wird
			lv.getSelectionModel().selectedItemProperty().addListener(this);
			root.setCenter(lv);

			feedback = new Label();
			root.setBottom(feedback);

			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wird aufgerufen, wenn sich die Listenauswahl verändert hat
	 */
	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		int index = lv.getSelectionModel().getSelectedIndex();
		String item = lv.getSelectionModel().getSelectedItem();
		String lvCurrent = String.format("index %d: %s", index, item);
		feedback.setText(lvCurrent);
	}

	@Override
	public void handle(ActionEvent event) {
		String t = text.getText();
		int index = lv.getSelectionModel().getSelectedIndex(); //-1 wenn keine Auswahl getroffen ist
		
		if (event.getSource() == add) //so kann unterschieden werden welcher Button gedrückt worden ist
		{
			
			if (t.length() > 0)
			{
				lv.getItems().add(t);
				feedback.setText(String.format("%s hinzugefügt", t));
			}
		} else if(event.getSource() == remove)
		{
			if (index != -1)
			{
				lv.getItems().remove(index);	
			}
		} else if (event.getSource() == change)
		{
			if (index != -1)
			{
				lv.getItems().set(index, t);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}



}
