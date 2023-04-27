package com.example.back_t2.bd;

public class Administrator {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String department;
    private String email;
    private String password;


    public Administrator() {
    }

    public Administrator(Long id, String name, String surname, int age, String department, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public Administrator(long id, String name, String surname, int age, String department, String email, String password) {
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

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
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
        return "Administrator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", experience=" + department +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
