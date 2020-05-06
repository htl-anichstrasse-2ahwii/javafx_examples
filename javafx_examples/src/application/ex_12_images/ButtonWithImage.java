package application.ex_12_images;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonWithImage extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			HBox top = new HBox();
			
			Image im1 = new Image("images/icons/accessories-calculator.png");
			Button b1 = new Button("");
			b1.setGraphic(new ImageView(im1));
			
			top.getChildren().add(b1);

			Image im2 = new Image("images/icons/accessories-character-map.png");
			Button b2 = new Button();
			b2.setGraphic(new ImageView(im2));
			top.getChildren().add(b2);

			Image im3 = new Image("images/icons/accessories-dictionary.png");
			Button b3 = new Button();
			b3.setGraphic(new ImageView(im3));			
			top.getChildren().add(b3);

			
			root.setTop(top);

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
