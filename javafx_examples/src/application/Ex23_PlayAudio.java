package application;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

public class Ex23_PlayAudio extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button b = new Button("Hallo");
			root.setCenter(b);

			Button b1 = new Button("Drück mich!! 1");
			b1.setOnAction((ActionEvent e) -> {
				String bip = "/home/albert/donna.mp3"; //Edit the path here
				Media hit = new Media(Paths.get(bip).toUri().toString());
		        AudioClip mediaPlayer = new AudioClip(hit.getSource());
		        mediaPlayer.play();
			});

			root.setCenter(b1);

			Scene scene = new Scene(root, 400, 400);

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
