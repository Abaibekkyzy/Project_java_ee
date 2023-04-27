package com.example.back_t2.bd;

import com.example.back_t2.bd.Administrator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager_administrator {

    private static Connection connection;

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrators_bd?useUnicode=true&serverTimezone=UTC", "root", "");

            System.out.println("Connected to database");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean addAdministrator(Administrator administrator){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO students (id, name, surname, age, dapertment, email, password)" +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?)" +
                    "");

            statement.setString(1, "name");
            statement.setString(2, "surname");
            statement.setInt(3, Integer.parseInt("age"));
            statement.setString(4, "department");
            statement.setString(5, "email");
            statement.setString(6, "password");
            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Administrator> getAdministrators(){
        ArrayList<Administrator> administrators = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    " SELECT * FROM administrators " +
                    "");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                    Administrator administrator=new Administrator();
                    administrator.setId(resultSet.getLong("id"));
                    administrator.setEmail(resultSet.getString("email"));
                    administrator.setPassword(resultSet.getString("password"));
                    administrator.setName(resultSet.getString("name"));
                    administrator.setSurname(resultSet.getString("surname"));
                    administrator.setAge(resultSet.getInt("age"));
                    administrator.setDepartment(resultSet.getString("department"));
                    administrators.add(administrator);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return administrators;
    }


    public static Administrator getAdministrator(Long id){

        Administrator administrator = null;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * " +
                    "FROM administrators WHERE id = ? LIMIT 1");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                administrator=new Administrator();
                administrator.setId(resultSet.getLong("id"));
                administrator.setEmail(resultSet.getString("email"));
                administrator.setPassword(resultSet.getString("password"));
                administrator.setName(resultSet.getString("name"));
                administrator.setSurname(resultSet.getString("surname"));
                administrator.setAge(resultSet.getInt("age"));
                administrator.setDepartment(resultSet.getString("department"));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return administrator;
    }

    public static ArrayList<Administrator> getAdministratorsMaxAge(){

        ArrayList<Administrator> administrators = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM administrators ORDER BY age DESC");

            ResultSet resultSet = statement.executeQuery();


            while(resultSet.next()){
                administrators.add(new Administrator(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("department"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return administrators;
    }

    public  static Administrator getAdministrator(String email){
        Administrator administrator = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM administrators WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                administrator=new Administrator();
                administrator.setId(resultSet.getLong("id"));
                administrator.setEmail(resultSet.getString("email"));
                administrator.setPassword(resultSet.getString("password"));
                administrator.setName(resultSet.getString("name"));
                administrator.setSurname(resultSet.getString("surname"));
                administrator.setAge(resultSet.getInt("age"));
                administrator.setDepartment(resultSet.getString("department"));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  administrator;
    }

    public static boolean saveAdministrator(Administrator administrator){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    " UPDATE administrators SET name=?, surname=?, age=?, department=?, email=?, password=? " +
                    " WHERE id=? " +
                    "");

            statement.setString(1, "name");
            statement.setString(2, "surname");
            statement.setInt(3, Integer.parseInt("age"));
            statement.setString(4, "department");
            statement.setString(5, "email");
            statement.setString(6, "password");
            statement.setLong(7, Long.parseLong("id"));

            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }


}
