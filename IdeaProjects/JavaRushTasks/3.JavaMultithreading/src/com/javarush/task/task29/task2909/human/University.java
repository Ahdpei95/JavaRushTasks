package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Student getStudentWithAverageGrade(double averageMark ) {
        //TODO:
        for (Student student :
                students) {
            if (student.getAverageGrade() == averageMark)
                return student;
            //break;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
            }
        });
        return students.get(students.size() - 1);
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
            }
        });
        return students.get(0);
    }

    public void expel(Student student) {
        students.remove(student);
    }

}