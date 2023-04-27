package com.example.back_t2.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_bd?useUnicode=true&serverTimezone=UTC", "root", "");

            System.out.println("Connected to database");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean addStudent(Student student){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "INSERT INTO students (id, students.name, surname, age, GPA, email, password, points, attempts) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)" +
                    "");

            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setDouble(4, student.getGPA());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.getPassword());
            statement.setInt(7, student.getPoints());
            statement.setInt(8, student.getAttempts());
            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Student> getStudents(){

        ArrayList<Student> students = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("GPA"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("points"),
                        resultSet.getInt("attempts")
                ));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static Student getStudent(Long id){

        Student student = null;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "SELECT * " +
                    "FROM students WHERE id = ? LIMIT 1");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                student = new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("GPA"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("points"),
                        resultSet.getInt("attempts")
                );
            }


            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
    public static ArrayList<Student> getStudentsMaxAge(){

        ArrayList<Student> students = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students ORDER BY age DESC");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                students.add(new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("GPA"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("points"),
                        resultSet.getInt("attempts")
                ));

            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static ArrayList<Student> getStudentsMaxGpa(){

        ArrayList<Student> students = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students ORDER BY GPA DESC");

            ResultSet resultSet = statement.executeQuery();


            while(resultSet.next()){
                students.add(new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("GPA"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("points"),
                        resultSet.getInt("attempts")
                ));
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }


    public static boolean saveStudent(Student student){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    " UPDATE students SET name=?, surname=?, age=?, GPA=?, email=?, password=?, points=?, attempts=? " +
                    " WHERE id=? " +
                    "");

            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setDouble(4, student.getGPA());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.getPassword());
            statement.setInt(7, student.getPoints());
            statement.setInt(8, student.getAttempts());
            statement.setLong(9, student.getId());


            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean deleteStudent(Student student){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    "DELETE FROM students WHERE id=? ");

            statement.setLong(1, student.getId());

            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public  static Student getStudent(String email){
        Student student = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = new Student(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("GPA"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getInt("points"),
                        resultSet.getInt("attempts")
                );

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }


    public static ArrayList<Test> getTests(){
        ArrayList<Test> tests = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM test_student");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                tests.add(new Test(
                        resultSet.getLong("id"),
                        resultSet.getString("answer1"),
                        resultSet.getString("answer2"),
                        resultSet.getString("answer3"),
                        resultSet.getString("answer4"),
                        resultSet.getString("answer5"),
                        resultSet.getString("answer6"),
                        resultSet.getString("answer7"),
                        resultSet.getString("answer8")
                ));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tests;
    }


    public static boolean addStudentAnswers(StudentAnswers studentAnswer){
        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO student_answers (id, email, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8 ) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ? )" +
                    "");

            statement.setString(1, studentAnswer.getEmail());
            statement.setString(2, studentAnswer.getAnswer1());
            statement.setString(3, studentAnswer.getAnswer2());
            statement.setString(4, studentAnswer.getAnswer3());
            statement.setString(5, studentAnswer.getAnswer4());
            statement.setString(6, studentAnswer.getAnswer5());
            statement.setString(7, studentAnswer.getAnswer6());
            statement.setString(8, studentAnswer.getAnswer7());
            statement.setString(9, studentAnswer.getAnswer8());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }


    public static StudentAnswers getStudentAnswers(String email){
        StudentAnswers studentAnswers = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM student_answers WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                studentAnswers = new StudentAnswers(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("answer1"),
                        resultSet.getString("answer2"),
                        resultSet.getString("answer3"),
                        resultSet.getString("answer4"),
                        resultSet.getString("answer5"),
                        resultSet.getString("answer6"),
                        resultSet.getString("answer7"),
                        resultSet.getString("answer8")
                );

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentAnswers;
    }


    public static ArrayList<StudentAnswers> getStudentAnswers(){
        ArrayList<StudentAnswers> studentAnswers = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM student_answers");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                studentAnswers.add(new StudentAnswers(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("answer1"),
                        resultSet.getString("answer2"),
                        resultSet.getString("answer3"),
                        resultSet.getString("answer4"),
                        resultSet.getString("answer5"),
                        resultSet.getString("answer6"),
                        resultSet.getString("answer7"),
                        resultSet.getString("answer8")
                ));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentAnswers;
    }



    public static boolean updateStudents(Student student){
        int rows = 0;
        try{
            PreparedStatement statement = connection.prepareStatement(""+
                    " UPDATE students SET name=?, surname=?, age=?, GPA=?, email=?, password=? , points = ?" +
                    " WHERE id=? " +
                    "");

            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setDouble(4, student.getGPA());
            statement.setString(5, student.getEmail());
            statement.setString(6, student.getPassword());
            statement.setInt(7, student.getPoints());
            statement.setLong(8, student.getId());


            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static Test getTest(Long id){
        Test test = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM test_student WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                test = new Test(
                        resultSet.getLong("id"),
                        resultSet.getString("answer1"),
                        resultSet.getString("answer2"),
                        resultSet.getString("answer3"),
                        resultSet.getString("answer4"),
                        resultSet.getString("answer5"),
                        resultSet.getString("answer6"),
                        resultSet.getString("answer7"),
                        resultSet.getString("answer8")
                );

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return test;
    }


}
