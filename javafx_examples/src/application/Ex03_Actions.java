package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex03_Actions extends Application implements EventHandler<ActionEvent>{
	
	Label feedback;
	Button b2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			feedback = new Label();
			root.setBottom(feedback);
			
			VBox center = new VBox();
			Button b1 = new Button("Drück mich!! 1");
			b1.setOnAction((ActionEvent e) -> {
			    feedback.setText("Button 1 gedrückt");
			});
			
			center.getChildren().add(b1);
			
			b2 = new Button("Drück mich auch!! 2");
			b2.setOnAction(this); //Wenn der Knopf gedrückt wird, wird die Methode handle aufgerufen
			center.getChildren().add(b2);
			
			root.setCenter(center);
			
			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handle(ActionEvent event) {
		Node n = (Node)event.getSource(); //Welcher Button hat das Event ausgelöst
		if (n == b2)
		{
			feedback.setText("Button 2 würde gedrückt!!");
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
