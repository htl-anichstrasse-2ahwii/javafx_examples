package application.ex_12_images;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ButtonWithImageResize extends Application {
	double width = 200;
	double height = 298;
	ArrayList<Button> bts = new ArrayList<Button>();

	
	@Override
	public void start(Stage stage) {
		try {
			BorderPane root = new BorderPane();

			

			GridPane center = new GridPane();
			addBtn(center, 0,0);
			addBtn(center, 0,1);
			addBtn(center, 1,0);
			addBtn(center, 1,1);
			root.setCenter(center);
			Scene scene = new Scene(root, 700, 700);

			stage.setScene(scene);
			stage.show();

			stage.widthProperty().addListener((obs, oldVal, newVal) -> {
				System.out.println("WIDTH:" + newVal);
				width = (Double) newVal;
				resizeImg();

			});

			stage.heightProperty().addListener((obs, oldVal, newVal) -> {
				System.out.println("HEIGHT:" + newVal);
				height = (Double) newVal;
				resizeImg();
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void addBtn(GridPane grid, int x, int y)
	{
		Button b = new Button();
		Image im = new Image("images/bart.png");
		b.setGraphic(new ImageView(im));
		grid.add(b, x,y);
		bts.add(b);
	}
	
	void resizeImg() {
		Image im1 = new Image("images/bart.png", width /2 , height / 2 , false, false);
		for (Button b: bts) {
			b.setGraphic(new ImageView(im1));
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
