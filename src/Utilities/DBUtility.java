/*
* TANUPREET KAUR
* 200440642
* SQL SOURCE - https://www150.statcan.gc.ca/n1/pub/71-607-x/71-607-x2018008-eng.htm
* */

package Utilities;

import Models.CrimeRecords;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "root";
    private static String password = "";



    public ArrayList<CrimeRecords> getAllCrimeRecordsFromDB() throws SQLException {
        ArrayList<CrimeRecords> crimeRecords = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime",
                    user, password);
            //2. Create a sql statement
            statement = conn.createStatement();

            //3.  execute the SQL statement and capture results in the resultSet
            resultSet = statement.executeQuery("SELECT * FROM crimeRecord");

            //4. loop over the result set and create patient objects
            while(resultSet.next())
            {
                CrimeRecords newCrimeRecords = new CrimeRecords(
                        resultSet.getInt("year"),

                        resultSet.getString("region"),
                        resultSet.getString("crimeType"),
                        resultSet.getInt("value")
                );
                crimeRecords.add(newCrimeRecords);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
            return crimeRecords;
        }

    }
    public ArrayList<CrimeRecords> getIdAllCrimeRecordsFromDB() throws SQLException {
        ArrayList<CrimeRecords> crimeRecords = new ArrayList<>();

        //1.define connection, preparedStatement
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1. connect to the DB
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime",
                    user, password);
            //2. Create a sql statement
            statement = conn.createStatement();

            //3.  execute the SQL statement and capture results in the resultSet
            resultSet = statement.executeQuery("SELECT * FROM crimeRecord");

            //4. loop over the result set and create patient objects
            while(resultSet.next())
            {
                CrimeRecords newCrimeRecords = new CrimeRecords(
                        resultSet.getInt("id"),
                        resultSet.getInt("year"),

                        resultSet.getString("region"),
                        resultSet.getString("crimeType"),
                        resultSet.getInt("value")
                );
                crimeRecords.add(newCrimeRecords);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
            return crimeRecords;
        }

    }

}