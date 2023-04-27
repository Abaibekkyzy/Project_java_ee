package com.example.back_t2.bd;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private double GPA;
    private String email;
    private String password;
    private int points;
    private int attempts;

    public Student(Long id, String name, String surname, int age, double GPA, String email, String password, int points) {
    }

    public Student(Long id, String name, String surname, int age, double GPA, String email, String password, int points, int attempts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.GPA = GPA;
        this.email = email;
        this.password = password;
        this.points = points;
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Student(long id, String name, String surname, int age, double gpa, String email, String password, int points) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
