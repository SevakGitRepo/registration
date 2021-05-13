package com.sevak.registration.model;

public class User {

    private String name; //Metsatar + 3<x<20
    private String surname; //Metsatar + 3<x<30
    private String email; //valid
    private int age; //18<100
    private String password; //8< <20

    public User(String name, String surname, String email, int age, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
