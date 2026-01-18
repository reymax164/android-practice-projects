package com.example.studentcrudapp;

public class Student {
    private int id, age;
    private String lastName, firstName, middleName;
    private boolean isRegular;

    // constructor
    public Student(int id, String lastName, String firstName, String middleName, int age, boolean isRegular) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.isRegular = isRegular;
    }

    // toString() method
    @Override
    public String toString() {
        return "Student {\n" +
                "id=" + id +
                ",\nage=" + age +
                ",\nlastName='" + lastName + '\'' +
                ",\nfirstName='" + firstName + '\'' +
                ",\nmiddleName='" + middleName + '\'' +
                ",\nisRegular=" + isRegular +
                "\n}";
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRegular() {
        return isRegular;
    }

    public void setRegular(boolean regular) {
        isRegular = regular;
    }
}
