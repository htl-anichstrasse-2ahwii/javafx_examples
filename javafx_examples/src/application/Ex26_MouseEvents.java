package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ex26_MouseEvents extends Application implements EventHandler<MouseEvent> {

	
		@Override
		public void start(Stage primaryStage) {
			try {
				BorderPane root = new BorderPane();
				Button b = new Button("Hallo");
				b.setOnMouseClicked(this);
				root.setCenter(b);

				
				
				Scene scene = new Scene(root, 400, 400);

				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void handle(MouseEvent ev) {
			if (ev.getEventType() == MouseEvent.MOUSE_CLICKED)
			{
				System.out.println("clicked");
				if (ev.getButton() == MouseButton.PRIMARY)
				{
					System.out.println("Linke Maustaste");
				} else if (ev.getButton() == MouseButton.SECONDARY)
				{
					System.out.println("Rechte Maustaste");
				}
			}
			
		}
		
		public static void main(String[] args) {
			launch(args);
		}

	}
