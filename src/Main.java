import Models.CrimeRecords;
import Utilities.DBUtility;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            //CrimeRecord c = new CrimeRecord(2000,"Manitoba","Murder",467899);
            ArrayList<CrimeRecords> crimeRecords = new ArrayList<>();
            DBUtility db = new DBUtility();
            crimeRecords=db.getAllCrimeRecordsFromDB();
            System.out.println("Year,"+"Region,"+"Type,"+"Value");
            for(int i=0;i<80;i++){
                System.out.println(crimeRecords.get(i).getYear()+"  "+crimeRecords.get(i).getRegion()+" "+crimeRecords.get(i).getCrimeType()+"  "+crimeRecords.get(i).getValue());
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}