
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
package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid; // ✅ Primary Key (auto-generated)

    private String name;
    private String email;

    // ✅ Encrypted password will be stored using BCrypt
    private String password;
}
