package com.example.back_t2.bd;

import com.example.back_t2.bd.Administrator;
import com.example.back_t2.bd.Student;
import com.example.back_t2.bd.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager_teacher {

    private static Connection connection;

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teachers?useUnicode=true&serverTimezone=UTC", "root", "");

            System.out.println("Connected to database");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean addTeacher(Teacher teacher){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO teachers (id, teacher.name, surname, age, experience, email, password)" +
                    "VALUES (NULL, ?, ?, ?, ?)" +
                    "");

            statement.setString(1, teacher.getName());
            statement.setString(2, teacher.getSurname());
            statement.setInt(3, teacher.getAge());
            statement.setDouble(4, teacher.getExperience());
            statement.setString(5, teacher.getEmail());
            statement.setString(6, teacher.getPassword());
            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Teacher> getTeachers(){

        ArrayList<Teacher> teachers = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Teacher teacher=new Teacher();
                teacher.setId(resultSet.getLong("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSurname(resultSet.getString("surname"));
                teacher.setAge(resultSet.getInt("age"));
                teacher.setExperience(resultSet.getInt("experience"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setPassword(resultSet.getString("password"));
                teachers.add(teacher);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return teachers;
    }

    public static Teacher getTeacher(Long id){

        Teacher teacher = null;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * " +
                    "FROM teachers WHERE id = ? LIMIT 1");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                teacher = new Teacher();
                teacher.setId(resultSet.getLong("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSurname(resultSet.getString("surname"));
                teacher.setAge(resultSet.getInt("age"));
                teacher.setExperience(resultSet.getInt("experience"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setPassword(resultSet.getString("password"));
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return teacher;
    }

    public  static Teacher getTeacher(String email){
        Teacher teacher = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                teacher=new Teacher();
                teacher.setId(resultSet.getLong("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSurname(resultSet.getString("surname"));
                teacher.setAge(resultSet.getInt("age"));
                teacher.setExperience(resultSet.getInt("experience"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setPassword(resultSet.getString("password"));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return teacher;
    }

    public static boolean saveTeacher(Teacher teacher){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    " UPDATE students SET name=?, surname=?, age=?, experience=?, email=?, password=? " +
                    " WHERE id=? " +
                    "");

            statement.setString(1, teacher.getName());
            statement.setString(2, teacher.getSurname());
            statement.setInt(3, teacher.getAge());
            statement.setDouble(4, teacher.getExperience());
            statement.setString(5, teacher.getEmail());
            statement.setString(6, teacher.getPassword());
            statement.setLong(7, teacher.getId());


            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }


    public static ArrayList<Teacher> getTeachersMaxAge(){

        ArrayList<Teacher> teachers = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers ORDER BY age DESC");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                teachers.add(new Teacher(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("experience"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return teachers;
    }
    public static ArrayList<Teacher> getTeachersMaxExperience(){

        ArrayList<Teacher> teachers = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM teachers ORDER BY experience DESC");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                teachers.add(new Teacher(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("experience"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return teachers;
    }

}
