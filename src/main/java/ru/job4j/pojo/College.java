package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {

        Student student = new Student();
        student.setFullName("Ivan Petrov");
        student.setGroup("Group 101");
        student.setEnrollmentDate(LocalDate.of(2021, 9, 1));

        System.out.println("Student Information:");
        System.out.println("Full Name: " + student.getFullName());
        System.out.println("Group: " + student.getGroup());
        System.out.println("Enrollment Date: " + student.getEnrollmentDate());
    }
}