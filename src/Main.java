import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/barGraphView.fxml"));

        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("/Views/crimes.png"));
        stage.setTitle("CrimeRecords");
        scene.getStylesheets().add("stylesheet.css");
        stage.setScene(scene);
        stage.show();
    }
}