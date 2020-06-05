package application.ex_20_custom_component;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * example borrowed from: https://panjutorials.de/tutorials/javafx-8-gui/lektionen/line-chart-in-javafx/?content-item-only=yes
 * Alternative wäre, dass hier gleich von <i>LineChart</i> geerbt wird
 */
public class MyCharts extends AnchorPane {
	public MyCharts() {
		super();
		
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
		
		this.getChildren().add(lineChart);
	}
}
