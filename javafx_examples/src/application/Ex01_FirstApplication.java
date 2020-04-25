package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Eine erste Anwendung, wo das Grundlayout ein BorderPane (center, top, bottom,
 * left, right) ist. Erste Steuerelemente werden in diese Bereiche gegeben
 */
public class Ex01_FirstApplication extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button b = new Button("Hallo");
			root.setCenter(b);

			TextField tf = new TextField("Das ist ein Text");
			root.setTop(tf);

			TextArea ta = new TextArea("Text area");
			root.setBottom(ta);

			CheckBox cb = new CheckBox("check");
			root.setLeft(cb);

			//...weitere Steuerelemente siehe Skriptum
			
			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
