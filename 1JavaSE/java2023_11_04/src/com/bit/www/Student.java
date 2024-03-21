package com.bit.www;

public class Student {
    private String name;
    private String classroom;
    private int age;

    public Student(String name, String classroom, int age) {
        this.name = name;
        this.classroom = classroom;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static void Fun() {
        System.out.println("FUN");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classroom='" + classroom + '\'' +
                ", age=" + age +
                '}';
    }
}
