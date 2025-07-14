
//
//package com.example.demo.models;
//
//
//public class Employee {
//    private int userid;
//    private String name;
//    private String job;
//
//    public Employee(int userid, String name, String job) {
//        this.userid = userid;
//        this.name = name;
//        this.job = job;
//    }
//
//    // Getters
//    public int getUserid() {
//        return userid;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getJob() {
//        return job;
//    }
//
//    // Setters
//    public void setUserid(int userid) {
//        this.userid = userid;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//}

//Day5 Task
//package com.example.demo.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "employees")
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int empID;
//
//    private String empName;
//    private String email;
//    private String password;
//    private String gender;
//
//    @Temporal(TemporalType.DATE)
//    private Date dob;
//
//    private String role;
//}


//Day 6
//package com.example.demo.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.Date;
//
//@Data // ✅ Generates all getters, setters, toString, etc.
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "employees")
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int empID;
//
//    private String empName;
//    private String email;
//    private String password;
//    private String gender;
//
//    @Temporal(TemporalType.DATE)
//    private Date dob;
//
//    private String role;
//}

//Day 6 Task
package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;

    private String empName;
    private String email;
    private String password;
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date dob;

    // 🔗 Many employees can have the same role (ADMIN, USER, etc.)
    @ManyToOne
    @JoinColumn(name = "role_id") // foreign key in employees table
    private Roles role;
}


