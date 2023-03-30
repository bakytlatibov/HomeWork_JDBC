package com.peaksoft;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

//        for (City city : getCities()) {
//            System.out.println(city);
//
//        }
//        for (Country country : getCountries()) {
//            System.out.println(country);
//        }
//
//        for (Mayor mayor : getMayors()) {
//            System.out.println(mayor);
//
//        }

        printCity(2);

    }

    public static void creatTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS cities(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "founded DATE NOT NULL," +
                "total_area REAL," +
                "mayorOfTheCity VARCHAR(50));";

        try (Connection connection = DB.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCities(String name, String founded, Double total_area, String mayorOfTHeCity) {
        String SQL = "INSERT INTO cities (name,founded,total_area,mayorOfTheCity)" +
                "VALUES (?,?,?,?)";
        try (Connection connection = DB.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setDate(2, Date.valueOf(founded));
            statement.setDouble(3, total_area);
            statement.setString(4, mayorOfTHeCity);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createCounty() {
        String SQL = "CREATE TABLE IF NOT EXISTS countries(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "founded Varchar NOT NULL," +
                "capital VARCHAR(50));";

        try (Connection connection = DB.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCountry(String name, String founded, String capital) {
        String SQl = "INSERT INTO countries(name,founded,capital)" +
                "VALUES (?,?,?)";

        try (Connection connection = DB.connection();
             PreparedStatement statement = connection.prepareStatement(SQl)) {
            statement.setString(1, name);
            statement.setString(2, founded);
            statement.setString(3, capital);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createMayor() {
        String SQL = "CREATE TABLE IF NOT EXISTS mayor(" +
                "id  SERIAL PRIMARY KEY ," +
                "first_name VARCHAR NOT NULL," +
                "last_name VARCHAR NOT NULL," +
                "age INTEGER NOT NULL," +
                "mayorOfTheCity VARCHAR NOT NULL);";
        try (Connection connection = DB.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addMayor(String first_name, String last_name, int age, String mayorOfTheCity) {
        String SQL = "INSERT INTO mayor(first_name,last_name,age,mayorOFTheCity)" + "VALUES(?,?,?,?)";

        try (Connection connection = DB.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setInt(3, age);
            statement.setString(4, mayorOfTheCity);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<City> getCities() {
        String SQL = "SELECT * FROM cities";
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = DB.connection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setFounded(String.valueOf(resultSet.getDate("founded")));
                city.setTotal_are(resultSet.getDouble("total_area"));
                city.setMayorOfTHeCity(resultSet.getString("mayorofthecity"));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }

    public static List<Country> getCountries() {
        String SQL = "SELECT * FROM countries";
        List<Country> countries = new ArrayList<>();
        try (
                Connection connection = DB.connection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Country country = new Country();
                country.setI(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setFounded(resultSet.getString("founded"));
                country.setCapital(resultSet.getString("capital"));
                countries.add(country);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countries;
    }

    public static List<Mayor> getMayors() {
        String SQL = "SELECT * FROM mayor";
        List<Mayor> mayors = new ArrayList<>();
        try (Connection connection = DB.connection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Mayor mayor = new Mayor();
                mayor.setId(resultSet.getInt("id"));
                mayor.setFirst_name(resultSet.getString("first_name"));
                mayor.setLast_name(resultSet.getString("last_name"));
                mayor.setMayorofthecity(resultSet.getString("mayorofthecity"));
                mayors.add(mayor);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mayors;
    }

    public static void printCity(int id) {
        String SQL = "SELECT * FROM cities WHERE id=?";
        try (Connection conn = DB.connection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            System.out.println(
                    rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getDate("founded") + " " +
                            rs.getDouble("total_area") + " " +
                            rs.getString("mayorofthecity"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}


