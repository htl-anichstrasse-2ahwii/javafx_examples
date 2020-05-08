package application;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex15_WorkingWithDate extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		HBox top = new HBox();
		DatePicker date = new DatePicker();
		date.setValue(LocalDate.of(2020, 5, 7)); //Setze als Startdatum den 7. Mai. LocalDate.now() setzt den heutigen Tag
		
		Button select = new Button("auslesen");
		select.setOnAction((ActionEvent e) -> {
		    LocalDate d = date.getValue();
		});
		top.getChildren().addAll(date);
		root.setTop(top);
		
        primaryStage.setScene(new Scene(root,500,500));
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
