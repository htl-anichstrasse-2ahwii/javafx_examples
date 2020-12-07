package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Hier werden 2 Menueintraege (mit Untereintraegen) in einer Menubar angezeigt.
 * Unterschiedliche Varianten: Radio-Button und Checkboxes
 *
 */
public class Ex16_MenuEntries extends Application implements EventHandler<ActionEvent> {

	Label center; // hier steht das Feedback, wenn ein Menupunkt ausgewählt wurde
	// Deklaration der Menupunkte hier, damit sie in der handle-Methode verwendbar
	// sind
	MenuItem m11;
	MenuItem m12;
	MenuItem m13;
	CheckMenuItem m21;
	CheckMenuItem m22;
	RadioMenuItem m24;
	RadioMenuItem m25;
	ToggleGroup tg;
	
	@Override
	public void start(Stage primaryStage) {		
		center = new Label("Hier wird dann der aktuell ausgewählte Menueintrag angezeigt");

		Menu m1 = new Menu("_Menu 1"); //Wenn ein Underscore davorsteht kann man das Menu mit z.B. ALT-M öffnen
		m11 = new MenuItem("_Eintrag 1 1");
		m12 = new MenuItem("Eintrag 1 2");
		m13 = new MenuItem("Eintrag 1 3");
		m1.getItems().addAll(m11, m12, m13);

		//Die Auswahl der Menus wird in der Handle-Methode dieser Klasse behandelt
		m11.setOnAction(this);
		m12.setOnAction(this);
		m13.setOnAction(this);

		Menu m2 = new Menu("Menu 2");
		m21 = new CheckMenuItem("Eintrag 2 1 - Check Menu");
		m22 = new CheckMenuItem("Eintrag 2 2 - Check Menu");
		MenuItem m23 = new SeparatorMenuItem();

		m24 = new RadioMenuItem("Eintrag 2 4");
		m25 = new RadioMenuItem("Eintrag 2 5");

		m21.setOnAction(this);
		m22.setOnAction(this);
		m24.setOnAction(this);
		m25.setOnAction(this);

		//Radio Buttons muss man in Gruppen zusammenfassen
		tg = new ToggleGroup();
		m24.setToggleGroup(tg);
		m25.setToggleGroup(tg);
		m2.getItems().addAll(m21, m22, m23, m24, m25);

		// Die gesamte Menuleiste
		MenuBar mb = new MenuBar();
		mb.getMenus().addAll(m1, m2); //Gib die beiden Menus dazu

		BorderPane root = new BorderPane();
		root.setTop(mb); //Zeig sie im Top-Bereich der scene an
		root.setCenter(center); //Das Textfeld fuer das Feedback kommt in die Mitte

		Scene scene = new Scene(root, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		MenuItem source = (MenuItem) event.getSource();
		String text = source.getText();
		
		//Das nur als Beispiel wie man schaun kann welcher Menupunkt gewählt wurde
		if (source == m11)
		{
			text += "\nHier spezielle Reaktion auf den Menupunkt m11";
		}
		
		//Ausgabe welcher Radiobutton gewählt ist
		RadioMenuItem selected = (RadioMenuItem)tg.getSelectedToggle();
		String selStr = "kein Radiobutton Ausgewählt";
		if (selected == m24)
		{
			selStr = "Radio m24, ist ausgewaehlt";
		} else if (selected == m25)
		{
			selStr = "Radio m25, ist ausgewaehlt";
		}
		text += "\n" + selStr;
		
		
		String checkStr = "Checkbox m21 ist nicht ausgewaehlt";
		//Ist die erste Checkbox ausgewaehlt
		if (m21.isSelected())
		{
			checkStr = "Checkbox m21 ist ausgewaehlt";
		}
		text += "\n" + checkStr;
		
		center.setText(text);
	}

	private String sampleInputDialog()
	{
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your name:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    return result.get();
		}
		return "";
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
