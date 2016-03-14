package com.example.kiran.testdemo;

/**
 * Created by kiran on 3/10/2016.
 */
public class City {
    String name;
    String car;
    String train;
    double latitude;
    double longitude;
    int id;
    public City(String name,String car,String train,double latitude,double longitude,int id){
        this.name = name;
        this.car = car;
        this.train = train;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
    }
    public  City(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
