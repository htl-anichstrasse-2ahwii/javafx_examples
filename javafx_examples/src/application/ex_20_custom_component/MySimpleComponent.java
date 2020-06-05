package application.ex_20_custom_component;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MySimpleComponent extends VBox{
	Button b1 = new Button("b1");
	Button b2 = new Button("b2");
	public MySimpleComponent() {
		super(); //Diesmal ist dieser Aufruf wichtig, da hier die VBox erzeugt wird
		this.getChildren().addAll(b1, b2);
	}
}
