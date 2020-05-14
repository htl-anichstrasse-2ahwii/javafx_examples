package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Es gibt auch die Moeglichkeit, Buttons einen gedrueckt bzw. nicht-gedrueckt
 * Zustand zuzuweisen. Dieser spezielle Button ist ein ToggleButton
 * 
 * Weiters soll gezeigt werden, wie man aus einer Bildersammlung einzelne Teile herausliest und fuer die Imageviews verwendet
 */
public class Ex05_2_SwitchBetweenButtons extends Application {
	private Label feedback;
	//Konstanten die verwendet werden, das icon aus dem Gesamtbild herauszuholen
	private final int Y_LINE = 110;
	private final int X_PADDING = 4;
	private final int WIDTH = 55;
	//Hier sind alle Buttons der Reihe nach aufgelistet. Das wird verwendet, um die Buttons rechnerisch herauszuholen
	//Weil auch bei einem enum stecken Zahlen dahinter: PLAY = 0, PAUSE = 1, STOP = 2 ....
	enum BUTTONS {PLAY, PAUSE, STOP, FORWARD, BACK, REPLAY, SHUFFLE, SOUND, MUTE}
	private ImageView[] imageViews; //Hier werden alle Bildansichten gespeichert um schnell umschalten zu koennen
	private boolean playOn = false; //wird aktuell gerade gespielt oder nicht
	
	/**
	 * Hier werden die einzelnen Ansichten erzeugt
	 */
	private void generateImageViews()
	{
		Image playImg = new Image("images/player.png");
		imageViews = new ImageView[BUTTONS.values().length];
		int i = 0;
		for (BUTTONS b : BUTTONS.values())
		{
			ImageView imageView = new ImageView(playImg);
			imageView.setFitWidth(WIDTH);
			imageView.setFitHeight(WIDTH);
			imageView.setViewport(new Rectangle2D(X_PADDING + WIDTH*b.ordinal(), Y_LINE, WIDTH,WIDTH));
			imageViews[i++] = imageView;
		}
	}
	
	/**
	 * Hole die aktuelle Bildansicht (fuer die Zuweisung auf den Buttons)
	 * Beispielaufruf: getIV(BUTTONS.STOP)
	 */
	private ImageView getIV(BUTTONS b)
	{
		return imageViews[b.ordinal()];
	}
	
	@Override
	public void start(Stage primaryStage) {
		generateImageViews();
		
		BorderPane root = new BorderPane();
		HBox center = new HBox();
		
		Button back = new Button();	
		back.setGraphic(getIV(BUTTONS.BACK)); //setze den back-Button
		back.setOnAction((ActionEvent e) -> {
		    feedback.setText("back");
		});
		center.getChildren().add(back);
		
		Button play = new Button();	
		play.setGraphic(getIV(BUTTONS.PLAY)); 
		play.setOnAction((ActionEvent e) -> {
			if (playOn)
			{
				play.setGraphic(getIV(BUTTONS.PLAY));
				feedback.setText("pause");
			} else
			{
				play.setGraphic(getIV(BUTTONS.PAUSE));
				feedback.setText("play");
				
			}
			playOn = !playOn;
		    
		});
		center.getChildren().add(play);

		Button stop = new Button();	
		stop.setGraphic(getIV(BUTTONS.STOP));
		stop.setOnAction((ActionEvent e) -> {
			play.setGraphic(getIV(BUTTONS.PLAY));
			playOn = false;
		    feedback.setText("stop");
		});
		center.getChildren().add(stop);
		
		Button forward = new Button();	
		forward.setGraphic(getIV(BUTTONS.FORWARD));
		forward.setOnAction((ActionEvent e) -> {
		    feedback.setText("forward");
		});
		center.getChildren().add(forward);
		
		root.setCenter(center);

		feedback = new Label("Hier wird der Status angezeigt");
		root.setBottom(feedback);
		
		Scene scene = new Scene(root, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
