package com.example.back_t2.bd;

public class Teacher {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private double experience;
    private String email;
    private String password;

    public Teacher() {
    }

    public Teacher(Long id, String name, String surname, int age, double experience, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
        this.email = email;
        this.password = password;
    }

    public Teacher(long id, String name, String surname, int age, double experience, String email, String password) {
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

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
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


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
