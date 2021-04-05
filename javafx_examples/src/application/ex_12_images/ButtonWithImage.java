package application.ex_12_images;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;




public class ButtonWithImage extends Application implements EventHandler<ActionEvent>{
	FadeTransition ft = new FadeTransition();
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
			ImageView iv3 = new ImageView(im3);
			b3.setGraphic(iv3);			
			top.getChildren().add(b3);
			b3.setOnAction(this);
			ft.setNode(iv3);
			ft.setDuration(new Duration(2000));
			ft.setFromValue(1.0);
			ft.setToValue(0.0);
			//ft.setCycleCount(6);
			//ft.setAutoReverse(true);
			
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

	@Override
	public void handle(ActionEvent event) {
		ft.play();
		
	}

}
