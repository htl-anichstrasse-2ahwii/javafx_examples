package application;

import java.lang.reflect.Field;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ex21_Charts extends Application {
	
	/**
	 * taken from: https://stackoverflow.com/questions/26854301/how-to-control-the-javafx-tooltips-delay?rq=1
	 * This method modifies private properties within the Tooltip object
	 * @param tooltip the tooltip where the modifications have to be applied on
	 */
	private void hackTooltipStartTiming(Tooltip tooltip)  {
	    try
	    {
	        Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
	        fieldBehavior.setAccessible(true);
	        Object objBehavior = fieldBehavior.get(tooltip);

	        Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
	        fieldTimer.setAccessible(true);
	        Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);
	        objTimer.getKeyFrames().clear();
	        objTimer.getKeyFrames().add(new KeyFrame(new Duration(0)));
	    } catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	@Override
	public void start(Stage primaryStage) {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Jahr");

		final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
		lineChart.setTitle("Verbreitung Minions");

		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("Anzahl neuer Minions");
		series.getData().add(new XYChart.Data<String, Number>("2011", 15));
		series.getData().add(new XYChart.Data<String, Number>("2012", 21));
		series.getData().add(new XYChart.Data<String, Number>("2013", 23));
		series.getData().add(new XYChart.Data<String, Number>("2014", 17));
		series.getData().add(new XYChart.Data<String, Number>("2015", 27));
		series.getData().add(new XYChart.Data<String, Number>("2016", 33));
		lineChart.getData().add(series);

		
		//hide x-Axis labels
		xAxis.setTickLabelsVisible(false);
		xAxis.setTickMarkVisible(false);
		
		//show tooltips on nodes
		for (Series<String, Number> d : lineChart.getData()) {
			for (Data<String, Number> data : d.getData()) {
				Tooltip tooltip = new Tooltip();

				tooltip.setText(data.getXValue() + " - " +  data.getYValue().toString());
				hackTooltipStartTiming(tooltip);
				Tooltip.install(data.getNode(), tooltip);
			}
		}

		
		
		BorderPane root = new BorderPane();
		root.setCenter(lineChart);
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add("application/application.css");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
