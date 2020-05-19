package application.ex17_css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ex17_CssAdvancedExample extends Application {

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		Button b = new Button("Ein Button");
		// So wird der Style direkt gesetzt (eher nicht zu empfehlen: Darstellung soll
		// von den Steuerelementen getrennt abgelegt werden
		b.setStyle("-fx-font: normal bold 20px 'serif' ");
		root.setCenter(b);

		b.getStyleClass().add("special_buttons");
		
		// so kann man die aktuell zugewiesenen Styles abfragen
		String style = b.getStyle();
		System.out.println(style);
		
		//so die zugewiesenen styleklassen
		String classes = String.join(",", b.getStyleClass());
		System.out.println(classes);

		//Wenn man die id setzt, kann man speziell nur für dieses Steuerelement styles setzen:
		b.setId("first_button");
		
		
		// System.out.println(b.getStyleClass());
		Scene scene = new Scene(root, 400, 400);
		// zusaetzlich zu speziellen Styles
		scene.getStylesheets().add("application/ex17_css/advanced.css");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
