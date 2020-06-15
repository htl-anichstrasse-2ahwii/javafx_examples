package application;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Ein kleines Beispiel, wie man die Anzeige von einzelnen Elementen fuer eine
 * ListView selbst definiert. Hier wurden einfache Bilder verwendet, es ist aber
 * auch möglich, komplette eigene Klassen in der Listview zu speichern und die
 * Anzeige individuell anzupassen
 * 
 * @author albert
 *
 */
public class Ex22_ListViewImages extends Application {

	// Hole Bilder vom Verzeichnis images/icons
	File[] images = getResourceFolderFiles("images/icons");

	/**
	 * Hole alle Dateien vom Klassenpfad aus einem bestimmten Verzeichnis
	 * 
	 * @param folder Das Verzeichnis das durchsucht werden soll
	 * @return Alle Dateien als File-Objekte
	 */
	private static File[] getResourceFolderFiles(String folder) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource(folder);
		String path = url.getPath();
		return new File(path).listFiles();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Wir speichern jetzt keine Strings, sondern Bilder
		ListView<Image> listView = new ListView<Image>();
		ObservableList<Image> items = FXCollections.observableArrayList();

		// Lege alle Bilder in der Listview ab
		for (File file : images) {
			Image im = new Image(file.toURI().toURL().toExternalForm());
			items.add(im);
		}

		listView.setItems(items);

		// Hier wird die Darstellung festgelegt
		listView.setCellFactory(new Callback<ListView<Image>, ListCell<Image>>() {

			@Override
			public ListCell<Image> call(ListView<Image> list) {
				ListCell<Image> cell = new ListCell<Image>() {
					@Override
					public void updateItem(Image item, boolean empty) {
						super.updateItem(item, empty);
						setGraphic(new ImageView(item));

					}
				};

				return cell;
			}
		});

		VBox box = new VBox(listView);
		box.setAlignment(Pos.CENTER);
		Scene scene = new Scene(box, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
