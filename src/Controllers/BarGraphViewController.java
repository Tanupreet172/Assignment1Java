package Controllers;

import Utilities.DBUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BarGraphViewController implements Initializable {


    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private CategoryAxis provinces;

    @FXML
    private NumberAxis numberOfCases;

    private XYChart.Series records;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        records = new XYChart.Series();
        records.setName("Records");
        DBUtility db=new DBUtility();

        try {
            for(int i=0;i<db.getAllCrimeRecordsFromDB().size();i++){
                records.getData().addAll(new XYChart.Data(db.getAllCrimeRecordsFromDB().get(i).getRegion(),
                        db.getAllCrimeRecordsFromDB().get(i).getValue()
                ));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        provinces.setLabel("Provinces");
        numberOfCases.setLabel("numberOfCases");

            barChart.getData().addAll(records);

    }
}
