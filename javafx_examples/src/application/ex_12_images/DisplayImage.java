package application.ex_12_images;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Das Beispiel zeigt wie ein Bild gleich wie ein Steuerelement (wie ein z.B.
 * Button) auf der GUI platziert werden kann
 *
 */
public class DisplayImage extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			GridPane grid = new GridPane();

			// Das Bild wird aus dem Klassenpfad geladen. Für uns bedeutet das, dass das
			// Verzeichnis mit den Bildern innerhalb von src liegen muss
			Image im = new Image("images/bart.png");
			ImageView v = new ImageView(im);
			grid.add(v, 0, 0);

			root.setCenter(grid);

			//rest wie gehabt....
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
