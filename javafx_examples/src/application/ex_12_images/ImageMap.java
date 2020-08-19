package application.ex_12_images;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Das Beispiel zeigt wie man auf das Klicken eines Bildes in unterschiedlichen Bereichen reagieren kann
 *
 */
public class ImageMap extends Application implements EventHandler<MouseEvent>{

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			GridPane grid = new GridPane();

			// Das Bild wird aus dem Klassenpfad geladen. Für uns bedeutet das, dass das
			// Verzeichnis mit den Bildern innerhalb von src liegen muss
			Image im = new Image("images/bart.png");
			ImageView v = new ImageView(im);
			//Weitere alternativen: v.setOnMousePressed(value); v.setOnMouseReleased(value);
			v.setOnMouseClicked((MouseEvent e) ->
			{
				double x = e.getX();
				double y = e.getY();
				System.out.printf("%f %f\n", x,y);
				if (y > 258)
				{
					System.out.println("Schuhe");
				} else
				{
					System.out.println("Der Rest");
				}
			});
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
