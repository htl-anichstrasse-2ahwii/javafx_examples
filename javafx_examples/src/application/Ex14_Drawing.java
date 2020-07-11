package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Dieses Beispiel soll zeigen, wie man mit JavaFX zeichnen kann. Von einfachen
 * Linien, geometrischen Objekten bis zum Einbinden von Bildern ist alles
 * moeglich.
 * 
 * Es ist natuerlich moeglich, dass die Zeichenflaeche (Canvas) nicht wie in
 * diesem Beispiel das komplette Fenster ausfuellt, sondern nur Teile. Das
 * Canvas-Element kann man naemlich gleich wie jedes Steuerelement einfach auf
 * der Seite positionieren
 */
public class Ex14_Drawing extends Application implements EventHandler<MouseEvent> {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Canvas canvas = new Canvas(1000, 600); // Eine Zeichenflaeche wird erzeugt
		canvas.setOnMouseClicked(this);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN); // Es muss immer eine Fuellfarbe gesetzt werden, bevor eine fill-Funktion
									// verwendet wird
		gc.fillRect(100, 100, 100, 100); // x,y,w,h

		gc.setFill(Color.RED);
		gc.fillRect(150, 150, 100, 100);

		gc.fillOval(300, 300, 100, 100); //// x,y,w,h w = h => Kreis

		gc.setLineWidth(3); // Einstellen der Stiftdicke
		gc.setStroke(Color.BLUE); // Einstellen der Zeichenfarbe
		gc.strokeOval(500, 300, 50, 40); // Hier wird nur gezeichnet, nicht ausgefuellt

		// Zeichne ein Bild an die enstprechende Stelle
		gc.drawImage(new Image("images/bart.png"), 500, 300);

		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root, 1000, 600));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(MouseEvent event) {
		System.out.println(String.format("%.1f %.1f", event.getX(), event.getY()));
		
	}
}
