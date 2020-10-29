package Models;

import Utilities.DBUtility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrimeRecords {
    private int id,year,value;
    private String crimeType,region;

    public CrimeRecords(int year,String region,String crimeType,int value) throws SQLException {
        setYear(year);
        setCrimeType(crimeType);
        setRegion(region);
        setValue(value);

    }
    public CrimeRecords(String region,int value) throws SQLException {

        setRegion(region);
        setValue(value);

    }
    public void setId(int id){
        if(id>0)
            this.id = id;
        else
            throw new IllegalArgumentException("Id must be greater than 0");

    }

    public int getId(){

        return id;
    }
    public int getValue() {

        return value;
    }

    public void setValue(int value) {
        if(value>=0)
            this.value = value;
        else
            throw new IllegalArgumentException("Value should be a positive number");

    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        if(year == 1999 || year == 2000)
            this.year = year;
        else
            throw new IllegalArgumentException("Year must be 1999 and 2000");
    }

    public String getCrimeType() {

        return crimeType;
    }

    public void setCrimeType(String crimeType) {
        if(crimeType.isBlank())
            throw new IllegalArgumentException("Crime type should not be blank");
        else
             this.crimeType = crimeType;
    }

    public String getRegion() {

        return region;
    }
    public static List<String> getRegionList(){
        List<String> list= new ArrayList<>();
        list.add("Quebec");
        list.add("Ontario");
        list.add("British Columbia");
        list.add("Alberta");
        list.add("Canada");
        list.add("Manitoba");
        list.add("New Brunswick");
        list.add("Prince Edward Island");
        list.add("Newfoundland and Labrador");
        list.add("Yukon and Northwest Territories");
        list.add("Saskatchewan");
        list.add("Nova Scotia");
        return list;
    }


    public void setRegion(String region) {
        if(getRegionList().contains(region))
            this.region = region;
        else
            throw new IllegalArgumentException("Region must be in the region");
    }

    @Override
    public String toString() {
        return "CrimeRecord{" +
                "year=" + year +
                ", value=" + value +
                ", crimeType='" + crimeType + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}

