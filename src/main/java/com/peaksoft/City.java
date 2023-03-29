package com.peaksoft;

import java.sql.Date;

public class City {
    private int id;
    private String name;
    private String founded;
    private Double total_are;
    private  String mayorOfTHeCity;

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public Double getTotal_are() {
        return total_are;
    }

    public void setTotal_are(Double total_are) {
        this.total_are = total_are;
    }

    public String getMayorOfTHeCity(String mayorOfTHeCity) {
        return this.mayorOfTHeCity;
    }

    public void setMayorOfTHeCity(String mayorOfTHeCity) {
        this.mayorOfTHeCity = mayorOfTHeCity;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", founded='" + founded + '\'' +
                ", total_are=" + total_are +
                ", mayorOfTHeCity='" + mayorOfTHeCity + '\'' +
                '}';
    }
}
