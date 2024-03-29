/*
 * TANUPREET KAUR
 * 200440642
 * SQL SOURCE - https://www150.statcan.gc.ca/n1/pub/71-607-x/71-607-x2018008-eng.htm
 * */
package Controllers;

import Models.CrimeRecords;
import Utilities.DBUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableView<CrimeRecords> table;

    @FXML
    private TableColumn<CrimeRecords, Integer> id;

    @FXML
    private TableColumn<CrimeRecords, Integer> year;

    @FXML
    private TableColumn<CrimeRecords, String> region;

    @FXML
    private TableColumn<CrimeRecords, String> crimeType;

    @FXML
    private TableColumn<CrimeRecords, Integer> value;

    @FXML
    private Button switchView;

    @FXML
    void changeToBarGraph(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Views/barGraphView.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        Scene tableViewScene = new Scene(root);
        tableViewScene.getStylesheets().add("Views/stylesheet.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }



    private DBUtility db;
    private ObservableList<CrimeRecords> records=FXCollections.observableArrayList();

    public void insertTable() throws SQLException {
        db=new DBUtility();
        CrimeRecords c;
        for(int i=0;i<db.getAllCrimeRecordsFromDB().size();i++){
            c=new CrimeRecords(db.getIdAllCrimeRecordsFromDB().get(i).getId(),db.getIdAllCrimeRecordsFromDB().get(i).getYear(),
                    db.getIdAllCrimeRecordsFromDB().get(i).getRegion(),
                    db.getIdAllCrimeRecordsFromDB().get(i).getCrimeType(),
                    db.getIdAllCrimeRecordsFromDB().get(i).getValue());
                    records.add(c);
        }
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            insertTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        crimeType.setCellValueFactory(new PropertyValueFactory<>("crimeType"));
        value.setCellValueFactory(new PropertyValueFactory<>("value"));
        table.setItems(records);
    }




}
