package application.ex17_css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Was kann man denn mit Texten noch so alles anstellen: 
 * https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/text-settings.htm
 *
 */
public class Ex17_Fonts extends Application{
	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		VBox center = new VBox();
		Text l = new Text("Das ist ein Text");
		l.setFont(Font.loadFont("file:resources/fonts/Inkspot.ttf", 120));
		l.setId("normaltext");
		
		Text t = new Text("Das ist auch ein Text");
		t.setId("fancytext");

		center.getChildren().addAll(l,t);
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
