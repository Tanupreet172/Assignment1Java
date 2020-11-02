/*
 * TANUPREET KAUR
 * 200440642
 * SQL SOURCE - https://www150.statcan.gc.ca/n1/pub/71-607-x/71-607-x2018008-eng.htm
 * */


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
        root.setId("pane");
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("/Views/crimes.png"));

        stage.setTitle("CrimeRecords");
        scene.getStylesheets().add("Views/stylesheet.css");
        stage.setScene(scene);
        stage.show();
    }
}