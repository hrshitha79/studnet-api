package com.project.studentapi.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int std_rollno;
    String std_name;
    String  std_address;


    public Student(){}
    public Student(int std_rollno, String std_name, String std_address) {
        this.std_rollno = std_rollno;
        this.std_name = std_name;
        this.std_address = std_address;
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

    public String getStd_address() {
        return std_address;
    }

    public void setStd_address(String std_address) {
        this.std_address = std_address;
    }
}
