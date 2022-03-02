
package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX verhält sich ein wenig kompliziert wenn es darum geht eine Application
 * ohne der statischen Methode launch zu erzeugen, sondern durch das Erzeugen eines Objektes
 */
public class Ex27_LaunchFromObject extends Application {
	String any;
	public Ex27_LaunchFromObject(String any) {
		this.any = any;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button b = new Button(any);
			root.setCenter(b);
			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Ex27_LaunchFromObject o = new Ex27_LaunchFromObject("Hallo");
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				o.start(new Stage());
			}
		});
	}
}
