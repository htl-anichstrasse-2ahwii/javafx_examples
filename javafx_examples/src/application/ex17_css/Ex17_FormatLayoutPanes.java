package application.ex17_css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex17_FormatLayoutPanes extends Application {

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		HBox top = new HBox();
		top.setId("top");
		for (int i = 1; i <= 10;i++)
		{
			Button b = new Button(i + "");
			top.getChildren().add(b);
		}
		
		root.setTop(top);
		
		// System.out.println(b.getStyleClass());
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add("application/ex17_css/layout_panes.css");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
