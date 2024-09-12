package controller;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import model.Car;

public class DBConnection {

    public boolean insertNewCar(Car car) {
    boolean result = false;
    Connection connection = null;
    try {
        // เชื่อมต่อฐานข้อมูล
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/faxtery_car",
                "root", "0857389154");

        Statement statement;
        statement = connection.createStatement();

        // สร้างคำสั่ง SQL สำหรับการเพิ่มข้อมูล
        String query = "INSERT INTO car "
            + "(name, type, size, color, price) "
            + "VALUES('" + car.getName() + "', '"
            + car.gettype() + "', '"
            + car.getsize() + "', '"
            + car.getcolor() + "', "
            + car.getPrice() + ")";
        System.out.println("........SQL: " + query);

        // ดำเนินการคำสั่ง SQL
        int i = statement.executeUpdate(query);  // executeUpdate returns row count
        if (i != 0) {
            result = true;
        }
        statement.close();
        connection.close();
    } catch (Exception exception) {
        System.out.println(exception);
    }

    return result;
}


    /*
    https://www.geeksforgeeks.org/java-database-connectivity-with-mysql/
     */
    public void testRetrieve() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/faxtery_car",
                    "root", "0857389154");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "SELECT name, type, size, color, price FROM car");
            String name;
            String type;
            String size;
            String color;
            String  price;
            while (resultSet.next()) {
            name = resultSet.getString("name").trim();
            type = resultSet.getString("type").trim();
            size = resultSet.getString("size").trim();
            color = resultSet.getString("color").trim();
            price = resultSet.getString("price");

            // พิมพ์ค่าที่เก็บในตัวแปร
            System.out.println("name: " + name);
            System.out.println("type: " + type);
            System.out.println("size: " + size);
            System.out.println("color: " + color);
            System.out.println("price: " + price);
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception exception) {
        System.out.println(exception);
    }
}
}
