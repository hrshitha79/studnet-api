package com.project.studentapi.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int std_rollno;
    String std_name;

    public Student(){}
    public Student(int std_rollno, String std_name) {
        this.std_rollno = std_rollno;
        this.std_name = std_name;
    }

    public int getStd_rollno() {
        return std_rollno;
    }

    public void setStd_rollno(int std_rollno) {
        this.std_rollno = std_rollno;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }
}
