package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * idea taken from: https://medium.com/@keeptoo/making-a-borderless-javafx-window-movable-f7855eb33a51
 * @author albert
 *
 */
public class Ex19_MoveUndecorated extends Application {
	private double xOffset = 0; 
	private double yOffset = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button b = new Button("Hallo");
			root.setCenter(b);

			root.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
	        });
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	            	primaryStage.setX(event.getScreenX() - xOffset);
	            	primaryStage.setY(event.getScreenY() - yOffset);
	            }
	        });
	        
			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
