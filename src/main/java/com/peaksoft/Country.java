package com.peaksoft;

public class Country {
    private int i;
    private  String name;
    private String founded;
    private String capital;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "i=" + i +
                ", name='" + name + '\'' +
                ", founded='" + founded + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
