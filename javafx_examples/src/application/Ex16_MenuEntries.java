package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Hier werden 2 Menueintraege (mit Untereintraegen) in einer Menubar angezeigt.
 * Unterschiedliche Varianten: Radio-Button und Checkboxes
 *
 */
public class Ex16_MenuEntries extends Application implements EventHandler<ActionEvent>{

	Label center;
	
	@Override
	public void start(Stage primaryStage) {
		
		center = new Label("Hier wird dann der aktuell ausgewählte Menueintrag angezeigt");
		
		Menu m1 = new Menu("Menu 1"); 
		MenuItem m11 = new MenuItem("Eintrag 1 1"); 
		MenuItem m12 = new MenuItem("Eintrag 1 2"); 
		MenuItem m13 = new MenuItem("Eintrag 1 3"); 
		m1.getItems().addAll(m11,m12,m13);

		m11.setOnAction(this);
		m12.setOnAction(this);
		m13.setOnAction(this);
		
		Menu m2 = new Menu("Menu 2"); 
		MenuItem m21 = new CheckMenuItem("Eintrag 2 1 - Check Menu"); 
		MenuItem m22 = new CheckMenuItem("Eintrag 2 2 - Check Menu"); 
		MenuItem m23 = new SeparatorMenuItem(); 
		

		RadioMenuItem m24 = new RadioMenuItem("Eintrag 2 2"); 
		RadioMenuItem m25 = new RadioMenuItem("Eintrag 2 3"); 

		m21.setOnAction(this);
		m22.setOnAction(this);
		m24.setOnAction(this);
		m25.setOnAction(this);

		
		ToggleGroup tg = new ToggleGroup();
		m24.setToggleGroup(tg);
		m25.setToggleGroup(tg);
		m2.getItems().addAll(m21,m22,m23, m24, m25);
		
		 // Das gesamte Menu
        MenuBar mb = new MenuBar(); 
		mb.getMenus().addAll(m1,m2);
		
		BorderPane root = new BorderPane();
		root.setTop(mb);
		root.setCenter(center);
		
		Scene scene = new Scene(root, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent event) {
		MenuItem source = (MenuItem)event.getSource();
		String text = source.getText();
		center.setText(text);
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
