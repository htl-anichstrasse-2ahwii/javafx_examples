package application.ex25_simple_game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SimpleGame extends Application {
	private int player_x = 400;
	private int player_y = 200;
	private final int SPEED = 10;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Canvas Example");

		Group root = new Group();
		Scene theScene = new Scene(root);
		primaryStage.setScene(theScene);

		Canvas canvas = new Canvas(800, 400);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
		gc.setFont(theFont);
		gc.fillText("the First game!", 60, 50);
		gc.strokeText("the First game!", 60, 50);

		Image player = new Image("images/bart_small.png");
		Image back = new Image("images/back.jpg");
		Image eyes = new Image("images/eyes.png");
		gc.drawImage(eyes, 180, 100);

		final long startNanoTime = System.nanoTime();

		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				double t = (currentNanoTime - startNanoTime) / 1000000000.0;
				System.out.println(t);
				double x = (int) (Math.random() * 10) + 232 + 128 * Math.cos(t);
				double y = 232 + 128 * Math.sin(t);

				// background image clears canvas
				gc.drawImage(back, 0, 0);
				gc.drawImage(eyes, x, y);
				gc.drawImage(player, player_x, player_y);
			}

		}.start();

		theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				KeyCode code = e.getCode();
				switch (code) {
				case LEFT:
					player_x -= SPEED;
					break;
				case RIGHT:
					player_x += SPEED;
					break;
				case UP:
					player_y -= SPEED;
					break;
				case DOWN:
					player_y += SPEED;
				default:
				}
			}
		});

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
