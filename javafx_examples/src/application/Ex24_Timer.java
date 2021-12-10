package application;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Diese Anwendung zeigt, wie man es schafft dass nach dem Clicken eines 
 * Buttons eine Sekunde gewartet wird, bis eine weitere Aktion gesetzt wird.
 * @author albert
 *
 */
public class Ex24_Timer extends Application implements EventHandler<ActionEvent> {

	Button b;

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		b = new Button("Please press");
		b.setOnAction(this);
		root.setCenter(b);
		Scene scene = new Scene(root, 300, 275);
		stage.setTitle("Usage of a Timer");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent arg0) {
		class MyTimerTask extends TimerTask {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					//Diese Methode wird nach einer Sekunde aufgerufen
					@Override
					public void run() {
						b.setText("After 1 second");

					}
				});

			}

		}
		b.setText("Pressed");
		Timer t = new Timer();
		t.schedule(new MyTimerTask(), 1000); //registriere den obigen Task, Aufruf nach 1000ms
	}

}
