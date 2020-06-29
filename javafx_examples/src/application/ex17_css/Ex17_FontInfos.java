package application.ex17_css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex17_FontInfos extends Application {
	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		
		
		VBox center = new VBox();
		Label fontNames = new Label("Font names");
		TextArea l = new TextArea();
		l.setEditable(false);
		
		for (String font: Font.getFontNames("monospace"))
		{
			l.appendText(font + "\n");
		}

		Label fontFamilies = new Label("Font families");
		TextArea f = new TextArea();
		l.setEditable(false);
		
		for (String familiy: Font.getFamilies())
		{
			f.appendText(familiy + "\n");
		}
		
		
		fontFamilies.setStyle("-fx-font-family: monospace; -fx-font: 12px Regular");
		//fontFamilies.setStyle("-fx-font: 100px Tahoma");
		center.getChildren().addAll(fontNames, l, fontFamilies, f);
		root.setCenter(center);
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add("application/ex17_css/fonts.css");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}