/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import Spark.Car;
import java.sql.*;

public class DBConnection {
    private final String url="jdbc:mysql://localhost:3306/projectcar";
    private final String user ="root";
    private final String password ="";
            
    public boolean insertNewCar(Car car){
        boolean result = false;
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
                        
            String query = "INSERT INTO car (name, email, carType, carColor, paymentType, carPrice) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getEmail());
            preparedStatement.setString(3, car.getCarType());
            preparedStatement.setString(4, car.getCarColor());
            preparedStatement.setString(5, car.getPaymentType());
            preparedStatement.setString(6, car.getCarPrice());

            System.out.println(". . . . . . .SQL: " + preparedStatement);

            int i = preparedStatement.executeUpdate();
            if(i != 0){
                result = true;
            }
            preparedStatement.close();
            connection.close();
            
        } catch (Exception exception) {
            System.out.println(">>>Exception: " + exception.getMessage());
            exception.printStackTrace();
        }
        return result;  
    }
}
