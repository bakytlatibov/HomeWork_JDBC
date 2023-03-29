package com.peaksoft;

public class Mayor {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private  String mayorofthecity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMayorofthecity() {
        return mayorofthecity;
    }

    public void setMayorofthecity(String mayorofthecity) {
        this.mayorofthecity = mayorofthecity;
    }

    @Override
    public String toString() {
        return "Mayor{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", mayorofthecity='" + mayorofthecity + '\'' +
                '}';
    }
}
