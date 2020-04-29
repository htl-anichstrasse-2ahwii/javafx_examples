package application.ex08_accessdatabase;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex08_AccessDatabase extends Application{

	TextField tfFirstName;
	TextField tfLastName;
	DBManager db;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			db = new DBManager(); //Oeffnen der Datenbank
			
			BorderPane root = new BorderPane();
			HBox top = new HBox();
			TextField text = new TextField("10001");
			text.setTooltip(new Tooltip("Hier bitte die employee id eingeben")); //Damit der Text hier als ToolTip angezeigt wird
			
			Button search = new Button("suchen");
			search.setOnAction((ActionEvent e) -> {
				int empId = Integer.parseInt(text.getText());
			    try {
					Employee emp = db.getEmployee(empId);
					tfFirstName.setText(emp.getFirstName());
					tfLastName.setText(emp.getLastName());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
			top.getChildren().addAll(text, search);
			root.setTop(top);

			VBox center = new VBox();
			tfFirstName = new TextField();
			tfFirstName.setTooltip(new Tooltip("Vorname")); 
			
			tfLastName = new TextField();
			tfLastName.setTooltip(new Tooltip("Nachname"));
			
			center.getChildren().addAll(tfFirstName, tfLastName);
			root.setCenter(center);
			
			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Diese Methode wird aufgerufen wenn die Anwendung gestoppt wird.
	 * Ein guter Zeitpunkt um die Datenbank zu schliessen
	 */
	@Override
	public void stop() throws Exception {
		db.close(); //schliessen der Datenban
		super.stop();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
