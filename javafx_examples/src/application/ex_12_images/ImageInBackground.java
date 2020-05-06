package application.ex_11_images;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Ein Hintergrundbild kann für alle Steuer- oder Layoutelemente gesetzt werden.
 * Hier wird der Hintergrund einfach auf ein GridPane gelegt
 */
public class ImageInBackground extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			GridPane grid = new GridPane();
			Image im = new Image("images/bart.png");
			/* Das sind ie Parameter:
			 * image: Das Bild
			 * repeatX: Wird das Bild in X-Richtung wiederholt
			 * repeatY: Wird das Bild in Y-Richtung wiederholt
			 * position: Wo soll das Bild angezeigt werden
			 * size: Wie groß soll das Hintergrundbild dargestellt werden
			*/
			BackgroundImage bi = new BackgroundImage(im, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT);
			
			grid.setBackground(new Background(bi));
			
			Button b = new Button("Ein Testbutton");
			grid.add(b, 0,0);
			
			root.setCenter(grid);

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
