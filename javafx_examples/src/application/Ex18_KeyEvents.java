package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Ein Beispiel wie man auf Tastendruck reagiert, hier im Fall einer
 * Zeichenflaeche, wo ein Rechteck die Position, Groesse und Farbe aendert
 *
 */
public class Ex18_KeyEvents extends Application {

	private GraphicsContext gc; // Wird benoetigt um neu zu zeichnen
	private int x = 450;
	private int y = 250;
	private int speed = 20;
	private int size = 50;

	private void drawRect() {
		gc.fillRect(x, y, size, size);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Canvas canvas = new Canvas(1000, 600);
			gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.RED);
			drawRect();
			root.setCenter(canvas);
			Scene scene = new Scene(root, 1000, 600);
			scene.setOnKeyPressed(e -> {
				gc.clearRect(x, y, size, size);
				System.out.println("xx");
				KeyCode code = e.getCode();
				switch (code) {
				case LEFT: // vom Typ KeyCode, also eigentlich KeyCode.LEFT
					x -= speed;
					break;
				case RIGHT:
					x += speed;
					break;
				case UP: // vom Typ KeyCode, also eigentlich KeyCode.LEFT
					y -= speed;
					break;
				case DOWN:
					y += speed;
					break;
				case C:  //Beim Druecken von c  wird eine zufaellige Farbe gesetzt
					Color rand = new Color(Math.random(), Math.random(), Math.random(), 1); // Erzeuge zufälligen
					gc.setFill(rand);
					break;
				case PAGE_UP:
					size += 10;
					break;
				case PAGE_DOWN:
					size -= 10;
					y += speed;
					break;
				default: // alle anderen Tasten
					break;
				}
				drawRect();
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
