package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex13_StackPane extends Application{
	StackPane center;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			center = new StackPane();
			
			HBox first = new HBox(); //Horizontale Anordnung der Steuerelemente
			Button b1 = new Button("A");
			Button b2 = new Button("B");
			Button b3 = new Button("C");
			//top.getChildren().add kann man verwendenn um ein einzelnes Steuerelement hinzuzufügen
			//hier werden gleich alle hinzugefügt:
			first.getChildren().addAll(b1, b2, b3);
			center.getChildren().add(first);

			VBox second = new VBox(); //Vertikale Anordnung der Steuerelemente
			RadioButton r1 = new RadioButton("rot");
			RadioButton r2 = new RadioButton("grün");
			RadioButton r3 = new RadioButton("blau");
			second.getChildren().addAll(r1,r2,r3);
			center.getChildren().add(second);
			
			
			GridPane third = new GridPane();
			//Die Elemente können natürlich auch dynamisch erzeugt werden
			for (int i = 0; i < 10;i++)
			{
				for (int j = 0; j < 10;j++)
				{
					String bStr = String.format("(%d %d)", i, j); //funktioniert wie printf
					Button b = new Button(bStr);
					third.add(b, i,j); //stelle den Button an die Stelle i,j
				}				
			}
			center.getChildren().add(third);
			root.setCenter(center);
			Scene scene = new Scene(root, 400, 400);

			Label feedback = new Label();
			root.setBottom(feedback);
			
			HBox top = new HBox();
			Button firstB = new Button("A B C ' s");
			firstB.setOnAction((ActionEvent e) -> {
				
				select(0);
			    feedback.setText("Button 1 gedrückt");
			});
			Button secondB = new Button("Radio Buttons");
			secondB.setOnAction((ActionEvent e) -> {
				select(1);
			    feedback.setText("Button 2 gedrückt");
			});
			
			Button thirdB = new Button("Grid");
			thirdB.setOnAction((ActionEvent e) -> {
				select(2);
			    feedback.setText("Button 3 gedrückt");
			});
			
			top.getChildren().addAll(firstB, secondB, thirdB);
			root.setTop(top);
			select(0);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void select(int pos)
	{
		for (Node n : center.getChildren())
		{
			n.setVisible(false);
		}
		Node n = center.getChildren().get(pos);
		//n.toFront();
		n.setVisible(true);
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
