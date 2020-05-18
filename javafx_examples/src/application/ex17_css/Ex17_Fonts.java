package application.ex17_css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ex17_Fonts extends Application{
	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		Label l = new Label("Das ist ein Text");
		root.setCenter(l);
		// System.out.println(b.getStyleClass());
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add("application/ex17_css/fonts.css");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
