package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ex21_Charts_multiplelines extends Application implements ChangeListener<String> {

	LineChart<String, Number> lineChart;

	private double[] rnd(int cnt, int upper) {
		double[] na = new double[cnt];
		for (int i = 0; i < na.length; i++) {
			na[i] = Math.random() * upper;
		}
		return na;
	}

	@Override
	public void start(Stage primaryStage) {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Jahr");

		lineChart = new LineChart<String, Number>(xAxis, yAxis);
		lineChart.setTitle("Bevölkerungsverteilung");

		xAxis.setTickLabelsVisible(true);
		xAxis.setTickMarkVisible(true);

		BorderPane root = new BorderPane();
		root.setCenter(lineChart);

		ListView<String> listView = new ListView<String>();
		//listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		for (int i = 0; i < 300; i++) {
			listView.getItems().add("Gemeinde " + (i + 1));
		}

		listView.getSelectionModel().selectedItemProperty().addListener(this);
		root.setLeft(listView);

		Button clear = new Button("löschen");
		clear.setOnAction((ActionEvent e) -> {
			lineChart.getData().clear();
		});
		root.setTop(clear);
		Scene scene = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
		scene.getStylesheets().add("application/application.css");
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		
		series.setName(newValue);
		double[] z1 = rnd(20, 1000);
		for (int i = 0; i < z1.length; i++) {
			series.getData().add(new XYChart.Data<String, Number>(i + 2000 + "", z1[i]));
		}
		lineChart.getData().add(series);
	}
}
